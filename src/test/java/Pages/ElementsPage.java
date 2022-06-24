package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage extends BaseTest {
    WebDriver driver;
    WebElement mainHeader;
    WebElement notification;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMainHeader() {
        return driver.findElement(By.className("main-header"));
    }

    public WebElement getNotification() {
        return driver.findElement(By.cssSelector(".col-12.mt-4.col-md-6"));
    }
}
