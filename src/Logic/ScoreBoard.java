package Logic;

import Interface.Saveable;
import Model.QuizResult;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreBoard implements Saveable {

    private List<QuizResult> results;
    private int maxEntries;

    public ScoreBoard(int maxEntries) {
        this.results = new ArrayList<>();
        this.maxEntries = maxEntries;
    }

    /**
     * Adds a result to the scoreboard and sorts it.
     * If maxEntries is exceeded, removes the last entry.
     * @param result the result to add
     */
    public void addResult(QuizResult result) {
        results.add(result);
        sortResults();
        if (results.size() > maxEntries) {
            results.remove(results.size() - 1);
        }
    }

    /**
     * Clears all results from the scoreboard.
     */
    public void clearAll() {
        results.clear();
    }


    /**
     * Returns top N results sorted by score.
     * @param count number of results to return
     * @return list of top results
     */
    public List<QuizResult> getTopResults(int count) {
        return results.subList(0, Math.min(count, results.size()));
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

    /**
     * Sorts results by score in descending order.
     */
    private void sortResults() {
        results.sort(Comparator.comparingInt(QuizResult::getScore).reversed());
    }

    /**
     * Saves results to a file using serialization.
     * @param filePath path to the file
     */
    @Override
    public void save(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            oos.writeObject(results);
        } catch (IOException e) {
            System.err.println("Error saving scoreboard: " + e.getMessage());
        }
    }

    /**
     * Loads results from a file using serialization.
     * @param filePath path to the file
     */
    @Override
    @SuppressWarnings("unchecked")
    public void load(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {
            results = (List<QuizResult>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Scoreboard file not found: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading scoreboard: " + e.getMessage());
        }
    }
}