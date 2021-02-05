package basic;

import java.util.Arrays;

import util.Util;

public class Code004BinarySearchIfExist {
	public static void main(String[] args) {
		int testNum = 1_000_000;
		// generate a random array with various size and value
		int maxSize = 200, maxRange = 500;
		int[] arr;
		int target;

		long start = Util.getSysTime();
		System.out.println("test start...");
		for (int i = 0; i < testNum; i++) {
			arr = Util.generateRandomArray(maxSize, maxRange);
			Arrays.sort(arr);
			target = (int) (Math.random() * maxSize);

			if (exist(arr, target) != binarySearchIfExist(arr, target)) {
				System.out.println("test fail...");
				Util.printArray(arr);
				System.out.println("target: " + target);
				return;
			}
		}
		long end = Util.getSysTime();
		System.out.println("test pass... time taken " + (end - start) / 1000f);
	}

	private static boolean binarySearchIfExist(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return false;
		}

		int left = 0;
		int right = arr.length - 1;
		int mid;

		while (left < right) {
			mid = left + ((right - left) >> 1);
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return arr[left] == target;
	}

	private static boolean exist(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (target == arr[i]) {
				return true;
			}
		}
		return false;
	}
}
