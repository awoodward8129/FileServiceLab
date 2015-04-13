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
import javax.swing.JFileChooser;

/**
 *
 * @author Alex
 */
public class FileService {

    FileSelectStrategy fileSelect;
    FileReaderStrategy fileReader;
    FileFormatStrategy fileFormat;
    FileWriterStrategy fileWriter;
    File file;



    public FileService(FileReaderStrategy fileReader, FileWriterStrategy fileWriter, FileFormatStrategy fileFormat, FileSelectStrategy fileSelect) {
        setFileReader(fileReader);
        setFileFormat(fileFormat);
        setFileWriter(fileWriter);
        fileReader.setFileFormat(fileFormat);
        fileWriter.setFileFormat(fileFormat);
        setFileSelect(fileSelect);
        fileSelect.setFilePathToRead();
        fileSelect.setFilePathToWrite();
        fileReader.setFilePath(fileSelect.getToRead());
        fileWriter.setFilePath(fileSelect.getToWrite());

    }

    public FileService(FileReaderStrategy fileReader, FileFormatStrategy fileFormat, FileSelectStrategy fileSelect) {
       setFileReader(fileReader);
        setFileFormat(fileFormat);
                fileReader.setFileFormat(fileFormat);
       
        setFileSelect(fileSelect);
        fileSelect.setFilePathToRead();
     
        fileReader.setFilePath(fileSelect.getToRead());
   
    }
    

    public FileService(FileReaderStrategy fileReader, FileFormatStrategy fileFormat) {
        setFileReader(fileReader);
        setFileFormat(fileFormat);
        fileReader.setFileFormat(fileFormat);
        fileReader.setFilePath(file);
    }

    public FileWriterStrategy getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriterStrategy fileWriter) {
        this.fileWriter = fileWriter;
    }

    public List<LinkedHashMap<String, String>> getRecordsFromReadFile() throws IOException {
        return fileReader.getRecords();
    }
  

    public FileReaderStrategy getFileReader() {
        return fileReader;
    }

    public FileFormatStrategy getFileFormat() {
        return fileFormat;
    }

    public void setFileReader(FileReaderStrategy fileReader) {
        this.fileReader = fileReader;
    }

    public void setFileFormat(FileFormatStrategy fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void addNewRecords(List<LinkedHashMap<String, String>> data, boolean useHeader) throws IOException {
        fileWriter.addNewRecords(data, useHeader);
    }
    public void setFileSelect(FileSelectStrategy fileSelect) {
        this.fileSelect = fileSelect;
    }
}
