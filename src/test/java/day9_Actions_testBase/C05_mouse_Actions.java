package day9_Actions_testBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilets.A_testBase;

import java.util.Set;

public class C05_mouse_Actions extends A_testBase {
    @Test
    public void test1(){

        /*
        1-https://the-internet.herokuapp.com/contex_menu sitesine gidelim
        2- cizili olan üzerinde sag click  yapalim
        3-Alert te cıkan yazinin "You selected a context menu" oldugunu test eddelim
        4-tamam diyerek alert i kapatalım
        5-elemental selenium linkine tiklayalim
        6-Acilan sayfada h1 tagına "Elemental Selenium" yazdigini test edelim.

         */

  //    1-https://the-internet.herokuapp.com/contex_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

 //   2- cizili olan üzerinde sag click  yapalim
        Actions actions=new Actions(driver);
       WebElement ciziliAlan= driver.findElement(By.id("hot-spot"));
       actions.contextClick(ciziliAlan).perform();

 //  3-Alert te cıkan yazinin "You selected a context menu" oldugunu test eddelim
        String expectedAlertYazisi="You selected a context menu";
        String actualYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals("sonuc bekelenenden farklı",expectedAlertYazisi,actualYazisi);
   //   4-tamam diyerek alert i kapatalım
   driver.switchTo().alert().accept();

  //   5-elemental selenium linkine tiklayalim
        String ilkSayfaHandle=driver.getWindowHandle();  //2.sayfa acilmadan 1.sayfanin handle ni aliyorum
  driver.findElement(By.xpath("//a[@target='_blank']")).click();

  //  6-Acilan sayfada h1 tagına "Elemental Selenium" yazdigini test edelim.

        Set<String>tümHandle=driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each: tümHandle
             ) {
            if (!equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;
            }

        }
driver.switchTo().window(ikinciSayfaHandle);
        String expectedyazi="Elemental Selenium";
        String actualYazi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedyazi,actualYazi);

    }
}
