package tests.part1;

import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.*;

public class CheckGenerateLoremIpsumCorrectness extends BaseTest {

    @Test
    public void checkGenerateLoremIpsumCorrectness() {
        getHomePage().clickOnGenerateLoremIpsumButton();
        getGeneratedTextPage().waitVisibilityOfElement(30,getGeneratedTextPage().getLoremIpsumText(0));
        assertTrue(getGeneratedTextPage().getTextFromLoremIpsumParagraph(0).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit"));
    }
}
