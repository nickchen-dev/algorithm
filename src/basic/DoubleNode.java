package basic;

class DoubleNode {
	int value;
	DoubleNode prev;
	DoubleNode next;

	public DoubleNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + value + "]";
	}

}
