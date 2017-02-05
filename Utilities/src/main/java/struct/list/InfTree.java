package struct.list;

import java.util.ArrayList;
import java.util.List;

public class InfTree {
	private List<InfTree> childreen = new ArrayList<>();
	private int value;
	
	public InfTree(List<InfTree> cs){
		this.childreen=cs;
	}

	public InfTree(int value) {
		this.value = value;
	}
	
	public InfTree add(InfTree ch){
		this.childreen.add(ch);
		return this;
	}
	public InfTree add(int v){
		this.childreen.add(new InfTree(v));
		return this;
	}

	public List<InfTree> getChildreen() {
		return childreen;
	}

	public void setChildreen(List<InfTree> childreen) {
		this.childreen = childreen;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
