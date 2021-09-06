package stepdefenitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class LoremIpsumSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    LoremIpsumHomePage loremIpsumHomePage;
    LoremIpsumGeneratedTextPage loremIpsumGeneratedTextPage;

    BBCHomePage bBCHomePage;
    BBCNewsPage bBCNewsPage;
    BBCSearchPage bBCSearchPage;
    BBCCoronaPage bBCCoronaPage;
    BBCCoronaYourStoriesTab bBCCoronaYourStoriesTab;
    BBCYourQuestionsPage bBCYourQuestionsPage;

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
        if(url=="https://lipsum.com/") {
            loremIpsumHomePage = pageFactoryManager.getHomePage();
            loremIpsumHomePage.openHomePage(url);
        }
        else {
            bBCHomePage = pageFactoryManager.getBBCHomePage();
            bBCHomePage.openHomePage(url);
        }
    }

    @And("User clicks on Generate Lorem Ipsum Button")
    public void userClicksOnGenerateLoremIpsumButton() {
        loremIpsumHomePage.clickOnGenerateLoremIpsumButton();
        loremIpsumGeneratedTextPage = pageFactoryManager.getGeneratedTextPage();
        loremIpsumGeneratedTextPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks what text of Generated Lorem Ipsum in the {int} paragraph is {string}")
    public void userChecksWhatTextOfGeneratedLoremIpsumInTheParagraphIs(int i, String checkText) {
        loremIpsumGeneratedTextPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loremIpsumGeneratedTextPage.getLoremIpsumText(i - 1));
        assertTrue(loremIpsumGeneratedTextPage.getTextFromLoremIpsumParagraph(i - 1).contains(checkText));
    }

    @And("User switch to Russian language using one of the links")
    public void userSwitchToRussianLanguageUsingOneOfTheLinks() {
        loremIpsumHomePage.clickOnLanguageRussianLink();
        loremIpsumHomePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that the text of the first <p> element, which is the first paragraph, contains the word {string}")
    public void userChecksThatTheTextOfTheParagraphElementWhichIsTheFirstParagraphContainsTheWord(String checkText) {
        loremIpsumHomePage.waitVisibilityOfElement(30, loremIpsumHomePage.getMainPageElement());
        assertTrue(loremIpsumHomePage.getMainPageText().contains("рыба"));
    }

    @And("User unchecks <start with Lorem Ipsum> checkbox")
    public void userUnchecksStartWithLoremIpsumCheckbox() {
        loremIpsumHomePage.clickOnStartWithLoremIpsumCheckbox();
        loremIpsumHomePage.implicitWait(30);
    }

    @Then("User verifies that result no longer starts with Lorem ipsum")
    public void userVerifiesThatResultNoLongerStartsWithLoremIpsum() {
        loremIpsumGeneratedTextPage.waitVisibilityOfElement(30, loremIpsumGeneratedTextPage.getLoremIpsumText(0));
        assertFalse(loremIpsumGeneratedTextPage.getTextFromLoremIpsumParagraph(0).startsWith("Lorem ipsum"));
    }

    @And("User clicks on {string}")
    public void userClicksOnRadioButton(String type) {
        loremIpsumHomePage.selectGenerationType(type);
    }

    @And("User input {int} into the number field")
    public void userInputNumberIntoTheNumberField(int i) {
        loremIpsumHomePage.enterAmount(i);
    }

    @Then("User verifies the result has {int} of {string}")
    public void userVerifiesTheResultHasNumberOfType(int i, String type) {
        loremIpsumGeneratedTextPage.waitVisibilityOfElement(30, loremIpsumGeneratedTextPage.getLoremIpsumText(0));
        if (type.equals("words")){
            assertEquals(loremIpsumGeneratedTextPage.getWordCountFromLoremIpsumText(), i);}
        else {
            assertEquals(loremIpsumGeneratedTextPage.getLengthFromLoremIpsumText(), i);
        }
    }

    @And("Run the generation {int} times and paragraphs contain word lorem with probability of more than 40 percent")
    public void runTheGenerationNumberTimes(int number) {
        int wordCount = 0;
        loremIpsumHomePage.waitVisibilityOfElement(30, loremIpsumHomePage.getGenerateLoremIpsumButton());
        for (int i = 0; i<number;i++) {
            loremIpsumHomePage.clickOnGenerateLoremIpsumButton();
            loremIpsumGeneratedTextPage = pageFactoryManager.getGeneratedTextPage();
            loremIpsumGeneratedTextPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
            loremIpsumGeneratedTextPage.waitVisibilityOfElement(30, loremIpsumGeneratedTextPage.getLoremIpsumText(0));
            wordCount = wordCount + loremIpsumGeneratedTextPage.getNumberOfParagraphsWhichContainsWordLorem();
            loremIpsumGeneratedTextPage.clickOnReturnToHomePageButton();
            loremIpsumHomePage = pageFactoryManager.getHomePage();
            loremIpsumHomePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        }
        assertTrue(wordCount/10>2);
    }

    //BBC

    @And("User clicks on News tab")
    public void userClicksOnNewsTab() {
        bBCHomePage.clickOnNewsTab();
        bBCNewsPage = pageFactoryManager.getBBCNewsPage();
        bBCNewsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks what the name of the headline article is {string}")
    public void userChecksWhatTheNameOfTheHeadlineArticleIs(String articleName) {
        bBCNewsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCNewsPage.getHeadlineArticle());
        assertEquals(articleName,bBCNewsPage.getTextFromHeadlineArticle());
    }

    @Then("User checks what the names of the secondary articles")
    public void userChecksWhatTheNamesOfTheSecondaryArticles() {

        List<String> secondaryArticlesList = new ArrayList<>();
        secondaryArticlesList.add("Relatives of MH17 victims speak of trauma in court");
        secondaryArticlesList.add("Australian boy, 3, rescued after four days in bush");
        secondaryArticlesList.add("Twins who were conjoined see each other first time");
        secondaryArticlesList.add("Long jail terms for key Belarus opposition pair");
        secondaryArticlesList.add("Kim Kardashian crypto ad singled out by watchdog");

        bBCNewsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCNewsPage.getSecondaryArticle(0));

        for(int i = 0; i<secondaryArticlesList.size(); i++){
            assertEquals(secondaryArticlesList.get(i),bBCNewsPage.getTextFromSecondaryArticle(i));
        }
    }

    @Then("User type in search category link and checks result")
    public void userTypeInSearchCategoryLinkAndChecksResult() {
        String searchInput;
        bBCNewsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCNewsPage.getSearchInput());
        searchInput = bBCNewsPage.getTextFromHeadlineCategory();
        bBCNewsPage.inputTextIntoSearch(searchInput);
        bBCNewsPage.clickOnSearchButton();
        bBCSearchPage = pageFactoryManager.getBBCSearchPage();
        bBCSearchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bBCSearchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCSearchPage.getSearchResult(0));
        assertTrue(bBCSearchPage.getTextFromSearchResult(0).contains(searchInput));
    }

    @When("User press on Coronavirus tab")
    public void userPressOnCoronavirusTab() {
        bBCNewsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCNewsPage.getCoronaTab());
        bBCNewsPage.clickOnCoronaTab();
        bBCCoronaPage = pageFactoryManager.getBBCCoronaPage();
        bBCCoronaPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User press on Your Coronavirus Stories tab")
    public void userPressOnYourCoronavirusStoriesTab() {
        bBCCoronaPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCCoronaPage.getYourStoriesTab());
        bBCCoronaPage.clickOnYourStoriesTab();
        bBCCoronaYourStoriesTab = pageFactoryManager.getBBCCoronaYourStoriesTab();
        bBCCoronaYourStoriesTab.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @When("User press on Your Questions link")
    public void userPressOnYourQuestionsLink() {
        bBCCoronaYourStoriesTab.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCCoronaYourStoriesTab.getYourQuestionsPage());
        bBCCoronaYourStoriesTab.clickYourQuestionsPage();
        bBCYourQuestionsPage = pageFactoryManager.getBBCYourQuestionsPage();
        bBCYourQuestionsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User types in {string}, {string}, {string}, {string} and {string} into appropriate fields")
    public void userTypesInAndIntoAppropriateFields(String text, String name, String email, String contactNumber, String location) {
        bBCYourQuestionsPage.inputTextIntoTextField(text);
        bBCYourQuestionsPage.inputTextIntoNameField(name);
        bBCYourQuestionsPage.inputTextIntoEmailField(email);
        bBCYourQuestionsPage.inputTextIntoContactNumberField(contactNumber);
        bBCYourQuestionsPage.inputLocationField(location);
    }

    @And("User {string} on check box")
    public void userOnCheckBox(String checkbox) {
        bBCYourQuestionsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCYourQuestionsPage.getAcceptTermsCheckbox());
        System.out.println(checkbox);
        if(!checkbox.equals("don't press")) {
            bBCYourQuestionsPage.clickOnAcceptTermsCheckbox();
            System.out.println("true");
        }
    }

    @When("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
        bBCYourQuestionsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bBCYourQuestionsPage.getSubmitButton());
        bBCYourQuestionsPage.clickOnSubmitButton();
    }

    @Then("User checks what error message is displayed")
    public void userChecksWhatErrorMessageIsDisplayed() {
        bBCYourQuestionsPage.waitTextToBePresent(DEFAULT_TIMEOUT,bBCYourQuestionsPage.getErrorMessage(),"be");
        assertTrue(bBCYourQuestionsPage.getTextFromErrorMessage().contains("can't be blank") || bBCYourQuestionsPage.getTextFromErrorMessage().contains("must be accepted"));
    }
}
