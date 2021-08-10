package stepdefenitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.GeneratedTextPage;
import pages.HomePage;

import java.util.Arrays;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class HomePageSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    GeneratedTextPage generatedTextPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks on Generate Lorem Ipsum Button")
    public void userClicksOnGenerateLoremIpsumButton() {
        homePage.clickOnGenerateLoremIpsumButton();
        generatedTextPage = pageFactoryManager.getGeneratedTextPage();
        generatedTextPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks what text of Generated Lorem Ipsum in the {int} paragraph is {string}")
    public void userChecksWhatTextOfGeneratedLoremIpsumInTheParagraphIs(int i, String checkText) {
        generatedTextPage.waitVisibilityOfElement(30, generatedTextPage.getLoremIpsumText(i - 1));
        assertTrue(generatedTextPage.getTextFromLoremIpsumParagraph(i - 1).contains(checkText));
    }

    @And("User switch to Russian language using one of the links")
    public void userSwitchToRussianLanguageUsingOneOfTheLinks() {
        homePage.clickOnLanguageRussianLink();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that the text of the first <p> element, which is the first paragraph, contains the word {string}")
    public void userChecksThatTheTextOfTheParagraphElementWhichIsTheFirstParagraphContainsTheWord(String checkText) {
        homePage.waitVisibilityOfElement(30, homePage.getMainPageElement());
        assertTrue(homePage.getMainPageText().contains("рыба"));
    }

    @And("User unchecks <start with Lorem Ipsum> checkbox")
    public void userUnchecksStartWithLoremIpsumCheckbox() {
        homePage.clickOnStartWithLoremIpsumCheckbox();
        homePage.implicitWait(30);
    }

    @Then("User verifies that result no longer starts with Lorem ipsum")
    public void userVerifiesThatResultNoLongerStartsWithLoremIpsum() {
        generatedTextPage.waitVisibilityOfElement(30, generatedTextPage.getLoremIpsumText(0));
        assertFalse(generatedTextPage.getTextFromLoremIpsumParagraph(0).startsWith("Lorem ipsum"));
    }

    @And("User clicks on {string}")
    public void userClicksOnRadioButton(String type) {
        homePage.selectGenerationType(type);
    }

    @And("User input {string} into the number field")
    public void userInputNumberIntoTheNumberField(String number) {
        homePage.enterAmount(Integer.parseInt(number.replaceAll("[^0-9.]", "")));
    }

    @Then("User verifies the result has {string} of {string}")
    public void userVerifiesTheResultHasNumberOfType(String number, String type) {
        generatedTextPage.waitVisibilityOfElement(30, generatedTextPage.getLoremIpsumText(0));
        System.out.println(generatedTextPage.getLengthFromLoremIpsumText());
        assertEquals(generatedTextPage.getLengthFromLoremIpsumText(), Integer.parseInt(number.replaceAll("[^0-9.]", "")));
    }

}
