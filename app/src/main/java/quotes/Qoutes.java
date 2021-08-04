package quotes;

import java.util.ArrayList;

public class Qoutes {
    ArrayList<String> tags;
    String author;
    String likes;
    String text;

    public Qoutes(ArrayList<String> tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Qoutes{" +
                "tags=" + tags +
                ", author='" + author + '\'' +
                ", likes='" + likes + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
