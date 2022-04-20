package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setupBrowser(){
        //set up the open browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find the element of username
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        //sent the value of username
        userNameField.sendKeys("abcdef");
        //find the element of password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        //sent the value of password
        passwordField.sendKeys("123456");
        //find the element of login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        //sent the value of password
        loginBtn.click();
        //expected login text

        String expectedLoginText = "Accounts Overview";
        //find the element of login text
        WebElement actualLoginTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        //get the text of login elements
        String actualLoginText = actualLoginTextElement.getText();
        //validate the login test
        Assert.assertEquals(expectedLoginText,actualLoginText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //find the element of username
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        //sent the value of username
        userNameField.sendKeys("abcde");
        //find the element of password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        //sent the value of password
        passwordField.sendKeys("12345");
        //find the element of login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        //sent the value of password
        loginBtn.click();
        //expected error text
        String expectedErrorText = "The username and password could not be verified.";
        //find the element of error text
        WebElement actualErrorTextElement = driver.findElement(By.cssSelector(".error"));
        //get the text of error elements
        String actualErrorText = actualErrorTextElement.getText();
        //validate the error test
        Assert.assertEquals(expectedErrorText,actualErrorText);
    }

    @Test
    public void userShouldLogOutSuccessfully(){
        //find the element of username
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        //sent the value of username
        userNameField.sendKeys("abcdef");
        //find the element of password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        //sent the value of password
        passwordField.sendKeys("123456");
        //find the element of login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginBtn.click();
        //sent the value of password
        WebElement logOutBtn = driver.findElement(By.linkText("Log Out"));
        logOutBtn.click();

        //expected customer login ext
        String expectedLoginText = "Customer Login";
        //find the element of login text
        WebElement actualLoginTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        //get the text of login elements
        String actualLoginText = actualLoginTextElement.getText();
        //validate the login test
        Assert.assertEquals(expectedLoginText,actualLoginText);
    }

    @After
    public void closeBrowserSetUp(){
        //set up for close browser
        closeBrowser();
    }

}
