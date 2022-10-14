package questions;

import java.util.List;

public abstract class AbstractQuestionWithOptions extends AbstractQuestion {
    private List<String> options;

    public AbstractQuestionWithOptions(String question, List<String> options) {
        super(question);
        if (options.size() > 8 || options.size() < 3) {
            throw new IllegalArgumentException("There should be 3~8 options!");
        }
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }
}
