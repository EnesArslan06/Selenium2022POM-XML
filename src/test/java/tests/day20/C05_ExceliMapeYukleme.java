package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class C05_ExceliMapeYukleme {
    @Test
    public void test() throws IOException {
        // dosya yolu ve sayfa ismi verilen bie excel sheet'i map olarak kaydeden
        // reusable bir method olusturalim
       String path ="src/test/java/resources/ulkeler.xlsx";
       String sayfaIsmi="Sayfa1";
        Map<String,String> map= ReusableMethodsExcel.mapExcel(path, sayfaIsmi);
       System.out.println(ReusableMethodsExcel.mapExcel(path, sayfaIsmi));
        // olusturdugumuz map'i kullanarak Turkey'in bilgilerini yazdirin
        System.out.println(map.get("Turkey"));
        // Listede Netherlands oldugunu testedin
        Assert.assertTrue(map.containsKey("Netherlands"));


    }


}
