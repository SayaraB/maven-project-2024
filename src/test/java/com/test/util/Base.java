package com.test.util;

import com.github.javafaker.Faker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Base {

    public WebDriver driver = null;
    public WebDriver wait = null;
    public static String streetAddress = null;
    public static String firstName = null;
    public static String lastName = null;
    public static String city = null;
    public static String state = null;
    public static String zipcode = null;
    public static String phoneNumber = null;
    public static String SSN = null;
    public static String username = null;
    public static String password = null;

    @BeforeClass
    public static void DataGenerator() {

       /* FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String email = fakeValuesService.bothify("????##@gmail.com");
        Matcher emailMatcher = Pattern.compile("\\w{4}\\d{2}@gmail.com").matcher(email);

        assertTrue(emailMatcher.find());*/

        Faker faker = new Faker();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        streetAddress = faker.address().streetAddress();
        city = faker.address().city();
        state = faker.address().state();
        zipcode = faker.address().zipCode();

        Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(99);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
        DecimalFormat df2 = new DecimalFormat("00"); //2 zeros
        phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        SSN = df3.format(num1) + "-" + df2.format(num2) + "-" + df4.format(num1);

        username = String.valueOf(faker.cat());
        password = rand.ints(10, 33, 122).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());
    }


    @BeforeMethod// it runs before each test case
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("-incognito");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();

    }

//@AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
