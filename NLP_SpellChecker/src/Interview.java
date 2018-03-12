import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Interview {
	public static void main(String[] args) 
    {
//----------------------------------------------------------     
        HashMap<String, Integer> map = new HashMap<>();
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);
        System.out.println(map.size());
        if (map.containsKey("vishal")){
        	int a = map.get("vishal");
        }
        
//------------------------------------------------------------
        ArrayList<Integer> obj = new ArrayList<Integer>();
        obj.add(182);
        obj.add(0);
        obj.add(52);
        //obj.remove("0");
        //Integer.valueOf();
        Collections.sort(obj);
        System.out.println(obj);
//------------------------------------------------------------
        String[] str = new String[10];
        str[1] = "a";
        int x = str.length;
        
        //Data types = linked lists, stacks, queues, maps, trees
        //Sorting = Swapping Selection Sort Bubble Sort Merge Sort Quick Sort ‘divide and conquer’	Counting Sort
        //Collections.sort();
        String a = "Hello";
        if(a.equals("Hello")){
        	System.out.println(true);
        }

    }
}
