package basic;

import util.Util;

public class Code010ReverseLinkedList {
	public static void main(String[] args) {
		int size = 100, range = 1000;
		int[] arr, reversedArr;

		int testCount = 1_000_000;

		long start = Util.getSysTime();

		System.out.println("test start...");
		for (int i = 0; i < testCount; i++) {
			arr = Util.generateRandomArray(size, range);

			Node head = generateLinkedList(arr);
			DoubleNode doubleHead = generateDoubleLinkedList(arr);

			if (!isOrderValid(arr, head, doubleHead)) {
				System.out.println("1. test fail...");
				Util.printArray(arr);
				printLinkedList(head);
				System.out.println();
				printDoubleLinkedList(doubleHead);
				return;
			}

			head = reverseLinkedList(head);
			doubleHead = reverseDoubleLinkedList(doubleHead);

			reversedArr = Util.reverseArr(arr);

			if (!isOrderValid(reversedArr, head, doubleHead)) {
				System.out.println("2. test fail...");
				Util.printArray(arr);
				printLinkedList(head);
				System.out.println();
				printDoubleLinkedList(doubleHead);
				return;
			}
		}
		long end = Util.getSysTime();
		System.out.println("test pass... time taken " + (end - start) / 1000f);
	}

	private static boolean isOrderValid(int[] arr, Node head, DoubleNode doubleHead) {
		if (arr == null || head == null || doubleHead == null) {
			return false;
		}

		int i = 0;
		int len = arr.length;

		Node cur1 = head;
		DoubleNode cur2 = doubleHead;

		while (i < len) {
			if (cur1.value != arr[i] || cur2.value != arr[i]) {
				return false;
			}

			cur1 = cur1.next;
			cur2 = cur2.next;
			++i;
		}
		return true;
	}

	private static Node reverseLinkedList(Node head) {
		if (head == null) {
			return null;
		}
		Node prev, cur, next;
		prev = null;
		cur = head;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	private static Node generateLinkedList(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		Node head = new Node(arr[0]);
		Node cur = head;
		Node tmp;
		int len = arr.length;
		for (int i = 1; i < len; ++i) {
			tmp = new Node(arr[i]);
			cur.next = tmp;
			cur = tmp;
		}
		return head;
	}

	private static void printLinkedList(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		System.out.print(cur);
		while ((cur = cur.next) != null) {
			System.out.print(" -> ");
			System.out.print(cur);
		}
	}

	private static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
		if (head == null) {
			return null;
		}
		DoubleNode prev, cur, next;
		prev = null;
		cur = head;
		while (cur != null) {
			next = cur.next;
			cur.prev = next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	private static DoubleNode generateDoubleLinkedList(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		DoubleNode head = new DoubleNode(arr[0]);
		DoubleNode cur = head;
		DoubleNode tmp;

		int len = arr.length;

		for (int i = 1; i < len; i++) {
			tmp = new DoubleNode(arr[i]);
			cur.next = tmp;
			tmp.prev = cur;
			cur = tmp;
		}
		return head;
	}

	private static void printDoubleLinkedList(DoubleNode head) {
		if (head == null) {
			return;
		}

		DoubleNode cur = head;
		DoubleNode prev = cur.prev;

		System.out.print(prev + " <- ");
		System.out.print(cur);
		while ((cur = cur.next) != null) {
			System.out.print(" -> <- ");
			System.out.print(cur);
		}

		System.out.print(" -> " + cur);
	}
}
