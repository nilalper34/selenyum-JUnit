package day7_HandleAllerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
   static WebDriver driver;

    @BeforeClass
    public static void SetUp(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

@AfterClass
    public static void TearnDown(){
        //driver.quit();
}

@Test
    public  void acceptAlert(){

    driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
    //alert te ok  tusuna basın
    driver.switchTo().alert().accept();
    // result kisiminda "you succesfully clicked an alert" yazdıgını test edin

    String expectedResult = "You successfully clicked an alert";
    WebElement sonucYazisi = driver.findElement(By.xpath("//p[@ id='result']"));
    String actualResultYazisi = sonucYazisi.getText();

    Assert.assertEquals(expectedResult,actualResultYazisi);

    }

    @Test
    public  void DismissAlert(){

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        //uyarıdaki cansel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime="successfully";
WebElement  sonucYazisi= driver.findElement(By.xpath("//*[text()='You clicked: Cansel']"));
String actualSonucYazisi=sonucYazisi.getText();

Assert.assertEquals(istenmeyenKelime,sonucYazisi);
    }

@Test
    public  void sendKeysAlert() throws InterruptedException {
driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

Thread.sleep(2000);
driver.switchTo().alert().sendKeys("yasemin");
driver.switchTo().alert().accept();

WebElement sonucYazisi= driver.findElement(By.xpath("//p[@id='result']"));
String actualResult= sonucYazisi.getText();
String girilenisim="yasemin";

Assert.assertTrue(actualResult.contains(girilenisim));

}

}
