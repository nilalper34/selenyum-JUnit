package day04_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Example {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();

        /*
        1- http://zero.webappsecurity.com saydfasina gidin
        2- signin butonuna tiklayin
        3- login alanina "username" yazdirin
        4- password alanina "password" yazdirin
        5- signin butonuna tiklayin
        6- Pay Bills sayfasina gidin
        7- amount kismina yatirmak istediğiniz herhangi miktari yazin
        8- tarih kismina "2020-09-10" yazdirin
        9- pay buttonuna tıklayin
        10- "The payment was successfully submitted." mesajinin ciktiğini kontrol edin
          */

       //   1- http://zero.webappsecurity.com saydfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2- signin butonuna tiklayin
        WebElement siginButtonu= driver.findElement(By.xpath("//button[@id='signin_button']"));
        siginButtonu.click();

        //3- login alanina "username" yazdirin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");

        //4- password alanina "password" yazdirin
       driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

       //  5- signin butonuna tiklayin
         driver.findElement(By.xpath("//input[@name='submit']")).click();

         driver.navigate().back();  // hata veriyor geri gelince düzeliyor ondan ekledim

       // 6- Pay Bills sayfasina gidin
        /*
        online bankıng altında o yüzden ilk önce ona gideceğiz
         */
        driver.findElement(By.xpath("(//*[text()='Online Banking' ] )[1]")).click();

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();    //pay Bills sayfasi

       // 7- amount kismina yatirmak istediğiniz herhangi miktari yazin
    driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("100");

     //   8- tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys("2020-09-10");

     // 9- pay buttonuna tıklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //10- "The payment was successfully submitted." mesajinin ciktiğini kontrol edin
      WebElement onay=  driver.findElement(By.xpath("//input[@type='submit']"));
     if (onay.isDisplayed()){
         System.out.println("PASSED");
     }else System.out.println("FAİLED");

 driver.close();

    }
}
