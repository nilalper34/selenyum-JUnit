package day05_rodioButton_chexBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_afterClass {

    /*
beforeclass ve afterclass static olmadan calişmazlar
 */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public static void test1(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public static void test2(){
        driver.get("https://www.amozon.com");
    }

    @Test
    public static void test3(){
        driver.get("https://www.facebook.com");
    }
}
