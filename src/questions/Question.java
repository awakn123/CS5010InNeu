package questions;

/**
 * question interface
 */
public interface Question extends Comparable<Question> {

    /**
     * get question text.
     * @return
     */
    String getText();

    /**
     * answer the question and get whether it is correct.
     * @param answer
     * @return
     */
    String answer(String answer);
}
