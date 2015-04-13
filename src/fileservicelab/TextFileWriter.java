/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import fileservicelab.fileServiceLab.format.FileFormatStrategy;
import java.io.File;
import fileservicelab.fileServiceLab.format.FileFormatStrategy;
import fileservicelab.fileServiceLab.format.CsvFileFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class TextFileWriter implements FileWriterStrategy {
    
    File file;
    FileFormatStrategy formatStrategy;

    public TextFileWriter() {
    }

    @Override
    public void setFilePath(File file) {
        this.file = file;
    }

    @Override
    public void setFileFormat(FileFormatStrategy format) {
        this.formatStrategy = format; 
    }
    
     @Override
    public void addNewRecords(List<LinkedHashMap<String,String>> newData, boolean useHeader) 
            throws IOException {
        
        final boolean APPEND = true;
  
        PrintWriter out = new PrintWriter(new BufferedWriter(
					  new FileWriter(file, APPEND)));
        
        String data = formatStrategy.encodeAll(newData, useHeader);
        
        out.print(data);
        out.close();
        
    }
    
}
