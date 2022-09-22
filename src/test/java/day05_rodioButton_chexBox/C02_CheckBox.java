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

public class C02_CheckBox {
    /*
    1- Bir class olusturun
    2- Gerekli yapiyi olusturun ve asagıdaki görevi tamamlayin
    a. "https://theinternet.herokuapp.com/checkboxes
    b.checkbox1 ve checkbox2 elementlerini locate edin
    c. checkbox1 secili değilse onay kutusunu tıklayın
    d. checkbox2 secili değilse onay kutusunu tıklayın
     */
WebDriver driver;
@Before
public void setUp(){
    driver=new ChromeDriver();
    WebDriverManager.chromedriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}

@After
    public void tearDown (){
     driver.close();

}

@Test
    public void test1() throws InterruptedException {
    // a. "https://theinternet.herokuapp.com/checkboxes
    driver.get("https://the-internet.herokuapp.com/checkboxes");

    // b.checkbox1 ve checkbox2 elementlerini locate edin
   WebElement checkBox1= driver.findElement(By.xpath("//(input[@type='checkbox'])[1]"));
   WebElement checkBox2= driver.findElement(By.xpath("//(input[@type='checkbox'])[2]"));

   //  c. checkbox1 secili değilse onay kutusunu tıklayın
   Thread.sleep(3000);
   if (!checkBox1.isSelected()){
       checkBox1.click();
   }

   //  d. checkbox2 secili değilse onay kutusunu tıklayın
   Thread.sleep(3000);
if (!checkBox2.isSelected()){
    checkBox2.click();
}





}






}
