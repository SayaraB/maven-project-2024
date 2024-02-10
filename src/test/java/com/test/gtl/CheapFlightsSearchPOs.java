package com.test.gtl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheapFlightsSearchPOs {
    private WebDriver driver;

    By fromSearchBoxDeleteBtn = By.xpath("(//a[aria-label='clear field;])[1]");
    By getFromSearchBox = By.xpath("//input[@id='from0']");

    public CheapFlightsSearchPOs(WebDriver driver) {
        this.driver=driver;
    }


}
