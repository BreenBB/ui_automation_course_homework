package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoremIpsumHomePage getHomePage() {
        return new LoremIpsumHomePage(driver);
    }
    public LoremIpsumGeneratedTextPage getGeneratedTextPage() {
        return new LoremIpsumGeneratedTextPage(driver);
    }

    public BBCHomePage getBBCHomePage() {
        return new BBCHomePage(driver);
    }
    public BBCNewsPage getBBCNewsPage() {
        return new BBCNewsPage(driver);
    }
    public BBCSearchPage getBBCSearchPage() {
        return new BBCSearchPage(driver);
    }
    public BBCCoronaPage getBBCCoronaPage() {
        return new BBCCoronaPage(driver);
    }
    public BBCCoronaYourStoriesTab getBBCCoronaYourStoriesTab() {
        return new BBCCoronaYourStoriesTab(driver);
    }
    public BBCYourQuestionsPage getBBCYourQuestionsPage() {
        return new BBCYourQuestionsPage(driver);
    }
}