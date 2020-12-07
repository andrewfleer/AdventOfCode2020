package day3;

import com.andrewfleer.day3.TobogganMap;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TobogganMapTest {
    TobogganMap tobogganMap;
    String testRow = "...X...";
    char[][] testMap;

    @Before
    public void initialize() {
        tobogganMap = new TobogganMap();
        testMap = buildTestMap();
    }

    private char[][] buildTestMap() {
        char[][] map = new char[5][5];
        map[0] = new char[]{'.','.','#','.','#'};
        map[1] = new char[]{'#','.','#','.','.'};
        map[2] = new char[]{'.','#','.','#','#'};
        map[3] = new char[]{'#','#','.','.','#'};
        map[4] = new char[]{'.','.','#','.','.'};

        return map;
    }

    @Test
    public void testMapBuilder() {
        List<String> testList = new ArrayList<String>();
        testList.add(testRow);

        char[][] map = tobogganMap.convertToMap(testList);

        assert(map[0][3] == 'X');
    }

    @Test
    public void testTraversal() {
        int trees = tobogganMap.traverseMap(testMap, 3, 1);

        assert(trees == 3);
    }
}
