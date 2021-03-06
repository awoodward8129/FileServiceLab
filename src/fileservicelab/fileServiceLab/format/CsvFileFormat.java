/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab.fileServiceLab.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Alex
 */
public class CsvFileFormat implements FileFormatStrategy {

    public CsvFileFormat() {
    }

    /**
     *
     * @param data
     * @return
     */
    @Override
    public List<LinkedHashMap<String, String>> decode(String data) {

    
        List<LinkedHashMap<String,String>> records = 
                new ArrayList<LinkedHashMap<String,String>>();
        
        String[] lines = data.split("\\n");
        String[] header = lines[0].split(",");
        
        for(int i=1; i < lines.length; i++) {
            LinkedHashMap<String,String> record = new LinkedHashMap<String,String>();
            String[] rowData = lines[i].split(",");
            for(int j=0;j < rowData.length; j++) {
                record.put(header[j], rowData[j]);
            }
            records.add(record);
        }
        
        return records;
    }
    
    
    
    
 @Override
    public String encodeAll(List<LinkedHashMap<String, String>> updatedFileContent, boolean useHeader) {
        StringBuilder encodedData = new StringBuilder();
        
        // Builder Header row
        LinkedHashMap<String, String> headerRec = updatedFileContent.get(0);
        Set<String> fields = headerRec.keySet();

        for(Iterator i = fields.iterator(); i.hasNext(); ) {
            encodedData.append("\"").append(i.next()).append("\"").append(",");
        }

        int lastChar = encodedData.length()-1;
        encodedData.replace(lastChar, lastChar+1, "\n");
        
        if(!useHeader) {
            encodedData = new StringBuilder(); // clear header info
        }
        
        // Now add data rows
        for(LinkedHashMap<String, String> dataRow : updatedFileContent) {
             for(Iterator i = fields.iterator(); i.hasNext(); ) {
                 encodedData.append("\"").append(dataRow.get(i.next().toString()))
                         .append("\"").append(",");
             }
             lastChar = encodedData.length()-1;
             encodedData.replace(lastChar, lastChar+1, "\n");             
        }
        
        lastChar = encodedData.length()-1;
        encodedData.replace(lastChar, lastChar+1, "\n");
        
        return encodedData.toString();        
    }


    
 
}
