package datastructure;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UseArrayList {

    public static void main(String[] args) throws Exception {
        /*
         * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
         * Use For Each loop and while loop with Iterator to retrieve data.
         * Store all the sorted data into one of the databases.
         *
         */

        ArrayList<Integer> arrli = new ArrayList();
//add element to ArrayList
        arrli.add(23);
        arrli.add(111);
        arrli.add(120);
        arrli.add(260);
        arrli.add(295);
//print ArrayList
        System.out.println("Retrieving elements from ArrayList: " + arrli);
//Using get method to peek the 1st element
        System.out.println("Peek first element: " + arrli.get(0));
//remove element from ArrayList
        System.out.println("Remove element at index 1: " + arrli.remove(1));
//Retrieving elements from ArrayList
        System.out.println("Re-retrieving elements from ArrayList: " + arrli);
//Using 'for-each'loop
        System.out.println("Use of for-each loop: ");
        for (Integer in : arrli) {
            System.out.println(in);
        }
        //Using iterator
        System.out.println("Use of iterator using while loop: ");
        Iterator it = arrli.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }
//Sorting ArrayList
        Collections.sort(arrli);
        System.out.println(arrli);
        List list = new ArrayList();
        list = arrli;
        //connect to MYSql Database
        try {
            ConnectToSqlDB connectDB = new ConnectToSqlDB();
            //Create table in the database
            connectDB.createTableFromToMySql("emp_record", "use_map", "arr_li");
            //insert data in the database
            connectDB.insertDataFromArrayListToSqlTable(list, "arr_li", "listElement");
            //Read data from database

            List<String> numbers = (List<String>) connectDB.readDataBase("arr_list", "listElement");
            for (String st : numbers) {
                System.out.println(st);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}




