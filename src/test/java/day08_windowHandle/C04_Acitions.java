package day08_windowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import unitilets.A_testBase;

public class C04_Acitions extends A_testBase {
    //amozon anasayfaya gidin nutella için arama yapın 9.ürüne tıklayın

    @Test
    public void test() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        //9.ürünü tiklayin
        Thread.sleep(3000);
      driver.findElement(By.xpath("//img[@data-image-index='9']")).click();

    }
}
