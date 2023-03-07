package day01;

public class BinarySearch {
    /**
     * 问题一：
     *      查询有序数组中的某个值，不存在返回-1，存在返回该值位置
     */
    public static int binarySearch(int[] arr, int target){
        if(arr == null || arr.length < 1){
            return -1;
        }
        return binary(arr, 0, arr.length-1, target);
    }

    private static int binary(int[] arr, int head, int front, int target){
        int res = -1;
        if (head == front){
            return arr[head] == target ? head : res;
        }
        //int mid = (head + front)/2;
        int mid = head + ((front - head) >> 1);
        if (arr[mid] == target){
            res = mid;
        } else if (arr[mid] < target){
            res = binary(arr, mid+1, front, target);
        } else {
            res = binary(arr, head, mid-1, target);
        }
        return res;
    }

    /**
     * 问题二：
     *      查询有序数组中，>=某个值的最左侧位置
     */
    public static int binarySearchLeft(int[] arr, int target){
        if(arr == null || arr.length < 1){
            return -1;
        }
        return binary2(arr, 0, arr.length-1, target);
    }

    private static int binary2(int[] arr, int head, int front, int target){
        int res = -1;
        if (head == front){
            return arr[front] >= target ? front : res;
        }
        //int mid = (head+front)/2;
        int mid = head + ((front - head) >> 1);
        if (arr[mid] >= target){
            return binary2(arr, head, mid, target);
        } else {
            return binary2(arr, mid+1, front, target);
        }
    }

    /**
     * 问题三：
     *      局部最小值
     *      当某个位置的值arr[i]比它左右位置的值都小时，我们称其为局部最小值
     *      当i=0，arr[i] < arr[i+1]时，称其为局部最小值
     *      当i=n-1，arr[n-1] < arr[n-2]时，称其为局部最小值
     *      找到一个无序数组中的局部最小值位置
     */
    public static int binaryFindPartMin(int[] arr){
        if (arr == null || arr.length < 2){
            return -1;
        }
        //先剔除左右两头的特殊情形
        if (arr[0] < arr[1]){
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        return binary3(arr, 1, arr.length-2);
    }

    private static int binary3(int[] arr, int head, int front){
        if (head > front){
            return -1;
        }
        //int mid = (head+front)/2;     //有溢出风险
        int mid = head + ((front - head) >> 1);
        if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]){
            return binary3(arr, mid+1, front);
        } else if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]){
            return mid;
        }
        if (arr[mid] > arr[mid - 1]){
            return binary3(arr, head, mid-1);
        }
        return -1;
    }
}
