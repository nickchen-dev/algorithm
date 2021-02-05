package basic;

/**
 * perform some binary operation
 * 
 * @author nick
 *
 */
public class Code009BinaryOps {
	public static void main(String[] args) {
		int num = 432;
		int bit1Count = countBinary1(num);
		System.out.println(bit1Count);

		convertIntToBit1(num);
		System.out.println();
		convertIntToBit2(num, 32);
	}

	private static void convertIntToBit1(int num) {
		int len = 31;
		for (int i = len; i >= 0; i--) {
			System.out.print(((num >> i) & 1) != 0 ? '1' : '0');
		}
	}

	private static void convertIntToBit2(int num, int prefix) {
		if (num == 0) {
			for (int i = 0; i < prefix; i++) {
				System.out.print(0);
			}
			return;
		}
		convertIntToBit2(num / 2, --prefix);
		System.out.print(num % 2);
	}

	private static int countBinary1(int num) {
		int count = 0;
		int rightMostOne;
		while (num != 0) {
			count++;
			rightMostOne = num & (~num + 1);
			num ^= rightMostOne;
		}
		return count;
	}

}
