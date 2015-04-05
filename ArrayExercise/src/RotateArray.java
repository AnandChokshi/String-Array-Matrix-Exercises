/*
 * Problem: Rotate an array of n elements to the right by k steps. 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray {

	/*-
	 * {1,2,3,4,5,6} and k = 2, n = 6
	1. Divide the array two parts: 1,2,3,4 and 5, 6
	2. Rotate first part: 4,3,2,1,5,6
	3. Rotate second part: 4,3,2,1,6,5
	4. Rotate the whole array: 5,6,1,2,3,4
	 */
	public static void rotateArray(int[] array, int k) {
		if (array == null || array.length == 1 || k == 0)
			return;

		int order = array.length - k;

		reverseArray(array, 0, order - 1);
		reverseArray(array, order, array.length - 1);
		reverseArray(array, 0, array.length - 1);
	}

	public static void reverseArray(int[] array, int left, int right) {
		int temp;

		while (left < right) {
			temp = array[left];
			array[left] = array[right];
			array[right] = temp;

			left++;
			right--;
		}
	}
}
