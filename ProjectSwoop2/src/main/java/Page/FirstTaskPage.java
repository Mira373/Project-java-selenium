package Page;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class FirstTaskPage {
    public SelenideElement relaxButton = $(byXpath("//li[contains(@class,'cat-3 cat')]"));
    public SelenideElement priceFilter = $(byXpath("//*[@class = 'sidebar']//child::div[@class= 'price-filter']"));
    public SelenideElement minPrice = $(byXpath("//*[@id = 'sidebar']//child::input[@id='minprice']"));
    public SelenideElement maxPrice = $(byXpath("//*[@id = 'sidebar']//child::input[@id='maxprice']"));
    public SelenideElement searchButton = $(byXpath("//*[@id = 'sidebar']//child::div[@class='submit-button']"));
    public ElementsCollection discountPrices = $$(byXpath("//*[@id= 'partialid'][1]//div[@class='voucher-counts']//p[1]"));
    public SelenideElement loadElementWait = $(byXpath("(//*[@id= 'partialid'][1]//div[@class='voucher-counts']//p[1])[last()]"));
}
