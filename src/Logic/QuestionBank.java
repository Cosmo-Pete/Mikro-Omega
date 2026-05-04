package Logic;

import Interface.Saveable;
import Model.Category;
import Model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank implements Saveable {

    private List<Question> allQuestions;

    public QuestionBank() {
        this.allQuestions = new ArrayList<>();
    }

    // Přidávání otázek
    public void addQuestion(Question question) {
        // TODO: Implementace
    }

    public void removeQuestion(Question question) {
        // TODO: Implementace
    }

    // Filtrování
    public List<Question> getByCategory(Category category) {
        return new ArrayList<>();
    }

    public List<Question> getByDifficulty(String difficulty) {
        return new ArrayList<>();
    }

    public List<Question> getByCategoryAndDifficulty(Category category, String difficulty) {
        return new ArrayList<>();
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

    // Pomocné
    public int getTotalCount() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }
}