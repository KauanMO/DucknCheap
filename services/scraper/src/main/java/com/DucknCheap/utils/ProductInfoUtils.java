package com.DucknCheap.utils;

public class ProductInfoUtils {
    public static Double productPriceParser(String productPrice) {
        if (!productPrice.matches("[0-9.,]+")) {
            productPrice = productPrice.replace("R$", "")
                    .replace("\n", ".")
                    .trim();
        }

        productPrice = productPrice.replace(",", ".");

        return Double.parseDouble(productPrice);
    }
}
