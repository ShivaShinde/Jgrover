package com.ipg.diff.tool.java;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.junit.Assert.*;
import org.junit.Before;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * Unit test for Diff App.
 */

public class AppTest
{
    File file1 = new File("src/main/resources/RNB1.txt");
    File file2 = new File("src/main/resources/RNB2.txt");
    File config = new File("src/main/resources/config.yaml");

    @org.junit.Test
    public void fileLocationTest() throws IOException
    {
        assertTrue(Files.exists(file1.toPath()));
        assertTrue(Files.exists(file1.toPath()));
    }

    @org.junit.Test
    public void fileDirectoryLocationTest() throws IOException
    {
        assertFalse(Files.isDirectory(file1.toPath()));
        assertFalse(Files.isDirectory(file2.toPath()));
    }

    @org.junit.Test
    public void fileFormatTest() throws IOException
    {
        assertTrue(Files.isReadable(file1.toPath()));
        assertTrue(Files.isReadable(file2.toPath()));
    }

    @org.junit.Test
    public void configTest() throws IOException
    {
        assertTrue(Files.exists(config.toPath()));
    }

    @org.junit.Test
    public void configFileFormatTest() throws IOException
    {
        assertTrue(Files.isReadable(config.toPath()));
    }

    @org.junit.Test
    public void fileContentTest() throws IOException
    {
        assertEquals(file1.length(),file2.length());
    }

    @org.junit.Test
    public void filesSchemaTest() throws IOException
    {
        BufferedReader br1 = new BufferedReader(new FileReader("src/main/resources/RNB1.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("src/main/resources/RNB2.txt"));

        assertTrue("Testing the schema",br1.readLine().equals(br2.readLine()));
    }

    @org.junit.Test
    public void fileLengthTest() throws IOException
    {
        assertEquals(file1.length(),file2.length());
    }

    @org.junit.Test
    public void hashedFileComparisionTest() throws IOException
    {
        assertNotSame(file1.hashCode(),file2.hashCode());
    }

    @org.junit.Test
    public void lineComparisionTest() throws IOException
    {
        String linesOfRNB1;
        String linesOfRNB2;
        BufferedReader br1 = new BufferedReader(new FileReader("src/main/resources/RNB1.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("src/main/resources/RNB2.txt"));

            while (((linesOfRNB1 = br1.readLine()) != null && (linesOfRNB2 = br2.readLine()) != null)) {
                assertEquals(linesOfRNB1, linesOfRNB2);
            }
    }

}
