package com.nttdata.page;

import org.openqa.selenium.By;

public class HomePage {

    public static By loginLink = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a");

    public static By userInfo = By.cssSelector(".account span");

    public static By categoriaMenu(String categoria) {
        return By.xpath("//ul[@id='top-menu']//a[contains(normalize-space(),'" + categoria + "')]");
    }

    public static By subCategoriaMenu(String subcategoria) {
        return By.xpath("//div[contains(@class,'sub-menu')]//a[contains(normalize-space(),'" + subcategoria + "')]");
    }
}
