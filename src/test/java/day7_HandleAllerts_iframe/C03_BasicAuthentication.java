package day7_HandleAllerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    static WebDriver driver;

    @BeforeClass
    public static void SetUp(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void TearnDown(){
        //driver.quit();
    }


    @Test
    public void test1(){
        //burda da alert gibi locator edemeyecegımız bir durumla karsı karsıyayız bu mesele makinelerin programların birbirini
        // tanıması için olan username ve password soruyor bu durumda siteye girecegimiz şirketin bize yöntemi söylemesi gerekiyor

        // bbu  sirket yöntemi söyle vermiş olsun" username:password@url"
        driver.get("https://admin:admin@the-internet.herokuapp.com");
        //artık sifre kullanıcı adı sormadan giriyor. her site farklı olabilir ste sahipleri yöntemi vermeden yapamam
    }







}
