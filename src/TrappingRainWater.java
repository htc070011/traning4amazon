import org.junit.Test;

public class TrappingRainWater {

    @Test
    public void test() {
        int[] arry = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ret = trap(arry);
        System.out.println(ret);
    }
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int l = 0, r = height.length - 1;
        int ret = 0;
        while(l < r) {
            if(leftMax > rightMax) {
                rightMax = Math.max(rightMax, height[r]);
                ret += rightMax;
                r--;
            } else {
                ret += leftMax;
                leftMax = Math.max(leftMax, height[l]);
                l++;
            }
        }
        return ret;
    }
}
