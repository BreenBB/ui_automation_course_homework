package tests.part2;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CheckAverageCountOfParagraphsWhichContainsWordLorem extends BaseTest {

    @Test
    public void checkGenerateLoremIpsumCorrectness() {
        int count=0;
        for (int i = 0; i<10;i++){
            getHomePage().waitVisibilityOfElement(30,getHomePage().getGenerateLoremIpsumButton());
            getHomePage().clickOnGenerateLoremIpsumButton();
            getGeneratedTextPage().waitVisibilityOfElement(30, getGeneratedTextPage().getLoremIpsumText(0));
            count=count+getGeneratedTextPage().getNumberOfParagraphsWhichContainsWordLorem();
            getGeneratedTextPage().clickOnReturnToHomePageButton();
        }
        System.out.println(count/10);
    }
}
