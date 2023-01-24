package Page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SecondTaskPage {
    public SelenideElement relaxButton = $(byXpath("//li[contains(@class,'cat-3 cat')]"));
    public SelenideElement bakuriani = $(byLinkText("ბაკურიანი"));
    public String bakurianiValidateColor = $(byXpath("(//a[contains(text(),'ბაკურიანი')])[4]")).getCssValue("color");
    public String bakurianiValidateBcolor = $(byXpath("(//a[contains(text(),'ბაკურიანი')])[4]")).getCssValue("background-color");
    public String bakurianiValidationTextt =$(byXpath("//*[@id= 'sidebar-container']//child::label[text()='ბაკურიანი']")).getText();
    public SelenideElement priceSort = $(byId("sort"));
    public ElementsCollection discountPrices = $$(byXpath("//*[@id= 'partialid'][1]//div[@class='voucher-counts']//p[1]"));
    public SelenideElement loader = $(byXpath("(//*[@id= 'partialid'][1]//div[@class='voucher-counts']//p[1])[last()]"));

}
