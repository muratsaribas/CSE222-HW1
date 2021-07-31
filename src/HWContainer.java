/**
 * Generic interface
 * @param <E> the type of elements stored by this container
 */
public interface HWContainer<E>{
    int size();
    boolean isEmpty();
    boolean add(E e);
    boolean remove(E e);
    void clear();
    int contains(Object o);
    E at(int index) throws ArrayIndexOutOfBoundsException;
}
