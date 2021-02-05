package basic;

import java.util.Arrays;

import util.Util;

public class Code002BubbleSort {
	public static void main(String[] args) {
		int testNum = 1_000_000;
		// generate a random array with various size and value
		int maxSize = 100, maxRange = 500;
		int[] arr, arr1, arr2;

		long start = Util.getSysTime();
		System.out.println("test start...");
		for (int i = 0; i < testNum; i++) {
			arr = Util.generateRandomArray(maxSize, maxRange);
			arr1 = Util.cpyArray(arr);
			arr2 = Util.cpyArray(arr);

			Arrays.sort(arr1);
			bubbleSort(arr2);

			if (!Util.isEqual(arr1, arr2)) {
				System.out.println("test fail...");
				Util.printArray(arr1);
				Util.printArray(arr2);
				return;
			}
		}
		long end = Util.getSysTime();
		System.out.println("test pass... time taken " + (end - start) / 1000f);
	}

	private static void bubbleSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int len = array.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					Util.swap(array, j, j + 1);
				}
			}
		}
	}
}
