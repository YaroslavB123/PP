package Task3;

import java.util.List;
import java.util.ArrayList;

public class Mark {
    public List<Integer> mark = new ArrayList<>();

    public Mark(final List<Integer> list) {
        this.mark = list;
    }

    public Mark() {

    }
    public List<Integer> getMark() {
        return mark;
    }

    public void setMark(final List<Integer> mark) {
        this.mark = mark;
    }

}
