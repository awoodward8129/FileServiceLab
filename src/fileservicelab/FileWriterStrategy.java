/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import fileservicelab.fileServiceLab.format.FileFormatStrategy;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface FileWriterStrategy {

    public abstract void setFilePath(File file);

    public abstract void setFileFormat(FileFormatStrategy format);

    public void addNewRecords(List<LinkedHashMap<String, String>> updatedFileContent, boolean useHeader) throws IOException;

}
