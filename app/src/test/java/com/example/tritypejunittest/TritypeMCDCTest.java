package com.example.tritypejunittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TritypeMCDCTest {
       /*decision used:
    if (Side1+Side2 <= Side3 || Side2+Side3 <= Side1 ||
                    Side1+Side3 <= Side2)
                triOut = 4;
            else
                triOut = 1;
            return (triOut);*/
    @Test
    public void testDecisionFalse(){
        Tritype tri = new Tritype();
        assertEquals(1,tri.Triang(2,3,4));
    }
    @Test
    public void conditionFirstTrue(){//Side1+Side2 <= Side3
        Tritype tri = new Tritype();
        assertEquals(4,tri.Triang(1,2,3));
    }
    @Test
    public void conditionSecondTrue(){//Side2+Side3 <= Side1
        Tritype tri = new Tritype();
        assertEquals(4,tri.Triang(3,2,1));
    }
    @Test
    public void conditionThirdTrue(){//Side1+Side3 <= Side2
        Tritype tri = new Tritype();
        assertEquals(4,tri.Triang(1,3,2));
    }

    /*| Side1+Side2 <= Side3 | Side2+Side3 <= Side1 | Side1+Side3 <= Side2 | decision |
      |          0           |           0          |           0          |     0    |
      |          1           |           0          |           0          |     1    |
      |          0           |           1          |           0          |     1    |
      |          0           |           0          |           1          |     1    |*/

}