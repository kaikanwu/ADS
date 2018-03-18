
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class BSTBag implements the Bag interface, using Binary search tree(BST).
 * @author 2327942w
 * @param <E>
 */
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

            if (root == null){
                return 0;
            }else {
                return size;
            }
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
            Node<E> cont = new Node<E>(element);
            for (;;){

                //check the current node
                if (current == null){
                    return false;
                }else {
                    direction = cont.element.compareTo(current.element);
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
    public boolean equals(Bag<E> that) {
        //not very sure about this part,  equal should be same elements？ What about the order?

        Iterator<E> bag1 = this.iterator();
        Iterator<E> bag2 = that.iterator();
        if (!(this.size() == that.size())){
            return false;
        }

        while (bag1.hasNext() && bag2.hasNext()){

            if (!bag1.next().equals(bag2.next())){
                return false;
            }
        }
        return true;
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


    /**
     * add method:Add element to bag. increment the number of element items in the bag
     * @param element
     */
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
                current = parent.left;
            }else {//direction > 0
                current = parent.right;
            }
        }
    }

    // Remove it from this set.
    // Do nothing if no item in bag pertaining to element
    // otherwise decrement number of element items (lazy deletion)
    /**
     * delete an element:Remove it from this set.
     * Do nothing if no item in bag pertaining to element
     * otherwise decrement number of element items (lazy deletion)
     * @param element
     */
    @Override
    public void remove(E element) {
        int direction = 0;
        Node<E> current = root;
        Node<E> parent = null;
        Node<E> deleteNode = new Node<E>(element);
        //decrease the size
        size--;
        for (;;){
            if (current == null){
                return;
            }
            //call the compareto method
            direction = deleteNode.element.compareTo(current.element);

            if (direction == 0){
                int count = current.element.getCount();
                if (count >= 1){
                    count--;
                    current.element.setCount(count);
                    return;
                }
            }
//            parent = current;
            else  if (direction < 0 ){
                current = current.left;
            }else {
                current =current.right;
            }
        }


    }


    /**
     * iterator method: Return an iterator that will visit all members of this bag, in no particular order
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        //call a new class here
        //return the iterator object
        return new InOrderIterator();
    }


    /**
     * create a iterator object
     */
    private class InOrderIterator implements Iterator<E>{
        LinkedStack<Node<E>> stack;

        /**
         * private constructor
         */
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
               for (int i = 0; i < current.element.getCount(); i++){
                   stack.push(current);
               }
            }

            return place.element.getElement();

        }





    }


}
