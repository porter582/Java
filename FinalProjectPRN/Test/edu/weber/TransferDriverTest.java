package edu.weber;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransferDriverTest {

    @Test
    public void test()
    {
        TransferDriver driver = new TransferDriver();
        assertEquals("Amount: ", 10000, driver.getTotalMoney());
    }
}