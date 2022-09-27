package day10_FakerKütüphanesi_Filetestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unitilets.A_testBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownload extends A_testBase {


    /*
    1-iki tane method olusturun: isExist()  ve downloadTest()
    2-downloadTest() methodunun icinde asagıdaki testi yapalım
    a. - https://the-internet.herokuapp.com/download adresine gidelim
    b. - dummy.txt dosyasını indirelim
    3-  dosyanın bassarıyla indirilip indirilmedigini test edin
     */

@Test
    public void test1() throws InterruptedException {
    driver.get(" https://the-internet.herokuapp.com/download");
    //  b. - sample.txt dosyasını indirelim
    WebElement sampleLinki= driver.findElement(By.xpath("//a[@href='download/sample.pdf']"));
    sampleLinki.click();
   Thread.sleep(5000);

    //   3-  dosyanın bassarıyla indirilip indirilmedigini test edin
    //dosya download sa indirilecektir,bize downloads ın dosya yolu gerekiyor

    String farklıKisim=System.getProperty("user.home");
    String ortakKisim="\\Downloads\\Sample.pdf";
    String arananDosyayolu=farklıKisim+ortakKisim;

    Assert.assertTrue(Files.exists(Paths.get(arananDosyayolu)));

}









}
