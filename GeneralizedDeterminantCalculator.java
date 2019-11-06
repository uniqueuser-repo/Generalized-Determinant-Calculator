package Generalized

public class GeneralizedDeterminantCalculator {

    /* n is the rows, columns of the n x n matrix */

    public static int calculate(int n, int[][] matrix) {
        if (n == 1) {  // base case for single element
            return matrix[0][0];
        } else if (n == 2) {  // base case for 2 x 2 matrix (most frequent case access)
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        } else {
            int sum = 0;
            for (int j = 0; j < n; j++) {                            // calculates a_0j * c_0j column by column, sums it with the +=
                int[][] renovatedMatrix = renovateMatrix(matrix, j);
                sum += matrix[0][j] * Math.pow(-1, 1 + (j + 1)) * calculate(n - 1, renovatedMatrix);
            }
            return sum;

        }
    }

    public static int[][] renovateMatrix(int[][] matrix, int j) {
        int[][] renovatedMatrix = new int[matrix.length - 1][matrix.length - 1];

        int renovatedMatrixColumnIterator = 0;
        int renovatedMatrixRowIterator = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i != 0) {
                for (int k = 0; k < matrix.length; k++) {
                    if (k != j ) { // if not on first row and k is not the column we want to burn
                        renovatedMatrix[renovatedMatrixRowIterator][renovatedMatrixColumnIterator] = matrix[i][k];
                        renovatedMatrixColumnIterator++;
                    }
                }

                renovatedMatrixRowIterator++;
                renovatedMatrixColumnIterator = 0;
            }
        }

        return renovatedMatrix;
    }
}
