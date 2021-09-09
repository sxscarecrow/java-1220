package com.shenxu.zuul.demo;


import java.util.*;

public class Test {
    public static void main(String[] args) {

        g();
        tt();
        List<String> str = new ArrayList<>();
        str.add("abceeeee");
        str.add("abc");
        str.add("abceddddd");
//
//        Collections.sort(str);
//        System.out.println(str.toString());

        StringBuilder res = new StringBuilder();
        boolean flag = true;
        int n = 0, m =0;
        for (int i = 0; i < str.get(0).length(); i++) {
                for (int j = 1; j < str.size(); j++) {
                    if (str.get(j).length()  <= i){
                        flag = false;
                        break;
                    }
                    if (str.get(j).charAt(i) != str.get(0).charAt(i)) {
                        flag = false;
                        break;
                    }
                    n++;
                }
            if (flag){
                res.append(str.get(0).charAt(i));
            }else {
                break;
            }
            m++;
        }
        System.out.println("外层" + m);
        System.out.println("内层" + n);
        System.out.println(res);
    }

    public static void g() {
        double pow = Math.pow(-2, 3);
        System.out.println(pow);
    }

    public double myPow(double x, int n) {
        if(x == 0){
            return 0d;
        }
        if(n == 0){
            return 1d;
        }

        int i;
        if(n > 0){
            double res = x;
            for(i = 0; i < n - 1; i++){
                res *= x;
            }
            return res;
        }else{
            double res = (double)(1/x);
            for(i = 0; i > n + 1; i--){
                res *= (double)(1/x);
            }
            return res;
        }
    }

    public static void tt(){
        int[] data = {1,2,3,4};
        int low = 0, fast = 0, tmp;
        while (data[fast] < data.length){
            if ((data[fast]&1) != 0){
                // 偶数且不等于的时候就交换
                if (low != fast){
                    tmp = data[fast];
                    data[fast] = data[low];
                    data[low] = tmp;
                }
                low++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(data));
    }

}
