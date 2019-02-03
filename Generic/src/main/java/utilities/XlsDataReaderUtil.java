package utilities;


import java.util.ArrayList;

public class XlsDataReaderUtil {

        static XlsReader reader;

        public static ArrayList<Object[]> getDataFromExcel(){

            ArrayList<Object[]> myData = new ArrayList<Object[]>();
            try {
                reader = new XlsReader("C:\\Users\\emdad\\IdeaProjects\\hiframework\\HDepot\\src\\test\\java\\dataDriventest\\Book1.Excel.xls");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            // change only sheet name in line 19
            for (int rowNum =2; rowNum <= reader.getRowCount("Sheet1"); rowNum++){
                String  items = reader.getCellData("Sheet1", "items",rowNum );
                Object obj[] = {items};
                myData.add(obj);
            }
            return  myData;
        }
    }

