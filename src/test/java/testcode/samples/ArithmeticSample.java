package testcode.samples;

public class ArithmeticSample {

    public static void main(String[] args) {
        int result = 10 + 5 * 2; // result = 20, так как умножение выполняется первым
        int x = 10;
        x += 5 * 2; // x = 20, так как умножение выполняется первым, а затем прибавляется к x
        int y = (10 + 5) * 2; // y = 30, так как выражение в скобках вычисляется первым
    }
}
