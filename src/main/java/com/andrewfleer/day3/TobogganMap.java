package com.andrewfleer.day3;

import com.andrewfleer.utils.FileUtil;

import java.util.List;

public class TobogganMap {
    private static final String fileName = "day3Input.txt";
    static int distanceX = 3;
    static int distanceY = 1;

    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();


        try {
            List inputs = fileUtil.readFileToList(fileName);
            
            char[][] map = convertToMap(inputs);

            int trees = traverseMap(map);
            System.out.println(trees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static char[][] convertToMap(List<String> inputs) {
        char[][] map = new char[inputs.size()][];
        for (int i = 0; i < inputs.size(); i++) {
            String input = inputs.get(i);
            map[i] = input.toCharArray();
        }

        return map;
    }

    public static int traverseMap(char[][] map) {
        int trees = 0;

        // Initialize toboggan
        int tobogganX = 0;
        int tobogganY = 0;

        // Get the height of the map
        int height = map.length;

        // Start sledding!
        try {
            for (int i = 0; i < height - 1; i++) {
                tobogganX = tobogganX + distanceX;
                tobogganY = tobogganY + distanceY;

                // If we went too far to the right,
                // loop around and start over.
                // Because the map "repeats" horizontally infinitely.
                if (tobogganX > map[i].length - 1) {
                    tobogganX = (tobogganX - map[i].length);
                }

                if (map[tobogganY][tobogganX] == '#') {
                    trees++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trees;
    }
}
