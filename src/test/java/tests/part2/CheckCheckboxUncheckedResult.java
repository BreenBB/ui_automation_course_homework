package tests.part2;

import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.*;

public class CheckCheckboxUncheckedResult extends BaseTest {

    @Test
    public void checkGenerateLoremIpsumCorrectness() {
        getHomePage().clickOnStartWithLoremIpsumCheckbox();
        getHomePage().implicitWait(30);
        getHomePage().clickOnGenerateLoremIpsumButton();
        getGeneratedTextPage().waitVisibilityOfElement(30,getGeneratedTextPage().getLoremIpsumText(0));
        assertFalse(getGeneratedTextPage().getTextFromLoremIpsumParagraph(0).startsWith("Lorem ipsum"));
    }

}
