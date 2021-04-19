package BTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreeDemo {

    public static void main(String[] args) {

        BTree bTree = new BTree(10);

        long start1 = System.nanoTime();
        for (int i = 1_000_000_000; i <= 1_000_001_000; i++) {
            bTree.insert(i);
        }
        long finish1 = System.nanoTime() - start1;
        System.out.println("Sequential filling: " + finish1 + " ns.");

        //**** SEARCHING FOR ELEM ****
        long startSearch = System.nanoTime();
        bTree.search(1_000_000_500);
        long finishSearch = System.nanoTime() - startSearch;
        //**** END SEARCHING FOR ELEM ****

        long start2 = System.nanoTime();
        for (int i = 1_000_001_000; i >= 1_000_000_000; i--) {
            bTree.remove(i);
        }
        long finish2 = System.nanoTime() - start2;
        System.out.println("Remove sequential elements: " + finish2 + " ns.\n");

        //************* PSEUDO RAND **************
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            arr.add(i * 888889);
        }
        Collections.shuffle(arr);
        //*************     END     **************

        long start3 = System.nanoTime();
        for (int i = 0; i < arr.size(); i++) {
            bTree.insert(arr.get(i));
        }
        long finish3 = System.nanoTime() - start3;
        System.out.println("Insert rand elems: " + finish3 + " ns.");

        long start4 = System.nanoTime();
        for (int i = 0; i < arr.size(); i++) {
            bTree.remove(arr.get(i));
        }
        long finish4 = System.nanoTime() - start4;
        System.out.println("Remove rand elems: " + finish4 + " ns.");

        System.out.println("\nSearch for elem: " + finishSearch + " ns.");


    }

}
