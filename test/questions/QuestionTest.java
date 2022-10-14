package questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * test All Question functions in all classes.
 */
public class QuestionTest {

    public static final String NEW_QUESTION_TEXT = "A new question";
    public static final String CORRECT = "Correct";
    public static final String IN_CORRECT = "Incorrect";

    private static List<String> generateOptions() {
        List<String> options = new ArrayList<>();
        options.add("Option 1");
        options.add("Option 2");
        options.add("Option 3");
        return options;
    }

    /**
     * test Get Question
     */
    @Test
    public void getText() {
        Question question = new Likert(NEW_QUESTION_TEXT);
        Assert.assertEquals(NEW_QUESTION_TEXT, question.getText());
    }

    /**
     * test likert answer function.
     * confirm right and wrong situation.
     */
    @Test
    public void answerLikert() {
        Question question = new Likert(NEW_QUESTION_TEXT);
        Assert.assertEquals(CORRECT, question.answer("1"));
        Assert.assertEquals(IN_CORRECT, question.answer(""));
    }

    /**
     * test create multiple choice.
     * 1. 2 Options -> Exception.
     * 2. 3 Options with correctResult A -> Exception
     * 3. 3 Options with correctResult 4 -> Exception
     * 4. 3 Options with correctResult 3 -> Worked
     */
    @Test
    public void createMultipleChoice() {
        List<String> options = new ArrayList<>();
        options.add("Option 1");
        options.add("Option 2");
        Assert.assertThrows(IllegalArgumentException.class, () -> new MultipleChoice(NEW_QUESTION_TEXT, "1", options));
        options.add("Option 3");
        Assert.assertThrows(IllegalArgumentException.class, () -> new MultipleChoice(NEW_QUESTION_TEXT, "A", options));
        Assert.assertThrows(IllegalArgumentException.class, () -> new MultipleChoice(NEW_QUESTION_TEXT, "4", options));
        Question question = new MultipleChoice(NEW_QUESTION_TEXT, "3", options);
        Assert.assertNotNull(question);
    }

    /**
     * create 3 options' multiple choice with correct answer 3.
     * answer "A" -> incorrect.
     * answer "4" -> incorrect.
     * answer "3" -> correct.
     * answer "1" -> incorrect.
     */
    @Test
    public void answerMultipleChoice() {
        List<String> options = generateOptions();
        Question question = new MultipleChoice(NEW_QUESTION_TEXT, "3", options);
        Assert.assertEquals(IN_CORRECT, question.answer("A"));
        Assert.assertEquals(IN_CORRECT, question.answer("4"));
        Assert.assertEquals(CORRECT, question.answer("3"));
        Assert.assertEquals(IN_CORRECT, question.answer("1"));
    }

    /**
     * create multiple select.
     * 1. 3 options with answer "A" -> exception;
     * 2. 3 options with answer "3 3" -> exception;
     * 3. 3 options with answer "1 3" -> worked.
     * 4. 3 options with answer "3 4" -> exception;
     */
    @Test
    public void createMultipleSelect() {
        List<String> options = generateOptions();
        Assert.assertThrows(IllegalArgumentException.class, () -> new MultipleSelect(NEW_QUESTION_TEXT, "A", options));
        Assert.assertThrows(IllegalArgumentException.class, () -> new MultipleSelect(NEW_QUESTION_TEXT, "3 3", options));
        Question question = new MultipleSelect(NEW_QUESTION_TEXT, "1 3", options);
        Assert.assertNotNull(question);
        Assert.assertThrows(IllegalArgumentException.class, () -> new MultipleSelect(NEW_QUESTION_TEXT, "3 4", options));
    }

    /**
     * create multiple select with 3 options and answer 1 3.
     * 1. answer "A" -> Incorrect;
     * 2. answer "3 3" -> Incorrect;
     * 3. answer "3" -> Incorrect;
     * 4. answer "1 3" -> Correct
     * 5. answer null -> Incorrect;
     */
    @Test
    public void answerMultipleSelect() {
        List<String> options = generateOptions();
        Question question = new MultipleSelect(NEW_QUESTION_TEXT, "1 3", options);
        Assert.assertEquals(IN_CORRECT, question.answer("A"));
        Assert.assertEquals(IN_CORRECT, question.answer("3 3"));
        Assert.assertEquals(IN_CORRECT, question.answer("3"));
        Assert.assertEquals(CORRECT, question.answer("1 3"));
        Assert.assertEquals(IN_CORRECT, question.answer(null));
    }

    /**
     * create true false with answer "A" -> exception;
     * create true false with answer "True" -> worked.
     */
    @Test
    public void createTrueFalse() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new TrueFalse(NEW_QUESTION_TEXT, "A"));
        Question question = new TrueFalse(NEW_QUESTION_TEXT, "True");
        Assert.assertNotNull(question);
    }

    /**
     * create true false with correct answer "True";
     * answer "A", incorrect;
     * answer "True", correct;
     * answer "False", incorrect;
     */
    @Test
    public void answerTrueFalse() {
        Question question = new TrueFalse(NEW_QUESTION_TEXT, "True");
        Assert.assertEquals(IN_CORRECT, question.answer("A"));
        Assert.assertEquals(CORRECT, question.answer("True"));
        Assert.assertEquals(IN_CORRECT, question.answer("False"));
    }

    /**
     * test comparable.
     * true false must be the first.
     * multiple choice must be the second.
     * multiple select must be the 3rd;
     * likert must be the forth;
     * and same type would be ordered by text;
     */
    @Test
    public void sort() {
        Question trueFalse = new TrueFalse(NEW_QUESTION_TEXT, "True");
        Question trueFalse2 = new TrueFalse(NEW_QUESTION_TEXT + "2", "True");
        Question multipleSelect = new MultipleSelect(NEW_QUESTION_TEXT, "1 3", generateOptions());
        Question multipleSelect2 = new MultipleSelect(NEW_QUESTION_TEXT + "2", "1 3", generateOptions());
        Question multipleChoice = new MultipleChoice(NEW_QUESTION_TEXT, "3", generateOptions());
        Question multipleChoice2 = new MultipleChoice(NEW_QUESTION_TEXT + "2", "3", generateOptions());
        Question likert = new Likert(NEW_QUESTION_TEXT);
        Question likert2 = new Likert(NEW_QUESTION_TEXT + "2");
        Question[] questions = new Question[]{trueFalse2, multipleChoice, multipleSelect2, multipleSelect, multipleChoice2, trueFalse, likert2, likert};
        Arrays.sort(questions);
        Assert.assertSame(trueFalse, questions[0]);
        Assert.assertSame(trueFalse2, questions[1]);
        Assert.assertSame(multipleChoice, questions[2]);
        Assert.assertSame(multipleChoice2, questions[3]);
        Assert.assertSame(multipleSelect, questions[4]);
        Assert.assertSame(multipleSelect2, questions[5]);
        Assert.assertSame(likert, questions[6]);
        Assert.assertSame(likert2, questions[7]);
    }
}