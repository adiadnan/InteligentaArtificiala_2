/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StreamHandlers;

import Printers.AbstractPrint;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ADI
 */
public class StreamHandler {

    private static final Scanner scanner = new Scanner(System.in);
    private static BufferedReader br = null;
    private static boolean fileIsOpen = false;

    public static int fileReader(String filePath) throws IOException {

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
