package com.andrewfleer.day5;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardingPassCheckerTest {
    BoardingPassChecker boardingPassChecker;
    int[] testArray;

    @Before
    public void initialize() {
        boardingPassChecker = new BoardingPassChecker();
        testArray = new int[]{1,2,3,4};
    }

    @Test
    public void testSplitRowArrayFront() {
        int[] validArray = new int[]{1,2};
        int[] codeArray = boardingPassChecker.splitRowArray(testArray, 'F');

        assert(Arrays.equals(validArray, codeArray));

    }

    @Test
    public void testSplitRowArrayBack() {
        int[] validArray = new int[]{3,4};
        int[] codeArray = boardingPassChecker.splitRowArray(testArray, 'B');

        assert(Arrays.equals(validArray, codeArray));

    }

    @Test
    public void testSplitColumnArrayLeft() {
        int[] validArray = new int[]{1,2};
        int[] codeArray = boardingPassChecker.splitColumnArray(testArray, 'L');

        assert(Arrays.equals(validArray, codeArray));
    }

    @Test
    public void testSplitColumnArrayRight() {
        int[] validArray = new int[]{3,4};
        int[] codeArray = boardingPassChecker.splitColumnArray(testArray, 'R');

        assert(Arrays.equals(validArray, codeArray));

    }

    @Test
    public void testGetRow() {
        String rowTest = "FB";

        assert(2 == boardingPassChecker.getRow(rowTest, testArray));
    }

    @Test
    public void testGetColumn() {
        String columnTest = "LL";

        assert(1 == boardingPassChecker.getColumn(columnTest, testArray));
    }

    @Test
    public void testCalculateSeat() {
        int seat = boardingPassChecker.calculateSeat(2,3);

        assert(19 == seat);
    }

    @Test
    public void testFindMaxSeat() {
        List<Integer> seats = new ArrayList<Integer>();
        seats.add(1);
        seats.add(4);
        seats.add(5);
        seats.add(2);
        seats.add(0);

        assert(5 == boardingPassChecker.findMaxSeat(seats));
    }

    @Test
    public void testFindMySeat() {
        List<Integer> seats = new ArrayList<Integer>();
        seats.add(1);
        seats.add(4);
        seats.add(5);
        seats.add(2);
        seats.add(0);

        assert(3 == boardingPassChecker.findMySeat(seats));
    }
}
