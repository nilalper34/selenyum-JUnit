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

public class C06_DropDownExample {
    /*
    1-https:://the-internet.herokuapp.com/dropdown adresine gidin
    2-index kullanarak option 1 secin vee yazdirin
    3-value kullanarak option2 secin ve yazdirin
    4-visibletext  kullanarak option1 secin ve yazdirin
    5.dropdown un boyutunu bulun.dropdown da 4 öge varsa t değilse false yazdirin
     */
    WebDriver driver;
    @Before
    public void SetUp(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

@After
    public void tearnDown() {

}

        @Test
    public void Test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
            WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']"));
            Select select=new Select(ddm);

           // 2-index kullanarak option 1 secin vee yazdirin
            select.selectByIndex(1);
            System.out.println(select.getFirstSelectedOption().getText());

          //  3-value kullanarak option2 secin ve yazdirin
            select.selectByValue("2");
            System.out.println(select.getFirstSelectedOption().getText());

            //4-visibletext  kullanarak option1 secin ve yazdirin
         select.selectByVisibleText("Option 1");
            System.out.println(select.getFirstSelectedOption().getText());

            //  5.Tüm dropdown optionslari yazdirin
            List<WebElement> tümOpsiyonlar=select.getOptions();
            for (WebElement each:tümOpsiyonlar
                 ) {
                System.out.println(each.getText());
            }

            // 6.dropdown un boyutunu bulun.
            int ddb=tümOpsiyonlar.size();

            // 7.dropdown da 4 öge varsa t değilse false yazdirin

           if (ddb==4){
               System.out.println("true");
           }else System.out.println("false");


    }



}
