package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C07_homework {

    /*
    1-http.//zero.webappsecurity.com/ adresine gidin
    2-Sign in butonuna basın
    3-login kutusuna "username" yazin
    4-password kutusuna "password." yazin
    5-Sign in tusuna basin
    6- pay bills sayfaasına gidin
    7-"purchase Foreign Currency" tusuna basin
    8-"Currency drop menusunden Eurozene'u secin
    9-"amount" kutusuna br sayi girin
    10-"us doolars" in secilmediğini test edin
    11-"sellected currency" butonunu secin
    12-"calculate costs" butonuna basin sonra "purchase" butonuna basin
    13-"Foreign currency cash  was succesfully purchased" yazisinin cıktıgını kontrol edin
     */

    WebDriver driver;

    @Before
    public void  SetUp(){
     driver=new ChromeDriver()  ;
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearnDown(){
     //   driver.quit();
}

@Test
    public void Test() throws InterruptedException {
 //   1-http.//zero.webappsecurity.com/ adresine gidin
    driver.get("http://zero.webappsecurity.com/ ");

    //   2-Sign in butonuna basın
    driver.findElement(By.xpath("//*[@class='icon-signin']")).click();

  //  3-login kutusuna "username" yazin
driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

 //   4-password kutusuna "password." yazin
driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

//   5-Sign in tusuna basin
driver.findElement(By.xpath("//input[@name='submit']")).click();

    driver.navigate().back();
    Thread.sleep(2000);

    //    6- pay bills sayfaasına gidin
    driver.findElement(By.xpath("//*[strong='Online Banking']")).click();
     driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

     //  7-"purchase Foreign Currency" tusuna basin
driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();

    Thread.sleep(2000);

    //    8-"Currency drop menusunden Eurozone'u secin
WebElement ddm=driver.findElement(By.xpath("//select[@id='pc_currency']"));

    Select select=new Select(ddm);
    select.selectByIndex(6);

    //    9-"amount" kutusuna br sayi girin
    driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("25");

    //    10-"us doolars" in secilmediğini test edin
    WebElement usDolarButonu= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
    Assert.assertFalse(usDolarButonu.isSelected());

    //    11-"sellected currency" butonunu secin
    WebElement ScButonu= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
    if (!ScButonu.isSelected()){
        ScButonu.click();
    }

    //    12-"calculate costs" butonuna basin sonra "purchase" butonuna basin
    driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
    driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

    //    13-"Foreign currency cash  was succesfully purchased" yazisinin cıktıgını kontrol edin
    WebElement BeklenenOutput=driver.findElement(By.xpath("//div[@id='alert_content']"));
    Assert.assertTrue(BeklenenOutput.isDisplayed());

    }

}
