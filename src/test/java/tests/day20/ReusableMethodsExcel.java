package tests.day20;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ReusableMethodsExcel {
    // bir method olusturalim
    // dosya yolu,sayfa ismi ve satir, hucre indexini verince hucre bilgisini dondursun

  public static Cell hucreGetir(String path, String sayfaIsmi,int satirIndex, int hucreIndex){
      Cell cell =null;
      try {
          FileInputStream fis=new FileInputStream(path);
          Workbook workbook= WorkbookFactory.create(fis);
          cell=workbook.getSheet(sayfaIsmi).getRow(satirIndex).getCell(hucreIndex);
      } catch (IOException e) {
          e.printStackTrace();
      }

      return cell;
  }

    public static Map mapExcel(String path, String sayfaIsmi) {

            //Map <String,String> mapExcel =new HashMap<>();//bu hizlidir ancak siralama yoktur
            Map <String,String> mapExcel =new TreeMap<>();//bu yavastir ancak alfabeye gore sıralama yapar.


         Workbook workbook=null;
         //ilk adim excelde istenen sayfaya ulasmak ulasmak
         try {
             FileInputStream fis =new FileInputStream(path);
             workbook=WorkbookFactory.create(fis);

         } catch (IOException e) {
             e.printStackTrace();
         }
         for (int i=0; i<workbook.getSheet(sayfaIsmi).getPhysicalNumberOfRows(); i++) {
             String key = workbook.getSheet(sayfaIsmi).getRow(i).getCell(0).toString();
             String value = workbook.getSheet(sayfaIsmi).getRow(i).getCell(1) + ", " +
                     workbook.getSheet(sayfaIsmi).getRow(i).getCell(2) + ", " +
                     workbook.getSheet(sayfaIsmi).getRow(i).getCell(3);
             mapExcel.put(key,value);
         }
        return mapExcel;
    }
}
