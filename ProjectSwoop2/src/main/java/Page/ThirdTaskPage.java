package Page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ThirdTaskPage {
    public SelenideElement logIn = $(byXpath("(//div[@class='swoop-login'])[1]\n"));
    public SelenideElement registrationButton = $(byXpath("(//p[@class='register'])[1]"));
    public SelenideElement pPersonValidation = $(byXpath("(//p[contains(text(),'ფიზიკური პირი')])[1]"));
    public SelenideElement pFirstName = $(byId("pFirstName"));
    public SelenideElement pLastName = $(byId("pLastName"));
    public SelenideElement pEmail = $(byId("pEmail"));
    public SelenideElement pPhone = $(byId("pPhone"));
    public SelenideElement datePicker = $(byId("pDateBirth"));
    public SelenideElement pPassword = $(byId("pPassword"));
    public SelenideElement pConfirmPassword = $(byId("pConfirmPassword"));
    public SelenideElement registrationBut = $(byXpath("//input[@type='button'][1]"));
    public SelenideElement outputText = $(byId("physicalInfoMassage"));
}
