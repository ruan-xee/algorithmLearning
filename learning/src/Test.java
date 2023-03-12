import common.SingleNode;
import day05.TreeNode;
import common.Utils;
import day01.BinarySearch;
import day01.SelectSort;
import day01.XorOperation;
import day02.SmallSum;
import day03.RadixSort;
import day04.IsPalindromeList;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        TreeNodeTest();

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
        int testTime = 200;    //比较次数
        int maxSize = 10;       //最大数组长度
        int maxValue = 100;     //最大值
        int minValue = 0;       //最小值
        boolean succeed = true; //对比成功标志

        for (int i = 0; i < testTime; i++) {
            //得到两个相同长度、相同数值内容的数组
            int[] arr1 = Utils.generateRandomArray(maxSize, maxValue, minValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            //调用方法一（待测方法）
            RadixSort.radixSort(arr1);
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

    public static void BinaryQues1Test(){
        int[] arr = new int[]{1,3,4,5,12,24,56};
        int[] arr2 = new int[]{2,1,2};
        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{};
        int[] arr5 = new int[]{1,2,3};
        int[] arr6 = new int[]{10,9,7,6,5,4,3,3};

        System.out.println(BinarySearch.binarySearch(arr, 24));
        System.out.println(BinarySearch.binarySearch(arr2, 3));
        System.out.println(BinarySearch.binarySearch(arr3, 3));
        System.out.println(BinarySearch.binarySearch(arr4, 3));
        System.out.println(BinarySearch.binarySearch(arr5, 3));


//        System.out.println(BinarySearch.binarySearchLeft(arr, 2));
//        System.out.println(BinarySearch.binarySearchLeft(arr2, 3));
//        System.out.println(BinarySearch.binarySearchLeft(arr3, 3));
//        System.out.println(BinarySearch.binarySearchLeft(arr4, 1));
//        System.out.println(BinarySearch.binarySearchLeft(arr5, 2));

//        System.out.println(BinarySearch.binaryFindPartMin(arr));
//        System.out.println(BinarySearch.binaryFindPartMin(arr2));
//        System.out.println(BinarySearch.binaryFindPartMin(arr3));
//        System.out.println(BinarySearch.binaryFindPartMin(arr4));
//        System.out.println(BinarySearch.binaryFindPartMin(arr5));
//        System.out.println(BinarySearch.binaryFindPartMin(arr6));


    }

    public static void smallSumTest(){
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(SmallSum.smallSum(arr));
    }

    public static void singleNodeTest(){
        SingleNode<Integer> node1 = new SingleNode(5);
        SingleNode<Integer> node2 = new SingleNode(2);
        node1.next = node2;
        SingleNode<Integer> node3 = new SingleNode(4);
        node2.next = node3;
        SingleNode<Integer> node4 = new SingleNode(3);
        node3.next = node4;
        SingleNode<Integer> node5 = new SingleNode(4);
        node4.next = node5;
        SingleNode<Integer> node6 = new SingleNode(2);
        node5.next = node6;
        SingleNode<Integer> node7 = new SingleNode(5);
        node6.next = node7;
        SingleNode<Integer> node8 = new SingleNode(5);
        //node7.next = node8;

//        SingleNode<Integer> resHead = SmallerEqualBigger.listPartition(node1, 5);
//        while (resHead != null){
//            System.out.print(resHead.value + " -> ");
//            resHead = resHead.next;
//        }

        System.out.println(IsPalindromeList.isPalindrome3(node1));
    }


    public static void TreeNodeTest(){
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        TreeNode<Integer> node10 = new TreeNode<>(10);
        TreeNode<Integer> node11 = new TreeNode<>(11);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node6.left = node7;
        node3.left = node8;
        node3.right = node9;
        node8.right = node10;
        node10.left = node11;

//        System.out.println("inOrderUnRecur:");
//        TreeNode.inOrderUnRecur(node1);
//        System.out.print("\ninOrderRecur:");
//        TreeNode.inOrderRecur(node1);
//        System.out.print("\npreOrderRecur:");
//        TreeNode.preOrderRecur(node1);
//        System.out.print("\npreOrderUnRecur:");
//        TreeNode.preOrderUnRecur(node1);
//        System.out.print("\nposOrderRecur:");
//        TreeNode.posOrderRecur(node1);
//        System.out.print("\nposOrderUnRecur:");
//        TreeNode.posOrderUnRecur(node1);
        System.out.println(TreeNode.findMaxWidth2(node1));
    }
}
