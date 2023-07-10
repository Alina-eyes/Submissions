package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class MainTest {

    @RepeatedTest(10)
    @Test
    @DisplayName("Simple test!")
    private static void test1() {
        System.out.println("AAA");
    }
}