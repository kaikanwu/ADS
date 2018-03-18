
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BSTBag<E extends Comparable<E>> implements Bag<E> {

    public Node<E> root;

    private int size;
    /**
     * Constructor
     */
    public BSTBag(){
        root = null;
        size = 0;
    }

    /**
     * inner class
     * @param <E>
     */
        public static class Node<E extends Comparable<E>>{
            protected CountedElement<E> element;
            protected Node<E> left;
            protected Node<E> right;
            protected int count;

            protected Node(E element){
                this.element = new CountedElement<E>(element);
                this.element.setCount(1);
                this.left = null;
                this.right = null;

            }
        }

        // Assessors methods

        /**
         * Return true if and only if this bag is empty.
         * @return
         */
        @Override
        public boolean isEmpty() {
            return root==null;

        }


        /**
         * Return the size of this set.
         * @return
         */
        @Override
        public int size() {
            return size;
        }


        /**
         * Return true if and only if element is a member of this bag.
         * @param element
         * @return
         */
        @Override
        public boolean contains(E element) {
            int direction = 0;
            Node<E> current = root;
            for (;;){

                if (current == null){
                    return false;
                }else {
                    direction = element.compareTo(current.element.getElement());
                    if (direction == 0){
                        if (current.element.getCount() == 0){
                            return false;
                        }else {
                            // only a member at root
                            return true;
                        }

                    }else if (direction<0){
                        current = current.left;
                    }else {
                        current = current.right;
                    }

                }



            }

    }

    /**
     *
     *  Return true if and only if this bag is equal to that.
     * @param that
     * @return
     */

    @Override
    public boolean equals(Bag<E> that) {//not very sure about this part
        if (this== that){
            return true;
        }else {
            return false;
        }

    }

    // Transformers methods


    /**
     *  Make this bag empty.
     */
    @Override
    public void clear() {

        //clear the set
        root = null;
    }


    @Override
    public void add(E element) {

        int direction = 0;
        Node<E> current = root;
        Node<E> parent = null;
        Node<E> newNode = new Node<E>(element);
        size += 1;
        //break the loop when reach to the bottom
        for (;;){
            //if the current node is null
            if (current == null){

                if (root == null){
                    root = newNode;
                }else if (direction < 0){
                    parent.left = newNode;
                }else if (direction> 0 ){
                    parent.right = newNode;
                }
                //exit this loop
                return;
            }

            // if current node is not null
            //call the compareto method
            direction = newNode.element.compareTo(current.element);

            if (direction == 0){

                current.count++;
                current.element.setCount(current.count);
                return;
            }
            parent = current;
            if (direction< 0 ){
                current = current.left;
            }else {//direction > 0
                current = current.right;
            }


        }




    }

    // Remove it from this set.
    // Do nothing if no item in bag pertaining to element
    // otherwise decrement number of element items (lazy deletion)

    /**
     * delete an element
     * @param element
     */
    @Override
    public void remove(E element) {
        int direction = 0;
        Node<E> partent = null;
        Node<E> current = root;
        Node<E> deleteNode = new Node<E>(element);
        for (;;){
            if (current == null){
                return;
            }
            //call the compareto method
            direction = deleteNode.element.compareTo(current.element);

            if (direction == 0){
                int cout = current.element.getCount();

                current.element.setCount(--cout);
                return;

            }else  if (direction < 0 ){
                current = current.left;
            }else {
                current =current.right;
            }



        }






    }


    @Override
    public Iterator<E> iterator() {
        // Return an iterator that will visit all members of this
        // bag, in no particular order



        return null;
    }

    //create a intertator object
    private class InOrderIterator implements Iterator<E>{
        LinkedStack<Node<E>> stack;

        //private constructor
        private InOrderIterator(){
            stack = new LinkedStack<Node<E>>();

            for (Node<E> current = root; current!= null; current = current.left){
                for (int i = 0; i < current.element.getCount(); i ++){
                    stack.push(current);
                }
            }
        }



        @Override
        public boolean hasNext(){
            return (!stack.empty());
        }


        @Override
        public E next(){
            if(stack.empty()){
                throw new NoSuchElementException();
            }
            Node<E> place = stack.pop();

            for (Node<E> current = place.right; current!=null; current = current.left){
                while (current.element.getCount()>0){
                    stack.push(current);
                    current.count--;

                }
            }

            return place.element.getElement();





        }





    }


}
