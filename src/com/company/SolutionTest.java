package com.company;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void testGetResultMethod() {
        String race = "Woodman";
        String cellType = "STWSWTPPTPTTPWPP";

        Solution res = new Solution();

        assertEquals(12, res.getResult(race, cellType));
    }
}