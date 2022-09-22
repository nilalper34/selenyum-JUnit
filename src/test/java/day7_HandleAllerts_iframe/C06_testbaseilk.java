package day7_HandleAllerts_iframe;

import org.junit.Test;
import unitilets.A_testBase;

public class C06_testbaseilk extends A_testBase {

    @Test
    public void test(){
driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }
}
