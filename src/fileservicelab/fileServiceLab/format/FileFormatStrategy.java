/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab.fileServiceLab.format;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.List;

/**
 *
 * @author Alex
 */
public interface FileFormatStrategy {
    
   public abstract List<LinkedHashMap<String,String>> decode(String data);
   
   public String encodeAll(List<LinkedHashMap<String, String>> updatedFileContent, boolean useHeader);


    
}
