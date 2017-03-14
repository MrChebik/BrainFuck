package ru.mrchebik;

import java.util.Scanner;

/**
 * Created by mrchebik on 14.03.17.
 */
public class BrainFuck {
    private static Scanner scn = new Scanner(System.in);
    private static char arr[] = new char[30000];
    private static int k = 0;

    public static void main(String[] args) {
        String code = scn.nextLine();

        brainfuck(code);
    }

    public static void brainfuck(String code) {
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '+') arr[k]++; else
            if (code.charAt(i) == '-') arr[k]--; else
            if (code.charAt(i) == '>') k++;      else
            if (code.charAt(i) == '<') k--;      else
            if (code.charAt(i) == '[') {
                String subcode = "";
                int temp = 0;

                for (i++; i < code.length(); i++) {
                    if (code.charAt(i) == '[') {
                        temp++;
                    } else if (code.charAt(i) == ']') {
                        if (temp == 0) {
                            break;
                        } else {
                            temp--;
                        }
                    }
                    if (arr[k] > 0) {
                        subcode += code.charAt(i);
                    }
                }

                for (; arr[k] > 0;) {
                    brainfuck(subcode);
                }
            }                                    else
            if (code.charAt(i) == '.') sout(k);  else
            if (code.charAt(i) == ',') input(k);
        }
    }

    private static void input(int k) {
        arr[k] = scn.next().charAt(0);
    }

    private static void sout(int k) {
        System.out.println(arr[k] + " -- (" + (int) arr[k] + ")");
    }
}
