import jdk.jshell.execution.Util;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HelloGit {
    public static void main(String[] args)throws InterruptedException {
          int[] arr = {4,2,6,8,5,65,7,1,93,4455,17};
        System.out.println(new HelloGit().close3Sum(arr, 15));
//        int[] newArr = new HelloGit().getNewArr(arr);
//        for(int i : newArr){
//            System.out.print(i+"--");
//        }
//        new HelloGit().exrThread();

    }

        // 题一
        public int[] getNewArr(int[] arr){
            if(arr!=null){
                int max = arr[0];
                int min = arr[0];
                int maxIndex = 0;
                int minIndex = 0;
                for(int i =0 ;i<arr.length ;i++){
                    maxIndex = (max > arr[i]) ? maxIndex : i;
                    max = Math.max(max, arr[i]);
                    minIndex = (min < arr[i]) ? minIndex : i;
                    min = Math.min(min, arr[i]);
                }
                int temp = arr[0];
                arr[0] = max;
                arr[maxIndex] = temp;
                temp = arr[arr.length-1];
                arr[arr.length-1]= min;
                arr[minIndex] = temp;
                return arr;

            }
           else {
               return null;
            }
        }

        // 题二
        public void exrThread() throws InterruptedException{
            for(int i=0;i<20;i++){
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName());
                }).start();
                Thread.sleep(300);
            }
        }

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * 返回这三个数的和。
     * 假定每组输入只存在恰好一个解。
     * 示例 1：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     */
    public int close3Sum(int[] num,int target){
        java.util.Arrays.sort(num);
        int res = num[0]+num[1]+num[2];
        for(int i=0;i<num.length-2;i++){
            int l= i+1;
            int r = num.length-1;
            while(l<r){
                if(Math.abs(target-num[i]-num[l]-num[r]) < Math.abs(target-res)){
                    res = num[i]+num[l]+num[r];
                }
                if( num[i]+num[l]+num[r] <target ){
                    l++;
                }else if( num[i]+num[l]+num[r] >target ){
                    r--;
                }else {
                    return res;
                }
            }

        }
        return res;
    }

}

