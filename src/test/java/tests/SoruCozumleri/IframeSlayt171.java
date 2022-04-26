package SoruCozumleri;

import Utiletes.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IframeSlayt171 extends TestBase {
//  1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
//          2.
//          2.“Our Products” butonuna basin
//
//      3.“Cameras product”i tiklayin
//
//  Popup mesajini yazdirin
//
//      5.“close” butonuna basin
//
//      6."WebdriverUniversity.com (IFrame)" linkini tiklayin
//
//      7."http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test() throws InterruptedException {
    driver.get("http://webdriveruniversity.com/IFrame/index.html");
        WebElement iframeElement=driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElement);
    driver.findElement(By.xpath("//a[text()='Our Products']")).click();

    //WebElement iframe2=driver.findElement(By.xpath("//iframe[@id='frame']"));
    //driver.switchTo().frame(iframe2);
    driver.findElement(By.id("camera-img")).click();
   // driver.switchTo().defaultContent();
  // driver.switchTo().alert();
        Thread.sleep(3000);
        WebElement popUp2=driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println(popUp2.getText());
        WebElement popUp=driver.findElement(By.xpath("//button[text()='Close']"));
        popUp.click();

        driver.switchTo().defaultContent();
        WebElement sonTik=driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]"));
        sonTik.click();
        System.out.println(driver.getCurrentUrl());
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(driver.getCurrentUrl(),"http://webdriveruniversity.com/index.html");
        soft.assertAll();
    }
}
