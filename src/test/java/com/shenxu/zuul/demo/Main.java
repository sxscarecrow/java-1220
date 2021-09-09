package com.shenxu.zuul.demo;


import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int absentNum = 0;
            int lateAndLeaveearlyNum = 0;
            int late = 0;

            String[] str = new String[100];

            int ii = 0;
            while (sc.hasNext()){
                if (sc.next() != " "){
                    str[ii] = sc.next();
                }
                ii++;

            }

//            String[] str = line.split(" ");
            // 判断几次
            for (int j = 0; j < str.length; j++) {
                if (str.length < 7){
                    // 缺勤
                    if ("absent".equals(str[j])){
                        absentNum++;
                    }
                    // 迟到 或早退
                    if ("late".equals(str[j]) || "leaveearly".equals(str[j])){
                        if (j < str.length - 1){
                            if (str[j].equals(str[j + 1])){
                                lateAndLeaveearlyNum++;
                            }
                        }
                    }
                }else{
                    if ("absent".equals(str[j]) || "late".equals(str[j]) || "leaveearly".equals(str[j])){
                        late++;
                    }
                }
            }

            System.out.println(str.length);

            if ((absentNum < 1 || lateAndLeaveearlyNum == 0) && str.length < 7){
                System.out.print(true + " ");
            }else if (late < 3 && str.length >= 7){
                System.out.print(true + " ");
            }else {
                System.out.print(false + " ");
            }
        }
    }
}
