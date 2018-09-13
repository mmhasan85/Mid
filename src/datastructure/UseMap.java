package datastructure;

import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */

		Map<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("chicken", new Integer(5));
		hm.put("beef", new Integer(9));
		hm.put("goat", new Integer(12));
		hm.put("salmon", new Integer(10));
		Set<Map.Entry<String, Integer>> st = hm.entrySet();
		for (Map.Entry<String, Integer> me : st) {
			System.out.print(me.getKey() + " : ");
			System.out.println(me.getValue() + "lb");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++");

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		List<String> fruitslist = new ArrayList<String>();
		fruitslist.add("watermelon");
		fruitslist.add("kiwi");
		fruitslist.add("orange");
		map.put("fruit", (ArrayList<String>) fruitslist);
		System.out.println(fruitslist);
		System.out.println("++++++++++++++++++++++++++++++++++++++");

		ArrayList<String> carlist = new ArrayList<String>();
		carlist.add("toyota");
		carlist.add("bmw");
		carlist.add("audi");
		map.put("car", carlist);
		System.out.println(map);
		System.out.println("===================================");

		for (Object str : map.keySet()) {
			System.out.println("keyset:" + str);
			for (String str1 : map.get(str)) {
				System.out.println("Value: " + str1);
			}
		}
		System.out.println("====================================");

		Map<String, List<String>> data = new HashMap<String, List<String>>();
		data.put("Computer language", Arrays.asList("Java", "Python", "C++", "C#", "Visual", "Basic.NET"));
		data.put("Lunch", Arrays.asList("dumplings", "hotpot", "cold dishes", "pizza"));
		data.put("Tea", Arrays.asList("Olong tea", "Jasmin tea", "Green tea"));
		System.out.println("Printing Hashmap using For each loop");
		//Hashmap-for each loop
		for (Map.Entry<String, List<String>> printdata : data.entrySet()) {
			System.out.println(printdata.getKey() + "--->" + printdata.getValue());
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println("Printing Hashmap using Iterator");
		//Hashmap-Iterator
		Iterator<Map.Entry<String, List<String>>> it = data.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<String>> group = it.next();
			System.out.println(group.getKey() + "--->" + group.getValue());
		}


	}

}
