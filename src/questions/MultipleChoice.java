package questions;

import java.util.Arrays;
import java.util.List;

/**
 * The multiple choice class. options should be 3~8, and correct answer should be a number in string.
 */
public class MultipleChoice extends AbstractQuestionWithOptions {

    private int correctAnswer;

    public MultipleChoice(String question, String correctAnswer, List<String> options) {
        super(question, options);
        try {
            this.correctAnswer = Integer.parseInt(correctAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The correct answer does not exist!");
        }
        if (this.correctAnswer < 1 || this.correctAnswer > options.size()) {
            throw new IllegalArgumentException("The correct answer does not exist!");
        }
    }

    public MultipleChoice(String question, String correctAnswer, String... options) {
        this(question, correctAnswer, Arrays.asList(options));
    }

    /**
     * check answer equals with the correct answer.
     * @return
     */
    @Override
    public boolean checkAnswer() {
        int answer;
        try {
            answer = Integer.parseInt(this.getAnswer());
        } catch (NumberFormatException e) {
            return false;
        }
        return answer == this.correctAnswer;
    }

    /**
     * The multiple choice would be place at 2rd, only below True false.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Question o) {
        if (o instanceof MultipleChoice) {
            return this.getText().compareTo(o.getText());
        } else if (o instanceof TrueFalse) {
            return 1;
        }
        return -1;
    }
}
