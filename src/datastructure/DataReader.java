package datastructure;

import databases.ConnectToSqlDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DataReader {

	public static void main(String[] args) throws Exception {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class.
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car.txt";

		FileReader fr = null;
		BufferedReader br = null;
		BufferedReader br1 = null;
		ConnectToSqlDB connectDB = new ConnectToSqlDB();
		//connectDB.createTableFromToMysql( "emp_record","use_map", "emp_record");
		try {
			fr = new FileReader(textFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		String text, text1;
		Stack stack = new Stack();
		LinkedList<String> linkedList = new LinkedList<>();
		int count = 0;
		try {
			while ((text = br.readLine()) != null) {
				System.out.println(text);
				String[] words = text.split(" ");
				for (int i = 0; i < words.length; i++) {
					stack.push(words[i]);
					linkedList.add(words[i]);
				}
				connectDB.insertDataFromStringToSqlTable(text, "SelfDrivingCar", "text");
			}
			System.out.println("Total word count: " + count);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		List<String> textLine = connectDB.readDataBase("SelfDrivingCar", "text");
		for (String st : textLine) {
			System.out.println(st);
		}
		System.out.println("++++++++++++++");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.println("FIFO order from LinkeList: " + linkedList.get(i));
		}
		System.out.println("++++++++++++++");
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.println("FIFO order from stack: " + stack.get(i));

		}
		System.out.println("Peeking stack: " + stack.peek());
		System.out.println("Searching stack: " + stack.search("steps!"));
		System.out.println("Popping stack: " + stack.pop());
		System.out.println("Peeking again; " + stack.peek());

		System.out.println("Retrieving data using for-each loop: ");
		for (Object st : stack) {
			System.out.println(st);
		}
		System.out.println("Retrieving data using while loop: ");
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
		System.out.println("Retrieving data using iterator: ");
		Iterator it = linkedList.iterator();
		while (it.hasNext()) {
			String obj = (String) it.next();
			System.out.println(obj);
		}
	}
}







