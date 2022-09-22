package day7_HandleAllerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;

    @Before
    public void SetUp(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
@After
    public void tearnDown(){
       // driver.quit();
}
    /*
    *** herhangi bir web sitesine gidince veya işlem yaparken cıkan uyarılara alert denir.
        eger bir Alert inspect yapılıyorsa bu tür Alert lere html alert denir.Bunları locate yapıp devam edebiliriz.
       bazen Alert ler Html ile degil java scrept ile yapılır bunlar inspect yapılamaz. dolayısıyla locate edilemez.
        Selenium da bunlar için bir yöntem var
        *

     */

@Test
    public void Test1() {
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

    //alert te ok  tusuna basın
    driver.switchTo().alert().accept();
    // result kisiminda "you succesfully clicked an alert" yazdıgını test edin

    String expectedResult = "You successfully clicked an alert";
    WebElement sonucYazisi = driver.findElement(By.xpath("//p[@ id='result']"));
    String actualResultYazisi = sonucYazisi.getText();

    Assert.assertEquals(expectedResult,actualResultYazisi);

}


}
