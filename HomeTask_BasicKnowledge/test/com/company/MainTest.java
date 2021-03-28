package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getIntegersFromList(){
        List<Integer> result = Main.getIntegersFromList(Arrays.asList(1,2,"a","b"));
        assertArrayEquals(Stream.of(1,2).mapToInt(Integer::intValue).toArray(),
                result.stream().mapToInt(Integer::intValue).toArray());

        result = Main.getIntegersFromList(Arrays.asList(1,2,"a","b",0,15));
        assertArrayEquals(Stream.of(1,2,0,15).mapToInt(Integer::intValue).toArray(),
                result.stream().mapToInt(Integer::intValue).toArray());

        result = Main.getIntegersFromList(Arrays.asList(1,2,"a","b","aasf","1","123",231));
        assertArrayEquals(Stream.of(1,2,231).mapToInt(Integer::intValue).toArray(),
                result.stream().mapToInt(Integer::intValue).toArray());

    }

    @Test
    void first_non_repeating_letter() {
        char result = Main.first_non_repeating_letter("stress");
        assertEquals('t',result);

        result = Main.first_non_repeating_letter("sTreSS");
        assertEquals('T',result);

    }

    @Test
    void digital_root() {
        int result = Main.digital_root(16);
        assertEquals(7,result);

        result = Main.digital_root(942);
        assertEquals(6,result);

        result = Main.digital_root(132189);
        assertEquals(6,result);

        result = Main.digital_root(493193);
        assertEquals(2,result);
    }

    @Test
    void numberOfPairs() {
        int result = Main.numberOfPairs(5,new int[]{1,3,6,2,2,0,4,5});
        assertEquals(4,result);

        result = Main.numberOfPairs(4,new int[]{1,3,6,2,2,0,4,5});
        assertEquals(3,result);
    }

    @Test
    void numberOfPairs2() {
        long result = Main.numberOfPairs2(5,new int[]{1,3,6,2,2,0,4,5});
        assertEquals(4,result);

        result = Main.numberOfPairs2(4,new int[]{1,3,6,2,2,0,4,5});
        assertEquals(3,result);
    }

    @Test
    void inviteList() {
        String result = Main.inviteList("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill");
        assertEquals("(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)" +
                "(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)", result);

        result = Main.inviteList("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Barney:Tornbull;Raphael:Corwill;Alfred:Corwill");
        assertEquals("(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)" +
                "(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BARNEY)(TORNBULL, BETTY)", result);
    }

    @Test
    void nextBigger() {
        int result = Main.nextBigger(12);
        assertEquals(21,result);

        result = Main.nextBigger(513);
        assertEquals(531,result);

        result = Main.nextBigger(2017);
        assertEquals(2071,result);

        result = Main.nextBigger(9);
        assertEquals(-1,result);

        result = Main.nextBigger(111);
        assertEquals(-1,result);

        result = Main.nextBigger(531);
        assertEquals(-1,result);
    }

    @Test
    void toIPv4() {
        String result = Main.toIPv4(2149583361L);
        assertEquals("128.32.10.1",result);

        result = Main.toIPv4(32);
        assertEquals("0.0.0.32",result);

        result = Main.toIPv4(0);
        assertEquals("0.0.0.0",result);

    }
}