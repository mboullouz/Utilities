package io;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static common.FileManager.fileToString;

public class FileTest {
    @Test
    public void utfTest() throws IOException {
        String content = "abc def àû!";
        String fileName = getClass().getResource("/void.txt").getFile();
        //empty file first
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("");
        }
        //Append content to the void file (NB: second parameter of FileWriter constructor
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(content);
        }
        String fromFile = fileToString(getClass(), "void.txt");
        Assert.assertEquals(content, fromFile);
    }

    @Test
    public void readLinesFromFileAsStrTest() {
        String str = fileToString(getClass(), "read.txt");
        String exp = "abc def\r\n" + "123 456\r\n" + "abc def\r\n" + "123 456";
        Assert.assertEquals(exp, str);
        Assert.assertArrayEquals(exp.toCharArray(), str.toCharArray());
    }


}
