package day08_windowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import unitilets.A_testBase;

public class C02_windowhandle extends A_testBase {
    /*
    1-amozon sayfassına gidelim
    2-url nin amozon içerdigini test edelim
    3-yeni bir pencere acıp bestbuy ana sayfasına gidelim
    4-titile nin best by içerdiğini test edelim
  5-  ilk sayfaya dönüp java aratalım
  6- arama sonuclarının java icerdiğini test eddelim
  7-yeniden bestbuy in acık oldugu sayfaya gidelim
  8-logonun gorundugunu test edelim

     */

   @Test
   public void test1() throws InterruptedException {
       //   1-amazon sayfassına gidelim
       driver.get("https://amozon.com");
       String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();

       // 2-url nin amazon içerdigini test edelim
       String istenenenKelime="amazon";
       String actualUrl= driver.getCurrentUrl();
       Assert.assertTrue(actualUrl.contains(istenenenKelime));

       //3-yeni bir pencere acıp bestbuy ana sayfasına gidelim
       driver.switchTo().newWindow(WindowType.WINDOW);
       driver.get("https://www.bestbuy.com");
       String ikinciSayfaHandleDegeri=driver.getWindowHandle();
       Thread.sleep(3000);

    //  4-titile nin best by içerdiğini test edelim
      String arananKelime="Best Buy";
    String actualtitle= driver.getTitle();
  Assert.assertTrue(actualtitle.contains(arananKelime));

    // 5-  ilk sayfaya dönüp java aratalım
       driver.switchTo().window(ilkSayfaWindowHandleDegeri);
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

       // 6- arama sonuclarının java icerdiğini test eddelim
       WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

     String sonucyazisistr=sonucYaziElementi.getText();
     String aradıgımızKelime="java";
     driver.close();

Assert.assertTrue(sonucyazisistr.contains(aradıgımızKelime));

   // 7-yeniden bestbuy in acık oldugu sayfaya gidelim
       driver.switchTo().window(ikinciSayfaHandleDegeri);

// 8-logonun gorundugunu test edelim
       WebElement logoElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
       Assert.assertTrue(logoElementi.isDisplayed());

   }

}
