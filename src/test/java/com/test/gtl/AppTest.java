package com.test.gtl;



import com.test.util.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class AppTest extends Base {

    public static String NewAccountNumber = null;
    public static String NewAccountBalance = null;
    public static String UpdatedBalance = null;
    public static int Difference = 0;

    @Test (priority = 1)
    public void TitleTest() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        String title = driver.getTitle();
        Assert.assertEquals(title, "ParaBank | Welcome | Online Banking", " Title didn't match");


    }

    @Test (priority = 2)
    public void UserRegistrationTest() throws InterruptedException {
                        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.xpath("(//a[contains(text(),'Register')])")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//input[@id='customer.firstName'])")).sendKeys(firstName);
        driver.findElement(By.xpath("(//input[@id='customer.lastName'])")).sendKeys(lastName);
        driver.findElement(By.xpath("(//input[@id='customer.address.street'])")).sendKeys(streetAddress);
        driver.findElement(By.xpath("(//input[@id='customer.address.city'])")).sendKeys(city);
        driver.findElement(By.xpath("(//input[@id='customer.address.state'])")).sendKeys(state);
        driver.findElement(By.xpath("(//input[@id='customer.address.zipCode'])")).sendKeys(zipcode);
        driver.findElement(By.xpath("(//input[@id='customer.phoneNumber'])")).sendKeys(phoneNumber);
        driver.findElement(By.xpath("(//input[@id='customer.ssn'])")).sendKeys(SSN);

        driver.findElement(By.xpath("(//input[@id='customer.username'])")).sendKeys(firstName);
        driver.findElement(By.xpath("(//input[@id='customer.password'])")).sendKeys(password);
        driver.findElement(By.xpath("(//input[@id='repeatedPassword'])")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[@value='Register'])")).click();
        System.out.println(firstName + "," + password);
//Marcell,8KdfZy@6i(

    }

    @Test (priority = 3)
    public void AccountOverview() throws InterruptedException{
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[@name='username'])")).click();
        driver.findElement(By.xpath("(//input[@name='username'])")).sendKeys(firstName);
       // driver.findElement(By.xpath("(//input[@name='username'])")).sendKeys(firstName);
        driver.findElement(By.xpath("(//input[@name='password'])")).sendKeys(password);
        driver.findElement(By.xpath("(//input[@value='Log In'])")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[contains(text(),'Accounts Overview')])")).sendKeys(Keys.ENTER);

    }

   @Test (priority = 4)
    public void OpenNewAccount() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.xpath("(//input[@name='username'])")).click();
        driver.findElement(By.xpath("(//input[@name='username'])")).sendKeys(firstName);
        driver.findElement(By.xpath("(//input[@name='password'])")).sendKeys(lastName);
        driver.findElement(By.xpath("(//input[@value='Log In'])")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Open New Account')])")).sendKeys(Keys.ENTER);
        Select AccountType = new Select(driver.findElement(By.xpath("(//select[@id='type'])")));
        AccountType.selectByValue("1");
        driver.findElement(By.xpath("(//input[@value='Open New Account'])")).click();
        NewAccountNumber = driver.findElement(By.xpath("(//a[@id='newAccountId'])")).getText();
        driver.findElement(By.xpath("(//a[@id='newAccountId'])")).click();
        NewAccountBalance = driver.findElement(By.xpath("(//td[@id='balance'])")).getText();

    }

  @Test (priority = 5)
    public void TransferFunds() throws InterruptedException {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.xpath("(//input[@name='username'])")).sendKeys(firstName);
        driver.findElement(By.xpath("(//input[@name='password'])")).sendKeys(lastName);
       // driver.findElement(By.xpath("(//input[@name='username'])")).sendKeys(username);
       // driver.findElement(By.xpath("(//input[@name='password'])")).sendKeys(password);
        driver.findElement(By.xpath("(//input[@value='Log In'])")).click();

        driver.findElement(By.xpath("(//a[contains(text(),'Transfer Funds')])")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[@id='amount'])")).sendKeys("500");
        driver.findElement(By.xpath("(//select[@id='fromAccountId'])")).click();

        Select fromAccount = new Select(driver.findElement(By.xpath("(//select[@id='fromAccountId'])")));
        fromAccount.selectByValue("14232");

        Select toAccount = new Select(driver.findElement(By.xpath("(//select[@id='toAccountId'])")));
        toAccount.selectByValue("14343");//NewAccountNumber);
        driver.findElement(By.xpath("(//input[@value='Transfer'])")).click();
        String validationtext = driver.findElement(By.xpath("(//h1[@class='title'])")).getText();
        Assert.assertTrue( validationtext != "Transfer Complete!", "not successful");

    }

    /*@Test (dependsOnMethods = "a4")
    public void a6() { //FundTransferValidation() {
       a3();
        System.out.println(NewAccountNumber);
        driver.findElement(By.xpath("//a[contains(text(),"+NewAccountNumber+")]")).click();
        UpdatedBalance = driver.findElement(By.xpath("(//td[@id='balance'])")).getText();
        // Difference= Integer.valueOf(NewAccountBalance)-Integer.valueOf(UpdatedBalance);
        //System.out.println(Difference);
        // Assert.assertEquals(text,"Selenium Webdriver", "Txt message did not match");


    }*/

}