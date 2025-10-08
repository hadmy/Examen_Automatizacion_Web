package com.nttdata.steps;

import com.nttdata.page.HomePage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.PopupPage;
import com.nttdata.page.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductStoreStep {

    private WebDriver driver;

    public ProductStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void irALogin() {
        this.driver.findElement(HomePage.loginLink).click();
    }

    public void typeUser(String user) {
        this.driver.findElement(LoginPage.userInput).sendKeys(user);
    }

    public void typePassword(String password) {
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    public void buttonLogin() {
        this.driver.findElement(LoginPage.loginButton).click();
    }

    public void validarLoginExitoso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean loginFallido = driver.findElements(LoginPage.errorMessage).size() > 0;
        if (loginFallido) {
            String mensajeError = driver.findElement(LoginPage.errorMessage).getText();
            throw new AssertionError("Error al iniciar sesion " + mensajeError);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.userInfo));
    }

    public void selectCategoria(String categoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Intentamos encontrar la categoría
        List<WebElement> categorias = driver.findElements(HomePage.categoriaMenu(categoria));

        if (categorias.isEmpty()) {
            throw new AssertionError("Categoria no existe.");
        }

        WebElement categoriaElemento = wait.until(ExpectedConditions
                .visibilityOfElementLocated(HomePage.categoriaMenu(categoria)));

        Actions actions = new Actions(driver);
        actions.moveToElement(categoriaElemento).perform();
    }

    public void selectSubCategoria(String subcategoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subCategoriaElemento = wait.until(ExpectedConditions
                .elementToBeClickable(HomePage.subCategoriaMenu(subcategoria)));

        subCategoriaElemento.click();
    }

    public void selectPrimerProducto() {
        WebElement primerProducto = driver.findElement(ProductPage.productoLink);
        primerProducto.click();
    }

    public void typeCantidad(int cantidad) {
        WebElement cantidadProducto = driver.findElement(ProductPage.quantityInput);
        cantidadProducto.sendKeys(Keys.CONTROL + "a");
        cantidadProducto.sendKeys(Keys.DELETE);
        cantidadProducto.sendKeys(String.valueOf(cantidad));
    }

    public void buttonAgregar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonAgregar = wait.until(ExpectedConditions.elementToBeClickable(ProductPage.agregarButton));
        botonAgregar.click();
    }

    public void validarPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.cartModal));
        WebElement titulo = modal.findElement(PopupPage.tituloModal);
        assert titulo.getText().contains("Producto añadido correctamente");
    }

    public void validarMontoTotalPopup(int cantidadEsperada) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.cartModal));

        String precioTexto = modal.findElement(PopupPage.precioUnitario).getText().replace("S/", "").replace(",", ".").trim();
        String cantidadTexto = modal.findElement(PopupPage.cantidadProducto).getText().trim();
        String totalTexto = modal.findElement(PopupPage.totalPopup).getText().replace("S/", "").replace(",", ".").trim();

        double precioUnitario = Double.parseDouble(precioTexto);
        int cantidadPopup = Integer.parseInt(cantidadTexto);
        double totalPopup = Double.parseDouble(totalTexto);

        double totalEsperado = precioUnitario * cantidadEsperada;
        assert cantidadPopup == cantidadEsperada : "Cantidad no es correcta";
        assert Math.abs(totalPopup - totalEsperado) < 0.01 : "Total no es correcto";
    }

    public void finalizarCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.cartModal));
        WebElement botonFinalizar = modal.findElement(PopupPage.finalizarButton);
        botonFinalizar.click();
    }
}
