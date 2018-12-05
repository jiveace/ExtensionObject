package subjects;

import extensions.PartExtension;

import java.util.HashMap;

public class Part {

    private String name;
    private Long partNumber;
    private HashMap<String, PartExtension> extensions;

    public Part(String name, Long partNumber) {
        this.name = name;
        this.partNumber = partNumber;
        extensions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Long getPartNumber() {
        return partNumber;
    }

    public HashMap<String, PartExtension> getExtensions() {
        return extensions;
    }

    public void setExtensions(HashMap<String, PartExtension> extensions) {
        this.extensions = extensions;
    }
}
