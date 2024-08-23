package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File oldfile = new File("E:/tt1.txt");
        File newfile = new File("E:/tt2.txt");

        if (oldfile.renameTo(newfile)) {
            System.out.println("rename succesful!");
        } else {
            System.out.println("rename failed!");
        }
    }
}