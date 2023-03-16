/*Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину 
*подмассива, который появляется в обоих массивах.

*Example 1:
*Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
*Output: 3
*Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].

*Example 2:
*Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
*Output: 5
*Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
    

public class task {
    public static void main(String[] args) {

        int[] nums1 = new int[] {1, 3, 2, 1, 7};
        int[] nums2 = new int[] {3, 2, 1, 4, 7};
        System.out.println(Array.findEqualsArr(nums1, nums2));

        /*int[] nums1 = new int[] {0, 0, 0, 0, 0};
        int[] nums2 = new int[] {0, 0, 0, 0, 0};
        System.out.println(Array.findEqualsArr(nums1, nums2));
        */
    }
}

abstract class Array {

    private static final int MinLengthArr = 2;

    public static String findEqualsArr(int[] arrayOne, int[] arrayTwo) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;


        for (int startIndex = 0; startIndex <= arrayOne.length; startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= arrayOne.length; endIndex++) {
                int[] tempArray = Arrays.copyOfRange(arrayOne, startIndex, endIndex);
                if (tempArray.length >= MinLengthArr && counter < tempArray.length && isContains(tempArray, arrayTwo)) {
                    result.clear();
                    for (int item : tempArray) result.add(item);
                    counter = tempArray.length;
                }
            }
        }

        if (result.size() < MinLengthArr) {
            return "Нет повторений";
        } else {
            return "Повторяющийся подмассив с максимальной длиной равен " + result;
        }
    }

    private static boolean isContains(int[] arrayOne, int[] arrayTwo) {
        for (int startIndex = 0; startIndex <= arrayTwo.length; startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= arrayTwo.length; endIndex++) {
                int[] tmp = Arrays.copyOfRange(arrayTwo, startIndex, endIndex);
                if (arrayOne.length == tmp.length && Arrays.equals(arrayOne, tmp)) {
                    return true;
                }
            }
        }
        return false;
    }
}
