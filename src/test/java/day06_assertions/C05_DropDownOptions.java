package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    1- Amozon anasayfasına gielim  dropdown menusunden books secelim sectiğimiz option u yazdiralim
    2- dropdownddaki opsiyonlarin toplam sayisini 28 oldugunu yazdıralım
     */
    WebDriver driver;
    @Before
    public void SetUp(){
        WebDriverManager.chromedriver();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

@After
    public void tearnDown(){
        driver.quit();
}

@Test
    public void Test1(){
        driver.get("https://www.amazon.com");
    WebElement dropDown= driver.findElement(By.xpath("//select[@name='url']"));
    Select select=new Select(dropDown);
    select.selectByVisibleText("Books");

    //bir dropdown ile calısıyorken son secilen option a ulasmak isterseniz  getFirstSelectedOption() kullanılır ve getText() ile yazdir
    System.out.println(select.getFirstSelectedOption().getText());

//dropdown ların sayısının 28 oldugunu yazzdirin

    List<WebElement> optionList=select.getOptions();
    int actualOptionSayisi= optionList.size();
    int expectedOptionSayisi=28;
    Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }













}
