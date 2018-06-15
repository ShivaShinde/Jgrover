package com.ipg.diff.tool.java;

import java.io.*;
import java.util.Scanner;


import org.apache.commons.io.FileUtils;

/**
 * Diff App!
 */
public class App {

    public void schemaComparision(BufferedReader br1, BufferedReader br2) throws IOException {
        try {
            if (br1.readLine().equals(br2.readLine())) {
                System.out.println("**Schema Comparision Success**");
                linesComparision(br1, br2);
            } else {
                System.out.println("**Schema Comparision Failure**" + "\n" + "Schema from RNB1: " + br1.readLine() + "\n" + "Schema from RNB2: " + br2.readLine());
            }
        } catch (IOException e) {
            throw new IOException("Problem reading a line", e);
        }
    }

    public void linesComparision(BufferedReader br1, BufferedReader br2) throws IOException {
        String linesOfRNB1;
        String linesOfRNB2;
        try {
            while (((linesOfRNB1 = br1.readLine()) != null && (linesOfRNB2 = br2.readLine()) != null)) {
                if (linesOfRNB1.equals(linesOfRNB2))
                    System.out.println("**Line Comparision Success**");
                else {
                    System.out.println("**Line Comparision Failure**" + "\n" + "Line from RNB1: " + linesOfRNB1 + "\n" + "Line from RNB2: " + linesOfRNB2);
                }
            }
        } catch (IOException e) {
            throw new IOException("Problem reading a line", e);
        }
    }

    public boolean fileComparision(File file1, File file2) throws IOException {
        return FileUtils.contentEquals(file1, file2); }

    public static void main(String[] args) throws IOException {

        BufferedReader br1 = new BufferedReader(new FileReader("src/main/resources/RNB1.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("src/main/resources/RNB2.txt"));

        File file1 = new File("src/main/resources/RNB1.txt");
        File file2 = new File("src/main/resources/RNB2.txt");

        App diffAppObject = new App();
        diffAppObject.schemaComparision(br1, br2);
        diffAppObject.fileComparision(file1, file2);

        }
}



