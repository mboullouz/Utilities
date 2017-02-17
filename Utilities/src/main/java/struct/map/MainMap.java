package struct.map;

import org.apache.commons.lang3.RandomStringUtils;

public class MainMap {

	public static void main(String[] args) {
		MHashMap map = new MHashMap();
		int len = 4;
		String lastKey = "";
		for (int i = 0; i < len; i++) {
			String key = RandomStringUtils.randomAlphanumeric(2);
			String value = key + "_" + i;
			System.out.println("V: "+ value+ " K: "+ key);
			map.put(key, value);
			lastKey = key;
		}
		map.printAll();
		if (map.size() < len) {
			System.out.println("There is N:" + (len - map.size()) + " Collision!");
		}

		System.out.println("LastValue: " + map.get(lastKey)+ " for key: "+ lastKey);
	}

}
