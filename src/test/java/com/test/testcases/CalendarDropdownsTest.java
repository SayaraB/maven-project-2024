package com.test.testcases;


import com.test.gtl.CheapFlightsSearchPOs;
import com.test.pageobjects.CheapFlightSearchPOs;
import com.test.pageobjects.CheapFlightSearchPageFactoryPOs;
import com.test.util.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CalendarDropdownsTest extends Base {


    @Test
    public void testCheapOair() throws InterruptedException {
        //CheapFlightSearchPOs homePage = new CheapFlightSearchPOs(driver);
        CheapFlightSearchPageFactoryPOs homePage = new CheapFlightSearchPageFactoryPOs(driver);
        driver.get("https://www.cheapoair.com/");
        Thread.sleep(3000);


        homePage.insertDepartureCity("New York");
        Thread.sleep(1000);
        homePage.selectOptionNumberDeparture(4);


        homePage.insertDestinationCity("Charlotte");
        homePage.selectOptionNumberArrival(1);


        driver.findElement(By.xpath("(//div[@class='widget__input'])")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@aria-label='10 February 2024']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class=' month-date']")).click();


        driver.findElement(By.id("travellerButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("addchild")).click();
        Select childAgeDrpDown = new Select(driver.findElement(By.name("ChildrenAge")));
        childAgeDrpDown.selectByValue("6");
    }

    @Test
    public void testCheapOair2() throws InterruptedException {
        CheapFlightSearchPOs homePage = new CheapFlightSearchPOs(driver);
        driver.get("https://www.cheapoair.com/");
        Thread.sleep(3000);


        homePage.insertDepartureCity("Los Angelos");
        Thread.sleep(1000);
        homePage.selectOptionNumberDeparture(4);


        homePage.insertDestinationCity("London");
        homePage.selectOptionNumberArrival(1);


        driver.findElement(By.xpath("(//div[@class='widget__input'])")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@aria-label='10 February 2024']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class=' month-date']")).click();


        driver.findElement(By.id("travellerButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("addchild")).click();
        Select childAgeDrpDown = new Select(driver.findElement(By.name("ChildrenAge")));
        childAgeDrpDown.selectByValue("6");
    }



    @Test
    public void testKayak() {
        driver.get("https://kayak.com");
        driver.findElement(By.xpath("//input[@class='k_my-input']")).sendKeys("New York");
        driver.findElement(By.xpath("//div[@aria-label='Remove']")).click();
    }

    @Test
    public void testExpedia() throws InterruptedException {
        driver.get("https://expedia.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[@data-stid='open-room-picker'])")).click();

    }


}
