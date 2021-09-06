package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BBCNewsPage extends BasePage {

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")
    private WebElement headlineArticle;

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//a[@class='gs-c-section-link gs-c-section-link--truncate nw-c-section-link nw-o-link nw-o-link--no-visited-state']//span")
    private WebElement headlineCategory;

    @FindBy(xpath = "//div[contains(@class,'nw-c-top-stories__secondary-item')]//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private List<WebElement> secondaryArticles;

    @FindBy(xpath = "//button[@id='orb-search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='gs-u-display-none gs-u-display-block@m nw-o-news-wide-navigation']//a[@href='/news/coronavirus']")
    private WebElement coronaTab;

    public BBCNewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeadlineArticle() {
        return headlineArticle;
    }
    public String getTextFromHeadlineArticle(){
        return headlineArticle.getText();
    }

    public WebElement getHeadlineCategory() {
        return headlineCategory;
    }
    public String getTextFromHeadlineCategory(){
        return headlineCategory.getText();
    }

    public WebElement getSecondaryArticle(int i) {
        return secondaryArticles.get(i);
    }
    public String getTextFromSecondaryArticle(int i){
        return secondaryArticles.get(i).getText();
    }

    public WebElement getSearchInput() {
        return searchInput;
    }
    public void inputTextIntoSearch(String input){
        searchInput.clear();
        searchInput.sendKeys(input);
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
    public void clickOnSearchButton(){
        searchButton.click();
    }

    public WebElement getCoronaTab() {
        return coronaTab;
    }
    public void clickOnCoronaTab(){
        coronaTab.click();
    }

}
