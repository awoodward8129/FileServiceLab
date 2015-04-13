/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.io.File;

/**
 *
 * @author Alex
 */
public interface FileSelectStrategy {
     public void setFilePathToRead();
     public void setFilePathToWrite();
     public File getToRead();
     public File getToWrite();
    
}
