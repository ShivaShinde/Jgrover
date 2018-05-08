package com.ipg.diff.tool.java;

import java.io.*;
import java.util.Scanner;


import org.apache.commons.io.FileUtils;

/**
 * Diff App!
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        File file3 = new File("src/main/resources/RNB1.txt");
        File file4 = new File("src/main/resources/RNB2.txt");

        System.out.println("Printing the raw file size "+file3.length());

        Scanner sc=new Scanner(file3);

        while(sc.hasNextLine())
        {
            System.out.println("Printing the file3 contents");
            System.out.println(sc.nextLine());
        }

        System.out.println(new File("RNB1.txt").getAbsolutePath());

        BufferedReader br1 = new BufferedReader(new FileReader("src/main/resources/RNB1.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("src/main/resources/RNB2.txt"));

        String str1;
        String str2;
        while((str1= br1.readLine()) != null){
            System.out.println(str1);
        }

        System.out.println("This is the file3 count: "+br1.readLine().length());


        System.out.println("This is the File INput stream count file3 count: "+file3);


        int s=file3.compareTo(file4);
        boolean compare1and2 = FileUtils.contentEquals(file3, file4);
        System.out.println("Are test1.txt and test2.txt the same? " + compare1and2);
    }

    public void compareRecordCount(File file3,File file4)
    {
    if(file3.length()==file4.length())
{
    System.out.println("");
    compareSchema(file3,file4);
}
else System.out.println();

    }

    public void compareSchema(File file3,File file4){
        file3.equals(file4);

    }
}


