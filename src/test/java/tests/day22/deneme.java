package tests.day22;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class deneme extends TestBaseRapor {

    @Test
    public void test(){
        extentTest=extentReports.createTest("AmazonTesti", "TitleTesti");
        Driver.getDriver().get("https://www.amazon.com");
        extentTest.info("amazona gidildi");
        String actuelTitle=Driver.getDriver().getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actuelTitle.contains(expectedTitle));
        extentTest.pass("Amazon Title Testi gecti");
    }
}
