package day08_windowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilets.A_testBase;

public class C07_KeyboardActions extends A_testBase {

    @Test
    public void test1(){
        /*
        1- facebook anassayfasına gidelim
        2-yeni kayıt olustur butonuna basın
        3-isim kutusunu locate edlim
        4-geriye kalan alanları tab ile dolasarak doldurun

         */

   //   1- facebook anassayfasına gidelim
        driver.get("https://www.facebook.com");
  //   2-yeni kayıt olustur butonuna basın
          driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

// 3-isim kutusunu locate edlim

WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
//   4-geriye kalan alanları tab ile dolasarak doldurun
        Actions actions=new Actions(driver);
        actions.click(isimKutusu).sendKeys("neva").sendKeys(Keys.TAB).sendKeys("ustaoglu").sendKeys(Keys.TAB).sendKeys("dfghjkl").sendKeys(Keys.TAB).
                sendKeys("123456987").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("april").sendKeys(Keys.TAB).sendKeys("15").
                sendKeys(Keys.TAB).sendKeys("2022").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER);




    }
}
