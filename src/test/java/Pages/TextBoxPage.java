package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    WebDriver driver;
    WebElement mainHeader;
    WebElement fullNameBox;
    WebElement emailBox;
    WebElement currentAddressBox;
    WebElement permanentAddressBox;
    WebElement submitButton;
    WebElement credentialsNotification;
    WebElement fieldErrorNotification;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMainHeader() {
        return driver.findElement(By.className("main-header"));
    }

    public WebElement getFullNameBox() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmailBox() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddressBox() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressBox() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getCredentialsNotification() {
        return driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12"));
    }

    public WebElement getFieldErrorNotification() {
        return driver.findElement(By.cssSelector(".mr-sm-2.field-error.form-control"));
    }

    public void insertFullName(String name) {
        getFullNameBox().clear();
        getFullNameBox().sendKeys(name);
    }

    public void insertEmail(String email) {
        getEmailBox().clear();
        getEmailBox().sendKeys(email);
    }

    public void insertCurrentAddress(String currentAddress) {
        getCurrentAddressBox().clear();
        getCurrentAddressBox().sendKeys(currentAddress);
    }
    public void insertPermanentAddress(String permanentAddress) {
        getPermanentAddressBox().clear();
        getPermanentAddressBox().sendKeys(permanentAddress);

            }
        }