package com.ipg.diff.tool.java;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.junit.Assert.*;
import org.junit.Before;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * Unit test for Diff App.
 */

public class AppTest
{


    @org.junit.Test
    public void linesTest() throws IOException
    {
        String file1 = "files/RNB3.txt";
        String file2 = "files/RNB4.txt";

        File file3 = new File(file1);
        File file4 = new File(file2);

        System.out.println(file3.length());

        assert(file3.length()==file4.length());
    }

//    public void schemaTest() throws IOException
//    {
//        List lst1=FileUtils.readLines(file3,  "UTF_8");
//        List lst2=FileUtils.readLines(file4,  "UTF_8");
//        assert(lst1.get(0).toString().split(",").length==lst2.get(0).toString().split(",").length);
//    }
}
