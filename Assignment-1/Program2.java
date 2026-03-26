//Problem Statement:
//Develop a Java program that implements a Matrix class with constructors and 
//performs matrix transpose and matrix multiplication operations.
import java.util.Scanner;

// Matrix class containing matrix operations
class Matrix {

    int rows;
    int cols;
    int[][] mat;

    // Constructor to initialize matrix
    Matrix(int r, int c) {
        rows = r;
        cols = c;
        mat = new int[rows][cols];
    }

    // Method to take matrix input
    void inputMatrix(Scanner sc) {

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    // Method to display matrix
    void display() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to find transpose
    void transpose() {

        System.out.println("Transpose of matrix:");

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println();
        }
    }

    // Method for matrix multiplication
    static Matrix multiply(Matrix a, Matrix b) {

        Matrix result = new Matrix(a.rows, b.cols);

        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.cols; j++) {

                result.mat[i][j] = 0;

                for (int k = 0; k < a.cols; k++) {
                    result.mat[i][j] += a.mat[i][k] * b.mat[k][j];
                }
            }
        }

        return result;
    }
}

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of matrix: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        Matrix m1 = new Matrix(r, c);
        Matrix m2 = new Matrix(r, c);

        System.out.println("Enter first matrix:");
        m1.inputMatrix(sc);

        System.out.println("Enter second matrix:");
        m2.inputMatrix(sc);

        System.out.println("First Matrix:");
        m1.display();

        System.out.println("Second Matrix:");
        m2.display();

        m1.transpose();

        System.out.println("Multiplication Result:");

        Matrix result = Matrix.multiply(m1, m2);
        result.display();

        sc.close();
    }
}