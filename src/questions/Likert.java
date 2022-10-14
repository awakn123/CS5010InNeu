package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * The likert class, only accept 1,2,3,4,5 as answer.
 */
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

    /**
     * if answer is in the correct range return true.
     * @return
     */
    @Override
    public boolean checkAnswer() {
        return ANSWERS.contains(this.getAnswer());
    }

    /**
     * The likert would be placed at last.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Question o) {
        if (o instanceof Likert) {
            return this.getText().compareTo(o.getText());
        }
        return 1;
    }
}
