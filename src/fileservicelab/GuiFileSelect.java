/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Alex
 */
public class GuiFileSelect implements FileSelectStrategy {
      private static final int ERROR = JFileChooser.ERROR_OPTION;
    private static final int APPROVE = JFileChooser.APPROVE_OPTION;
    private static final int CANCEL = JFileChooser.CANCEL_OPTION;
    File toRead;
    File toWrite;

    public GuiFileSelect() {
    }
 @Override
    public File getToRead() {
        return toRead;
    }

      @Override
    public File getToWrite() {
        return toWrite;
    }

    
    @Override
    public void setFilePathToRead() {
      
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // check if user clicked Cancel button on dialog, if so, return
        int result = fileChooser.showOpenDialog(null);
        if (!(result == APPROVE)) {
            System.exit(0);
        }

		
        File file = fileChooser.getSelectedFile();
        
        this.toRead = file;
    }

    @Override
   public void setFilePathToWrite() {
      
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // check if user clicked Cancel button on dialog, if so, return
        int result = fileChooser.showOpenDialog(null);
        if (!(result == APPROVE)) {
            System.exit(0);
        }

		
        File file = fileChooser.getSelectedFile();
        
        this.toWrite = file;
    }
    
}
