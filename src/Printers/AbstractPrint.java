/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Printers;

/**
 *
 * @author ADI
 */
public class AbstractPrint {
    
    public static void print(String outputText){
        
        System.out.print(outputText);
        
    }
    
    
    public static void printLine(){
        
        System.out.println();
        
    }
    
    public static void printLine(String outputText){
        
        System.out.println(outputText);
        
    }
    
    
}
