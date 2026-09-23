import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // массив c нечет 15;3
        short[] c = new short[7];
        short val = 15;
        for (int i = 0; i < c.length; i++) {
            c[i] = val;
            val -= 2;
        }

        // массив x -9;14
        float[] x = new float[11];
        Random rnd = new Random();
        float min = -9.0f;
        float max = 14.0f;
        for (int j = 0; j < x.length; j++) {
            x[j] = min + rnd.nextFloat() * (max - min);
        }

        // двумерный массив b
        double[][] b = new double[7][11];

        // заполнение матрицы
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 11; j++) {
                b[i][j] = calculateElement(c[i], x[j]);
            }
        }

        // вывод матрицы
        //System.out.println("Результат вычислений (матрица 7x11):");
        printMatrix(b);
    }

    // расчет одного элемента
    public static double calculateElement(short cVal, float xVal) {
        // если эл == 11
        if (cVal == 11) {
            return Math.cbrt(0.25) / (Math.sin(xVal) + 1.0);
        }
        // эл == 3, 5, 7
        else if (cVal == 3 || cVal == 5 || cVal == 7) {
            return Math.exp(Math.atan(Math.sin(xVal)));
        }
        // для всех остал знач
        else {
            double p1 = Math.pow(0.25 * Math.cos(xVal), 3);
            double p2 = Math.exp(Math.sin(xVal)) + Math.PI;
            double top = Math.pow(p1 * p2, 3);

            // Защита от отрицательного числа под корнем четной степени (защита от NaN)
            top = Math.abs(top);

            double bottom = Math.asin(Math.sin(Math.pow((xVal - 3.0) / 3.0, 3))) - 0.75;

            // Защита от деления на ноль
            if (Math.abs(bottom) < 0.000001) {
                bottom = 0.000001;
            }

            return Math.pow(top, 0.25) / bottom;
        }
    }

    // вывода матрицы с округлением
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}