package Generalized

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class JUnit_Tests {

    @Rule
    public Timeout globalTimeout = new Timeout(2);

    @Test
    public void test_renovateMatrix_One() {
        int[][] tester = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] returnMatrix = GeneralizedDeterminantCalculator.renovateMatrix(tester, 2);

        assertEquals("Ensure that the returned matrix dimensions have decreased by one! (rows)", 2, returnMatrix.length);
        assertEquals("Ensure that the returned matrix dimensions have decreased by one! (columns)", 2, returnMatrix[0].length);

        for (int i = 0; i < returnMatrix.length; i++) {
            for (int j = 0; j < returnMatrix[i].length; j++ ) {
                assertEquals("Ensure the values are identical!", tester[i + 1][j], returnMatrix[i][j]);
            }
        }


    }

    @Test
    public void test_renovateMatrix_Two() {
        int[][] tester = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] returnMatrix = GeneralizedDeterminantCalculator.renovateMatrix(tester, 1);

        assertEquals("Ensure that the returned matrix dimensions have decreased by one! (rows)", 2, returnMatrix.length);
        assertEquals("Ensure that the returned matrix dimensions have decreased by one! (columns)", 2, returnMatrix[0].length);

        assertEquals("Ensure the values are identical!", 4, returnMatrix[0][0]);
        assertEquals("Ensure the values are identical!", 6, returnMatrix[0][1]);
        assertEquals("Ensure the values are identical!", 7, returnMatrix[1][0]);
        assertEquals("Ensure the values are identical!", 9, returnMatrix[1][1]);
    }

    @Test
    public void test_calculate_one() {
        int[][] tester = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int val = GeneralizedDeterminantCalculator.calculate(3, tester);

        assertEquals("Ensure that the determinant was calculated correctly!", 0, val);
    }

    @Test
    public void test_calculate_two() {
        int[][] tester = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int val = GeneralizedDeterminantCalculator.calculate(4, tester);

        assertEquals("Ensure that the determinant was calculated correctly!", 0, val);
    }

    @Test
    public void test_calculate_three() {
        int[][] tester = new int[][]{{1,2,3,4}, {17,29,15,17}, {55,83,102,205}, {13,14,15,16}};
        int val = GeneralizedDeterminantCalculator.calculate(4, tester);

        assertEquals("Ensure that the determinant was calculated correctly!", 24480, val);
    }


}
