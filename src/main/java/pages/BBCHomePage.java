package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BBCHomePage extends BasePage {

    @FindBy(xpath = "//nav[@role='navigation']//a[@HREF='https://www.bbc.com/news']")
    private WebElement newsTab;

    public BBCHomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public WebElement getNewsTab() {
        return newsTab;
    }

    public void clickOnNewsTab() {
        newsTab.click();
    }

}
