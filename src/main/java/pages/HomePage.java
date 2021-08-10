package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='http://ru.lipsum.com/']")
    private WebElement languageRussianLink;

    @FindBy(xpath = "//strong[contains(text(),'Lorem Ipsum')]/ancestor::p")
    private WebElement mainPageFirstParagraph;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement generateLoremIpsumButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement startWithLoremIpsumCheckbox;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amountInput;

    @FindBy(xpath = "//input[@name='what']")
    private List<WebElement> generationTypeButtons;

    public void clickOnLanguageRussianLink() {
        languageRussianLink.click();
    }

    public void enterAmount(int i) {
        amountInput.clear();
        amountInput.sendKeys(String.valueOf(i));
    }

    public void selectGenerationType(String type) {
        switch (type) {
            case "paragraphs":
                generationTypeButtons.get(0).click();
                break;
            case "words":
                generationTypeButtons.get(1).click();
                break;
            case "bytes":
                generationTypeButtons.get(2).click();
                break;
            case "lists":
                generationTypeButtons.get(3).click();
                break;
        }
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public WebElement getGenerateLoremIpsumButton() {
        return generateLoremIpsumButton;
    }

    public void clickOnGenerateLoremIpsumButton() {
        generateLoremIpsumButton.click();
    }

    public WebElement getStartWithLoremIpsumCheckbox() {
        return startWithLoremIpsumCheckbox;
    }

    public void clickOnStartWithLoremIpsumCheckbox() {
        startWithLoremIpsumCheckbox.click();
    }

    public WebElement getMainPageElement(){
        return mainPageFirstParagraph;
    }

    public String getMainPageText(){
        return mainPageFirstParagraph.getText();
    }

}
