package Logic;

import Interface.Saveable;
import Model.Category;
import Model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionBank implements Saveable {

    private List<Question> allQuestions;

    public QuestionBank() {
        this.allQuestions = new ArrayList<>();
    }

    /**
     * adding question to the List
     * @param question
     */
    public void addQuestion(Question question) {
        allQuestions.add(question);
    }

    /**
     * removing question from the List
     * @param question
     */
    public void removeQuestion(Question question) {
        allQuestions.remove(question);
    }

    /**
     *
      * @param categoryName name of the category
     * @return returns any matching category names from the List
     */
    public List<Question> getByCategory(String categoryName) {
        return allQuestions.stream()
                .filter(c -> c.getCategory().getName().equals(categoryName))
                .toList();
    }

    /**
     *
     * @param difficulty difficulty of the question
     * @return returns any matching difficulty with the one were searching for
     */
    public List<Question> getByDifficulty(String difficulty) {
        return allQuestions.stream()
                .filter(d -> d.getDifficulty().equals(difficulty))
                .toList();
    }

    /**
     *
     * @param categoryName name of the category
     * @param difficulty difficulty of the question
     * @return combination of getByDifficulty and getByCategory
     */
    public List<Question> getByCategoryAndDifficulty(String categoryName, String difficulty) {
        return allQuestions.stream()
                .filter(c -> c.getCategory().getName().equals(categoryName))
                .filter(d -> d.getDifficulty().equals(difficulty))
                .toList();
    }

    public List<Question> getRandomQuestions(int count) {
        return new ArrayList<>();
    }

    // Saveable
    @Override
    public void save(String filePath) {
        // TODO: Implementace
    }

    @Override
    public void load(String filePath) {
        // TODO: Implementace
    }


    public int getTotalCount() {
        return allQuestions.size();
    }

    public boolean isEmpty() {
        return allQuestions.isEmpty();
    }
}