package com.shenxu.zuul.desgin.factory;

/**
 * @author shen_xu
 * @date 2021/8/9 10:30 下午
 */
public class OperationFactory {
    public static Operation getOperation(String operate, Integer numA, Integer numB){
        Operation operation = null;
        switch (operate){
            case "+" :
                operation = new OperationAdd(numA, numB);
                break;
            case "-" :
                operation = new OperationSub(numA, numB);
                break;
            case "*" :
                operation = new OperationMul(numA, numB);
                break;
            case "/" :
                operation = new OperationDiv(numA, numB);
                break;
        }
        return operation;
    }
}
