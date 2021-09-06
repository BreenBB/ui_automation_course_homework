package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoremIpsumGeneratedTextPage extends BasePage {

    public LoremIpsumGeneratedTextPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='lipsum']/p")
    private List<WebElement> generatedLoremIpsumTextList;

    @FindBy(xpath = "//div[@id='lipsum']/p")
    private WebElement generatedLoremIpsumText;

    @FindBy(xpath = "//a[@class='zz']")
    private WebElement returnToHomePageButton;

    public void clickOnReturnToHomePageButton() {
        returnToHomePageButton.click();
    }

    public WebElement getLoremIpsumText(int i){
        return generatedLoremIpsumTextList.get(i);
    }

    public String getTextFromLoremIpsumParagraph(int i){
        return generatedLoremIpsumTextList.get(i).getText();
    }

    public int getNumberOfParagraphsWhichContainsWordLorem(){
        int count=0;
        for (int i = 0; i<generatedLoremIpsumTextList.size();i++){
            if (generatedLoremIpsumTextList.get(i).getText().toLowerCase().contains("lorem"))
                count++;
        }
        return count;
    }

    public int getWordCountFromLoremIpsumText(){
        String[] words = generatedLoremIpsumText.getText().split("\\s+");
        return words.length;
    }

    public int getLengthFromLoremIpsumText(){
        return generatedLoremIpsumText.getText().length();
    }

}
