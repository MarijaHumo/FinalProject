package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SidebarPage extends BaseTest {

    public SidebarPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;

    }

    public @FindBy(className = "text") List<WebElement> cardOptions;

    public void clickOnCardOption(String cardOption) {
        for (int i = 0; i < cardOptions.size(); i++) {
            scrollIntoView(cardOptions.get(i));
            if (cardOptions.get(i).getText().equals(cardOption)) {
                cardOptions.get(i).click();
            }
        }
    }
}