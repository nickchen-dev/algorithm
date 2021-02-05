package basic;

import java.util.HashSet;
import java.util.Set;

import util.Util;

/**
 * 1. in a array, only 1 number occurs odd times, the rest of the numbers all
 * appear even times, use exclusive or to find out the occurs odd times number
 * 
 * 2. in a array, there are 2 different numbers occur odd times, the rest of the
 * numbers all appear even times, use exclusive or to find out the 2 different
 * odd times numbers
 * 
 * @author nick
 *
 */
public class Code008GetOddOccurNum {

	public static void main(String[] args) {
		int[] arr1, arr2;
		int range = 5;
		int target1, target21, target22;
		int numType1, numType2;
		target1 = getRandomNumber(range, 1);
		numType1 = getRandomNumber(range, 5);
		arr1 = generateOneOddArray(target1, numType1);

		Util.printArray(arr1);
		int oddNum1 = getOneOddNum(arr1);
		System.out.println(oddNum1);

		target21 = getRandomNumber(range, 1);
		target22 = getRandomNumber(range, 1);
		numType2 = getRandomNumber(range, 5);

		arr2 = generateTwoOddArray(target21, target22, numType2);
		getTwoOddNum(arr2);
		Util.printArray(arr2);
	}

	private static int getOneOddNum(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("empty array not allowed");
		}
		int len = arr.length;
		int xor = arr[0];
		for (int i = 1; i < len; i++) {
			xor ^= arr[i];
		}
		return xor;
	}

	private static void getTwoOddNum(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length % 2 != 0) {
			throw new RuntimeException("invalid array not allowed");
		}
		int len = arr.length;
		int xorSum = arr[0];
		int i;
		for (i = 1; i < len; i++) {
			xorSum ^= arr[i];
		}

		int rightMostOne = xorSum & (-xorSum);
		int odd = 0;

		for (i = 0; i < len; i++) {
			if ((rightMostOne & arr[i]) == 0) {
				odd ^= arr[i];
			}
		}
		System.out.println("odd1: " + odd + ", odd2: " + (xorSum ^ odd));
	}

	private static int[] generateOneOddArray(int target, int numType) {
		int odd, even;
		int range = 4;
		while ((odd = getRandomNumber(range, 1)) % 2 == 0)
			;
		while ((even = getRandomNumber(range, 1)) % 2 != 0)
			;

		int[] arr = new int[odd + (numType - 1) * even];
		int i = 0;

		Set<Integer> set = new HashSet<>();
		set.add(target);

		for (; i < odd; i++) {
			arr[i] = target;
		}

		int item;
		while (--numType > 0) {
			do {
				item = getRandomNumber(range, 1);
			} while (set.contains(item));

			for (int j = 0; j < even; j++) {
				arr[i++] = item;
			}
		}

		return arr;
	}

	private static int[] generateTwoOddArray(int odd1, int odd2, int numType) {

		while (odd1 == odd2) {
			odd2 = 2 * odd1 - 1;
		}

		System.out.println("odd1: " + odd1 + ", odd2: " + odd2);

		int odd, even;
		int range = 4;
		while ((odd = getRandomNumber(range, 1)) % 2 == 0)
			;
		while ((even = getRandomNumber(range, 1)) % 2 != 0)
			;

		int len = odd + (2 * odd - 1) + (numType - 2) * even;
		int[] arr = new int[len];
		int i = 0;

		Set<Integer> set = new HashSet<>();
		set.add(odd1);
		set.add(odd2);

		for (; i < odd; i++) {
			arr[i] = odd1;
		}

		for (; i < odd + 2 * odd - 1; i++) {
			arr[i] = odd2;
		}

		numType -= 2;

		int item;
		while (numType-- > 0) {
			do {
				item = getRandomNumber(range, 1);
			} while (set.contains(item));

			for (int j = 0; j < even; j++) {
				arr[i++] = item;
			}
		}

		return arr;
	}

	private static int getRandomNumber(int range, int minimum) {
		return (int) (Math.random() * range) + minimum;
	}
}
