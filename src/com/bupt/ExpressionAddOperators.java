package com.bupt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<String>();
        if(num == null || num.length() == 0)
            return ret;
        char[] ch = num.toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append(ch[0]);
        backTracking(ch, target, Integer.parseInt(num.substring(0,1)), 1, ret, sb);
        return ret;
    }

    private void backTracking(char[] ch, int tar, int cur, int start, List<String> ret, StringBuffer sb) {
        if(start == ch.length ) {
            if(cur == tar)
                ret.add(new String(sb.toString()));
            return;
        } else {
            for(int j = 0; j < 3; j++) {
                switch(j) {
                    case 0:
                        cur += ch[start] - '0';
                        sb.append("+").append(ch[start]);
                        backTracking(ch, tar, cur, start + 1, ret, sb);
                        break;
                    case 1:
                        cur -= ch[start] - '0';
                        sb.append("-").append(ch[start]);
                        backTracking(ch, tar, cur, start + 1, ret, sb);
                        break;
                    default:
                        cur *= ch[start] - '0';
                        sb.append("*").append(ch[start]);
                        backTracking(ch, tar, cur, start + 1, ret, sb);
                        break;
                }
                sb.delete(sb.length() - 2, sb.length());
            }
        }
    }
    @Test
    public void test() {
        String number = "123";
        int target = 6;
        List<String> ret = addOperators(number, target);
        System.out.println(ret);

    }
}
