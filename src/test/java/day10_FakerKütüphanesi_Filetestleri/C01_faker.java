package day10_FakerKütüphanesi_Filetestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilets.A_testBase;

public class C01_faker extends A_testBase {

@Test
    public void test1() throws InterruptedException {

        /*
        1- facebook anassayfasına gidelim
        2-yeni kayıt olustur butonuna basın
        3-isim kutusunu locate edlim
        4-geriye kalan alanları tab ile dolasarak doldurun

         */


        Actions actions=new Actions(driver);
        Faker faker=new Faker();

        //   1- facebook anassayfasına gidelim
        driver.get("https://www.facebook.com");

        //   2-yeni kayıt olustur butonuna basın
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

      // 3-isim kutusunu locate edlim
    WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

      //   4-geriye kalan alanları tab ile dolasarak doldurun
        String fakeMail=faker.internet().emailAddress();

        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()). sendKeys(Keys.TAB)
               .sendKeys(fakeMail).sendKeys(Keys.TAB).
                sendKeys(fakeMail). sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("April").sendKeys(Keys.TAB).
                sendKeys("16").sendKeys(Keys.TAB).
                sendKeys("2011").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);

}

}
