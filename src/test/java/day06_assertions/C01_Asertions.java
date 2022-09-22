package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Asertions {


    /*
    *** amazon anasayfaya gidin 3 farklı test methodu olusturarak  asagıdaki görevleri yapın
    1- url nin amozon icerdiğini test eddin
     2- title in facebook icermediigini test edin
     3- sol üst kösede amozon logosunun gorundugunu test edin

     */


static WebDriver   driver ;
@BeforeClass
    public  static void  Setup(){
   driver=new ChromeDriver() ;
    WebDriverManager.chromedriver().setup();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://www.amozon.com");
}
@AfterClass
    public  static void tearnDown(){
   driver.close();
  }

  @Test
  public  void test1(){
    driver.get("https://www.amozon.com");
    // 1- url nin amozon icerdiğini test eddin
      String arananKelime="amazon";
      String actualUrl= driver.getCurrentUrl();
      Assert.assertTrue(actualUrl.contains(arananKelime));
  }

  @Test
public void test2(){
    // 2- title in facebook icermediigini test edin
    String istenmeyenKelime="facebook";
    String title= driver.getTitle();
    Assert.assertFalse(title.contains(istenmeyenKelime));
}
@Test
    public void test3(){
    //3- sol üst kösede amozon logosunun gorundugunu test edin
   WebElement amazonLogosu=driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
   Assert.assertTrue(amazonLogosu.isDisplayed());
}

}
