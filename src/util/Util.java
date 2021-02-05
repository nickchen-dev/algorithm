package util;

public class Util {
	public static int[] generateRandomArray(int size, int range) {
		int[] array = new int[(int) (Math.random() * size + 1)];
		int len = array.length;
		for (int i = 0; i < len; i++) {
			array[i] = (int) (Math.random() * range + 1 - Math.random() * range);
		}
		return array;
	}

	public static int[] cpyArray(int[] array) {
		if (array == null) {
			return null;
		}
		int len = array.length;
		int[] cpyArray = new int[len];
		for (int i = 0; i < len; i++) {
			cpyArray[i] = array[i];
		}
		return cpyArray;
	}

	public static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		array[i] ^= array[j];
		array[j] ^= array[i];
		array[i] ^= array[j];
	}

	public static long getSysTime() {
		return System.currentTimeMillis();
	}

	public static boolean isEqual(int[] arr1, int[] arr2) {
		if (arr1 == arr2) {
			return true;
		}
		if (arr1 == null ^ arr2 == null) {
			return false;
		}
		int len;
		if ((len = arr1.length) != arr2.length) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void printArray(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return;
		}
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + (i != len - 1 ? " " : "\n"));
		}
	}

	public static int[] reverseArr(int[] arr) {
		if (arr == null) {
			return null;
		}

		if (arr.length <= 1) {
			return arr;
		}

		int len = arr.length;
		int[] reversedArr = new int[len];

		int j = 0;
		for (int i = len - 1; i >= 0; --i) {
			reversedArr[j++] = arr[i];
		}
		return reversedArr;
	}
}
