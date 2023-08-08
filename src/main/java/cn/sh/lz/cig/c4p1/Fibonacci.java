package cn.sh.lz.cig.c4p1;

import java.math.BigInteger;

/**
 * Created by Link at 13:35 on 2023/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */

/**
 * 问题：斐波那契问题
 */
public class Fibonacci {
    /**
     * Textbook recursive
     * <p>
     * 时间复杂度O(e^n)
     * 空间复杂度O(e^n)的系统栈
     */
    @Deprecated
    public BigInteger stackOverflowFibonacci(int n) {
        if (n <= 0) {
            return BigInteger.ZERO;
        }
        if (1 == n) {
            return BigInteger.ONE;
        }
        return stackOverflowFibonacci(n - 1).add(stackOverflowFibonacci(n - 2));
    }

    /**
     * F(n+2) = F(n+1) + F(n).
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public BigInteger slowFibonacci(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c;
        for (int i = 0; i < n - 1; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * [1 1]^n   [F(n+1) F(n)  ]
     * [1 0]   = [F(n)   F(n-1)].
     * <p>
     * 时间复杂度O(log n)
     * 空间复杂度O(1)
     */
    public BigInteger fastFibonacciMatrix(int n) {
        Matrix fibonacciMatrix = new Matrix(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
        Matrix result = new Matrix().power(fibonacciMatrix, n - 1);
        return result.getA();
    }

    /**
     * F(2n) = F(n) * (2*F(n+1) - F(n)).
     * F(2n+1) = F(n+1)^2 + F(n)^2.
     * <p>
     * 时间复杂度O(log n)
     * 空间复杂度O(1)
     */
    public BigInteger fastFibonacciDoubling(int n) {
        // F(n)
        BigInteger a = BigInteger.ZERO;
        // F(n+1)
        BigInteger b = BigInteger.ONE;
        for (int bit = Integer.highestOneBit(n); bit != 0; bit >>>= 1) {
            // Double it
            // F(2n) = F(n) * (2*F(n+1) - F(n))
            BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
            // F(2n+1) = F(n+1)^2 + F(n)^2
            BigInteger e = multiply(a, a).add(multiply(b, b));
            a = d;
            b = e;

            // Advance by one conditionally
            if ((n & bit) != 0) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
            }
        }
        return a;
    }

    private BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }
}
