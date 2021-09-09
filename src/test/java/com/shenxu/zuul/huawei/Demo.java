package com.shenxu.zuul.huawei;

import java.util.*;


public class Demo {
    public static void main(String[] args) {

        System.out.println((char) ('A' + 32));
        System.exit(0);

//        demo1(5,12);
//        demo1(33,11);
//
//        demo2("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
//
//        demo3(1000);
//
//        demo4(5);
//
//        demo6(6);

//        demo7("add123#$%#%#O");
//        demo7();

        demo5("abcde", "ace");

        demo8(5);
        demo10(2);
    }

    /**
     * 最小公倍数
     * 1.找到最大公约数
     * 2.求最小公倍数 a * b / 最大公约数
     */
    private static void demo1(int a, int b){
        int res = 1;
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0){
                res = i;
                break;
            }
        }
        System.out.println("最小公倍数为 = " + (a * b) / res);
    }

    /**
     * 最长回文字串
     */
    private static void demo2(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }else {
                map.put(str.charAt(i), 1);
            }
        }

        int res = 0;
        int num = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() - 1 > 0){
                res += entry.getValue() / 2 * 2;
            }
        }
        System.out.println("最长回文字串 = " + (res + 1));
    }

    /**
     * 完全数计算
     * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
     * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
     * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。s
     * 输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
     * 本题输入含有多组样例
     */
    private static void demo3(int n){
       int res = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j > 0 ; j--) {
                if (i % j == 0){
                    if (i != j){
                        sum += j;
                    }
                }
            }
            if (sum == i){
                res++;
            }
        }
        System.out.println("完全数的个数为 = " + res);
    }

    /**
     * 求 二进制中1的个数
     */
    private static void demo4(int n){
        int res = 0;
        while (n > 0){
            if ((n & 1) == 1){
                res++;
            }
            n >>= 1;
        }
        System.out.println("二进制中1的个数 = " + res);
    }

    /**
     * 两个字符串的最长公共字串
     * 这次要使用二维数组动态规划 目前来看真心做不出来
     */
    private static void demo5(String str1, String str2){
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            char c1 = str1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                if (c1 == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println("max = " + dp[m][n]);

    }

    /**
     * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     * 例如：
     * 1^3=1
     * 2^3=3+5
     * 3^3=7+9+11
     * 4^3=13+15+17+19
     * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
     */
    private static void demo6(int a){
        if (a == 1){
            System.out.println("对应的字符串为 = " + a);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int n = a * a - (a - 1);
        stringBuilder.append(n)
                .append("+");
        for (int i = 1; i < a; i++) {
            stringBuilder.append(n + 2 * i)
                    .append("+");
        }
        System.out.println("stringBuilder = " + stringBuilder.substring(0, stringBuilder.length()-1));
    }

    /**
     * 统计大写字母的个数
     */
    private static void demo7(){

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String a = scanner.nextLine();
            int res = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z'){
                    res++;
                }
            }
            System.out.println("大写字母的个数为 = " + res);
        }
    }

    /**
     * 求最大连续byte 1 的个数
     */
    private static void demo8(int a){
        int res = 0;
        int max = 0;
        while (a > 0){
            if ((a&1) == 1){
                res++;
            }else {
                res = 0;
            }

            max = Math.max(max, res);

            a >>= 1;
        }
        System.out.println("求最大连续byte 1 的个数 = " + max);
    }

    /**
     * 密码强度
     * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。

     * 二、字母:
     * 0 分: 没有字母
     * 10 分: 全都是小（大）写字母
     * 20 分: 大小写混合字母
     * 三、数字:
     * 0 分: 没有数字
     * 10 分: 1 个数字
     * 20 分: 大于1 个数字
     * 四、符号:
     * 0 分: 没有符号
     * 10 分: 1 个符号
     * 25 分: 大于1 个符号
     * 五、奖励:
     * 2 分: 字母和数字
     * 3 分: 字母、数字和符号
     * 5 分: 大小写字母、数字和符号
     * 最后的评分标准:
     * >= 90: 非常安全
     * >= 80: 安全（Secure）
     * >= 70: 非常强
     * >= 60: 强（Strong）
     * >= 50: 一般（Average）
     * >= 25: 弱（Weak）
     * >= 0:  非常弱
     * 对应输出为：
     * VERY_SECURE
     * SECURE,
     * VERY_STRONG,
     * STRONG,
     * AVERAGE,
     * WEAK,
     * VERY_WEAK,
     * 请根据输入的密码字符串，进行安全评定。
     * 注：
     * 字母：a-z, A-Z
     * 数字：-9
     * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
     * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
     * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
     * [\]^_`              (ASCII码：x5B~0x60)
     * {|}~                (ASCII码：x7B~0x7E)
     */
//    private static void demo9(){
//        public String GetPwdSecurityLevel(String pPasswordStr)
//        {
//            int score = 0;
//
//            boolean number = false;
//            boolean upper = false;
//            boolean lower = false;
//            boolean symbol = false;
//            boolean numberOnce = true;
//            boolean symbolOnce = true;
//
//            if (pPasswordStr.length() <= 4) {
//                score += 5;
//            }
//
//            else if (pPasswordStr.length() <= 7) {
//                score += 10;
//            }
//            else {
//                score += 25;
//            }
//
//            for (char ch : pPasswordStr.toCharArray()) {
//                if (ch >= '0' && ch <= '9') {
//                    if (number && numberOnce) {
//                        score += 20;
//                        numberOnce = false;
//                    }
//                    number = true;
//                }
//                else if (ch >= 'a' && ch <= 'z') {
//                    lower = true;
//                }
//                else if (ch >= 'A' && ch <= 'Z') {
//                    upper = true;
//                }
//                else if (
//                        ch >= 0x21 && ch <= 0x2F ||
//                                ch >= 0x3A && ch <= 0x40 ||
//                                ch >= 0x5B && ch <= 0x60 ||
//                                ch >= 0x7B && ch <= 0x7E)
//                {
//                    if (symbol && symbolOnce) {
//                        score += 25;
//                        symbolOnce = false;
//                    }
//                    symbol = true;
//                }
//
//            }
//
//            if (number && numberOnce) {
//                score += 10;
//            }
//            if (symbol && symbolOnce) {
//                score += 10;
//            }
//            if (lower && upper) {
//                score += 20;
//            }
//            else if (lower || upper) {
//                score += 10;
//            }
//            if (lower && upper && number && symbol) {
//                score += 5;
//            }
//            else if ((lower || upper) && number && symbol) {
//                score += 3;
//            }
//            else if ((lower || upper) && number) {
//                score += 2;
//            }
//
//            if (score >= 90) {
//                return "VERY_SECURE";
//            }
//            else if (score >= 80) {
//                return "SECURE";
//            }
//            else if (score >= 70) {
//                return "VERY_STRONG";
//            }
//            else if (score >= 60) {
//                return "STRONG";
//            }
//            else if (score >= 50) {
//                return "AVERAGE";
//            }
//            else if (score >= 25) {
//                return "WEAK";
//            }
//            else {
//                return "VERY_WEAK";
//            }
//        }
//
//    public Main()
//        {
//            Scanner in = new Scanner(System.in);
//            while (in.hasNextLine())
//            {
//                String pPasswordStr = in.nextLine();
//                String safelevel = GetPwdSecurityLevel(pPasswordStr);
//                System.out.println(safelevel);
//            }
//        }
//
//        public static void main(String[] args)
//        {
//            Main solution = new Main();
//        }
//    }

    /**
     * 一、密码长度:
     * 5 分: 小于等于4 个字符
     * 10 分: 5 到7 字符
     * 25 分: 大于等于8 个字符
     */
    private int length(String str){
        int score = 0;
        if (str.length() <= 4){
            score = 5;
        }
        if (str.length() >=5 && str.length() <= 7){
            score = 10;
        }
        if (str.length() >= 8){
            score = 25;
        }
        return score;
    }

    /**
     * 功能:等差数列 2，5，8，11，14。。。。
     * 输入:正整数N >0
     * 输出:求等差数列前N项和
     * 本题为多组输入，请使用while(cin>>)等形式读取数据
     */
    private static void demo10(int a){
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += (2 + i * 3);
        }
        System.out.println("sum = " + sum);
    }



    /**
     * 求近似值
     */
    private static void demo11(Double a){
        Scanner in = new Scanner(System.in);

        double u = 0.8;
        int aa = (int)u;
    }

    /**
     * 数字颠倒
     */
    private static void demo12(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            a = in.nextInt();
        }
        String b = String.valueOf(a);
        StringBuilder res = new StringBuilder();
        for(int i = b.length() - 1; i >= 0; i--){
            res.append(b.charAt(i));
        }
        System.out.println(res);
    }

    /**
     * 字符串反转
     */
    private static void demo13(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.next();
        char[] res = str.toCharArray();
        for(int i = res.length - 1; i >= 0; i--){
            System.out.print(res[i]);
        }
        System.out.println();
    }

    /**
     * 汽水瓶
     */
    private static void demo14(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if(a == 0){
                System.exit(0);
            }
            System.out.println(a / 2);
        }
    }

    /**
     * 统计某个月兔子的总数
     */
    private static void demo15(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int n = 0, m = 1, sum = 0;
            while(a > 0){
                sum = n + m;
                n = m;
                m = sum;
                a--;
            }
            System.out.println(n);
        }
    }

    /**
     * 四则运算
     */
    private static void demo16(){
//        import java.util.*;
//// 第一步，先考虑无括号的情况，先乘除后加减，这个用栈很容易解决，遇到数字先压栈，如果下一个是乘号或除号，先出栈，和下一个数进行乘除运算，再入栈，
//// 最后就能保证栈内所有数字都是加数，最后对所有加数求和即可。
//// 第二步，遇到左括号，直接递归执行第一步即可，最后检测到右括号，返回括号内的计算结果，退出函数，这个结果作为一个加数，返回上一层入栈。
//
//        public class Main{
//            public static void  main(String[] args){
//                Scanner scanner = new Scanner(System.in);
//                while(scanner.hasNext()){
//                    String s =scanner.nextLine();
//                    int pos = 0;
//                    System.out.println(getInnerResult(s));
//
//
//                }
//            }
//            static int pos;
//            //递归，消消乐，算括号里面的(无括号的)数字的结果
//            public static int getInnerResult(String s){
//                Stack<Integer> val = new Stack<>();
//                int num = 0;
//                char opt = '+';
//                while(pos < s.length()){
//                    //遇到括号，开始递归 ，从括号里面开始算，消消乐
//                    if(s.charAt(pos) == '{' || s.charAt(pos) == '[' || s.charAt(pos) == '('){
//                        pos ++;
//                        num = getInnerResult(s);
//                    }
//
//                    //得到数字num
//                    while(pos < s.length() && Character.isDigit(s.charAt(pos))){
//                        //这步操作是 num是几位就得到几位的num。
//                        num = num * 10 + s.charAt(pos) - '0';
//                        pos ++;
//                    }
//
//                    //按照题目意思，正常合法的表达式字符串的话，数字后面一定会是跟运算符。
//                    //所以这里判断运算符
//                    //这一步的终极目的是把栈里面全部变成+ 号的运算，
//                    switch (opt){
//                        case '+':
//                            val.push(num);
//                            break;
//                        //- 号的时候变成负数
//                        case '-':
//                            val.push(-num);
//                            break;
//                        //乘号的时候出栈先做乘法运算后把得到的结果 再入栈
//                        case '*':
//                            val.push(val.pop()*num);
//                            break;
//                        //同上面的乘号
//                        case '/':
//                            val.push(val.pop()/num);
//                            break;
//                    }
//                    num =0;
//                    if(pos < s.length()){
//                        //数字后面有可能是运算符或者括号
//                        //如果下面没有被break，这里opt是取得的下一个运算符
//                        opt = s.charAt(pos);
//                        //如果这里是括号，就break，那么opt的值会在一开始被初始化成+
//                        if(s.charAt(pos) == '}' || s.charAt(pos) == ']' || s.charAt(pos) == ')'){
//                            pos ++;
//                            break;
//                        }
//                    }
//                    pos ++;
//                }
//                int sum = 0;
//                while(!val.empty()){
//                    sum += val.pop();
//                }
//                return sum;
//            }
//        }
    }

    /**
     * 杨辉三角变形
     */
    private static void demo17(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            if(num == 1 || num == 2){
                System.out.println(-1);
            }else if(num % 4 == 0){
                System.out.println(3);
            }else if(num % 4 == 1 || num % 4 == 3){
                System.out.println(2);
            }else{
                System.out.println(4);
            }
        }
    }

    /**
     * 放苹果
     */
    private static void demo18(){
        // 计算放苹果方法的数目
//        private int count(int m, int n) {
//            // 没有苹果或者只剩一个盘子
//            if (m == 0 || n == 1) return 1;
//            // 盘子大于苹果， 则不考虑多出来的盘子
//            if (n > m) return count(m, m);
//            return count(m, n-1) + count(m - n, n);
//        }
//
//    public Main() {
//            Scanner in = new Scanner(System.in);
//            while (in.hasNextInt()) {
//                int m = in.nextInt();
//                int n = in.nextInt();
//                int result = -1;
//                if (n >= 1 && n <= 10 && m >= 1 && m <= 10) {
//                    result = count(m, n);
//                }
//                System.out.println(result);
//            }
//        }
//
//        public static void main(String[] args)
//        {
//            Main solution = new Main();
//        }
    }

    /**
     * 百钱买百鸡的问题
     */
    private static void demo19(){
        for(int x = 0; x<= 20 ; x ++){
            for(int y = 0; y<= 33; y++){
                int z = 100-x-y;
                if(z%3==0 && 5*x+3*y+z/3 ==100 && x+y+z == 100){
                    System.out.println(x+" "+y+" "+z+" ");
                }
            }
        }
    }

    /**
     * 计算日期到天数的转换
     */
    private static void demo20(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int[] month_day = {31,28,31,30,31,30,31,31,30,31,30,31};
            int sum = 0;
            for(int i = 0; i < month - 1; i++){
                sum += month_day[i];
            }
            sum += day;
            if(month > 2 && is_leap(year)){
                sum += 1;
            }
            System.out.println(sum);
        }
    }

    private static boolean is_leap(int n){
        if(n % 4 == 0 && n % 100 != 0 || n % 400 == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 最长回文字串
     */
    private static int demo21(String  a){
        char[] chararr = a.toCharArray();
        int len=chararr.length;
        if(len<2) return len;
        int start=0;
        int end=0;
        int maxLen=0;
        boolean[][] dp=new boolean[len][len];
        /*这部分可不要
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }*/
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(chararr[i]==chararr[j]){
                    if(j-i<3) dp[i][j]=true;
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if(dp[i][j]){
                        if(j-i+1>maxLen){
                            maxLen=j-i+1;
                            start=i;
                            end=j;
                        }
                    }
                }
            }//for j end
        }//for i end

        return maxLen;
    }

    /**
     * 走方格的方案
     */
    private static void demo21(){
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            while(sc.hasNext()){
//                int num1= sc.nextInt();
//                int num2= sc.nextInt();
//                System.out.println(methods(num1,num2));
//            }
//        }
//
//        public static  int methods(int num1,int num2){
//            if(num1 == 0 ||num2 == 0){
//                return 1;
//            }
//            return methods(num1-1,num2)+methods(num1,num2-1);
//        }
    }

    /**
     * 字符逆袭
     */
    private static void demo22(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            System.out.println(new StringBuilder(a).reverse());
        }
    }

    /**
     * 最小公倍数
     */
    private static void demo23(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a=0, b=0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            a = in.nextInt();
            b = in.nextInt();
        }
        int res = 1;
        for(int i = Math.min(a, b); i > 1; i--){
            if(a % i == 0 && b % i == 0){
                res = i;
                break;
            }
        }
        System.out.println(a * b / res);
    }

    /**
     * 二维数组的操作
     */
    private static void demo24(){

    }

    /**
     * 十六进质转10jinzhi
     */
    private static void demo25(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String str = scanner.nextLine();
            System.out.println(Integer.valueOf(str.substring(2),16).toString());
        }
    }

    /**
     * 十进制转十六禁止
     */
    private static void demo26(int n){
        StringBuffer s = new StringBuffer();
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            s = s.append(b[n%16]);
            n = n/16;
        }
        a = s.reverse().toString();
    }

    /**
     * 质数因子
     */
    private static void demo27(){
//        public static void main(String[] args){
//            Scanner scan = new Scanner(System.in);
//            long num = Long.parseLong(scan.next());
//            getPrimer(num);
//        }
//
//        public static void getPrimer(long num){
//            for (int i= 2;i <= num; i++){
//                if (num % i==0){
//                    System.out.print(i + " ");
//                    getPrimer(num/i);
//                    break;
//                }
//                if (i==num){
//                    System.out.print( i + "");
//                }
//            }
//        }
    }

    /**
     * 合并表记录
     */
    private static void demo28(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int next = sc.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for (int i = 0; i < next; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else {
                    map.put(key,value);
                }
            }
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                System.out.println(integerIntegerEntry.getKey()+" "+integerIntegerEntry.getValue());
            }
        }
    }

    /**
     * 提取不重复的整数
     */
    private static void demo29(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        char[] chars= (num+"").toCharArray();
        String str ="";
        for(int i= chars.length-1; i>= 0;i--){
            if(!str.contains(chars[i]+"")){
                str +=chars[i];
            }
        }
        System.out.println(Integer.valueOf(str));
    }

    /**
     * 字符串排序
     */
    private static void demo30(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String [] arr = new String[n];
            for(int i=0;i<n;i++){
                String str = sc.next();
                arr[i] = str;
            }
            Arrays.sort(arr);
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);
            }
        }
    }

    /**
     * 密码转换
     */
    private static void demo31(){
//        import java.util.*;
//        public class Main{
//            public static void main(String[] arg){
//                HashMap<String,Integer> map=new HashMap<>();
//                map.put("abc",2);
//                map.put("def",3);
//                map.put("ghi",4);
//                map.put("jkl",5);
//                map.put("mno",6);
//                map.put("pqrs",7);
//                map.put("tuv",8);
//                map.put("wxyz",9);
//                Scanner sc=new Scanner(System.in);
//                String line=sc.next();
//                for(char c:line.toCharArray()){
//                    if(c>='A'&&c<='Z'){
//                        if((c+32)=='z'){
//                            System.out.print('a');
//                        }else{
//                            System.out.print((char)(c+33));
//                        }
//                    }else if(c>='a'&&c<='z'){
//                        final Character cF=c;
//                        String key= map.keySet().stream().filter(o->o.contains(cF.toString())).findAny().get();
//                        System.out.print(map.get(key));
//                    }else{
//                        System.out.print(c);
//                    }
//                }
//            }
//        }

    }

    /**
     * 字符串排序
     */
    private static void demo32(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(Character.isLetter(c)){
                    sb.append(c);
                }
            }
            //冒泡排序
            char[] cs = sb.toString().toCharArray();
            for(int i = 0; i < cs.length; i++){
                for(int j = 0; j < cs.length - i - 1; j++){
                    if(Character.toLowerCase(cs[j]) - Character.toLowerCase(cs[j + 1]) > 0){
                        char temp = cs[j];
                        cs[j] = cs[j + 1];
                        cs[j + 1] = temp;
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            int index = 0;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(Character.isLetter(c)){
                    result.append(cs[index]);
                    index++;
                }else{
                    result.append(c);
                }
            }

            System.out.println(result.toString());
        }
    }

    /**
     * 图片整理
     */
    private static void demo33(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str= scanner.nextLine();
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            for(char c :chars ){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    /**
     * 蛇形矩阵
     */
    private static void demo34() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            StringBuffer str = new StringBuffer();
            int a = 1;
            int b = 0;
            for (int i = 0; i < n; i++) {
                a = a + i;
                b = a;
                for (int j = 0; j < n - i; j++) {
                    str.append(b + " ");
                    b = b + j + i + 2;
                }
                System.out.println(str.toString().trim());
                str = new StringBuffer();
            }
        }
    }

    /**
     * 字符串加密
     */
    private static void demo35(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine().toUpperCase();
            String s2 = sc.nextLine();
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            LinkedHashSet<Character> set = new LinkedHashSet();
            for (int i = 0; i < chars1.length; i++) {
                set.add(chars1[i]);
            }
            int k = 0;
            while (set.size() < 26) {
                char a = (char) ('A' + k);
                set.add(a);
                k++;
            }
            ArrayList<Character> list = new ArrayList<>(set);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < chars2.length; i++) {
                if (chars2[i] == ' ') {
                    sb.append(chars2[i]);
                } else if (chars2[i] < 'a') {
                    int n = (int) (chars2[i] - 'A');
                    char c = list.get(n);
                    sb.append(c);
                } else {
                    int n = (int) (chars2[i] - 'a');
                    char c = (char)(list.get(n)+'a'-'A');
                    sb.append(c);
                }

            }

            System.out.println(sb.toString());
        }
    }

    /**
     * 小球落地弹落的高度
     */
    private static void demo36(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            double sum = 0;
            double temp = n;
            for(int i = 0; i < 5; i++){
                sum += temp * 2;
                temp = temp / 2;
            }
            //第一次按它先弹上来再掉下去算的，要减掉第一次弹上来的路程
            sum -= n;
            System.out.printf("%.6f\n",sum);
            System.out.printf("%.6f\n",temp);
        }
    }

    /**
     * 统计字符
     */
    private static void demo37() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int isLetter = 0, isDigit = 0, isWhitespace = 0, isQt = 0;
            char[] str = sc.nextLine().toCharArray();
            for (int i = 0; i < str.length; i++) {
                char a = str[i];
                if (Character.isLetter(a))
                    isLetter++;
                else if (Character.isDigit(a))
                    isDigit++;
                else if (Character.isWhitespace(a))
                    isWhitespace++;
                else isQt++;
            }
            System.out.println(isLetter);
            System.out.println(isWhitespace);
            System.out.println(isDigit);
            System.out.println(isQt);
        }
    }

    /**
     * 名字的漂亮度
     */
    private static void demo38(){
//        import java.util.*;
//
//        public class Main {
//
//            private final int N = 26;
//
//            public Main() {
//            }
//
//            public int count(String name) {
//                int[] arr = new int[N];
//                for (int i = 0; i < name.length(); i++) {
//                    char ch = name.charAt(i);
//                    arr[ch - 'a']++;
//                }
//                Arrays.sort(arr);
//                int result = 0;
//                for (int weight = N, i = N - 1; i >= 0; i--) {
//                    if (arr[i] != 0) {
//                        result += weight * arr[i];
//                        weight--;
//                    }
//                }
//                return result;
//            }
//
//            public static void main(String[] args)
//            {
//                Main solution = new Main();
//                Scanner in = new Scanner(System.in);
//                while (in.hasNextLine()) {
//                    int n = Integer.parseInt(in.nextLine());
//                    for (int i = 0; i < n; i++) {
//                        String name = in.nextLine().toLowerCase();
//                        int result = solution.count(name);
//                        System.out.println(result);
//                    }
//                }
//            }
//        }
    }

    /**
     * 截取字符串
     */
    private static void demo39(){
//        import java.util.*;
//        public class Main{
//            public static void main(String[] args){
//                Scanner sc=new Scanner(System.in);
//                while(sc.hasNext()){
//                    String str=sc.next();
//                    int n=sc.nextInt();
//                    char[] ch=str.toCharArray();
//                    int i=0;  //保存应该生成的子串的索引位置
//                    int count=0;
//                    for(int j=0;j<ch.length;j++){
//                        if(ch[j]>128){
//                            //说明是汉字
//                            count+=2;  //每一个汉字占两个字符
//                            if(count<n){
//                                //如果该汉字加入后，任然不会超过所输出的字符个数，那么可以接着输出
//                                i++;
//                            }
//                        }
//                        else{
//                            //说明是普通字符
//                            count++;
//                            if(count<=n){
//                                i++;
//                            }
//                        }
//                    }
//                    System.out.println(str.substring(0,i));
//                }
//            }
//        }
    }

}
