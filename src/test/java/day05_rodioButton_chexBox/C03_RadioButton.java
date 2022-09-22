package day05_rodioButton_chexBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    /*
    1- Gerekli yapiyi olusturun ve asagıdaki görevi tamamlayın
    a. https://www.facebook.com adresine gidin
    b.Cookies i kabul edin
    c."Create an Account" buttonuna basın
    d."radio buttons" elementlerini locateedin
    e. secili degilse cinsiyet butonundan size uygun olani secin
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
    public void tearnDown(){
    driver.close();
}

@Test
    public void test1() throws InterruptedException {
    // a. https://www.facebook.com adresine gidin
    driver.get("https://www.facebook.com");

    //  c."Create an Account" buttonuna basın
   driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

   // d."radio buttons" elementlerini locateedin
    WebElement femaleButonu= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
    WebElement maleButonu= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
    WebElement customButonu= driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

    // e. secili degilse cinsiyet butonundan size uygun olani secin

    Thread.sleep(2000);
   if (!femaleButonu.isSelected()){
    femaleButonu.click();
   }

}



}
