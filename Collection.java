import java.util.*;

public class Collection {
    public static void main(String[] args) {
        Collection collect = new Collection();
        int[] arr = {1,3,5,7,9,11};
        LinkedList<Integer> list = new LinkedList<Integer>();


        for(int i = 0 ; i < arr.length; i++){
            list.add(arr[i]);
        }
        System.out.println("\nStarting List : "  + list);
        int add =10;
        System.out.println("\nAdding "+ add+  " to Linked list and sorting");
        collect.addAndSort(list, add);
        System.out.println("After 'addAndSort(list, " + add + " )' , List : " + list );


        int id1 = 3;
        int id2 = 6;
        System.out.println("\nSwapping values for index " + id1 + " and " + id2);
        System.out.println("Current Linked list : " + list);
        collect.swapValues(list, 3, 6);
        System.out.println("After swapping by index by calling swapValues( list,"+ id1+ ","+ id2 + ")");
        System.out.println("Linked list : " + list);

        System.out.println("\nGenerating a new linked list with 500 random integer from 1000 to 9000 ");
        LinkedList<Integer> random_list = new LinkedList<Integer>();
        Random random_gen = new Random();
        int new_value;
        for(int j = 0 ; j < 500; j++){
            new_value= random_gen.nextInt(9000) +1000;
            random_list.add(new_value);
            /*
            if (j <4){
                System.out.println(random_list.peekLast());
            }
            */
        }


        int findValue = random_gen.nextInt(9000) +1000;
        System.out.println("Finding " + findValue + " in the new linked list by calling findValue(map, " + findValue + " )");
        int result = collect.findValue(random_list , findValue);
        System.out.println("Value " + findValue + " is found at index " + result);


        System.out.println("");

       /*System.out.println(random_list.size()); */

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        

        for(int i = 0 ; i < arr.length; i++){
            map.put(i , arr[i]);
        }
        System.out.println("\nStarting HashMap : "  + map);
        System.out.println("\nAdding "+ add+  " to map and sorting");
        collect.mapAddAndSort(map, add);
        System.out.println("After 'mapAddAndSort(map, " + add + " )' , map : " + map );


        System.out.println("\nSwapping values for index " + id1 + " and " + id2);
        System.out.println("Current Hashmap : " + map);
        collect.mapSwapValues(map, id1,id2);
        System.out.println("After swapping by index using  by calling mapSwapValues( map,"+ id1 + ","+ id2 + ")");
        System.out.println( map);
        System.out.println("\nGenerating a new Hashmap with 500 random integer from 1000 to 9000");
        HashMap<Integer,Integer> random_map = new HashMap<Integer,Integer>();
        for(int j = 0 ; j < 5000; j++){
            new_value= random_gen.nextInt(9000) +1000;
            random_map.put(j,new_value);
        }


        findValue = random_gen.nextInt(9000) +1000;
        System.out.println("Finding " + findValue + " in the new Hashmap by calling mapFindValue(map, " + findValue + " )");
        result = collect.mapFindValue(random_map , findValue);
        System.out.println("Value " + findValue + " is found at key: " + result);

        System.out.println();
    }

    public void addAndSort(LinkedList<Integer> list, int value){

        int id = 0 ;
        ListIterator<Integer> list_Iter = list.listIterator(0);
        while(list_Iter.hasNext()){

            if (list_Iter.next() >= value){
                list.add(id,value );
                return ;
            }
            id +=1;
        } 
        list.addLast(value);
        return;
    }

    public void swapValues(LinkedList<Integer> list, int indexOne ,int indexTwo ){
        int temp  = list.get(indexOne);
        list.set(indexOne, list.get(indexTwo));
        list.set(indexTwo, temp);
    }

    public int findValue(LinkedList<Integer> list, int searchValue){
        int id = 0 ;
        ListIterator list_Iter = list.listIterator(0);
        while(list_Iter.hasNext()){

            if ((int)list_Iter.next() == searchValue){
                return id;
            }
            id +=1;

        } 

        return(-1);
    }


    public void mapAddAndSort(HashMap<Integer,Integer> map , int value){
        int size = map.size();
        int i = 0;
        int done = 0;
        int temp = value;
        int sub =value;
        map.put(size,0);
        for( i=0; i <= size ; i++ ){
            if (map.get(i) >= value ){
                done =1;
            }
            if (done > 0  ){
                temp = map.get(i);
                map.replace(i, sub);
                sub = temp;
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int j = 0 ; j < size+ 1 ; j++ ){
            arr.add(map.get(j));
        }
        
        return;
    }

    public void mapSwapValues(HashMap<Integer,Integer> map ,int indexOne ,int indexTwo ){
        int tmp = map.get(indexOne);
        map.replace(indexOne, map.get(indexTwo));
        map.replace(indexTwo, tmp);
    }
    public int mapFindValue(HashMap<Integer,Integer> map , int searchValue){
        int size = map.size();
        for(int i = 0 ; i< size ; i++){
            if (map.get(i) == searchValue){
                return i;
            }
        }
        return -1;
    }

}
