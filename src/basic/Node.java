package basic;

class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + value + "]";
	}
}
