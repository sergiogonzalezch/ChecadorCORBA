import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class savetxt {

    public savetxt() {
    }
    
    
    public boolean findfile() throws IOException{
           File file = new File ("C:\\archivos\\List\\registryWorkesTimes.txt"); 
           boolean var = file.exists();
           System.out.println(String.valueOf(var)); 
     
       return var; 
    }

    public  void createFile(String name, int id, Date d )  {
        String root = "C:\\archivos\\List\\registryWorkesTimes.txt";
        File file = new File (root); 
        FileWriter flwriter = null ; 
        try { 
            flwriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(flwriter); 
            bw.write("\n"+ name+"   "+ id+"     "+d);
            bw.close();            
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            if (flwriter != null){
                try { 
                    flwriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(savetxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void updateFile(String name, int id, Date d) throws IOException{
        
        String root = "C:\\archivos\\List\\registryWorkesTimes.txt";
        File file = new File (root);
        FileWriter flwriter = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(flwriter);
        bw.write( "\n"+ name+"   "+ id+"     "+d);
        bw.newLine();
        bw.close();
        
       }  
}

