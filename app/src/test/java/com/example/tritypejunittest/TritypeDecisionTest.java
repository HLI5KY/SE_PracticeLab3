package com.example.tritypejunittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TritypeDecisionTest {
    /*decision used:
    if (Side1+Side2 <= Side3 || Side2+Side3 <= Side1 ||
                    Side1+Side3 <= Side2)
                triOut = 4;
            else
                triOut = 1;
            return (triOut);*/
    @Test
    public void testTrue(){
        Tritype tri = new Tritype();
        assertEquals(4,tri.Triang(1,2,3));
    }
    @Test
    public void testFalse(){
        Tritype tri = new Tritype();
        assertEquals(1,tri.Triang(2,3,4));
    }

}