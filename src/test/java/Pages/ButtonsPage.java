package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ButtonsPage {
    WebDriver driver;
    WebElement doubleClickButton;
    WebElement rightClickButton;
    WebElement clickButton;
    WebElement doubleClickNotification;
    WebElement rightClickNotification;
    WebElement clickNotification;
    Actions actions;

    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public @FindBy(css = ".btn.btn-primary")
    List<WebElement> buttons;

    /*public void clickOnButton(String buttonName) {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals(buttonName)) {
                actions.doubleClick(buttons.get(i)).perform();
                break;
            } else if (buttons.get(i).getText().equals(buttonName)) {
                actions.contextClick(buttons.get(i)).perform();
                break;
            } else {
                System.out.println("kajsdhaksj");
                }
        }
    }*/ //zadrzati metodu, izbaciti @FindBy i stavili id lokator



    public WebElement getDoubleClickButton() {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getRightClickButton() {
        return driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement getClickButton() {
        return driver.findElement(By.cssSelector(".btn.btn-primary"));
    }

    public WebElement getDoubleClickNotification() {
        return driver.findElement(By.id("doubleClickMessage"));
    }

    public WebElement getRightClickNotification() {
        return driver.findElement(By.id("rightClickMessage"));
    }

    public WebElement getClickNotification() {
        return driver.findElement(By.id("dynamicClickMessage"));
    }



}

