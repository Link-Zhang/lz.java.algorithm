package cn.sh.lz.cig.c4p1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * Created by Link at 13:54 on 2023/08/04.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Matrix {
    private BigInteger a, b, c, d;

    public Matrix multiply(Matrix A, Matrix B) {
        BigInteger newA = A.a.multiply(B.a).add(A.b.multiply(B.c));
        BigInteger newB = A.a.multiply(B.b).add(A.b.multiply(B.d));
        BigInteger newC = A.c.multiply(B.a).add(A.d.multiply(B.c));
        BigInteger newD = A.c.multiply(B.b).add(A.d.multiply(B.d));
        return new Matrix(newA, newB, newC, newD);
    }

    public Matrix power(Matrix m, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        // Identity Matrix
        Matrix result = new Matrix(BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE);
        for (; 0 != n; n >>= 1) {
            if (0 != (n & 1)) {
                result = multiply(result, m);
            }
            m = multiply(m, m);
        }
        return result;
    }

    public void print() {
        System.out.println("===Matrix Print Begin===");
        System.out.printf("[%d %d]\n[%d %d]\n", this.a, this.b, this.c, this.d);
        System.out.println("===Matrix Print End===");
    }

    public void print(Matrix m) {
        System.out.println("===Matrix Print Begin===");
        System.out.printf("[%d %d]\n[%d %d]\n", m.a, m.b, m.c, m.d);
        System.out.println("===Matrix Print End===");
    }
}
