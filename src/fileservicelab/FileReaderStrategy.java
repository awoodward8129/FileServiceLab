/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import fileservicelab.fileServiceLab.format.FileFormatStrategy;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface FileReaderStrategy{
   
    
    public abstract File getFile();
    
   public abstract List<LinkedHashMap<String, String>> getRecords() throws IOException;
   
   public abstract void setFilePath(File file);
   
   public abstract void setFileFormat(FileFormatStrategy format);
    
}
