package day04_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeAfter {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){

        driver.close();
    }

@Test
    public void test1(){
        driver.get("https://www.techproeducation.com");
}

    @Test
    public void test2(){
        driver.get("https://www.amozon.com");
    }

    @Test
    public void test3(){
        driver.get("https://www.facebook.com");
    }

}
// after ve befor test baslamadan önce ve test bitimindeki otomatik olması gerekenleri bizim iççin gerçekleştirir