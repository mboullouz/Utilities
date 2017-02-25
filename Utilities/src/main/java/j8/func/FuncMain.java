package j8.func;

import java.util.Arrays;
import java.util.List;

import common.StringsAlgo;

public class FuncMain {

	public static void main(String[] args) {
		
		System.out.println("Starts...");
		List<String> list = Arrays.asList("Lyon", "paris", "grenoble", "nantes","lille");
		list.stream()
			.map(String::toUpperCase)
			.sorted(StringsAlgo::compare)
			.filter(v -> {
				return v.length() > 2;
			})
			.max((x,y)->{
				return 2;
			})
			.ifPresent(w->{
				System.out.println(w);
			});
		
	}

}
