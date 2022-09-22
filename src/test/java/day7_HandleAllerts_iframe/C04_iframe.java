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

public class C04_iframe {


    /*
    1. "https://the-internet.herokuapp.com/iframe" adresine gidin
    2. bir method olusturun:İframeTest
    a. "An Iframe containing..." textinin erisilebilir oldugunu test edin ve konsola yazdirin
    b. Text Box a "merhaba Dunya!" yazin.
    c. TextBox in altında bulunan "Elemental Selenium" linkini textinin görünür oldugunu dogrulayin ve konsola yazdirin.
     */

    WebDriver driver;
@Before
    public void SetUp(){
    driver=new ChromeDriver();
    WebDriverManager.chromedriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}

@After
    public void TearnDown(){
  //  driver.quit();
}

@Test
    public void Test() throws InterruptedException {
    //  1. "https://the-internet.herokuapp.com/iframe" adresine gidin
driver.get("https://the-internet.herokuapp.com/iframe");

    //    2. bir method olusturun:İframeTest
    //    a. "An Iframe containing..." textinin erisilebilir oldugunu test edin ve konsola yazdirin

    WebElement baslikElementi= driver.findElement(By.xpath("//h3"));
    Assert.assertTrue(baslikElementi.isEnabled());

    //    b. Text Box a "merhaba Dunya!" yazin.
    // **testbox i dogru locate etsekte bulamadı bu yüzden iframe locate edip o iframe gecmeliyiz
  WebElement iframeElementi=driver.findElement(By.id("mce_0_ifr"));
  driver.switchTo().frame(iframeElementi);
  WebElement textKutusu= driver.findElement(By.xpath("//body[@id='tinymce']"));
  textKutusu.clear();
  textKutusu.sendKeys("Merhaba Dunya");
  Thread.sleep(5000);


  //    c. TextBox in altında bulunan "Elemental Selenium" linkini textinin görünür oldugunu dogrulayin ve konsola yazdirin.

    //**link yazi elementi  dogru locate etmemize ragmen bulamadı sebep biz iframe gectik sonrada cıkmadık. şimdi iframe den cıkarsak düzelecek
driver.switchTo().defaultContent();

WebElement linkYaziElementi= driver.findElement(By.linkText("Elemental Selenium"));
Assert.assertTrue(linkYaziElementi.isDisplayed());
    System.out.println(linkYaziElementi.getText());
}


}
