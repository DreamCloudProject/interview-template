package com.mastermindcms.lessons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTasksHolder {

    @Test
    public void testLucky() {
        assertEquals(7, TasksHolder.getLucky());
    }

    @Test
    public void testHelloWorld() {
        assertEquals("hello world", TasksHolder.getHelloWorld());
    }

    @Test
    public void testNumber10() {
        assertEquals(10, TasksHolder.getNumber10());
    }
}
