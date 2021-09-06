package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BBCYourQuestionsPage extends BasePage {

    @FindBy(xpath = "//textarea[@aria-label='What questions would you like us to answer?']")
    private WebElement textField;

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@aria-label='Contact number']")
    private WebElement contactNumberField;

    @FindBy(xpath = "//input[@aria-label='Location ']")
    private WebElement locationField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement acceptTermsCheckbox;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private WebElement errorMessage;

    @FindBy(xpath = " //button[@class='button']")
    private WebElement submitButton;

    public BBCYourQuestionsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTextField() {
        return textField;
    }
    public void inputTextIntoTextField(String input){
        textField.clear();
        textField.sendKeys(input);
    }

    public WebElement getNameField() {
        return nameField;
    }
    public void inputTextIntoNameField(String input){
        nameField.clear();
        nameField.sendKeys(input);
    }

    public WebElement getEmailField() {
        return emailField;
    }
    public void inputTextIntoEmailField(String input){
        emailField.clear();
        emailField.sendKeys(input);
    }

    public WebElement getContactNumberField() {
        return contactNumberField;
    }
    public void inputTextIntoContactNumberField(String input){
        contactNumberField.clear();
        contactNumberField.sendKeys(input);
    }

    public WebElement getLocationField() {
        return locationField;
    }
    public void inputLocationField(String input){
        locationField.clear();
        locationField.sendKeys(input);
    }

    public WebElement getAcceptTermsCheckbox() {
        return acceptTermsCheckbox;
    }
    public void clickOnAcceptTermsCheckbox(){
        acceptTermsCheckbox.click();
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
    public void clickOnSubmitButton(){
        //Actions builder = new Actions(driver);
        //builder.moveToElement(submitButton).perform();
        //((JavascriptExecutor) driver).executeScript("arguments[0].click()", submitButton);
        submitButton.click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
    public String getTextFromErrorMessage(){
        return errorMessage.getText();
    }
}
