package test.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task2 {

    public static void main(String [] args) {
        List<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(3);

        removeWithSequence(list, 0);
        
        System.out.print("Task2.1 - ");
        for (Integer i: list)
            System.out.print(i);
        
        System.out.println();
        
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(3);
    
        System.out.print("Task2.2 - ");
        removeWithoutSequence(list, 0);
    
        for (Integer i: list)
            System.out.print(i);
        
        System.out.println();
    }

    private static void removeWithSequence(List<Integer> list, int index) {
        if (list.isEmpty())
            return;
        
        if (list.size() <= index)
            return;

        int number = list.get(index);
        int counter = 0;

        for (int i=index; i < list.size(); i++)
            if (number == list.get(i)) 
                counter++;
            else
                break;

        for (int i = index; i < index + counter && counter >= 3; i++)
            list.remove(index);
        
        removeWithSequence(list, index+1);
    }

    private static void removeWithoutSequence(List<Integer> list, int index) {
//        System.out.println("index " + index);
        
        if (list.isEmpty())
            return;

        if (list.size() <= index)
            return;
        
        int number = list.get(index);
        
//        System.out.println("number " + number);

        List<Integer> indexesToRemove = new ArrayList<Integer>();
        
        for (int i = list.size()-1; i >=0; i--)
            if (number == list.get(i))
                indexesToRemove.add(i);
        
        if (indexesToRemove.size() >= 3) {
            for (int i: indexesToRemove)
                list.remove(i);
//    
//            for (Integer i: list)
//                System.out.print(i);
            
//            System.out.println("\n");
            
            removeWithoutSequence(list, index);
        }
        else {
//            for (Integer i: list)
//                System.out.print(i); 
//            
//            System.out.println("\n");
        
            removeWithoutSequence(list, index+1); //indexesToRemove.size());
        }
    }
}
