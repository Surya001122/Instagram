package postSection;
import user.User;

import java.util.ArrayList;

public abstract class Section<T>{
    ArrayList<T> postSection;

    public Section() {
        this.postSection = new ArrayList<>();
    }

    abstract void add(T data);
    abstract void delete(T data);
    abstract T get(User user, int id);

    public ArrayList<T> getPostSection() {
        return new ArrayList<T>(postSection);
    }
}
