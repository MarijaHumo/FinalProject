package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {
    WebDriver driver;
    WebElement mainHeader;
    WebElement collapsedNodeOption;
    WebElement expandedNodeOptions;
    WebElement expandAllButton;
    WebElement colapseAllButton;
    WebElement expandAndCloseButton;
    WebElement resultNotification;
    WebElement homeBox;


    public CheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public @FindBy (className = "rct-title")
    List<WebElement> nodeTitles;

    public void clickOnNodeTitle(String nodeName) {
        for (int i = 0; i < nodeTitles.size(); i++) {
            scrollIntoView(nodeTitles.get(i));
            if (nodeTitles.get(i).getText().equals(nodeName)) {
                nodeTitles.get(i).click();
            }
        }
    }


    public WebElement getMainHeader() {
        return driver.findElement(By.className("main-header"));
    }

    public WebElement getCollapsedNodeOption() {
        return driver.findElement(By.cssSelector(".rct-node.rct-node-parent.rct-node-collapsed"));
    }

    public WebElement getExpandedNodeOptions() {
        return driver.findElement(By.cssSelector(".rct-node.rct-node-parent.rct-node-expanded"));
    }

    public WebElement getExpandAllButton() {
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-all"));
    }

    public WebElement getColapseAllButton() {
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-collapse-all"));
    }

    public WebElement getExpandAndCloseButton() {
        return driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn"));
    }

    public WebElement getResultNotification() {
        return driver.findElement(By.id("result"));
    }
}

