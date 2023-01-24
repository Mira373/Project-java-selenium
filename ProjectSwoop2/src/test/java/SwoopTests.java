
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertTrue;


public class SwoopTests {
    WebDriver driver;
     @BeforeMethod
     public  void setUp(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
         driver.get("https://www.swoop.ge/");
     }

     @Test(groups = {"Resgression1"})
     public  void firstTestMethod() throws InterruptedException {
         driver.get("https://www.swoop.ge/");
         WebElement relaxButton = driver.findElement(By.xpath("//li[contains(@class,'cat-3 cat')]"));
         relaxButton.click();
         WebElement priceFilter = driver.findElement(By.xpath("//*[@class = 'sidebar']//child::div[@class= 'price-filter']"));
         JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("arguments[0].scrollIntoView();",priceFilter);
         WebElement minPrice = driver.findElement(By.xpath("//*[@id = 'sidebar']//child::input[@id='minprice']"));
         minPrice.sendKeys("200");
       //  WebElement spanEl = driver.findElement(By.xpath("//*[@id=\"sidebar\"]//child::span"));
        // js.executeScript("arguments[0].remove();", spanEl);
         WebDriverWait waitElement = new WebDriverWait(driver,Duration.ofSeconds(5000));
         waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'sidebar']//child::input[@id='maxprice']")));
         WebElement maxPrice = driver.findElement(By.xpath("//*[@id = 'sidebar']//child::input[@id='maxprice']"));
         maxPrice.sendKeys("230");
         WebElement searchButton = driver.findElement(By.xpath("//*[@id = 'sidebar']//child::div[@class='submit-button']"));
         searchButton.click();
         Thread.sleep(5000);
         List<WebElement> discountPrice = driver.findElements(By.xpath("//*[@id= 'partialid'][1]//div[@class='voucher-counts']//p[1]"));
         //WebDriverWait waitElements = new WebDriverWait(driver,Duration.ofSeconds(50000));
        // waitElements.until(ExpectedConditions.visibilityOfAllElements(discountPrice));
         System.out.println(discountPrice.size());
         for( int i = 0; i<discountPrice.size(); i++){

             try {
                 String price =discountPrice.get(i).getText();
                 String intPriceT = price.replace("₾","");
                 int intPrice = Integer.parseInt(intPriceT);
                 assertTrue(intPrice > 200 && intPrice < 230);
                 System.out.println(intPrice);
             } catch (StaleElementReferenceException e) {
                 System.out.println("stale Element exception");
             }
         }
     }

    @Test(groups = {"Resgression1"})
     public void secondTestMethod() throws InterruptedException {
         WebElement relaxButton = driver.findElement(By.xpath("//li[contains(@class,'cat-3 cat')]"));
         Actions action = new Actions(driver);
         action.moveToElement(relaxButton).perform();
         WebElement bakuriani = driver.findElement(By.linkText("ბაკურიანი"));
         bakuriani.click();
         String bakurianiValidateColor = driver.findElement(By.xpath("(//a[contains(text(),'ბაკურიანი')])[4]")).getCssValue("color");
         String bakurianiValidateBcolor = driver.findElement(By.xpath("(//a[contains(text(),'ბაკურიანი')])[4]")).getCssValue("background-color");
         if(!bakurianiValidateColor.equals(bakurianiValidateBcolor)){
             System.out.println("highlighted!");
         }
         else{
             System.out.println("it's not highlighted!");
         }
         String bakurianiValidationTextt = driver.findElement(By.xpath("//*[@id= 'sidebar-container']//child::label[text()='ბაკურიანი']")).getText();
         Assert.assertEquals(bakurianiValidationTextt, "ბაკურიანი");
         WebElement priceSort = driver.findElement(By.id("sort"));
         Select select = new Select(priceSort);
         select.selectByVisibleText("ფასით კლებადი");
         Thread.sleep(5000);
         List<Integer> sortedItems = new ArrayList<>();
         for (int i=0; i<2; i++){
             List<WebElement> discountPrice = driver.findElements(By.xpath("//*[@id= 'partialid'][1]//div[@class='voucher-counts']//p[1]"));
             String price = discountPrice.get(i).getText();
             String intPriceT = price.replace("₾","");
             int intPrice = Integer.parseInt(intPriceT);
             sortedItems.add(intPrice);
         }
        // Thread.sleep(5000);
         assertTrue(sortedItems.get(0) > sortedItems.get(1));
     }

     @Test(groups = {"Resgression2"})
     public void thirdTestMethod(){
         WebElement logIn = driver.findElement(By.xpath("(//div[@class='swoop-login'])[1]\n"));
         logIn.click();
         WebElement registrationButton = driver.findElement(By.xpath("(//p[@class='register'])[1]"));
         registrationButton.click();
         WebElement pPersonValidation = driver.findElement(By.xpath("(//p[contains(text(),'ფიზიკური პირი')])[1]"));
         Assert.assertEquals(pPersonValidation.getText(),"ფიზიკური პირი");
         WebElement pFirstName = driver.findElement(By.id("pFirstName"));
         pFirstName.sendKeys("Miranda");
         WebElement pLastName = driver.findElement(By.id("pLastName"));
         pLastName.sendKeys("Begashvili");
         WebElement pEmail = driver.findElement(By.id("pEmail"));
         pEmail.sendKeys("miranda@gmail.com");
         WebElement pPhone = driver.findElement(By.id("pPhone"));
         pPhone.sendKeys("574570351");
         WebElement datePicker = driver.findElement(By.id("pDateBirth"));
         datePicker.sendKeys("12032022");
         WebElement pPassword = driver.findElement(By.id("pPassword"));
         pPassword.sendKeys("Demo123");
         WebElement pConfirmPassword = driver.findElement(By.id("pConfirmPassword"));
         pConfirmPassword.sendKeys("Demo123");
         WebElement registrationBut = driver.findElement(By.xpath(" //input[@type='button'][1]"));
         registrationBut.click();
         WebElement outputText = driver.findElement(By.id("physicalInfoMassage"));
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(500));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("physicalInfoMassage")));
         JavascriptExecutor js = (JavascriptExecutor)driver;
         String errorMessageTextActual = (String)js.executeScript("return arguments[0].innerHTML;", outputText);
         String errorMessageTextExpected = "გთხოვთ აირჩიოთ სქესი!";
         Assert.assertEquals(errorMessageTextActual,errorMessageTextExpected);
     }

     @AfterMethod
     public void afterMethod(){
         driver.close();
     }
}
