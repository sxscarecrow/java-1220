package com.shenxu.zuul.desgin.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 加法实现类
 * @author shen_xu
 * @date 2021/8/9 10:08 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationAdd implements Operation {

    private Integer numA;
    private Integer numB;

    @Override
    public int getResult(){
        return numA + numB;
    }
}
