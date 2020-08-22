package com.edineva.calculator2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Calculator2Test {
     private Calculator2 calculator = new Calculator2();

     @Test
     public void testSum() {
          assertEquals(5, calculator.sum(2, 3));
     }
}
