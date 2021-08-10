package tests.part2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class CheckNumberOfWordsInText extends BaseTest {

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{10,"words",10},
                {-1,"words",5},
                {0,"words",5},
                {5,"words",5},
                {20,"words",20},
                {10,"bytes",10},
                {-1,"bytes",5},
                {0,"bytes",5},
                {4,"bytes",4},
        };
    }

    @Test (dataProvider = "data-provider")
    public void checkNumberOfWordsInText(int amount, String type, int result) {
        getHomePage().enterAmount(amount);
        getHomePage().selectGenerationType(type);
        getHomePage().clickOnGenerateLoremIpsumButton();
        getGeneratedTextPage().waitVisibilityOfElement(30,getGeneratedTextPage().getLoremIpsumText(0));
        if (type=="words")
            assertEquals(getGeneratedTextPage().getWordCountFromLoremIpsumText(), result);
        else
            assertEquals(getGeneratedTextPage().getLengthFromLoremIpsumText(), result);
    }
}
