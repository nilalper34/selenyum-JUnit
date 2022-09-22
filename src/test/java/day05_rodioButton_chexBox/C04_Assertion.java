package day05_rodioButton_chexBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertion {

    WebDriver driver;

    @Before

    public void Setup(){

        driver= new ChromeDriver();
        WebDriverManager.chromedriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();

     }

@Test
    public void test1(){
        driver.get("https://www.amazon.com");

    /*
     url nin https:// www.facebook.com oldugunu test edin
     if (driver.getCurrentUrl().equals("https:// www.facebook.com") ){
         System.out.println("url testi PASSED");
     }else System.out.println("url testi FAILED");
      */

    //eger testleri if else ile yaparsak test failed olsa bile sorunsuz calıstıgı için test passed yazacaktır


String expectedUrl="https://www.facebook.com";
String actualUrl= driver.getCurrentUrl();
    Assert.assertEquals("test failed oldu",expectedUrl,actualUrl); // if else yerine artık bunu kullanıyoruz


    }

   /*

  Assert ile yaptigımız testlerde assertion failed olursa java kodlarinin calismasını durdurur
   ve Asser class i bizi hata konusunda bilgilendirir

    org.junit .comparisonFailure:url beklenenden farklı
    expected:https://www.facebook.com
    actual:https://www.amazon.com
   <click to see difference>
   böylece hatayıda raporladı

    */




}
