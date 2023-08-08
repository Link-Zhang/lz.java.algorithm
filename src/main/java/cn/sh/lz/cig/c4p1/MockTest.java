package cn.sh.lz.cig.c4p1;

/**
 * Created by Link at 10:45 on 2023/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long startTime;
        int n = 10;

//        startTime = System.nanoTime();
//        System.out.println(fibonacci.stackOverflowFibonacci(n));
//        System.out.printf("slowFibonacci: %d ms%n", (System.nanoTime() - startTime) / 1000000);

        startTime = System.nanoTime();
        System.out.println(fibonacci.slowFibonacci(n));
        System.out.printf("slowFibonacci: %d ms%n", (System.nanoTime() - startTime) / 1000000);

        startTime = System.nanoTime();
        System.out.println(fibonacci.fastFibonacciMatrix(n));
        System.out.printf("fastFibonacciMatrix: %d ms%n", (System.nanoTime() - startTime) / 1000000);


        startTime = System.nanoTime();
        System.out.println(fibonacci.fastFibonacciDoubling(n));
        System.out.printf("fastFibonacciDoubling: %d ms%n", (System.nanoTime() - startTime) / 1000000);
    }
}
