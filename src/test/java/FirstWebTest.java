
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.*;

public class FirstWebTest {

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        //sleep(2000);

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='/abc.html']"
                )
        );

        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='/']"
                )
        );
        menuStart.click();

        sleep(2000);

        WebElement h2 = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/h2"
                )
        );

        String actualResult = h2.getText();
        sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
