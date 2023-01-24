package Steps;

import Page.SecondTaskPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertTrue;

public class SecondTaskSteps extends SecondTaskPage {
    SoftAssert softAssert = new SoftAssert();

    @Step
    public SecondTaskSteps hoverOnRelaxButton() {
       actions().moveToElement(relaxButton).perform();
        return this;
    }
    @Step
    public SecondTaskSteps clickOnFirstReturnedElement() {
        bakuriani.click();
        return this;
    }

    @Step
    public SecondTaskSteps ValidateColorAndLocation() {
       // SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(bakurianiValidateColor, bakurianiValidateBcolor, "\"ბაკურიანი\" is highlighted");
        softAssert.assertEquals(bakurianiValidationTextt, "ბაკურიანი");
        softAssert.assertAll();
//        if(!bakurianiValidateColor.equals(bakurianiValidateBcolor)){
//            System.out.println("highlighted!");
//        }
//        else{
//            System.out.println("it's not highlighted!");
//        }
        return this;
    }

    @Step
    public SecondTaskSteps sortPrices() {
        priceSort.selectOption("ფასით კლებადი");
        return this;
    }

    @Step
    public SecondTaskSteps compareSortedPrices() {
        loader.should(Condition.visible,Duration.ofSeconds(5000));
        List<Integer> sortedItems = new ArrayList<>();
        for (int i=0; i<2; i++){
            String price = discountPrices.get(i).getText();
            String intPriceT = price.replace("₾","");
            int intPrice = Integer.parseInt(intPriceT);
            sortedItems.add(intPrice);
        }
        softAssert.assertTrue(sortedItems.get(0) > sortedItems.get(1));
        softAssert.assertAll();
        return this;
    }
}
