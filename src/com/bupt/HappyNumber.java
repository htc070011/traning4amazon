package com.bupt;

import org.junit.Test;

public class HappyNumber {

    public boolean isHappy(int n) {

        int ret = 0, slow = n, fast = n;
        while(fast != slow) {
            slow = calculate(slow);
            fast = calculate(calculate(fast));
            if(slow == 1 || fast == 1)
                return true;
        }
        return false;
    }
    private int calculate(int n) {
        int ret = 0;
        while(n > 0) {
            int m = n % 10;
            ret += m * m;
            n /= 10;
        }
        return ret;
    }
    @Test
    public void test() {
        int n = 2;
        boolean res = isHappy(n);
        System.out.println(res);
    }

}
