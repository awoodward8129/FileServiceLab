/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import fileservicelab.fileServiceLab.format.FileFormatStrategy;
import fileservicelab.fileServiceLab.format.CsvFileFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;

/**
 *
 * @author Alex
 */
public class TextFileReader implements FileReaderStrategy{
    
  
    
//    List<HashMap<String,String>> records = new ArrayList<>();
   File file;
   private FileFormatStrategy formatStrategy;

    public TextFileReader(FileFormatStrategy formatStrategy) {
        this.formatStrategy = formatStrategy;
    }

    TextFileReader() {
        
    }
   

    @Override
    public File getFile() {
        
        return file;
    }

    @Override
    public List<LinkedHashMap<String, String>> getRecords() throws IOException {
      
        String data = "";
        
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(file));
	   String line = in.readLine();
	   while(line != null){
                data += (line + "\n");
                line = in.readLine();  
	   }
	 
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                throw new IOException(e.getMessage());
            }
        }
        
        return formatStrategy.decode(data);
  

}

    @Override
    public void setFilePath(File file) {
      
        this.file = file;
    }

 

    @Override
    public void setFileFormat(FileFormatStrategy format) {
       this.formatStrategy = format;
    }
}