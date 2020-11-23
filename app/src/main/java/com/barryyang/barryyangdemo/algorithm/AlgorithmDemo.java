package com.barryyang.barryyangdemo.algorithm;

import com.barryyang.barryyangdemo.kotlin.interfaces.A;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author : BarryYang
 * @date : 2020/11/16 9:45 PM
 * @desc :
 */
public class AlgorithmDemo {

    public static void main(String[] args) {
//        test1();
//        test2();
//        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
//        System.out.println(Arrays.toString(ints));
        // reverseList(new ListNode(1, new ListNode(2, null)));
        isValid("(])");
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '{' || currChar == '[' || currChar == '(') {
                stack.push(currChar);
            } else {
                if (stack.size() == 0) return false;
                Character preChar = stack.peek();
                if ((preChar == '{' && currChar == '}')
                        || (preChar == '[' && currChar == ']')
                        || (preChar == '(' && currChar == ')')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newLinkList = head.next;
        while (newLinkList != null) {
            ListNode temp = newLinkList;

        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    /**
     * log(n)
     */
    private static void test2() {
        for (int i = 1; i < 9; i = i * 2) {
            System.out.println("i=" + i);
        }
    }

    /**
     * O(n*n)
     */
    private static void test1() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                System.out.println("i=" + i + ",j=" + j);
            }
        }
    }
}
