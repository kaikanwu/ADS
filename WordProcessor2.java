
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordProcessor2 {

    public static void main(String[] args) {

        BSTBag<String> Bag1 = new BSTBag<String>();
        BSTBag<String> Bag2 = new BSTBag<String>();



        //for each input file (assume 3 arguments, each the name of a file)
        for(String fileName : args) {

            try {
                BufferedReader file = new BufferedReader(new FileReader(fileName));
                Scanner scanner = new Scanner(file);
                //  for each word w
                while (scanner.hasNext()) {

                    String word = scanner.next();
                     Bag1.add(word);
                     Bag2.add(word);

                }

            } catch (IOException e) {

            }
        }


//        System.out.println("the size of bag is " + Bag1.size() +", " + Bag2.size());
//        System.out.println("The bag1 is empty?" + Bag1.isEmpty());
//        Bag1.clear();
//        System.out.println("The bag1 is empty?" + Bag1.isEmpty());
//        System.out.println("the size of bag is " + Bag1.size() +", " + Bag2.size());
//
//        Bag2.remove("cow");
//        Bag2.remove("ant");
//
//        System.out.println("the size of bag is " + Bag1.size() +", " + Bag2.size());
//
//
//        System.out.println("The bag2 is empty?" + Bag2.isEmpty());
//
//        Bag2.clear();
//        System.out.println("The bag2 is empty?" + Bag2.isEmpty());

//        System.out.println("equal or not : " + Bag2.equals(Bag1));
//        Bag2.remove("ant");
//        Bag1.remove("ant");
//        System.out.println(Bag2.size());
//        System.out.println("the size of bag is " + Bag1.size() +", " + Bag2.size());
//
//        System.out.println("equal or not : " + Bag2.equals(Bag1));
//        Bag1.add("ant");
//        Bag2.add("ant");
//        System.out.println("the size of bag is " + Bag1.size() +", " + Bag2.size());
//
//        System.out.println("equal or not : " + Bag2.equals(Bag1));

//

    }
}


