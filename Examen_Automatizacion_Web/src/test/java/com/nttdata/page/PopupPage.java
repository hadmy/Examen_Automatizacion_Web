package com.nttdata.page;

import org.openqa.selenium.By;

public class PopupPage {

    public static By cartModal = By.id("blockcart-modal");

    public static By tituloModal = By.cssSelector("h4.modal-title");

    public static By precioUnitario = By.cssSelector(".product-price");

    public static By cantidadProducto = By.cssSelector(".product-quantity strong");

    public static By totalPopup = By.cssSelector(".subtotal.value");

    public static By finalizarButton = By.cssSelector("a.btn.btn-primary");
}
