package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestByAssertions {
    /*
    1-bir class olusturun:BestByAssertions
    2-https://www.bestby.com/ adresine gidin farklı test methodları olusturarak asagıdaki
    testleri yapin
    a- sayfa URL nin https://www.bestby.com/ a eşit oldugunu test edin
    b-titleTest=>Sayfa baslıgının "Rest" içermediğini kontrol edin
    c- logotest=> BestBuy logosunun görüntülendigini test edin
    d- FrancaisLinkTest=>Fransızcca linkinin görüntülendiğini test edin
     */

  static   WebDriver driver;
@BeforeClass
    public static void SetUp() {
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://www.bestbuy.com");
}
@AfterClass
    public static void tearnDown(){
    driver.close();
}

@Test
    public  void test1(){
    //a- sayfa URL nin https://www.bestby.com/ a eşit oldugunu test edin
    String expectedURl= "https://www.bestbuy.com/";
            String actualURL=driver.getCurrentUrl();
  Assert.assertEquals(expectedURl,actualURL);
}

@Test
public  void test2(){
 //  b-titleTest=>Sayfa baslıgının "Rest" içermediğini kontrol edin
    String expectedTitle="Rest";
    String actualTitle=driver.getTitle();
    Assert.assertFalse(actualTitle.contains(expectedTitle));
}

@Test
    public void  test3(){
 //   c- logotest=> BestBuy logosunun görüntülendigini test edin

    WebElement LogoElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
   Assert.assertTrue(LogoElementi.isDisplayed());

}

@Test
    public void test4(){
    //d- FrancaisLinkTest=>Fransızcca linkinin görüntülendiğini test edin
  WebElement LinkTest= driver.findElement(By.xpath("//button[@lang='fr']"));
 Assert.assertTrue(LinkTest.isDisplayed());

}
}
