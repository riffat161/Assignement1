import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class GenericStackArray <E> implements GenericStack<E>{
    private int maxSize;
    private E[] array;
    private int top;

    public GenericStackArray(int maxSize) {
        this.maxSize = maxSize;
//        @SuppressWarnings("unchecked")
        this.array = (E[]) Array.newInstance(GenericStackArray.class, maxSize);
        this.top = -1;
    }

    private E[] resizeArray() {
        /**
         * create a new array double the size of the old, copy the old elements then return the new array */
        int newSize = maxSize * 2;
        E[] newArray = (E[]) Array.newInstance(GenericStackArray.class, newSize);
        for(int i = 0; i < maxSize; i++) {
            newArray[i] = this.array[i];
        }
        return newArray;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public void push(E element) {
        if(!this.isFull()) {
            ++top;
            array[top] = element;
        }
        else {
            this.array = resizeArray();
            array[++top] = element;
        }
    }

    public E pop() {
        if(!this.isEmpty())
            return array[top--];
        else {
            throw new EmptyStackException();
        }
    }

    
}