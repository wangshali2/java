package day20;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wsl
 * @Date 2021-11-16
 * @Description
 * @Version 1.0
 */
public class 青蛙 {

    static Map<Integer, Integer> map = new HashMap();

    public static void main(String[] args) {

        System.out.println(solve(5));
        System.out.println(f1(6));
        System.out.println(f2(6));
    }

    public static int solve(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return solve(n - 1) + solve(n - 2);
        }
    }

    //⽤⼀个HashMap来保存已经计算过的状态 <n,f(n)>
    public static int solve2(int n) {
        if (n <= 2) {
            return 1;
        } else {//是否计算过
            if (map.containsKey(n)) {
                return map.get(n);
            } else {
                int m = solve(n - 1) + solve(n - 2);
                map.put(n, m);
                return m;
            }
        }
    }

    //斐波那契数列 1 1 2 3 5 8 13
    public static int f1(int n) {
        if (n < 1) {
            return 0;
        } else if (n <=2) {
            return 1;
        }

        return f1(n - 1) + f1(n - 2);
    }


    public static int f2(int n) {
        if (n <= 1) {
            return 1;
        }

        int f1 = 0;
        int f2 = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}
