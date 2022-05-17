import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests {

    @Test
    public void testHeadingOfPage() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        //sleep(3000);

        driver.get(url);

        WebElement menuStart = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='/']"
                )
        );
        menuStart.click();

       // sleep(3000);

        WebElement h1 = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='header']/h1"
                )
        );

        String actualResult = h1.getText();
        //sleep(3000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();




    }


}
