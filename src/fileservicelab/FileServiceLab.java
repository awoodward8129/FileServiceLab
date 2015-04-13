/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import fileservicelab.fileServiceLab.format.CsvFileFormat;
import fileservicelab.fileServiceLab.format.FileFormatStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Alex
 */
public class FileServiceLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
      
       FileService fileService = new FileService( new TextFileReader(), new TextFileWriter(), new CsvFileFormat(), new GuiFileSelect());
        
       List<LinkedHashMap<String, String>> updatedFileContent
                = new ArrayList<LinkedHashMap<String, String>>();
       
        LinkedHashMap<String, String> record
                = new LinkedHashMap<String, String>();
       
        record.put("firstName", "Jim");
        record.put("lastName", "James");
        record.put("age", "35");
        updatedFileContent.add(record);

        fileService.addNewRecords(updatedFileContent, false);

        System.out.println("Writing done...");
       
        FileService fileToRead = new FileService(new TextFileReader(), new CsvFileFormat(), new GuiFileSelect());

        System.out.println(fileToRead.getRecordsFromReadFile());
        
    
    }
    
}
