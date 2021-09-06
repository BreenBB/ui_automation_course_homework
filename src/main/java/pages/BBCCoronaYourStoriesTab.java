package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCCoronaYourStoriesTab extends BasePage {

    @FindBy(xpath = "//a[@href='/news/52143212']")
    private WebElement yourQuestionsPage;

    public WebElement getYourQuestionsPage() {
        return yourQuestionsPage;
    }
    public void clickYourQuestionsPage(){
        yourQuestionsPage.click();
    }

    public BBCCoronaYourStoriesTab(WebDriver driver) {
        super(driver);
    }
}
