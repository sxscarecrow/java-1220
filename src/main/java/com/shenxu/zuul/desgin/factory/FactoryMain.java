package com.shenxu.zuul.desgin.factory;

/**
 * @author shen_xu
 * @date 2021/8/9 10:43 下午
 */
public class FactoryMain {
    public static void main(String[] args) {
        int numA = 8;
        int numB = 4;

        Operation operation = OperationFactory.getOperation("+", numA, numB);
        int result = operation.getResult();
        System.out.println("result = " + result);
    }
}
