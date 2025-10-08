package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ProductStoreStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreStepdefs {

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
        productStep.login();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        //productStep = new ProductStoreStep(driver);
        /*productStep.navegarACategoriaYSubcategoria(categoria, subcategoria);
        screenShot();*/
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        //productStep = new ProductStoreStep(driver);
        /*productStep.agregarProductoAlCarrito(cantidad);
        screenShot();*/
    }
}
