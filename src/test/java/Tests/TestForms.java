package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestForms extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void forms1() {
        homepagePage.clickOnCard("Forms");
    }
}