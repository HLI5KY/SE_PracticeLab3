package com.example.tritypejunittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TritypMutantTest {
    @Test
    public void original(){
        Tritype tri = new Tritype();
        assertEquals(4,tri.Triang(1,1,2));
    }
    @Test
    public void killOne(){
        TritypMutantOne tri = new TritypMutantOne();
        assertEquals(4,tri.Triang(1,1,2));
    }
    @Test
    public void killTwo(){
        TritypMutantTwo tri = new TritypMutantTwo();
        assertEquals(4,tri.Triang(1,1,2));
    }
}