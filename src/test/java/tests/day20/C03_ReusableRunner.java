package tests.day20;

import org.apache.poi.ss.usermodel.Cell;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusableRunner {
    // Ulkeler excelindeki, Sayfa1'de
    // 11.index'deki satirin, 2.indexdeki hucresinin Azerbaycan oldugunu test edin
    Cell cell =null;
    @Test
    public void test(){
        String path ="src/test/java/resources/ulkeler.xlsx";
        String cell= ReusableMethodsExcel.hucreGetir(path,"Sayfa1",11,2).toString();
        Assert.assertEquals(cell,"Azerbaycan");
        System.out.println(cell);
    }
}
