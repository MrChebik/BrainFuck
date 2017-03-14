package ru.mrchebik;

import java.io.IOException;

/**
 * Created by mrchebik on 14.03.17.
 */
public class BrainFuck {
    private static char arr[] = new char[30000];
    private static int k = 0;

    public static void main(String[] args) {
        //String code = new Scanner(System.in).nextLine();

        String code = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++" +
                ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++." +
                "------.--------.>+.>.";

        brainfuck(code);
    }

    public static void brainfuck(String code) {
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '+') arr[k]++; else
            if (code.charAt(i) == '-') arr[k]--; else
            if (code.charAt(i) == '>') k++;      else
            if (code.charAt(i) == '<') k--;      else
            if (code.charAt(i) == '[') {
                if (arr[k] < 0) {
                    i = findMatchingBrace(i, code);
                } else {
                    String subcode = "";
                    for (int h = ++i; h < code.length(); h++) {
                        if (code.charAt(h) != ']') {
                            subcode += code.charAt(h);
                        } else {
                            i = h;
                            break;
                        }
                    }

                    for (; arr[k] > 0;) {
                        brainfuck(subcode);
                    }
                }
            }                                    else
            if (code.charAt(i) == ']') {
                if (arr[k] != 0) {
                    i = findNextBrace(i, code);
                }
            }                                    else
            if (code.charAt(i) == '.') sout(k);  else
            if (code.charAt(i) == ',') input(i);
        }
    }

    private static void input(int i) {
        try {
            arr[i] = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sout(int k) {
        System.out.print(arr[k]);
    }

    private static int findNextBrace(int i, String code) {
        for (int j = i; j < code.length(); j++) {
            if (code.charAt(j) == '[') {
                return j;
            }
        }

        return Integer.MAX_VALUE;
    }

    private static int findMatchingBrace(int i, String code) {
        int temp = 0;
        String subcode = "";

        for (int j = i; j < code.length(); j++) {
            if (code.charAt(j) == '[') {
                temp++;
            } else if (code.charAt(j) == ']') {
                if (temp == 0) {
                    return j;
                } else {
                    temp--;
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
