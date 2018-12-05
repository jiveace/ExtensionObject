package subjects;

import java.util.List;

public class Assembly extends Part{
    public List<Part> subParts;

    public Assembly(String name, Long partNumber, List<Part> subParts) {
        super(name, partNumber);
        this.subParts = subParts;
    }
}
