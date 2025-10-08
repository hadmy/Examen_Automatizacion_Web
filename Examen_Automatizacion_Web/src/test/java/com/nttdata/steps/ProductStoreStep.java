package com.nttdata.steps;

import com.nttdata.page.HomePage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductStoreStep {

    private WebDriver driver;

    public ProductStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void irALogin(){
        this.driver.findElement(HomePage.loginLink).click();
    }

    public void typeUser(String user) {
        this.driver.findElement(LoginPage.userInput).sendKeys(user);
    }

    public void typePassword(String password) {
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }

    /*public void navegarACategoriaYSubcategoria(String categoria, String subcategoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        WebElement categoriaElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.categoriaMenu(categoria)));
        actions.moveToElement(categoriaElemento).perform();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.subCategoriaMenu(subcategoria)));

        WebElement subCategoriaElemento = driver.findElement(HomePage.subCategoriaMenu(subcategoria));
        subCategoriaElemento.click();
    }

    public void agregarProductoAlCarrito(int cantidad) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement primerProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.productoLink));
        primerProducto.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#quantity_wanted")));

        WebElement inputCantidad = driver.findElement(ProductPage.quantityInput);
        inputCantidad.clear();
        inputCantidad.sendKeys("");
        inputCantidad.sendKeys(String.valueOf(cantidad));

        // Clic en el botón "Añadir al carrito"
        WebElement botonAgregar = driver.findElement(By.cssSelector("button.add-to-cart"));
        botonAgregar.click();

        // Espera a que aparezca el modal de confirmación
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("blockcart-modal")));

        // Clic en "Continuar comprando" o cierra el modal si existe
        try {
            WebElement continuar = driver.findElement(By.cssSelector("button.continue.btn.btn-secondary"));
            continuar.click();
        } catch (Exception e) {
            System.out.println("El botón 'Continuar comprando' no se encontró, cerrando modal.");
            driver.findElement(By.cssSelector("button.close")).click();
        }
    }*/
}
