package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazon a gidiğ dropdown'dan books seccenegini secip
    java aratalim
    ve araama sonuclarının java icerdiğini test edelim

     */

WebDriver driver;
@Before
    public  void SetUp(){
    driver=new ChromeDriver();
    WebDriverManager.chromedriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}

@After
    public void tearnDown(){
   // driver.quit();
}

@Test
    public void test1() throws InterruptedException {
    driver.get("https://www.amazon.com");
    //1.adım dropdown locate edin
    WebElement dropdown= driver.findElement(By.xpath("//select[@name='url']"));
    //2.select obj olusturun
    Select select=new Select(dropdown);
// 3. dropdown da olan optionlaardan birini secin

 // select.selectByIndex(); 1.yol
   select.selectByVisibleText("Books"); //2.yol
   // select.selectByValue(); //3.yol
    // arama kutusuna java yazalım

    WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("java"+ Keys.ENTER);


WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
String sonucYazısıstr=aramaSonucu.getText();
String arananKelime="Java";
    Assert.assertTrue(sonucYazısıstr.contains(arananKelime));

    Thread.sleep(5000);
}



}
