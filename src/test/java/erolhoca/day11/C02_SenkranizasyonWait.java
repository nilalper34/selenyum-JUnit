package erolhoca.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import unitilets.A_testBase;

import java.time.Duration;

public class C02_SenkranizasyonWait extends A_testBase {
    @Test
    public void imlicitlyWaitTest1() {

        //Iki tane metod olusturun : implicitWait() , explicitWait()

                  /*
                imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
                max belirttiğimiz süre altında bütün web elementler için bekler
                  */

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed()); //it's de tek tırnak oldugundan  slash ları silmedik

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }

    @Test
    public void explicitWaitTest2() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement itsGoneWE = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        //***20sn  30sn  beni ilgilendirmez içine yazdıgım element görüntülene kadar bekle diyorum

        Assert.assertTrue(itsGoneWE.isDisplayed());

        /*
        explicitWait itsgoneWE  görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
      WebElement itsBackWE=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());

    }
}
