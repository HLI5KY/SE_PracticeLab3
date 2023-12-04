package com.example.tritypejunittest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class TritypeLineBranchTest {
    @Test
    public void testTypeCheck(){
        Tritype tri = new Tritype();
        assertEquals(4,tri.Triang(1,1,0));
        assertEquals(3,tri.Triang(1,1,1));
        assertEquals(2,tri.Triang(1,2,2));
        assertEquals(2,tri.Triang(2,2,3));
        assertEquals(2,tri.Triang(2,1,2));
        assertEquals(1,tri.Triang(3,4,5));
        assertEquals(4,tri.Triang(1,1,2));
        assertEquals(4,tri.Triang(1,2,3));
    }
    @Test
    public void testGetN() throws Exception {
        //反射
        Class<Tritype> triClass = Tritype.class;
        Tritype tri = (Tritype) triClass.newInstance();
        Method getNMethod = triClass.getDeclaredMethod("getN");
        getNMethod.setAccessible(true);
        //设置输入
        ByteArrayOutputStream outStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(outStream);
        PrintStream oldStream = System.out;
        InputStream oldIn = System.in;
        System.setOut(cacheStream);
        //测试
        getNMethod.invoke(tri);
        FileInputStream fileIn = new FileInputStream("src\\main\\AndroidManifest.xml");//生成文件流，可能出现路径问题
        fileIn.close();//关闭流
        System.setIn(fileIn);
        getNMethod.invoke(tri);
        assertEquals("Entry must be a number, choosing 1.\r\nCould not read input, choosing 1.\r\n",outStream.toString());
        System.setOut(oldStream);
        System.setIn(oldIn);
    }
    @Test
    public void testMain(){
        Tritype tri = new Tritype();
        //设置输入
        ByteArrayOutputStream outStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(outStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        String[] arg = new String[]{"","",""};
        //测试
        tri.main(arg);
        assertEquals("This is the ancient TriTyp program.\n" +
                "Enter three integers that represent the lengths of the sides of a triangle.\n" +
                "The triangle will be categorized as either scalene, isosceles, equilateral\n" +
                "or invalid.\n" +
                "\r\n" +
                "Enter side 1: \r\n" +
                "Entry must be a number, choosing 1.\r\n" +
                "Enter side 2: \r\n" +
                "Entry must be a number, choosing 1.\r\n" +
                "Enter side 3: \r\n" +
                "Entry must be a number, choosing 1.\r\n" +
                "Result is: equilateral\r\n",outStream.toString());
        System.setOut(oldStream);
    }

}