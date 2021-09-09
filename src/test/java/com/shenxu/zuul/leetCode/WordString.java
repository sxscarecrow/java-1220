package com.shenxu.zuul.leetCode;

import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * @author shen_xu
 * @date 2021/6/9 1:26 上午
 *
 * 求一个字符串的所有字串
 */
public class WordString {
    public static void main(String[] args) {
        String str = "abcdef";
        StringBuilder res;
        for (int i = 0; i <= str.length(); i++){
            for (int j = i; j <= str.length(); j++){
                res = new StringBuilder();
                for (int k = i; k < j; k++){
                    res.append(str.charAt(k));
                }
                if (StringUtils.isBlank(res.toString())){
                    continue;
                }
                System.out.println(res);
            }
        }
    }
}
