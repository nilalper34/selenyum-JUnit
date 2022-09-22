package day08_windowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unitilets.A_testBase;

import java.util.Set;

public class C01_windowHandle<SoftAssert> extends A_testBase {
    /*
    1- "https://the-internet.herokuapp.com/windows " adresine gidin.
    2- sayfadaki texstin "opening a new window" oldugunu dogrulayın
    3- sayfa basslıgının (title) "The Internet" oldugunu dogrulayın
    4- click here butonuna basın
    5- Acilan yeni pencerenin sayfa baslıgının "new window" oldugunu dogrulayın
    6- sayfadaki  textin "new window" oldugunu dogrulyın.
    7-bir önceki pencereye geri döndükten sonra sayfa baslıgının "The Internet" oldugunu dogrulayın.

     */

    @Test
    public void Test(){
        //  1- "https://the-internet.herokuapp.com/windows " adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  2- sayfadaki texstin "opening a new window" oldugunu testedin

WebElement yaziElementi =driver.findElement(By.tagName("h3"));
String actualElementi=yaziElementi.getText();
String expectedYaziElementi="Opening a new window";
        Assert.assertTrue(actualElementi.contains(expectedYaziElementi));

  //  3- sayfa basslıgının (title) "The Internet" oldugunu dogrulayın

String actualTitle=driver.getTitle();
String expectedTitle="The Internet";
Assert.assertEquals(expectedTitle,actualTitle);

System.out.println("ilk sayfnın handle degeeri: "+driver.getWindowHandle()); //CDwindow-E8CEB7F8D5D3935344E73491A4D55715

        String ilksayfaHandle= driver.getWindowHandle();

// 4- click here butonuna basın
        //*bu sayfada h2. sayfa acıldı
  driver.findElement(By.xpath("//a[@href='/windows/new']")) .click();

        Set<String>  tümWindowHandleri=driver.getWindowHandles();
        System.out.println("handle degerleri: "+tümWindowHandleri);
        //handle degerleri: [CDwindow-AE90163AA345093541BBB469C4F5D0A3, CDwindow-AEDBD1F85B4169D84FE04FB7324BADD4]


         /*
      1.adim  benim burda yapacagım is 2.sayfaya gecemeden 1.sayfanın handle ni alıp sonra 2.sayfaya acılınca ayırt edebilmem lazım
     2. adim    birden cok handle degerlerini bana set döndürecekmis ondan gelecek handle degerleri yani hashcod lar için set conteynr hazırladık
     3.adim  set ıcerisinde birinci sayfanin handle ddegerine esit olmayanı bulup bir string e atamalıyız
         */

     String ikinciHandleDegeri="";

        for (String each:tümWindowHandleri
             ) {
            if (! each.equals(ilksayfaHandle)){
                ikinciHandleDegeri=each;
            }
        }

        //suan benim 2.sayfamın handle degeri var görelim
        System.out.println("2.sayfa handle degeri: "+ikinciHandleDegeri);

//  5- Acilan yeni pencerenin sayfa baslıgının "new window" oldugunu dogrulayın
        driver.switchTo().window(ikinciHandleDegeri);
        //window benden window handle degeri istiyor
        String actualYeniTitle= driver.getTitle();
        String expectedYeniTitle="New Window";
        Assert.assertEquals(actualYeniTitle,expectedYeniTitle);

WebElement yenisayfaYaziElementi= driver.findElement(By.tagName("h3"));
String expectedYenisayfaYazisi="New Window";
String actualYenisayfaYazisi=yenisayfaYaziElementi.getText();
Assert.assertEquals(expectedYenisayfaYazisi,actualYenisayfaYazisi);


        //  7-bir önceki pencereye geri döndükten sonra sayfa baslıgının "The Internet" oldugunu dogrulayın.
        driver.switchTo().window(ilksayfaHandle);
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
