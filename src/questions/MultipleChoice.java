package questions;

import java.util.List;

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
