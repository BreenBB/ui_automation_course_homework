package tests.part1;

import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.*;

public class CheckRussianWordContainsFishTest extends BaseTest {

    @Test
    public void checkRussianWordContainsFish() {
        getHomePage().clickOnLanguageRussianLink();
        getHomePage().waitVisibilityOfElement(30,getHomePage().getMainPageElement());
        assertTrue(getHomePage().getMainPageText().contains("рыба"));
    }
}
