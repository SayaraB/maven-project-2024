package com.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheapFlightSearchPageFactoryPOs {

    // uses annotations to find element

    @FindBy(xpath = "(//a[@aria-label='clear field'])[1]")
    WebElement fromSearchBoxDeleteBtn;

    @FindBy(xpath = "//input[@id='from0']")
    WebElement fromSearchBox;

    @FindBy(xpath = "(//a[@aria-label='clear field'])[2]")
    WebElement toSearchBoxDeleteBtn;
    @FindBy(xpath = "//input[@id='to0']")
    WebElement toSearchBox;

    public CheapFlightSearchPageFactoryPOs(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private void cleanDepartureBox() {
        fromSearchBoxDeleteBtn.click();
    }

    private void cleanArrivalBox() {
        toSearchBoxDeleteBtn.click();
    }

    public void insertDepartureCity(String city) {
        cleanDepartureBox();
        fromSearchBox.sendKeys(city);
    }

    public void insertDestinationCity(String city) {
        cleanArrivalBox();
        toSearchBox.sendKeys(city);

    }

    public void selectOptionNumberDeparture(int number) {

        for (int i = 0; i < number; i++) {
            fromSearchBox.sendKeys(Keys.ARROW_DOWN);

        }
        fromSearchBox.sendKeys(Keys.ENTER);
    }

    public void selectOptionNumberArrival(int number) {

        for (int i = 0; i < number; i++) {
            toSearchBox.sendKeys(Keys.ARROW_DOWN);

        }
        toSearchBox.sendKeys(Keys.ENTER);
    }


}
