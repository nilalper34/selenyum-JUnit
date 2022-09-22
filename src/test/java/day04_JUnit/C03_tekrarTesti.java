package day04_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_tekrarTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        /*
        1-C01_tekrar testi isimli bir class olusturun
        2- https://www.google.com/adresine gidin
        3- cookies uyarisini kabul ederek kapatin
        4- sayfa baslıgının "Google" ifadesi içerdiğini test edin
        5- Arama cubuguna "Nutella" yazip aratin
        6- Bulunan sonuc sayisini yazdirin
        7-sonuc sayisinin 10 miyondan fazla oldugunu test edin
        8- sayfayi kapatin
         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();

        //  2- https://www.google.com/adresine gidin
        driver.get("https://www.google.com/");

        //  3- cookies uyarisini kabul ederek kapatin



        //4- sayfa baslıgının "Google" ifadesi içerdiğini test edin
        String Title= driver.getTitle();
        String istenenKelime="Google";

        if (Title.contains(istenenKelime)){
            System.out.println("PASSED");
        }else System.out.println("FAİLED");

        // 5- Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Nutella"+ Keys.ENTER);

       // 6- Bulunan sonuc sayisini yazdirin
        WebElement ResultText= driver.findElement(By.xpath("//div[@id='result-stats']"));

       String [] ResultNumber=ResultText.getText().split(" "); // sadece sayiyi almak için splitle boşluktan  ayırıp array e attık
       System.out.println("cikti  sonucu: "+ResultNumber[1]);
       /* bize 100.000.000 gerekiyor "yaklasık,100.000.000,sonuc,bulundu" haline geldi biz de 1. indexteki elemanı aldık
         */

      // 7-sonuc sayisinin 10 miyondan fazla oldugunu test edin

        String numberOfResult=ResultNumber[1].replace(".","");  //100 miyonu almak için noktaları kaldırıp birleştiriyoruz

        int number=Integer.parseInt(numberOfResult); //matematiksel işlem kurabilmek için int uyarlıyoruz

        if (number>10000000){
            System.out.println(" sonuc 10 miyondan fazla PASSED");
        }else System.out.println("FAİLED");

      // 8- sayfayi kapatin
      driver.close();


    }
}
