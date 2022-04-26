package SoruCozumleri;

import Utiletes.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Slayt172SoruCozumu extends TestBase {
//    1."http://webdriveruniversity.com/" adresine gidin
//2."Login Portal" a kadar asagi inin
//3."Login Portal" a tiklayin
//4.Diger window'a gecin
//            5."username" ve "password" kutularina deger yazdirin
//6."login" butonuna basin
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
//            8.Ok diyerek Popup'i kapatin
//            9.Ilk sayfaya geri donun
//10.Ilk sayfaya donuldugunu test edin

    @Test
    public void test() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String handle1 = driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin

        Set<String> handlefull = driver.getWindowHandles();
        String handle2 = "";
        for (String each : handlefull) {
            if (!each.equals(handle1))
                handle2 = each;
        }
        System.out.println(handle2);

        driver.switchTo().window(handle2);
        Thread.sleep(3000);

        //5."username" ve "password" kutularina deger yazdirin
        WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
       Faker fake = new Faker();

       username.click();
       username.sendKeys(fake.name().name());
        WebElement password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.click();
        password.sendKeys(fake.internet().password());
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String popUp=driver.switchTo().alert().getText();
        System.out.println(popUp);
        Assert.assertTrue(popUp.equals("validation failed"));
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(handle1);
        act.sendKeys(Keys.PAGE_DOWN).perform();


        //10.Ilk sayfaya donuldugunu test edin
        WebElement ilkSayfa=driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));

        Assert.assertTrue(ilkSayfa.isEnabled());

    }
}
