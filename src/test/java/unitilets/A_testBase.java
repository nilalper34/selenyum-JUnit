package unitilets;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class A_testBase {
    // biz test base class i sadeceeextends ile inherit ederek kullanacagız
    //dolayısıyla protecd seciyoruz
    //abstract yaparakta da obje olusturulmasının önüne geceris

    protected WebDriver driver;

    @Before
    public void SetUp(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void TearnDown(){
        //driver.quit();
    }

}
