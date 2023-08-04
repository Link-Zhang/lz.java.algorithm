package cn.sh.lz.cig.c1p1;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Link at 16:02 on 2022/08/03.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */

/**
 * 问题：设计一个有getMin功能的栈
 */
public class StackWithMin2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public StackWithMin2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int data) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(data);
        } else if (data < this.getMin()) {
            this.stackMin.push(data);
        } else {
            this.stackMin.push(this.getMin());
        }
        this.stackData.push(data);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new EmptyStackException();
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stackMin.peek();
    }

    public void printMin() {
        System.out.println("The Min in Stack is: " + this.getMin() + ".");
    }
}
