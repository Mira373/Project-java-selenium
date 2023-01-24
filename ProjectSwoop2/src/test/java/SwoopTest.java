import Page.FirstTaskPage;
import Steps.FirstTaskSteps;
import Steps.SecondTaskSteps;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static org.testng.Assert.assertTrue;

@Listeners({ SoftAsserts.class})
public class SwoopTest {

    @BeforeMethod
    public void openLink(){
        timeout=5000;
        holdBrowserOpen=false;
        screenshots=true;
        assertionMode = SOFT;
        baseUrl = "https://www.swoop.ge/";
        reportsFolder="src/main/resources/Reports";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    FirstTaskSteps firstTaskSteps = new FirstTaskSteps();
    SecondTaskSteps secondTaskSteps = new SecondTaskSteps();

    @Test//(groups = {"Resgression1"})
    public  void firstTestMethod(){
        open("");
        firstTaskSteps
                .clickRelaxButton()
                .filterByPrice()
                .putMinPrice()
                .putMaxPrice()
                .searchInPriceRange()
                .returnedItemsValidationInPriceRange(); //დააფეილებს, რადგან სორტში რეინგს გარეთა მონაცემსაც აყოლებს
    }
    @Test//(groups = {"Resgression1"})
    public  void secondTestMethod(){
        open("");
        secondTaskSteps
                .hoverOnRelaxButton();
              //  .clickOnFirstReturnedElement();
//                .ValidateColorAndLocation()
//                .sortPrices()
//                .compareSortedPrices();
    }

    @AfterMethod
    public void afterMethod(){
        timeout=5000;
        Selenide.closeWindow();
    }
}
