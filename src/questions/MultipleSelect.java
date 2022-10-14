package questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleSelect extends AbstractQuestionWithOptions {

    private List<Integer> correctAnswers;

    public MultipleSelect(String question, String correctAnswer, List<String> options) {
        super(question, options);
        try {
            correctAnswers = Arrays.stream(correctAnswer.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The correct answer does not exist!");
        }

        if (correctAnswers.size() != correctAnswers.stream().distinct().count()) {
            throw new IllegalArgumentException("The correct answer duplicates!");
        }
    }

    @Override
    public boolean checkAnswer() {
        if (this.getAnswer() == null)
            return false;
        String[] answers = this.getAnswer().split(" ");
        List<Integer> answerInts;
        try {
            answerInts = Arrays.stream(answers).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return false;
        }

        if (answerInts.size() != answerInts.stream().distinct().count()) {
            return false;
        }
        if (answerInts.size() != correctAnswers.size()) {
            return false;
        }
        return answerInts.stream().allMatch(answer -> correctAnswers.contains(answer));
    }

    @Override
    public int compareTo(Question o) {
        if (o instanceof MultipleSelect) {
            return this.getText().compareTo(o.getText());
        } else if (o instanceof Likert) {
            return -1;
        }
        return 1;
    }
}
