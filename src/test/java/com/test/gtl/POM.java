/*public class POM extends Base {

    CheapFlightsSearchPOs homePage = new CheapFlightsSearchPOs(driver);
        driver.get("https://www.cheapoair.com/");

    // Select your departure airport:
        Thread.sleep(3000);
    // Click on x button to clean the box
        homePage.cleanDepartureBox();
        homePage.insertDepartureCity("New York");
        Thread.sleep(1000);
        homePage.selectOptionNumber(4);

    // Select your destination airport: 8:51
        driver.findElement(By.xpath("(//a[@aria-label='clear field'])[2]")).click();
    WebElement box2 = driver.findElement(By.xpath("//input[@id='to0']"));
        box2.sendKeys("Miami");
        Thread.sleep(1000);
        box2.sendKeys(Keys.ENTER);
}
*/