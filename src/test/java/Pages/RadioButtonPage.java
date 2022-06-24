package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {
    WebDriver driver;
    WebElement mainHeader;
    WebElement question;

    WebElement selectedButtonNotification;
    WebElement yesButton;
    WebElement impressiveButton;
    WebElement noButton;




    public RadioButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public @FindBy (className = "custom-control-label")
    List<WebElement> answers;


    public void clickOnAnswer(String answer) {
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).getAttribute("for").equals(answer)) {
                answers.get(i).click();
            }}}

    public WebElement getMainHeaderRadioButton() {
        return driver.findElement(By.className("main-header"));
    }

    public WebElement getQuestion() {
        return driver.findElement(By.className("mb-3"));
    }

    public WebElement getSelectedButtonNotification() {
        return driver.findElement(By.className("text-success"));
    }

    public WebElement getYesButton() {
        return driver.findElement(By.id("yesRadio"));
    }

    public WebElement getImpressiveButton() {
        return driver.findElement(By.id("impressiveRadio"));
    }

    public WebElement getNoButton() {
        return driver.findElement(By.id("noRadio"));
    }
}
