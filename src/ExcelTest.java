
import com.jycykj.export.ExcelExportManager;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class ExcelTest {
    public static void main(String [] args) {
         WritableWorkbook wrk = null;
         WritableSheet sheet = null;
        try {
            wrk = Workbook.createWorkbook(new File("12.xls"));
            sheet = wrk.createSheet("Sheet1",0);
            int rowNum=0;
            
            Label cell = new Label(0,0,"hello");
            sheet.addCell(cell);
            
            wrk.write();

        } catch (IOException ex) {
            Logger.getLogger(ExcelExportManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ExcelExportManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(wrk!=null){
                try {
                    wrk.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExcelExportManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (WriteException ex) {
                    Logger.getLogger(ExcelExportManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
 }
}


