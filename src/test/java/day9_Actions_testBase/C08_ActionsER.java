package day9_Actions_testBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilets.A_testBase;

public class C08_ActionsER extends A_testBase {

        @Test
        public void test1(){
            // - Amazon sayfasına gidelim
            // - Account menusundan create a list linkine tıklayalım
            driver.get("https://amazon.com");
            WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(accountList).perform();

        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */
            driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        }
}
