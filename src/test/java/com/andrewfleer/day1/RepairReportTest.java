package com.andrewfleer.day1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepairReportTest {
    public RepairReport repairReport = new RepairReport();
    List<Integer> testList;
    Integer testValue;

    @Before
    public void initialize() {
        testList = new ArrayList<Integer>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);

        testValue = 6;
    }

    @Test
    public void testFindingTwoNumbers() {
        Integer[] array = repairReport.findTwoNumbersThatEqualSum(testList, testValue);
        Integer[] validationArray = new Integer[] {2,4};

        assert(Arrays.equals(array, validationArray));

    }

    @Test
    public void testFindingThreeNumbers() {
        Integer[] array = repairReport.findThreeNumbersThatEqualSum(testList, testValue);
        Integer[] validationArray = new Integer[] {1,2,3};

        assert(Arrays.equals(array, validationArray));
    }

    @Test
    public void testMultiplication() {
        Integer[] testArray = new Integer[] {2,3,4};
        Integer testProduct = 24;

        Integer product = repairReport.multiplyFoundNumbers(testArray);

        assert(product == testProduct);
    }
}
