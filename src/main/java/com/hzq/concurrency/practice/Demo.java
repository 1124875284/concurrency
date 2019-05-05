package com.hzq.concurrency.practice;

import org.junit.Test;

import java.util.Arrays;

public class Demo {
    /**
     * 输入1234  输出4321
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long a = 0;
        int b =0;
        if(x>=0){
            b=(x+"").length();//正数
        }
        else{
            b=(x+"").length()-1;//负数有一个负号
        }
        while (x!=0){
            for(int i=0;i<b;i++){
                int a1 = x%10;//当前最后一位数字 ，负数则显示的是负数-25%10 等于 -5
                x=(x-a1)/10;//把最后一位数字剔除掉的新数字
                a += (int) (a1*Math.pow(10,b-i-1));  //相当于将每次的最后一位乘以当前位在十进制中的权重。234 = 2*10^2+3*10^1+4*10^0
            }
        }
        if((a>Math.pow(2,31)-1)||(a<(-1)*Math.pow(2,31))){  //超过范围的返回0
            return 0;
        }
        return (int) a;
    }

//    public static void main(String[] args) {
//        int reverse = reverse(123456789);
//        System.out.println(reverse);
//    }

    /**
     * 快速排序
     */


    public static void quickSort(int[] arr, int low, int high){
        if(arr.length <= 0) return;
        if(low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];   //挖坑1：保存基准的值
        while (left < right){
            while(left < right && arr[right] >= temp){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;   //基准值填补到坑3中，准备分治递归快排
        System.out.println("Sorting: " + Arrays.toString(arr));
        quickSort(arr, low, left-1);
        quickSort(arr, left+1, high);
    }
    public static void main(String[] args) {
        int[] arr={1,321,231,23123,3523,44,33,221,5555,3};
        quickSort(arr,0,arr.length-1);
    }
}
