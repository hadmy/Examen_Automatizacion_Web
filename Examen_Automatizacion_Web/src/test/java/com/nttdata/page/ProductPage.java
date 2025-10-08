package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {

    public static By productoLink = By.cssSelector("#js-product-list .products .product a.product-thumbnail");

    public static By quantityInput = By.id("quantity_wanted");

    public static By agregarButton = By.cssSelector("button[data-button-action='add-to-cart']");
}
