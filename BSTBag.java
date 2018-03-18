import javax.xml.soap.Node;
import java.util.Iterator;

public class BSTBag<E extends Comparable<E>> implements Bag<E> {

    Node<E> root;

    private int size;
    /**
     * Constructor
     */
    public BSTBag(){
        root = null;
        size = 0;
    }

    public static class Node<E extends Comparable<E>>{
        protected CountedElement<E> element;
        protected Node<E> left;
        protected Node<E> right;
        protected int count;

        protected Node(E element){
            this.element = new CountedElement<E>(element);
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
        return false;
    }

    /**
     *  Return true if and only if this bag is equal to that.
     * @param that
     * @return
     */
    @Override
    public boolean equals(Bag<E> that) {
        return false;
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
        for (;;){
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

            direction = newNode.element.compareTo(current.element);

            if (direction == 0){
                
            }

        }




    }

    @Override
    public void remove(E element) {

    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
