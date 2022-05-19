import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class WebTests {
    //TC_11_01
    //Steps:
    //1. Open the website on the base page https://www.99-bottles-of-beer.net/
    //2. Read the title in the upper right corner
    //3. Verify that the title text matches the expected
    //4. Close the browser
    @Test
    public void testHeadingOfPage() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement h1 = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='header']/h1"
                )
        );
        String actualResult = h1.getText();
        sleep(1000);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    //--------------------------------------------------------------------------
    //TC_11_02
    //Steps:
    //1. Open the website on the base page https://www.99-bottles-of-beer.net/
    //2. Read the name of the last menu item
    //3. Verify that the name of the last menu item corresponds to the expected
    //4. Close the browser
    @Test
    public void testNameOfLastMenuItem() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "SUBMIt NEW LANGUAGE";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement menuLastElement = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul/li" +
                                "/a[contains(text(), 'Submit new Language')]"
                )
        );

        sleep(1000);
        String actualResult = menuLastElement.getText();

        expectedResult = expectedResult.toLowerCase();
        actualResult = actualResult.toLowerCase();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    //--------------------------------------------------------------------------
    //TC_11_03
    //Steps:
    //1. Open the website on the base page https://www.99-bottles-of-beer.net/
    //2. Click on the menu item Submit new Language
    //3. Read the title of the subtitle of the last menu item
    //4. Verify that the title of the subtitle of the last menu item corresponds to the expected
    //5. Close the browser
    @Test
    public void testSubtitleNewLanguage() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        WebElement menuLastElement = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul/li" +
                                "/a[contains(text(), 'Submit new Language')]"
                )
        );
        menuLastElement.click();
        sleep(1000);

        WebElement nameOfSubtitle = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='submenu']/li" +
                                "/a[contains(text(), 'Submit New Language')]"
                )
        );
        String actualResult = nameOfSubtitle.getText();

        expectedResult = expectedResult.toLowerCase();
        actualResult = actualResult.toLowerCase();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    //--------------------------------------------------------------------------
    //TC_11_04
    //1. Open the website on the page http://www.99-bottles-of-beer.net/abc.html
    //2. Read the title of the first subtitle
    //3. Verify that the name of the submenu corresponds to the expected
    //4. Close the browser
    @Test
    public void testFirstItemOfSubmit() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement firstSubmenuOfBrowseLanguages = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a"
                )
        );

        sleep(1000);

        String actualResult = firstSubmenuOfBrowseLanguages.getText();
        sleep(1000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
    //--------------------------------------------------------------------------
    //TC_11_05
    //Steps:
    //1.  Open the website on the base page https://www.99-bottles-of-beer.net/
    //2.  Find the Team subtitle on the page
    //3.  Click on the Team subtitle
    //4.  Find the names of the creators of the site
    //5.  Verify that the names of the creators of the site:
    //    Oliver Schade
    //    Gregor Scheithauer
    //    Stefan Scheler
    //6.  Close the browser
    @Test
    public void testNamesOfSiteCreator() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultOne = "Oliver Schade";
        String expectedResultTwo = "Gregor Scheithauer";
        String expectedResultThree = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement SubtitleTeam = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='submenu']/li/a[@href='team.html']"
                ));
        sleep(1000);
        SubtitleTeam.click();
        sleep(3000);

        WebElement teamOFSiteCreatorsOne = driver.findElement(
                By.xpath(
                        "//h3[contains(text(), 'Oliver Schade')]"
                ));
        String actualResultOne = teamOFSiteCreatorsOne.getText();
        Assert.assertEquals(actualResultOne, expectedResultOne);
        sleep(1000);

        WebElement teamOFSiteCreatorsTwo = driver.findElement(
                By.xpath(
                        "//h3[contains(text(), 'Gregor Scheithauer')]"
                ));
        String actualResultTwo = teamOFSiteCreatorsTwo.getText();
        Assert.assertEquals(actualResultTwo, expectedResultTwo);
        sleep(1000);

        WebElement teamOFSiteCreatorsThree = driver.findElement(
                By.xpath(
                        "//h3[contains(text(), 'Stefan Scheler')]"
                ));
        String actualResultThree = teamOFSiteCreatorsThree.getText();
        Assert.assertEquals(actualResultThree, expectedResultThree);
        sleep(1000);

        driver.quit();
    }
    //--------------------------------------------------------------------------
    //TC_11_07

    //TC_11_11

    //TC_11_12

    //TC_11_13

    //TC_11_14

    //TC_11_15

    //TC_11_21


}
