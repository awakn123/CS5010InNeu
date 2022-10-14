package questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The multiple class.
 */
public class MultipleSelect extends AbstractQuestionWithOptions {

    private List<Integer> correctAnswers;

    /**
     * Receive correct answe split by space.
     * @param question
     * @param correctAnswer
     * @param options
     */
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

        if (!correctAnswers.stream().allMatch(ans -> ans >= 1 && ans <= options.size())) {
            throw new IllegalArgumentException("The correct answer does not exist!");
        }
    }

    public MultipleSelect(String question, String correctAnswer, String... options) {
        this(question, correctAnswer, Arrays.asList(options));
    }

    /**
     * only when answer is equals with correct answer it would be true.
     * @return
     */
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

    /**
     * Multiple Select will be placed at the 3rd, only above likert.
     * @param o the object to be compared.
     * @return
     */
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
