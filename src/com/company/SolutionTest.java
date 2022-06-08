package com.company;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void testGetResultMethod() {
        String race = "Woodman";
        String cellType = "STWSWTPPTPTTPWPP";

        assertEquals(12, Solution.getResult(race, cellType));
    }
}