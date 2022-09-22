package day04_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Homework {

    /*
    1- "https://www.saucedemo.com adresine gidin
    2- username kutusuna "standard_user" yazdirin
    3- password kutusuna "secret_sauce" yazdirin
    4- login tusuna basın
    5- ilk urunun ismini kaydedin ve bu urunun sayfasına gidin
    6-add to cart butonuna basın
    7- Alisveris sapetine tiklayin
    8-setiğiniz ürünün basarılı sekilde sepete eklendiğini control edin
    9- sayfayi kapatin
     */

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        WebDriverManager.chromedriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

       // 1- "https://www.saucedemo.com adresine gidin
        driver.get("https://www.saucedemo.com");

        //  2- username kutusuna "standart_user" yazdirin
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("standard_user");

       //  3- password kutusuna "scret_sauce" yazdirin
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");

       //  4- login tusuna basın
        driver.findElement(By.xpath("//input[@type='submit']")).click();

     //   5- ilk urunun ismini kaydedin ve bu urunun sayfasına gidin
   WebElement ilkÜrün=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
       String ürünAdi= ilkÜrün.getText();
       ilkÜrün.click();

       // 6-add to cart butonuna basın
    driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")) .click();

    // 7- Alisveris sapetine tiklayin
       driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

       Thread.sleep(3000);

   // 8-setiğiniz ürünün basarılı sekilde sepete eklendiğini control edin
     WebElement sepetteürün= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

   String sepetTest= sepetteürün.getText();

   if (sepetTest.equals(ürünAdi)){
       System.out.println("test PASSED");
   }else System.out.println("test FAİLED");

      //  9- sayfayi kapati
        driver.close();




    }
}
