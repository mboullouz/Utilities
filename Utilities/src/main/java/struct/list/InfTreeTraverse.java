package struct.list;

import org.apache.commons.lang3.RandomStringUtils;

public class InfTreeTraverse {
	static boolean found = false;
	static int valueToSearch = 11;
	static InfTree nodeContainigValue;

	public static void main(String[] args) {
		InfTree tree0 = new InfTree(1);
		InfTree tree1 = new InfTree(11);
		InfTree tree2 = new InfTree(22);
		tree2.add(23).add(24).add(25);
		tree1.add(12).add(13).add(14);
		tree0.add(2).add(tree1).add(3).add(4).add(tree2).add(5);

		System.out.println("\n ===========\n Traversing the three");
		traverse(tree0);

		System.out.println("\n ===========\n Check if the three contains the value: " + valueToSearch);
		valueExists(tree0, valueToSearch);
		if (found) {
			System.out.println("The value is found ^-^ in the node: " + nodeContainigValue.getName());
		} else {
			System.out.println("No Success *__*' ");
		}
	}

	public static void traverse(InfTree head) {
		if (head == null) {
			return;
		}
		System.out.println("\n current value: " + head.getValue());
		for (InfTree ch : head.getChildreen()) {
			traverse(ch);
		}
	}

	public static void valueExists(InfTree head, int v) {
		if (head == null || found) {
			return;
		}

		if (head.getValue() == v) {
			found = true;
			nodeContainigValue = head;
			return;
		}
		for (InfTree ch : head.getChildreen()) {
			valueExists(ch, v);
		}
	}

	public static String randomString() {
		return RandomStringUtils.random(13);
	}

}
