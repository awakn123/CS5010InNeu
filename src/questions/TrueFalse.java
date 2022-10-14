package questions;

/**
 * The true false question.
 */
public class TrueFalse extends AbstractQuestion {
    private static final String TRUE = "True";
    private static final String FALSE = "False";
    private String correctAnswer;

    public TrueFalse(String question, String correctAnswer) {
        super(question);
        if (!TRUE.equals(correctAnswer) && !FALSE.equals(correctAnswer)) {
            throw new IllegalArgumentException("The correct answer must be " + TRUE + " or " + FALSE + "!");
        }
        this.correctAnswer = correctAnswer;
    }

    /**
     * check whether equals with correct answer.
     * @return
     */
    @Override
    public boolean checkAnswer() {
        return this.correctAnswer.equals(this.getAnswer());
    }

    /**
     * true false will be place at the top.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Question o) {
        if (o instanceof TrueFalse) {
            return this.getText().compareTo(o.getText());
        }
        return -1;
    }
}
