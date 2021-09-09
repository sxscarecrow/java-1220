package com.shenxu.zuul.demo;

/**
 * @author shen_xu
 * @date 2021/7/18 3:55 下午
 */
public class Main2 {
    public static void main(String[] args) {


        String line = "3 4 256 257 258 259 260 261 262 263 264 265";
        String[] str = line.split(" ");

        int c = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        int num = 0;

        for (int i = 2; i < str.length; i++) {
            int data = 0;

            String s = str(Integer.parseInt(str[i]));

            for (int j = 0; j < s.length(); j++) {
                data += Integer.parseInt(String.valueOf(s.charAt(j)));
            }

            if (data % b == c){
                num++;
            }
        }
        System.out.println(num);
    }

    private static String str(int n){
        StringBuffer s = new StringBuffer();
        String str;
        char []bb = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            s = s.append(bb[n%16]);
            n = n/16;
        }
        str = s.reverse().toString();
        return str;
    }
}
