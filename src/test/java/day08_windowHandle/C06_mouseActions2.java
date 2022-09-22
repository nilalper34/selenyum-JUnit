package day08_windowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilets.A_testBase;

public class C06_mouseActions2 extends A_testBase {
    /*
  1-   https://demoqa.com/droppable adresine gidelim
  2-"Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım
  3-"Drop Here" yazisi yerine "Dropped!" oldugunu test eddelim

      */
    @Test
    public void test1(){
// 1-   https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // 2-"Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım

        Actions actions=new Actions(driver);
        WebElement dragElementi= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drapElementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragElementi,drapElementi).perform();
// 3-"Drop Here" yazisi yerine "Dropped!" oldugunu test eddelim
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath(" //*[text()='Dropped!']")).getText());

    }
}
