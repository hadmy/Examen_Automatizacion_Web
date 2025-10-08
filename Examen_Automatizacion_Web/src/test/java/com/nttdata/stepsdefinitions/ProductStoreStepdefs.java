package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ProductStoreStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreStepdefs {

    private int cantidadGlobal;
    private WebDriver driver;
    private ProductStoreStep productStep;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();

        productStep = new ProductStoreStep(driver);
        productStep.irALogin();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        /*productStep = new ProductStoreStep(driver);*/
        productStep.typeUser(usuario);
        productStep.typePassword(clave);
        productStep.buttonLogin();
        screenShot();

        productStep.validarLoginExitoso();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        productStep.selectCategoria(categoria);
        productStep.selectSubCategoria(subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        cantidadGlobal = cantidad;
        productStep.selectPrimerProducto();
        productStep.typeCantidad(cantidad);
        productStep.buttonAgregar();
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        productStep.validarPopup();
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        productStep.validarMontoTotalPopup(cantidadGlobal);
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        productStep.finalizarCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }
}
