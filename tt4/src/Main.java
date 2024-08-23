import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] names = {"Lemon", "Be", "Zuli", "Thu"};
        Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Mang sau khi duoc sap xep: ");
        for(String name : names) {
            System.out.println(name);
        }
    }
}
