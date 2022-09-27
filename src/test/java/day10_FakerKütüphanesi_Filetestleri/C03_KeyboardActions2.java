package day10_FakerKütüphanesi_Filetestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilets.A_testBase;

public class C03_KeyboardActions2 extends A_testBase {
    /*
    1-https://html.com/tags/iframe/ sayfasina gidelim
    2-videoyu görecek kadar assagı inin
    3-videoyu izlemek için play butonuna basin
    4-videoyu calistirdigininzi test edin

     */
    @Test
    public void Test1(){
        // 1-https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //   2-videoyu görecek kadar assagı inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

//   3-videoyu izlemek için play butonuna basin
        WebElement iframe= driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

//   4-videoyu calistirdigininzi test edin

        WebElement youtubeLinki= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink'"));
        Assert.assertTrue(youtubeLinki.isDisplayed());

        driver.switchTo().defaultContent();




    }
}
