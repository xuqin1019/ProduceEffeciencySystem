
import com.jycykj.helper.ConfigFile;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuqin
 */
public class Main {
    public static void main(String[] args)
{
    String str = " 22|6,";
    String [] parts = str.split(",");
    String [] addProcedureIds = parts[0].split("\\|");
    String [] delProcedureIds = (parts.length==2 ? parts[1].split("\\|") : new String[0]);
                
               for(String id : addProcedureIds) {
                     if(!id.trim().equals("")) {
                         System.out.println("ADD_ID : " + id);
                     }
                }
   System.out.println(ConfigFile.getConfig("configuration.txt", "SQLServerHost"));
}

}
