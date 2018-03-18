
//import classes for file input - scanner etc.
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
//import implementing set (eg. TreeSet)
import java.util.Set;
import java.util.TreeSet;


/**
 * class wordProcessor
 * @author Kaikan Wu, 2327942w
 */
public class WordProcessor {
	private static <E> String displaySet(Set<E> inputSet){
		//implement this static method to create a
		// String representation of set - 5 comma separated elements per line
		// assume that type E has a toString method
		StringBuilder output = new StringBuilder();
		int counter = 0;
        for (E element: inputSet) {
            output.append(element + ", ");
            counter++;
            //5 elements per line
            if (counter == 5){
                output.append("\r\n");
                counter = 0;
            }
        }

        return output.toString();

	}

	/**
     * main method
	 * @param args
	 */
	public static void main(String[] args) {

		//create a set of type String called wordSet
        Set<String> wordSet = new TreeSet<String>();

		//create a set of type CountedElement<String> called countedWordSet 
		Set<CountedElement<String>> countedWordSet = new TreeSet<CountedElement<String>>();

		//for each input file (assume 3 arguments, each the name of a file)
        for(String fileName : args){

            try {
                BufferedReader file = new BufferedReader(new FileReader(fileName));
                Scanner scanner = new Scanner(file);
                //  for each word w
                while (scanner.hasNext()){

                    String word = scanner.next();
                    //  if wordset doesnt contain w:
                    if (!wordSet.contains(word)){
                        //  add w to wordset
                        wordSet.add(word);
                        //  add new element to countedWordSet
                        countedWordSet.add(new CountedElement<String>(word,1));
                    }
                    //  else
                    //  increment numeric part of element in countedWordSet containing w
                    else {

                        Iterator<CountedElement<String>> c = countedWordSet.iterator();

                            while (c.hasNext() ){
                                CountedElement<String> element = c.next();
                                String str = element.getElement();
                                if (str.equals(word)){
                                    element.setCount(element.getCount()+1);
                                }
                            }
                    }

                }

                //close the file read part
                file.close();
                scanner.close();

            }catch (IOException e){

            }

        }
	System.out.println(displaySet(countedWordSet));

	}
}
