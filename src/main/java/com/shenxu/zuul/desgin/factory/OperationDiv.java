package com.shenxu.zuul.desgin.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shen_xu
 * @date 2021/8/9 10:28 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDiv implements Operation {

    private Integer numA;
    private Integer numB;

    @Override
    public int getResult() {
        if (numB == 0){
            return 0;
        }
        return numA / numB;
    }
}
