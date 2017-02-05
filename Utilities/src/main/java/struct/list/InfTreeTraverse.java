package struct.list;

public class InfTreeTraverse {

	public static void main(String[] args) {
		InfTree tree0 = new InfTree(1);
		InfTree tree1 = new InfTree(11);
		InfTree tree2 = new InfTree(22);
		tree2.add(23).add(24).add(25);
		tree1.add(12).add(13).add(14);
		tree0.add(2)
		     .add(tree1)
		     .add(3).add(4)
		     .add(tree2)
		     .add(5);
		
		traverse(tree0);
	}
	
	public static void traverse(InfTree head){
		if(head==null){
			return;
		}
		System.out.println("\n current value: "+head.getValue());
		for(InfTree ch: head.getChildreen()){
			traverse(ch);
		}
	}

}
