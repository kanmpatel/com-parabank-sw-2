package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setupBrowser(){
        //set up the open browser
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //find the element of registration link
        WebElement registrationLink = driver.findElement(By.linkText("Register"));
        //click on registration link
        registrationLink.click();
        //expected registration text
        String expectedRegistrationText = "Signing up is easy!";
        //find the element of registration text
        WebElement actualRegistrationTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        //get the text of registration elements
        String actualRegistrationText = actualRegistrationTextElement.getText();
        //validate the registration test
        Assert.assertEquals(expectedRegistrationText,actualRegistrationText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        verifyThatSigningUpPageDisplay();
        //find the element of firstname
        WebElement firstNameField = driver.findElement(By.id("customer.firstName"));
        //send the value of the firstname
        firstNameField.sendKeys("abcdefg");
        //find the element of lastname
        WebElement lastNameField = driver.findElement(By.id("customer.lastName"));
        //send the value of the lastname
        lastNameField.sendKeys("xyz");
        //find the element of addressField
        WebElement addressField = driver.findElement(By.xpath("//input[@name='customer.address.street']"));
        //send the value of the addressField
        addressField.sendKeys("25,dfgs");
        //find the element of cityField
        WebElement cityField = driver.findElement(By.id("customer.address.city"));
        //send the value of the cityField
        cityField.sendKeys("abcdfg");
        //find the element of stateField
        WebElement stateField = driver.findElement(By.name("customer.address.state"));
        //send the value of the stateField
        stateField.sendKeys("tyuo");
        //find the element of zipCodeField
        WebElement zipCodeField = driver.findElement(By.name("customer.address.zipCode"));
        //send the value of the zipCodeField
        zipCodeField.sendKeys("123456");
        //find the element of ssnField
        WebElement ssnField = driver.findElement(By.id("customer.ssn"));
        //send the value of the zipCodeField
        ssnField.sendKeys("123456");
        //find the element of userNameField
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='customer.username']"));
        //send the value of the userNameField
        userNameField.sendKeys("abcdefr");
        //find the element of passwordField
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='customer.password']"));
        //send the value of the passwordField
        passwordField.sendKeys("abcdefr");
        //find the element of confirmPasswordField
        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@name='repeatedPassword']"));
        //send the value of the confirmPasswordField
        confirmPasswordField.sendKeys("abcdefr");
        //find the element of registerBtn
        WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Register']"));
        //click on registration
        registerBtn.click();
        //expected registration text
        String expectedRegistrationMessageText = "Your account was created successfully. You are now logged in.";
        //find the element of registration text
        WebElement actualRegistrationMessageTextElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"));
        //get the text of registration elements
        String actualRegistrationMessageText = actualRegistrationMessageTextElement.getText();
        //validate the registration test
        Assert.assertEquals(expectedRegistrationMessageText,actualRegistrationMessageText);

    }

    @After
    public void closeBrowserSetUp(){
        //set up for close browser
        closeBrowser();
    }
}
