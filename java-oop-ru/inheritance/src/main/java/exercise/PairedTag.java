package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag  extends Tag{
    private String body;
    private List<Tag> children;
    PairedTag(String name, Map<String, String> attr, String body, List<Tag> children) {
        super(name, attr);
        this.body = body;
        this.children = children;
    }

    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("<")
            .append(getName())
                .append(attributesToString())
                .append(">")
                .append(body);
        for(Tag tag: children) {
            text.append(tag);
        }
        text.append("</").append(getName()).append(">");
        return text.toString();
    }
}
// END
