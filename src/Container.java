import java.util.Arrays;

public class Container<E> implements HWContainer<E>{

    private E[] arr;
    private int used=0;
    private int capacity=0;

    /**
     * No parameter constructor
     * Capacity is set to 10
     */
    public Container(){
        this.used=0;
        setCapacity(10);
    }

    /**
     * Constructor
     * @param capacity is container's capacity
     */
    public Container(int capacity){
        this.used = 0;
        setCapacity(capacity);
    }

    /**
     * Setter for capacity
     * @param capacity new capacity for container
     */
    private void setCapacity(int capacity) {
        if (capacity < 0)
            capacity = 10;

        E[] temp = (E[]) new Object[capacity];
        for (int i=0; i<size();i++)
            temp[i] = at(i);
        this.used = temp.length > size() ? size() : temp.length-1;
        arr = temp;
        this.capacity = capacity;
    }

    /**
     * Getter for capacity
     * @return capacity
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Fix the capacity
     */
    protected void fixCapacity(){
        if(size() == getCapacity())
            setCapacity(capacity*2);
    }

    /**
     * Returns the number of elements in the container
     * @return the number of element in the container
     */
    @Override
    public int size() {
        return used;
    }

    /**
     *
     * @return true if the container is empty
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * Add new element
     * @param e to be added element the container
     * @return true if the element is added
     */
    @Override
    public boolean add(E e) {
        if (e == null || contains(e) >= 0)
            return false;
        fixCapacity();
        arr[size()] = e;
        used++;
        return true;
    }

    /**
     * Remove element
     * @param e to be removed element the container
     * @return true if the element is removed
     */
    @Override
    public boolean remove(E e) {
        if (e == null || contains(e) == -1)
            return false;
        boolean flag = true;

        for (int i=0; i<size() && flag;i++)
            if (at(i).equals(e)){
                arr[i] = at(size()-1);
                flag = false;
            }
        used--;
        return true;
    }

    /**
     * Removes all element from the container
     */
    @Override
    public void clear() {
        arr = null;
        this.used = 0;
        setCapacity(10);
    }

    /**
     * Check if there is object in the container
     * @param o object whose presence in this collection is to be controlled
     * @return index if this container contains the object
     */
    @Override
    public int contains(Object o) {
        if (o == null)
            return -1;
        for (int i=0; i<size();i++)
            if (arr[i].equals(o))
                return i;
        return -1;
    }

    /**
     * Indexing
     * @param index of container
     * @return the element if index is valid
     * @throws ArrayIndexOutOfBoundsException if index is invalid
     */
    @Override
    public E at(int index) throws ArrayIndexOutOfBoundsException {
        if (index<0 || index>=size())
            throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Container))
            return false;

        Container<E> temp = (Container<E>) o;

        if (size() != temp.size())
            return false;

        for (int i=0; i < size(); i++)
            if (arr[i] != temp.arr[i])
                return false;

        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i=0; i<size();i++)
            str += arr[i] + "\n";
        return str;
    }
}
