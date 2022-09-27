package day9_Actions_testBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilets.A_testBase;

public class C06_KeyboardActions extends A_testBase {

    @Test
    public void test1() throws InterruptedException {
        // amazon a gidelim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        //önce arama kutusuna click yapıp harf harf nutella yazisini yazdiralim,sonradda enter
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).
    keyDown(Keys.SHIFT).
      sendKeys("n").
        keyUp(Keys.SHIFT).
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").sendKeys("l").sendKeys("a").
                sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);

    }
}
