/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.security.CodeSigner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author VAN
 */
public class Test {

    public static void main(String[] args) {
        FileController fileController = new FileController();
        List<String> str = new ArrayList<>();
        str = ReadFileDK("TM.DAT");
        for (String string : str) {
            System.out.println(string);
        }
        Sort(str);
        WriteFileTĐ(str,"TM_Unit1.DAT");
    }

    private static List<String> ReadFileDK(String fileName1) {
        FileController fileController = new FileController();
        List<String> strs = new ArrayList<>();
        fileController.OpenFileToRead(fileName1);
        while (fileController.getScanner().hasNext()) {
            String infor = fileController.getScanner().nextLine();
            
            String firstLetter = infor.substring(0, 1);
            String remainingLetters = infor.substring(1, infor.length());
            firstLetter = firstLetter.toUpperCase();
            
            infor = firstLetter + remainingLetters;
            strs.add(infor);
        }
        fileController.CloseFileAfterRead();
        return strs;
    }

    
    
    private static void Sort(List<String> str){
        Collections.sort(str, (o1, o2) -> {
            return o1.compareToIgnoreCase(o2);
        });
        System.out.println("----------------------");
        for (String string : str) {
            System.out.println(string);
        }
    }

    private static void WriteFileTĐ(List<String> strs, String fileName){
       FileController fileController = new FileController();
        fileController.OpenFileToWrite(fileName,false);
        for (String str : strs) {
            fileController.getPrintWriter().println(str);
        }
        fileController.CloseFileAfterWrite();
    }
}
