package struct.map;

public class MHashMap {
	int initSize = 999;
	Object[] table = new Object[initSize];

	public void put(String key, Object obj) {
		int index = hashFunc(key);
		int ix = Math.abs(index % initSize);
		if (table[ix] != null) {
			System.out.println("collision, ix: " + ix + " v: " + obj + " will replace: "+table[ix]);
		}
		table[ix] = obj;
	}

	public Object[] getTable() {
		return table;
	}

	public void printAll() {
		for (Object o : table) {
			if (o != null)
				System.out.println(o);
		}
	}
	
	public Object get(String key) {
		int index = hashFunc(key);
		int ix = Math.abs(index % initSize);
		return table[ix];
	}
	
	public int size(){
		int s=0;
		for (Object o : table) {
			if (o != null)
				s++;
		}
		return s;
	}

	private int hashFunc(String key) {
		int i = key.hashCode();
		return i;
	}

}