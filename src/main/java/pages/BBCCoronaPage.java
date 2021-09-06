package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCCoronaPage extends BasePage {

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide-secondary']//a[@href='/news/have_your_say']")
    private WebElement yourStoriesTab;

    public WebElement getYourStoriesTab() {
        return yourStoriesTab;
    }
    public void clickOnYourStoriesTab(){
        yourStoriesTab.click();
    }

    public BBCCoronaPage(WebDriver driver) {
        super(driver);
    }
}
