import java.util.ArrayList;

public class Media<T>{
    private ArrayList<T> elements;

    public Media() {
        this.elements = new ArrayList<>();
    }

    T get(int i){
        return elements.get(i);
    }

    void set(T object){
        elements.add(object);
    }

}
