package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {
    WebDriver driver;
    WebElement addButton;
    WebElement searchBox;
    WebElement firstNameOption;
    WebElement lastNameOption;
    WebElement ageOption;
    WebElement emailOption;
    WebElement salaryOption;
    WebElement departmentOption;
    WebElement actionOption;
    WebElement credentials;
    WebElement editCredentialButton;
    WebElement deleteCredentialButton;

    public WebTablesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public @FindBy (className = "rt-resizable-header-content")
    List<WebElement> credentialOptions;

    /*public void listOfCredentialOptions (WebElement credentialOption) {
        for (int i = 0; i < credentialOptions.size(); i++) {
            if (credentialOptions.get(i).getText().equals(credentialOption)) {
                credentialOptions.add(credentialOption);
            } }}*/
     /*public WebElement getCredential (List<WebElement> credentialOptions, WebElement credentialName, String) {
         for (int i = 0; i < credentialOptions.size(); i++) {
             if (credentialOptions.get(i).getText().equals(credentialName)) {
                 return driver.findElement(By.partialLinkText(String));*/


    public WebElement getAddButton() {
        return driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.id("searchBox"));
    }

    public WebElement getFirstNameOption() {
        return driver.findElement(By.className("rt-resizable-header-content"));
    }

    public WebElement getLastNameOption() {
        return driver.findElement(By.className("rt-resizable-header-content"));
    }

    public WebElement getAgeOption() {
        return driver.findElement(By.className("rt-resizable-header-content"));
    }

    public WebElement getEmailOption() {
        return driver.findElement(By.className("rt-resizable-header-content"));
    }

    public WebElement getSalaryOption() {
        return driver.findElement(By.className("rt-resizable-header-content"));
    }

    public WebElement getDepartmentOption() {
        return driver.findElement(By.linkText("rt-resizable-header-content"));
    }

    public WebElement getActionOption() {
        return driver.findElement(By.linkText("rt-resizable-header-content"));
    }

    public WebElement getCredentials() {
        return driver.findElement(By.className("rt-tr-group"));
    }

    /*public WebElement getDeleteCredentialButton() {
        return driver.findElement();*/
    }
