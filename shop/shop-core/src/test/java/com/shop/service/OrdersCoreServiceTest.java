package com.shop.service;

import org.junit.Test;

import com.shop.model.Orders;

import static org.junit.Assert.*;

public class OrdersCoreServiceTest {
    @Test
    public void canConstructAPersonWithAName() {
        Orders person = new Orders();
        assertEquals("Larry", person.getAddress());
    }
}
