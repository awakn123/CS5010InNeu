package questions;

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

    @Override
    public boolean checkAnswer() {
        return this.correctAnswer.equals(this.getAnswer());
    }

    @Override
    public int compareTo(Question o) {
        if (o instanceof TrueFalse) {
            return this.getText().compareTo(o.getText());
        }
        return -1;
    }
}
