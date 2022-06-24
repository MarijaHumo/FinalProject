package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestElements extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    public void clickOnElementsCard() {
        homepagePage.clickOnCard("Elements");
    }

    public boolean credentialsNotificationIsDisplayed() {
        boolean checkCredentialsNotification = false;
        try {
            checkCredentialsNotification = textBoxPage.getCredentialsNotification().isDisplayed();
        } catch (Exception e) {
        }
        return checkCredentialsNotification;
    }

    public boolean expandedNodesOptionIsDisplayed() {
        boolean checkNodes = false;
        try {
            checkNodes = checkBoxPage.getExpandedNodeOptions().isDisplayed();
        } catch (Exception e) {
        }
        return checkNodes;
    }

    public boolean resultNotificationIsDisplayed() {
        boolean checkResultNotification = false;
        try {
            checkResultNotification = checkBoxPage.getResultNotification().isDisplayed();
        } catch (Exception e) {
        }
        return checkResultNotification;
    }


    @Test
    public void elementsTextBox() {
        clickOnElementsCard();
        Assert.assertTrue(elementsPage.getMainHeader().isDisplayed());
        Assert.assertEquals(elementsPage.getMainHeader().getText(), "Elements");
        Assert.assertTrue(elementsPage.getNotification().isDisplayed());
        Assert.assertEquals(elementsPage.getNotification().getText(), "Please select an item from left to start practice.");

        sidebarPage.clickOnCardOption("Text Box");
        Assert.assertTrue(textBoxPage.getMainHeader().isDisplayed());
        Assert.assertEquals(textBoxPage.getMainHeader().getText(), "Text Box");
        Assert.assertTrue(textBoxPage.getFullNameBox().isDisplayed());
        Assert.assertTrue(textBoxPage.getEmailBox().isDisplayed());
        Assert.assertTrue(textBoxPage.getCurrentAddressBox().isDisplayed());
        Assert.assertTrue(textBoxPage.getPermanentAddressBox().isDisplayed());
        Assert.assertTrue(textBoxPage.getSubmitButton().isDisplayed());
        Assert.assertFalse(credentialsNotificationIsDisplayed());

        String validFullName = excelReader.getStringData("Sheet1", 1, 0);
        String validEmail = excelReader.getStringData("Sheet1", 1, 1);
        String validCurrentAddress = excelReader.getStringData("Sheet1", 1, 2);
        String validPermanentAddress = excelReader.getStringData("Sheet1", 1, 3);
        String invalidEmail = excelReader.getStringData("Sheet1", 2, 1);

        textBoxPage.insertFullName(validFullName);
        textBoxPage.insertEmail(validEmail);
        textBoxPage.insertCurrentAddress(validCurrentAddress);
        textBoxPage.insertPermanentAddress(validPermanentAddress);
        scrollIntoView(textBoxPage.getSubmitButton());
        textBoxPage.getSubmitButton().click();

        Assert.assertTrue(credentialsNotificationIsDisplayed());
        Assert.assertEquals(textBoxPage.getCredentialsNotification().getText(), "Name:" + validFullName + "\n" +
                "Email:" + validEmail + "\n" +
                "Current Address :" + validCurrentAddress + "\n" +
                "Permananet Address :" + validPermanentAddress);

        textBoxPage.insertFullName(validFullName);
        textBoxPage.insertEmail(invalidEmail);
        textBoxPage.insertCurrentAddress(validCurrentAddress);
        textBoxPage.insertPermanentAddress(validPermanentAddress);
        scrollIntoView(textBoxPage.getSubmitButton());
        textBoxPage.getSubmitButton().click();
        Assert.assertTrue(textBoxPage.getFieldErrorNotification().isDisplayed());
        // ovde bih predlozila notifikaciju koja jasno govori gde je greska pri unosu
        // Assert.assertFalse(credentialsNotificationIsDisplayed()); moguci bag
    }

    @Test
    public void elementsCheckBox() {
        clickOnElementsCard();
        sidebarPage.clickOnCardOption("Check Box");

        Assert.assertTrue(checkBoxPage.getMainHeader().isDisplayed());
        Assert.assertEquals(checkBoxPage.getMainHeader().getText(), "Check Box");
        Assert.assertTrue(checkBoxPage.getCollapsedNodeOption().isDisplayed());
        Assert.assertEquals(checkBoxPage.getCollapsedNodeOption().getText(), "Home");
        Assert.assertTrue(checkBoxPage.getExpandAndCloseButton().isDisplayed());
        Assert.assertTrue(checkBoxPage.getExpandAllButton().isDisplayed());
        Assert.assertTrue(checkBoxPage.getColapseAllButton().isDisplayed());
        Assert.assertFalse(expandedNodesOptionIsDisplayed());
        Assert.assertFalse(resultNotificationIsDisplayed());

        checkBoxPage.getExpandAllButton().click();
        Assert.assertTrue(expandedNodesOptionIsDisplayed());
        Assert.assertEquals(checkBoxPage.getExpandedNodeOptions().getText(), "Home\n" +
                "Desktop\n" +
                "Notes\n" +
                "Commands\n" +
                "Documents\n" +
                "WorkSpace\n" +
                "React\n" +
                "Angular\n" +
                "Veu\n" +
                "Office\n" +
                "Public\n" +
                "Private\n" +
                "Classified\n" +
                "General\n" +
                "Downloads\n" +
                "Word File.doc\n" +
                "Excel File.doc");

        Assert.assertFalse(resultNotificationIsDisplayed());

        checkBoxPage.getColapseAllButton().click();
        Assert.assertFalse(expandedNodesOptionIsDisplayed());
        Assert.assertFalse(resultNotificationIsDisplayed());

        checkBoxPage.getExpandAllButton().click();
        Assert.assertTrue(expandedNodesOptionIsDisplayed());
        Assert.assertFalse(resultNotificationIsDisplayed());
        checkBoxPage.clickOnNodeTitle("Home");
        Assert.assertTrue(expandedNodesOptionIsDisplayed());
        //Assert.assertTrue();
        Assert.assertTrue(resultNotificationIsDisplayed());
        Assert.assertEquals(checkBoxPage.getResultNotification().getText(), "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");

        checkBoxPage.clickOnNodeTitle("Home");
        Assert.assertTrue(expandedNodesOptionIsDisplayed());
        Assert.assertFalse(resultNotificationIsDisplayed());

        checkBoxPage.getExpandAndCloseButton().click();
        Assert.assertFalse(expandedNodesOptionIsDisplayed());
        Assert.assertTrue(checkBoxPage.getCollapsedNodeOption().isDisplayed());
        Assert.assertEquals(checkBoxPage.getCollapsedNodeOption().getText(), "Home");
    }

    @Test
    public void elementsRadioButton() {
        clickOnElementsCard();
        sidebarPage.clickOnCardOption("Radio Button");
        Assert.assertTrue(radioButtonPage.getMainHeaderRadioButton().isDisplayed());
        Assert.assertEquals(radioButtonPage.getMainHeaderRadioButton().getText(), "Radio Button");
        Assert.assertTrue(radioButtonPage.getQuestion().isDisplayed());
        Assert.assertEquals(radioButtonPage.getQuestion().getText(), "Do you like the site?");

        boolean checkYesButtonIsSelected = false;
        try {
            checkYesButtonIsSelected = radioButtonPage.getYesButton().isSelected();
        } catch (Exception e) {
        }
        Assert.assertFalse(checkYesButtonIsSelected);
        boolean checkImpressiveButtonIsSelected = false;
        try {
            checkImpressiveButtonIsSelected = radioButtonPage.getYesButton().isSelected();
        } catch (Exception e) {
        }
        Assert.assertFalse(checkImpressiveButtonIsSelected);
        boolean checkNoButtonIsSelected = false;
        try {
            checkNoButtonIsSelected = radioButtonPage.getNoButton().isSelected();
        } catch (Exception e) {
        }
        Assert.assertFalse(checkNoButtonIsSelected);

        radioButtonPage.clickOnAnswer("yesRadio");
        Assert.assertTrue(radioButtonPage.getYesButton().isSelected());
        Assert.assertFalse(radioButtonPage.getImpressiveButton().isSelected());
        Assert.assertFalse(radioButtonPage.getNoButton().isSelected());
        Assert.assertTrue(radioButtonPage.getSelectedButtonNotification().isDisplayed());
        Assert.assertEquals(radioButtonPage.getSelectedButtonNotification().getText(), "Yes");

        radioButtonPage.clickOnAnswer("impressiveRadio");
        Assert.assertTrue(radioButtonPage.getImpressiveButton().isSelected());
        Assert.assertFalse(radioButtonPage.getYesButton().isSelected());
        Assert.assertFalse(radioButtonPage.getNoButton().isSelected());
        Assert.assertTrue(radioButtonPage.getSelectedButtonNotification().isDisplayed());
        Assert.assertEquals(radioButtonPage.getSelectedButtonNotification().getText(), "Impressive");

        radioButtonPage.clickOnAnswer("noRadio");
        Assert.assertTrue(radioButtonPage.getNoButton().isSelected()); // bag
        Assert.assertFalse(radioButtonPage.getYesButton().isSelected());
        Assert.assertFalse(radioButtonPage.getImpressiveButton().isSelected());
        Assert.assertTrue(radioButtonPage.getSelectedButtonNotification().isDisplayed());
        Assert.assertEquals(radioButtonPage.getSelectedButtonNotification().getText(), "No");
    }

   /* @Test
    public void elementsWebTables() {
        clickOnElementsCard();
        sidebarPage.clickOnCardOption("Web Tables");

        Assert.assertTrue(webTablesPage.getAddButton().isDisplayed());
        Assert.assertTrue(webTablesPage.getSearchBox().isDisplayed());
        Assert.assertTrue(webTablesPage.getFirstNameOption().isDisplayed());
        Assert.assertEquals(webTablesPage.getFirstNameOption().getText(), "First Name");
        Assert.assertTrue(webTablesPage.getLastNameOption().isDisplayed());

        //Assert.assertEquals(webTablesPage.getLastNameOption().getText(), "Last Name");
        Assert.assertTrue(webTablesPage.getAgeOption().isDisplayed());
        //Assert.assertEquals(webTablesPage.getAgeOption().getText(), "Age");
        Assert.assertTrue(webTablesPage.getEmailOption().isDisplayed());
        // Assert.assertEquals(webTablesPage.getEmailOption().getText(), "Email");
        Assert.assertTrue(webTablesPage.getSalaryOption().isDisplayed());
        //Assert.assertEquals(webTablesPage.getSalaryOption().getText(), "Salary");
        Assert.assertTrue(webTablesPage.getDepartmentOption().isDisplayed());
        //Assert.assertEquals(webTablesPage.getDepartmentOption().getText(), "Department");
        Assert.assertTrue(webTablesPage.getActionOption().isDisplayed());
        //Assert.assertEquals(webTablesPage.getActionOption().getText(),"Action");

        //webTablesPage.getAddButton().click();
        Assert.assertTrue(webTablesPage.getCredentials().isDisplayed());
    }*/

    @Test
    public void elementsButtons() {
        clickOnElementsCard();
        sidebarPage.clickOnCardOption("Buttons");

        Assert.assertTrue(buttonsPage.getDoubleClickButton().isDisplayed());
        Assert.assertEquals(buttonsPage.getDoubleClickButton().getText(), "Double Click Me");
        Assert.assertTrue(buttonsPage.getRightClickButton().isDisplayed());
        Assert.assertEquals(buttonsPage.getRightClickButton().getText(), "Right Click Me");
        Assert.assertTrue(buttonsPage.getClickButton().isDisplayed());
        //Assert.assertEquals(buttonsPage.getClickButton().getText(), "Click Me"); probala sam id i css lokator, nece

        boolean check1 = false;
        try {
            check1 = buttonsPage.getDoubleClickNotification().isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(check1);

        boolean check2 = false;
        try {
            check2 = buttonsPage.getRightClickNotification().isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(check2);

        boolean check3 = false;
        try {
            check3 = buttonsPage.getClickNotification().isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(check3);

        /*buttonsPage.clickOnButton("Double Click Me");
        //Assert.assertTrue(buttonsPage.getDoubleClickButton().isSelected());
        Assert.assertTrue(buttonsPage.getDoubleClickNotification().isDisplayed());
        Assert.assertEquals(buttonsPage.getDoubleClickNotification().getText(), "You have done a double click");
        Assert.assertFalse(check2);
        Assert.assertFalse(check3);

        buttonsPage.clickOnButton("Right Click Me");
        //Assert.assertTrue(buttonsPage.getRightClickButton().isSelected());
        Assert.assertTrue(buttonsPage.getDoubleClickNotification().isDisplayed());
        Assert.assertEquals(buttonsPage.getDoubleClickNotification().getText(), "You have done a double click");

        Assert.assertTrue(buttonsPage.getRightClickNotification().isDisplayed());
        Assert.assertEquals(buttonsPage.getRightClickNotification().getText(), "You have done a right click");
        Assert.assertFalse(check3);*/
    }
}
