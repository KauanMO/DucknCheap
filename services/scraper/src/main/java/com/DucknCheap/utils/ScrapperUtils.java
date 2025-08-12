package com.DucknCheap.utils;

import com.duckncheap.model.ValiableStoresEnum;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ScrapperUtils {
    public static Map<ValiableStoresEnum, Map<String, String>> storeXPathDictionary = Map.of(
            ValiableStoresEnum.AMAZON, Map.of(
                    "image", "//*[@id=\"landingImage\"]",
                    "description", "//*[@id=\"productDescription\"]/p/span",
                    "name", "//*[@id=\"productTitle\"]",
                    "price", "//*[@id=\"corePrice_feature_div\"]/div/div/span[1]/span[2]",
                    "promoPrice", "//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[2]/span/span[1]/span[2]/span/span[2]",
                    "promoCheck", "//*[@id=\"dealBadge_feature_div\"]",
                    "necessary", "/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button"
            )
    );
}
