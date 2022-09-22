package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_yanlisEmailTesti {
    /*
    2-"https://autamotionpractice.com/index.php" adresine gidiniz
    3- sigin butonuna basalım
    4- email kutusuna @isareti olmayan bir mail yazip emter a basalım
    bastıgımızda "Invalid email address" uyarısı cıktıgını test edelim
     */
  static  WebDriver driver;

    @BeforeClass
    public static void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }
    @AfterClass
    public static void tearnDown(){
        driver.close();
    }

@Test
    public void test1(){
        //    3- sigin butonuna basalım
        driver.findElement(By.xpath("//*[@class='login']")).click();
    }

@Test
    public void test2(){
  //  4- email kutusuna @isareti olmayan bir mail yazip emter a basalım
   // bastıgımızda "Invalid email address" uyarısı cıktıgını test edelim
    driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("yase.1881.alper"+ Keys.ENTER);
    WebElement output= driver.findElement(By.xpath("//*[text()='Invalid email address.']"));

    Assert.assertTrue(output.isDisplayed());


}

}
