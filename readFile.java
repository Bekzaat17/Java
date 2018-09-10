
package exercises;

import java.io.*;

public class readFile {
    
    public static void main(String[] args){
    BufferedReader br = null;
        try {
    File file = new File("newFile.txt");
    if(!file.exists())
    file.createNewFile();
    
    PrintWriter pw = new PrintWriter(file);
    pw.println("Everything are working!");
    pw.close();
    
    br = new BufferedReader(new FileReader("newFile.txt"));
    String line;
    while((line = br.readLine()) != null){
        System.out.println(line);
    }
    
} catch(Exception e){
    System.out.println("Error: " + e);
} finally{
            try{
            br.close();} catch(Exception e) {System.out.println("Error: "+e);}
        }
    
}
}
