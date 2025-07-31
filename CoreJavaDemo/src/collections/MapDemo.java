package collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		System.out.println(map.putIfAbsent(1, "One"));
		map.put(4, "Four");
		map.put(2, "Two");
		System.out.println(map);
		//System.out.println(map.put(1, "OneOne"));
		System.out.println(map.putIfAbsent(1, "OneOne"));
		map.put(3, "Three");
		map.put(10, "Ten");
		System.out.println(map);
		
		System.out.println(map.get(1));
		System.out.println(map.containsKey(2));
		System.out.println(map.getOrDefault(100, "0"));
		System.out.println(map.getOrDefault(3, "0"));

		System.out.println(map.remove(3));
		System.out.println(map);
		map.forEach((key, value) ->{
				System.out.println(key+" "+value);
		});
		
		List<String> names = Arrays.asList("A","A","B","A","C","B","D","E","A");
		
		Map<String, Integer> countNames = new HashMap<String, Integer>();
		
		/**
		 * 1. get 1st name from the list -> loop A
		 * 2. add name in the map and value should be set to 1
		 * 3. get 2nd name from the list -> A
		 * 4. 
		 */
		
		
		names.forEach(name->{
			countNames.put(name, countNames.getOrDefault(name, 0)+1);
			
//			if(countNames.containsKey(name)) {
//				int pcount = countNames.get(name);
//				countNames.put(name, pcount+1);
//			}
//			else
//				countNames.put(name, 1);// A, A / B
			
		});
		System.out.println(countNames);
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * create a map with key as names in the list
		 * value as count of names
		 * A=3
		 * B=2
		 * C=1
		 * D=1
		 * E=1
		 */
//		Map<String , Integer> count = new HashMap<String, Integer>();
//		names.forEach(name->{
//			
//			count.put(name, count.getOrDefault(name, 0)+1);
//			
////			if(count.containsKey(name))
////			{
////				int c = count.get(name);
////				count.put(name, c+1);
////			}
////			else{
////				count.put(name, 1);
////			}
//		});
//		System.out.println(count);
	}

}
