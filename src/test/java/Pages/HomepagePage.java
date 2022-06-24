package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomepagePage extends BaseTest {

    public HomepagePage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public @FindBy (className = "card-body")
    List<WebElement> cards;


    public void clickOnCard(String cardName) {

        for (int i = 0; i < cards.size(); i++){
            scrollIntoView(cards.get(i));
            if(cards.get(i).getText().equals(cardName)) {
                cards.get(i).click();
            }
        }

    }
}
