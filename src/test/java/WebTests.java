import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class WebTests {

    private static final String URL = "http://www.99-bottles-of-beer.net/";
    private static final String URL_SUBMIT_NEW_LANGUAGE =
            "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

    //TC_11_01+
    //Steps:
    //1. Open the website on the base page https://www.99-bottles-of-beer.net/
    //2. Read the title in the upper right corner
    //3. Verify that the title text matches the expected
    //4. Close the browser
    @Test
    public void testHeadingOfPage() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

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
    //TC_11_02+
    //Steps:
    //1. Open the website on the base page https://www.99-bottles-of-beer.net/
    //2. Read the name of the last menu item
    //3. Verify that the name of the last menu item corresponds to the expected
    //4. Close the browser
    @Test
    public void testNameOfLastMenuItem() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = ("SUBMIt NeW LANGUAGE").toLowerCase();

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement menuLastElement = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul/li/a[contains(text(), 'Submit new Language')]"
                )
        );
        String actualResult = menuLastElement.getText().toLowerCase();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_03+
    //Steps:
    //1. Open the website on the base page https://www.99-bottles-of-beer.net/
    //2. Click on the menu item Submit new Language
    //3. Read the title of the subtitle of the last menu item
    //4. Verify that the title of the subtitle of the last menu item corresponds
    // to the expected
    //5. Close the browser
    @Test
    public void testSubtitleNewLanguage() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = ("Submit New Language").toLowerCase();

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        WebElement menuLastElement = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul/li/a[contains(text(), 'Submit new Language')]"
                )
        );
        menuLastElement.click();

        WebElement nameOfSubtitle = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[contains(text(), 'Submit New Language')]"
                )
        );
        String actualResult = nameOfSubtitle.getText().toLowerCase();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_04+
    //1. Open the website on the page http://www.99-bottles-of-beer.net/abc.html
    //2. Read the title of the first subtitle
    //3. Verify that the name of the submenu corresponds to the expected
    //4. Close the browser
    @Test
    public void testFirstItemOfSubmit() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.99-bottles-of-beer.net/abc.html");

        WebElement firstSubmenuOfBrowseLanguages = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a"
                )
        );

        String actualResult = firstSubmenuOfBrowseLanguages.getText();
        sleep(1000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_05 ???? Можно сделать по другому????
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
        String expectedResultOne = "Oliver Schade";
        String expectedResultTwo = "Gregor Scheithauer";
        String expectedResultThree = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement subtitleTeam = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"
                )
        );
        subtitleTeam.click();
        sleep(1000);

        WebElement teamOFSiteCreatorsOne = driver.findElement(
                By.xpath(
                        "//h3[contains(text(), 'Oliver Schade')]"
                ));
        String actualResultOne = teamOFSiteCreatorsOne.getText();
        Assert.assertEquals(actualResultOne, expectedResultOne);

        WebElement teamOFSiteCreatorsTwo = driver.findElement(
                By.xpath(
                        "//h3[contains(text(), 'Gregor Scheithauer')]"
                ));
        String actualResultTwo = teamOFSiteCreatorsTwo.getText();
        Assert.assertEquals(actualResultTwo, expectedResultTwo);

        WebElement teamOFSiteCreatorsThree = driver.findElement(
                By.xpath(
                        "//h3[contains(text(), 'Stefan Scheler')]"
                ));
        String actualResultThree = teamOFSiteCreatorsThree.getText();
        Assert.assertEquals(actualResultThree, expectedResultThree);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_06+
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Найти кнопку Search Languages
    //3. Нажать на кнопку Search Languages
    //4. Найти название поля для ввода языка
    //5. Подтвердить, что поле для ввода соответствует ожидаемому "Search for:"
    //6. Закрыть браузер
    @Test
    public void test() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = "Search for:";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement searchLanguages = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul/li/a[@href='/search.html']"
                )
        );
        searchLanguages.click();

        WebElement searchFor = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/form/p/strong"
                )
        );
        String actualResult = searchFor.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_07+
    //    Подтвердите, что если на странице по ссылке
    //    http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
    //    пользователь нажмет кнопку Submit Language,  не заполнив информацию
    //    в обязательных полях, будет показана ошибка
    //Error: Precondition failed - Incomplete Input.
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Нажать на кнопку Submit Language
    //3. Подтвердить, что на странице показана ошибка
    //4. Подтвердить, что текст ошибки соответствует ожидаемому
    //5. Закрыть браузер
    @Test
    public void testErrorOfSubmitLanguage() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_SUBMIT_NEW_LANGUAGE);
        WebElement submitLanguage = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']//div[@id='main']/form[@id='addlanguage']/p/input[@name='submitlanguage']"
                )
        );
        submitLanguage.click();

        WebElement error = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/p/b/u"
                )
        );
        error.getText();

        WebElement textOfError = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/p[contains(text(), ' Precondition failed - Incomplete Input.')]"
                )
        );

        String actualResult = textOfError.getText();
        sleep(1000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_08+/-
    //Precondition: Если на странице по ссылке
    // http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
    // пользователь нажмет кнопку Submit Language,
    // не заполнив информацию в обязательных полях,
    // будет показана ошибка с текстом
    //Error: Precondition failed - Incomplete Input.
    //Подтвертите, что в тексте ошибки слова Error, Precondition,
    // Incomplete и Input написаны с большой буквы, а слово failed  написано
    // с маленькой буквы.
    //Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Нажать на кнопку Submit Language
    //3. Считать текст ошибки
    //4. Подтвердить requirenments
    //5. Закрыть браузер
    @Test
    public void testTextOfErrorOfSubmitLanguage() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_SUBMIT_NEW_LANGUAGE);
        WebElement submitLanguage = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']//div[@id='main']/form[@id='addlanguage']/p/input[@name='submitlanguage']"
                )
        );
        submitLanguage.click();

        WebElement error = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/p/b/u"
                )
        );
        error.getText();

        WebElement textOferror = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/p[contains(text(), ' Precondition failed - Incomplete Input.')]"
                )
        );

        String actualResult = textOferror.getText();
        sleep(1000);

        for (int i = 0; i < actualResult.length(); i++) {
            if (actualResult.charAt(i) == 'E' && actualResult.charAt(i) == 'P'
                    && actualResult.charAt(i) == 'f'
                    && actualResult.charAt(i) == 'I'
                    && actualResult.charAt(i) == ':'
                    && actualResult.charAt(i) == '-'
                    && actualResult.charAt(i) == '.') {
            }
            Assert.assertEquals(actualResult, expectedResult);
        }
        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_09+
    //    Подтвердите, что на странице по ссылке
    //    http://www.99-bottles-of-beer.net/submitnewlanguage.html в первом пункте
    //    списка пользователь видит текст
    //IMPORTANT: Take your time! The more carefully you fill out this form
    // (especially the language name and description), the easier it will be for
    // us and the faster your language will show up on this page. We don't have the
    // time to mess around with fixing your descriptions etc. Thanks for your
    // understanding.
    //Шаги:
    //1. Открыть вебсайт на странице
    //2. Считать текст
    //3. Подтвердить, что текст соответствует ожидаемому
    //4. Закрыть браузер
    @Test
    public void testTextOfImportant() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = "IMPORTANT: Take your time! The more " +
                "carefully you fill out this form (especially the language" +
                " name and description), the easier it will be for us and the" +
                " faster your language will show up on this page. We don't" +
                " have the time to mess around with fixing your descriptions " +
                "etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_SUBMIT_NEW_LANGUAGE);
        WebElement important = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/ul/li[position()=1]"
                )
        );
        String actualResult = important.getText();
        sleep(1000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_10+
    //Подтвердите, что нажав на пункт меню Browse Languages, пользователь
    // увидит таблицу со следующими названиями для первого и второго столбцов:
    //Language
    //Author
    //Шаги:
    //1. Открыть вебсайт на базовой странице http://www.99-bottles-of-beer.net/
    //2. Нажать на пункт меню Browse Languages
    //3. Считать названия первого и второго столбцов таблицы
    //3. Подтвердить, что названия соответствует ожидаемым
    //4. Закрыть браузер
    @Test
    public void testNameOfСolumns() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResultOne = "Language";
        String expectedResultTwo = "Author";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        sleep(1000);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='/abc.html']"
                )
        );

        menuBrowseLanguages.click();

        WebElement nameOfFirstColumn = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']" +
                                "/table[@id='category']/tbody/tr/th[position()=1]"
                )
        );
        String actualResultOne = nameOfFirstColumn.getText();
        sleep(600);
        Assert.assertEquals(actualResultOne, expectedResultOne);

        WebElement nameOfSecondColumn = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']" +
                                "/table[@id='category']/tbody/tr/th[position()=2]"
                )
        );

        String actualResultTwo = nameOfSecondColumn.getText();
        sleep(600);
        Assert.assertEquals(actualResultTwo, expectedResultTwo);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_11+
    //Подтвердите, что на странице по базовой ссылке  пользователь НЕ увидит
    // новые комментарии, если нажмет на пункты меню Top List → New Comments
    //Шаги:
    //1. Открыть вебсайт на базовой странице http://www.99-bottles-of-beer.net/
    //2. Нажать на пункт меню Top List
    //3. Нажать на пункт подменю New Comments
    //4. Считать текст
    //5. Подтвердить, что текста нет
    @Test
    public void testNothingnothingIsVisible() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = "";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath(
                        "//ul/li/a[@href='/toplist.html']"
                )
        ).click();

        driver.findElement(
                By.xpath(
                        "//ul[@id='submenu']/li/a[@href='./newcomments.html']"
                )
        ).click();

        WebElement list = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='main']/p"
                )
        );

        String actualResult = list.getText();;

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //--------------------------------------------------------------------------
    //TC_11_12 Доделать!!!!!
    //Подтвердите, что на странице по ссылке
    // http://www.99-bottles-of-beer.net/submitnewlanguage.html пользователь
    // видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом
    // на красном фоне, и что все буквы - capital
    //Шаги:
    //1. Открыть вебсайт на странице http://www.99-bottles-of-beer.net/submitnewlanguage.html
    //2. Считать слово IMPORTANT: из списка
    //3. Подтвердить requirenments
    //4. Закрыть браузер
    @Test
    public void testStyleOfWordImportant() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "F:\\QA\\Installer\\ChromeDriver\\chromedriver.exe";
        String expectedResult = "IMPORTANT:";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_SUBMIT_NEW_LANGUAGE);

        WebElement important = driver.findElement(
                By.xpath(
                        "//div[@id='main']/ul/li/span/b"
                )
        );

       String actualResult =  important.getText();

       if(driver.findElement(By.xpath("//div[@id='main']/ul/li/span"))
               .getAttribute("style")=="background-color:red; color: white"){

           Assert.assertEquals(actualResult, expectedResult);
       }

       driver.quit();
    }
}
