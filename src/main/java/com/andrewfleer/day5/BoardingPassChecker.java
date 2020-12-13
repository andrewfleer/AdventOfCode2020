package com.andrewfleer.day5;

import com.andrewfleer.utils.FileUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardingPassChecker {
    private static final String fileName = "day5Input.txt";
    static char FRONT = 'F';
    static char LEFT = 'L';
    static Integer maxRow = 128;
    static Integer maxColumn = 8;
    static int[] rowArray;
    static int[] columnArray;


    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();

        try {
            List<String> inputs = fileUtil.readFileToList(fileName);
            buildRowArray();
            buildColumnArray();


            List<Integer> seats = getSeats(inputs);
            int maxSeat = findMaxSeat(seats);
            int mySeat = findMySeat(seats);

            System.out.println(mySeat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void buildRowArray() {
        rowArray = new int[maxRow];
        for (int i = 0; i < maxRow; i++) {
            rowArray[i] = i;
        }
    }

    public static void buildColumnArray() {
        columnArray = new int[maxColumn];
        for(int i = 0; i < maxColumn; i++) {
            columnArray[i] = i;
        }
    }

    private static List<Integer> getSeats(List<String> inputs) {
        List<Integer> seats = new ArrayList<Integer>();

        if (!CollectionUtils.isEmpty(inputs)) {
            for (String seatString : inputs) {
                String row = seatString.substring(0, 7);
                String column = seatString.substring(7);

                Integer rowAssignment = getRow(row, rowArray);
                Integer columnAssignment = getColumn(column, columnArray);

                Integer seat = calculateSeat(rowAssignment, columnAssignment);

                seats.add(seat);
            }
        }

        return seats;
    }

    public static Integer calculateSeat(Integer rowAssignment, Integer columnAssignment) {
        Integer seat = 0;
        seat = (rowAssignment * 8) + columnAssignment;

        return seat;
    }

    public static Integer getRow(String row, int[] rowsArray) {
        Integer rowAssignment = 0;
        int[] tempArray = rowsArray;
        char[] rows = row.toCharArray();
        for (int i = 0; i < rows.length; i++) {
            char position = rows[i];
            tempArray = splitRowArray(tempArray, position);
        }

        rowAssignment = tempArray[0];
        return rowAssignment;
    }

    public static int[] splitRowArray(int[] tempArray, char position) {
        int splitPoint = 0;

        if (tempArray.length % 2 == 1 ) {
            splitPoint = (tempArray.length + 1) / 2;
        } else {
            splitPoint = (tempArray.length) / 2;
        }
        if (position == FRONT) {
            return Arrays.copyOfRange(tempArray,0,splitPoint);
        } else {
            return Arrays.copyOfRange(tempArray, splitPoint, tempArray.length);
        }
    }

    public static Integer getColumn(String column, int[] columnsArray) {
        Integer columnAssignment = 0;
        int[] tempArray = columnsArray;
        char[] columns = column.toCharArray();
        for (int i = 0; i < columns.length; i++) {
            char position = columns[i];
            tempArray = splitColumnArray(tempArray, position);
        }

        columnAssignment = tempArray[0];
        return columnAssignment;
    }

    public static int[] splitColumnArray(int[] tempArray, char position) {
        int splitPoint;

        if (tempArray.length % 2 == 1 ) {
            splitPoint = (tempArray.length + 1) / 2;
        } else {
            splitPoint = (tempArray.length) / 2;
        }

        if (position == LEFT) {
            return Arrays.copyOfRange(tempArray,0,splitPoint);
        } else {
            return Arrays.copyOfRange(tempArray, splitPoint, tempArray.length);
        }
    }

    public static int findMaxSeat(List<Integer> seats) {
        Collections.sort(seats);

        return(seats.get(seats.size() - 1));
    }

    public static int findMySeat(List<Integer> seats) {
        int mySeat = 0;

        Collections.sort(seats);
        for (int i = 0; i < seats.size(); i++) {
            int currentSeat = seats.get(i);
            try {
                int nextSeat = seats.get(i + 1);

                if ((nextSeat - currentSeat) > 1) {
                    mySeat = currentSeat + 1;
                    break;
                }
            } catch (IndexOutOfBoundsException iobe) {
                mySeat = currentSeat + 1;
                return mySeat;
            }
        }
        return mySeat;
    }
}
