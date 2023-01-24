package Steps;

import Page.FirstTaskPage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import java.time.Duration;
import static org.testng.Assert.assertTrue;


public class FirstTaskSteps extends FirstTaskPage {

    @Step
    public FirstTaskSteps clickRelaxButton() {
        relaxButton.click();
        return this;
    }
    @Step
    public FirstTaskSteps filterByPrice() {
        priceFilter.scrollTo();
        return this;
    }
    @Step
    public FirstTaskSteps putMinPrice() {
        minPrice.setValue("200");
        return this;
    }
    @Step
    public FirstTaskSteps putMaxPrice() {
        maxPrice.should(Condition.appear, Duration.ofSeconds(5000)).setValue("230");
        return this;
    }
    @Step
    public FirstTaskSteps searchInPriceRange() {
        searchButton.click();
        return this;
    }
    @Step
    public FirstTaskSteps returnedItemsValidationInPriceRange() {
        loadElementWait.should(Condition.appear,Duration.ofSeconds(5000));
        for( int i = 0; i<discountPrices.size(); i++){
            try {
                String price =discountPrices.get(i).getText();
                String intPriceT = price.replace("₾","");
                int intPrice = Integer.parseInt(intPriceT);
                assertTrue(intPrice > 200 && intPrice < 230);
                System.out.println(intPrice);
            } catch (StaleElementReferenceException e) {
                System.out.println("stale Element exception");
            }
        }
        return this;
    }
}
