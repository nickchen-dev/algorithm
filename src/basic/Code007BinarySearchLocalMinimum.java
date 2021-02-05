package basic;

import util.Util;

/**
 * in an unsorted array, use binary search to find an index where its value is
 * less than both left value and right value. if 1st or last index, then it only
 * need to be less than right value or left value
 * 
 * @author nick
 *
 */
public class Code007BinarySearchLocalMinimum {

	public static void main(String[] args) {
		int testNum = 1_000_000;
		// generate a random array with various size and value
		int maxSize = 60, maxRange = 500;
		int[] arr;
		int index1, index2;

		long start = Util.getSysTime();
		System.out.println("test start...");
		for (int i = 0; i < testNum; i++) {
			arr = Util.generateRandomArray(maxSize, maxRange);

			index1 = findLocalMinimum(arr);
			index2 = getMinimumIndex(arr);

			if (index1 != index2) {
				System.out.println("test fail...");
				Util.printArray(arr);
				System.out.println("1: " + index1 + " 2: " + index2);
				return;
			}
		}
		long end = Util.getSysTime();
		System.out.println("test pass... time taken " + (end - start) / 1000f);
	}

	private static int findLocalMinimum(int[] arr) {
		if (arr == null || arr.length < 1) {
			return -1;
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}

		int len = arr.length;
		if (arr[len - 1] < arr[len - 2]) {
			return len - 1;
		}

		int left = 1;
		int right = len - 2;
		int mid;

		while (left < right) {
			mid = left + ((right - left) >> 1);
			if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				return mid;
			} else if (arr[mid] >= arr[mid - 1]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private static int getMinimumIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;

		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}
}
