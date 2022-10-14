package questions;

import java.util.ArrayList;
import java.util.List;

public class Likert extends AbstractQuestion {

    private static List<String> ANSWERS = new ArrayList<>();

    static {
        ANSWERS.add("1");
        ANSWERS.add("2");
        ANSWERS.add("3");
        ANSWERS.add("4");
        ANSWERS.add("5");
    }

    public Likert(String question) {
        super(question);
    }

    @Override
    public boolean checkAnswer() {
        return ANSWERS.contains(this.getAnswer());
    }

    @Override
    public int compareTo(Question o) {
        if (o instanceof Likert) {
            return this.getText().compareTo(o.getText());
        }
        return 1;
    }
}
