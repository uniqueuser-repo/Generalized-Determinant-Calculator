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
        int[][] returnMatrix = GeneralizedDeterminantCalculator.renovateMatrix(new int[][]
                {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}, 2);

        assertEquals("Ensure that the returned matrix dimensions have decreased by one! (rows)", 2, returnMatrix.length);
        assertEquals("Ensure that the returned matrix dimensions have decreased by one! (columns)", 2, returnMatrix[0].length);


    }
}
