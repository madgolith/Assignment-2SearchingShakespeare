/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import datastructures.ArraySymbolTable;
import wordsorter.LoadTextFile;

/**
 *
 * @author jaw40
 */
public class TestArraySymbolTable {
    public static void main(String[] args) throws IOException {
        LoadTextFile TF =new LoadTextFile();
        String[] allShake = TF.loadText();
        
        String[] subShake = Arrays.copyOfRange(allShake, 0, 100000);
        
        ArraySymbolTable lst = new ArraySymbolTable();
        
        for (String string : subShake){
            lst.put(string, 1);
        }
        
        for (String string : lst.keys()){
            System.out.println(string + " : " + lst.get(string));
        }
    }
}
