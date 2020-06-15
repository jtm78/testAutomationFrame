package testcases.pet;

import core.helpers.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void checkOutThatUrlOpens() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Constants.RESOURCES_PATH + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(5000);

    }
}
