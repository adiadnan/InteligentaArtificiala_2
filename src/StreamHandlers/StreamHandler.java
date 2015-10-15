/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StreamHandlers;

import Printers.AbstractPrint;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ADI
 */
public class StreamHandler {

    private static final Scanner scanner = new Scanner(System.in);
    private static String filePath = "";
    private static BufferedReader br = null;
    private static boolean fileIsOpen = false;

    public static int fileReader(String filePath) throws IOException {
        
        StreamHandler.setFilePath(filePath);

        try {

            br = new BufferedReader(new FileReader(filePath));
            StreamHandler.setFileStatus(true);

            try {

                return Integer.parseInt(br.readLine());

            } catch (IOException exception) {

                AbstractPrint.printLine(exception.getMessage());

            }

        } catch (FileNotFoundException exception) {

            AbstractPrint.printLine(exception.getMessage());

        }

        return 0;

    }
    
    public static void writeToFile(String fileContent) throws IOException{
        
        File file = new File(StreamHandler.getFilePath());
        
        try{
        
        if(!file.exists()) {
            
            file.createNewFile();
            
        }
        } catch(IOException exception){
            
            AbstractPrint.printLine(exception.getMessage());
            
        }
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(fileContent);
        bw.close();
        
    }

    public static boolean closeBuffer() {

        boolean fileStatus = StreamHandler.getFileStatus();

        if (fileStatus == true) {

            try {

                StreamHandler.getBuffer().close();
                StreamHandler.setFileStatus(false);

            } catch (IOException exception) {

                AbstractPrint.printLine(exception.getMessage());

            }

            return true;

        } else if (fileStatus == false) {
            
            return false;
            
        }

        return false;
    }

    public static int consoleReader() {

        try {

            return Integer.parseInt(getScanner().nextLine());

        } catch (NumberFormatException exception) {

            AbstractPrint.printLine(exception.getMessage());

        }

        return 0;

    }
    
    public static void setFilePath(String filePath){
        
        StreamHandler.filePath = filePath;
        
    }
    
    public static String getFilePath(){
        
        return filePath;
        
    }

    public static Scanner getScanner() {

        return scanner;

    }

    public static BufferedReader getBuffer() {

        return br;

    }

    private static void setFileStatus(boolean fileIsOpen) {

        StreamHandler.fileIsOpen = fileIsOpen;

    }

    private static boolean getFileStatus() {

        return fileIsOpen;

    }

}
