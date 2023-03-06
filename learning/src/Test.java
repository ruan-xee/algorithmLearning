import common.Utils;
import day01.PopSort;
import day01.SelectSort;
import day01.XorOperation;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        XorTest();
    }

    /**
     * 对数器
     * 思路：
     *      有一个你待测的方法a，以及一个不计时间成本和空间成本但稳定的方法b
     *      对同一数组（不是同一个地址的数组，是指数组长度、内容值相同的）分别使用两个方法运行
     *      得到的结果进行一一比对，可以验证待测方法的运行结果是否正确
     *
     * 优点：
     *      不用依赖平台OG来验证自己写的方法是否正确
     *      比对次数可以自己定义
     *      每次比对的数组长度、数组内容可以自己定义范围
     *      待发现错误时，可以通过缩小数组长度、数值范围等控制变量来进行debug修正
     */
    public static void comparator(){
        int testTime = 10000;    //比较次数
        int maxSize = 30;       //最大数组长度
        int maxValue = 100;     //最大值
        boolean succeed = true; //对比成功标志

        for (int i = 0; i < testTime; i++) {
            //得到两个相同长度、相同数值内容的数组
            int[] arr1 = Utils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            //调用方法一（待测方法）
            PopSort.popSort(arr1);
            //调用方法二
            SelectSort.selectSort(arr2);

            //比对两个方法结果是否相同
            if (!Arrays.equals(arr1, arr2)){
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "成功！" : "失败！");
    }

    public static void XorTest(){
        int[] arr1 = new int[]{1,1,2,2,3,3,4,5,5,6,6};
        int[] arr2 = new int[]{1,1,2,2,3,4,5,5,6,6,7,7};

        System.out.println(XorOperation.findOneOdd(arr1));

        int[] twoOdd = XorOperation.findTwoOdd(arr2);
        Utils.printArray(twoOdd);
    }
}
