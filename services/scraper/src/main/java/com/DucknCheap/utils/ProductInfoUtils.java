package com.DucknCheap.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ProductInfoUtils {
    public static Double productPriceParser(String productPrice) {
        try {
            NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
            Number number = format.parse(productPrice.replace("R$", "").trim());
            return number.doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException("Error converting price: " + productPrice, e);
        }
    }
}
