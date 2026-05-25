package Logic;

import Interface.Saveable;
import Model.QuizResult;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard implements Saveable {

    private List<QuizResult> results;
    private int maxEntries;

    /**
     * Creates a new ScoreBoard with a maximum number of entries.
     * @param maxEntries maximum number of results to store
     */
    public ScoreBoard(int maxEntries) {
        this.results = new ArrayList<>();
        this.maxEntries = maxEntries;
    }

    public void addResult(QuizResult result) {
        // TODO
    }

    public void clearAll() {
        // TODO
    }

    public List<QuizResult> getTopResults() {
        return new ArrayList<>();
    }

    public List<QuizResult> getTopResults(int count) {
        return new ArrayList<>();
    }

    public List<QuizResult> getResultsByPlayer(String playerName) {
        return new ArrayList<>();
    }

    public QuizResult getBestResult() {
        return null;
    }

    /**
     * Returns a list of all unique category names from results.
     * @return list of category names
     */
    public List<String> getAvailableCategories() {
        return results.stream()
                .map(r -> r.getCategory().getName())
                .distinct()
                .toList();
    }

    public int getTotalEntries() {
        return results.size();
    }

    private void sortResults() {
        // TODO
    }

    @Override
    public void save(String filePath) {
        // TODO
    }

    @Override
    public void load(String filePath) {
        // TODO
    }
}