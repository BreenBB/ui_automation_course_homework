package tests;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.GeneratedTextPage;
import pages.HomePage;

public class BaseTest {

    ChromeOptions driverOptions = new ChromeOptions();
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }
    public GeneratedTextPage getGeneratedTextPage() {
        return new GeneratedTextPage(getDriver());
    }

    @BeforeMethod
    public void testsSetUp() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driverOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(driverOptions);//создаем экзаемпляр хром драйвера
        driver.manage().window().maximize();//открыли браузер на весь экран
        driver.get("https://lipsum.com/");//открыли сайт
    }

    @AfterMethod
    public void tearDown() {
        driver.close();//закрытие драйвера
    }
}
