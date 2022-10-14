package questions;

/**
 * abstract question class, store text, whether is correct, answer, and provide default answer logic.
 */
public abstract class AbstractQuestion implements Question {

    private String text;

    private boolean isCorrect;

    private String answer;

    private static final String CORRECT = "Correct";

    private static final String IN_CORRECT = "Incorrect";

    public AbstractQuestion(String question) {
        this.text = question;
    }

    @Override
    public String getText() {
        return this.text;
    }


    /**
     * answer function that provides default logic
     * @param answer
     * @return
     */
    @Override
    public String answer(String answer) {
        this.answer = answer;
        this.isCorrect = checkAnswer();
        return isCorrect ? CORRECT : IN_CORRECT;
    }

    public String getAnswer() {
        return answer;
    }

    /**
     * function for implementing class, check whether answer is right.
     * @return
     */
    public abstract boolean checkAnswer();

}
