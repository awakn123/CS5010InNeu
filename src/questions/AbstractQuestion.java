package questions;

public abstract class AbstractQuestion implements Question{

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


    @Override
    public String answer(String answer) {
        this.answer = answer;
        this.isCorrect = checkAnswer();
        return isCorrect ? CORRECT : IN_CORRECT;
    }

    public String getAnswer() {
        return answer;
    }

    public abstract boolean checkAnswer();

}
