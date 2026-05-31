package Logic;

import Interface.Saveable;
import Model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBank implements Saveable {

    // List of all loaded questions
    private List<Question> allQuestions;

    /**
     * Creates an empty question bank.
     */
    public QuestionBank() {
        this.allQuestions = new ArrayList<>();
    }
    /**
     * Returns all questions matching the given difficulty.
     * @param difficulty difficulty level to filter by
     * @return list of questions with the given difficulty
     */
    public List<Question> getByDifficulty(String difficulty) {
        return allQuestions.stream()
                .filter(q -> q.getDifficulty().equals(difficulty))
                .toList();
    }

    /**
     * Returns all questions matching both category and difficulty.
     * @param categoryName name of the category to filter by
     * @param difficulty difficulty level to filter by
     * @return list of matching questions
     */
    public List<Question> getByCategoryAndDifficulty(String categoryName, String difficulty) {
        return allQuestions.stream()
                .filter(q -> q.getCategory().getName().equals(categoryName))
                .filter(q -> q.getDifficulty().equals(difficulty))
                .toList();
    }

    /**
     * Saves questions to a file.
     * Not yet implemented.
     * @param filePath path to the file
     */
    @Override
    public void save(String filePath) {
        // TODO: Implementace
    }

    /**
     * Loads questions from a JSON file using QuestionParser.
     * @param filePath path to the JSON file
     */
    @Override
    public void load(String filePath) {
        QuestionParser parser = new QuestionParser();
        allQuestions = parser.parse(filePath);
    }
}