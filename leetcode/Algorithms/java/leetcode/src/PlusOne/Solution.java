package PlusOne;

import org.junit.Test;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            if (sum / 10 > 0) {
                carry = 1;
            }
            else {
                carry = 0;
            }

            digits[i] = sum % 10;
            sum = 0;
        }

        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for (int i= 1; i < digits.length + 1; i++) {
                res[i] = digits[i - 1];
            }

            return res;
        }

        return digits;
    }

    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    @Test
    public void test() {
        int[] digits = {9, 9, 9};
        int[] res = plusOne1(digits);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
