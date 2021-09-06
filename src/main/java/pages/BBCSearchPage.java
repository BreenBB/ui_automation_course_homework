package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BBCSearchPage extends BasePage {

    @FindBy(xpath = "//p[@class='ssrcss-7sxcrr-PromoHeadline e1f5wbog4']//span")
    private List<WebElement> searchResultList;

    public BBCSearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchResult(int i) {
        return searchResultList.get(i);
    }
    public String getTextFromSearchResult(int i){
        return searchResultList.get(i).getText();
    }

}
