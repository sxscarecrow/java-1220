package com.shenxu.zuul.desgin.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 减法实现类
 * @author shen_xu
 * @date 2021/8/9 10:22 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationSub implements Operation{

    private Integer numA;
    private Integer numB;

    @Override
    public int getResult(){
        return numA - numB;
    }
}
