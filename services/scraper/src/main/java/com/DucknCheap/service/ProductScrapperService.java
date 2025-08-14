package com.DucknCheap.service;

import com.DucknCheap.RabbitMQ.product.ProductFactoryPublisher;
import com.DucknCheap.utils.ProductInfoUtils;
import com.DucknCheap.utils.ScrapperUtils;
import com.duckncheap.model.ValiableStoresEnum;
import com.duckncheap.rabbitmq.ProductInfoMessage;
import com.duckncheap.rabbitmq.ProductScrapMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductScrapperService {
    private final ProductFactoryPublisher productPublisher;

    public void WebScrapProduct(ProductScrapMessage scrapMessage) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(scrapMessage.getProductUrl());

        Map<String, String> xpaths = ScrapperUtils.storeXPathDictionary.get(scrapMessage.getStore());

        checkNecessaryClicks(driver, wait, xpaths.get("necessary"), xpaths.get("image"));

        String productName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpaths.get("name")))).getText();
        WebElement productImage = driver.findElement(By.xpath(xpaths.get("image")));
        String productImageSrc = productImage.getAttribute("src");

        String productDescription;
        try {
            productDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpaths.get("description")))).getText();
        } catch (TimeoutException e) {
            productDescription = "Description not found";
        }

        String productPrice;
        try {
            driver.findElement(By.xpath(xpaths.get("promoCheck")));
            productPrice = driver.findElement(By.xpath(xpaths.get("promoPrice"))).getText();
        } catch (NoSuchElementException e) {
            productPrice = driver.findElement(By.xpath(xpaths.get("price"))).getText();
        }

        driver.quit();

        ProductInfoMessage productInfoMessage = new ProductInfoMessage(scrapMessage.getProductUrl(),
                scrapMessage.getUserId(),
                scrapMessage.getProductName() != null ? scrapMessage.getProductName() : productName,
                scrapMessage.getStore(),
                productImageSrc,
                productDescription,
                ProductInfoUtils.productPriceParser(productPrice));

        productPublisher.sendProductInfoMessage(productInfoMessage);

        System.out.println("Product sent to creation");
    }

    public Optional<Double> webScrapPromo(String productUrl, ValiableStoresEnum store) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(productUrl);

        Map<String, String> xpaths = ScrapperUtils.storeXPathDictionary.get(store);

        checkNecessaryClicks(driver, wait, xpaths.get("necessary"), xpaths.get("image"));

        try {
            driver.findElement(By.xpath(xpaths.get("promoCheck")));
            String stringPrice = driver.findElement(By.xpath(xpaths.get("price"))).getText();

            return Optional.of(ProductInfoUtils.productPriceParser(stringPrice));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    public void checkNecessaryClicks(WebDriver driver, WebDriverWait wait, String clickXpath, String checkerXpath) {
        try {
            WebElement necessaryElement = driver.findElement(By.xpath(clickXpath));
            if (necessaryElement.isDisplayed() && necessaryElement.isEnabled()) {
                necessaryElement.click();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkerXpath)));
            }
        } catch (NoSuchElementException e) {
            System.out.println("No necessary click");
        }
    }

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        return new ChromeDriver(options);
    }
}
