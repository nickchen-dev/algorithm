package basic;

import java.util.Arrays;

import util.Util;

public class Code001SelectionSort {
	public static void main(String[] args) {
		int testNum = 1_000_000;
		// generate a random array with various size and value
		int maxSize = 50, maxRange = 500;
		int[] arr, arr1, arr2;

		long start = Util.getSysTime();
		System.out.println("test start...");
		for (int i = 0; i < testNum; i++) {
			arr = Util.generateRandomArray(maxSize, maxRange);
			arr1 = Util.cpyArray(arr);
			arr2 = Util.cpyArray(arr);

			Arrays.sort(arr1);
			selectSort(arr2);

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

	private static void selectSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int len = array.length;
		int min;
		for (int i = 0; i < len - 1; i++) {
			min = i;
			for (int j = i + 1; j < len; j++) {
				min = array[j] < array[min] ? j : min;
			}
			Util.swap(array, min, i);
		}
	}
}
