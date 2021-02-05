package basic;

import java.util.Arrays;

import util.Util;

/**
 * in a sorted array, given a value as a target, use binary search to find the
 * right most position where its value is less than or equal to the target
 * 
 * @author nick
 */
public class Code006BinarySearchRightMostIndex {

	public static void main(String[] args) {
		int testNum = 1_000_000;
		// generate a random array with various size and value
		int maxSize = 300, maxRange = 500;
		int[] arr;
		int target;
		int index1, index2, index3;

		long start = Util.getSysTime();
		System.out.println("test start...");
		for (int i = 0; i < testNum; i++) {
			arr = Util.generateRandomArray(maxSize, maxRange);
			Arrays.sort(arr);
			target = (int) (Math.random() * maxSize);

			index1 = test(arr, target);
			index2 = findRightMostIndex1(arr, target);
			index3 = findRightMostIndex2(arr, target);

			if (index1 == index2 ^ index1 == index3) {
				System.out.println("test fail...");
				Util.printArray(arr);
				System.out.println("target: " + target);
				return;
			}
		}
		long end = Util.getSysTime();
		System.out.println("test pass... time taken " + (end - start) / 1000f);
	}

	private static int findRightMostIndex1(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		int mid;
		int rightMost = -1;

		while (left < right) {
			mid = left + ((right - left) >> 1);
			if (arr[mid] <= target) {
				rightMost = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return arr[left] <= target ? left : rightMost;
	}

	private static int findRightMostIndex2(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		int mid;
		int rightMost = -1;

		while (left <= right) {
			mid = left + ((right - left) >> 1);
			if (arr[mid] > target) {
				right = mid - 1;
			} else {
				rightMost = mid;
				left = mid + 1;
			}
		}
		return rightMost;
	}

	private static int test(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int len = arr.length;
		int i = 0;

		while (i < len && arr[i++] <= target)
			;
		return i == len ? -1 : i - 1;
	}
}
