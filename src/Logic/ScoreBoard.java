package Logic;

import Interface.Saveable;
import Model.QuizResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard implements Saveable {

    private List<QuizResult> results;
    private int maxEntries;             // max entries for example 10;

    public ScoreBoard(int maxEntries) {
        this.results = new ArrayList<>();
        this.maxEntries = maxEntries;
    }

    // Správa výsledků
    public void addResult(QuizResult result) {
        results.add(result);
        sortResults();
        if (results.size()>maxEntries){
            results.removeLast();
        }
    }

    public void clearAll() {
        results.clear();
    }

    public List<QuizResult> getTopResults(int count) { //returns n best results
        int to = Math.min(count, results.size());
        return new ArrayList<>(results.subList(0, to));
    }

    /**
     *
     * @param playerName
     * @return results from the player by name
     */
    public List<QuizResult> getResultsByPlayer(String playerName) {
        return results.stream()
                .filter(r -> r.getPlayer().equals(playerName)) //gets player from the result and compares gim to the player were searching for
                .collect(Collectors.toList()); //saves them to a new list
    }

    public QuizResult getBestResult() {
        if (results.isEmpty()){
            return null;
        }
        return results.getFirst();
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


    public int getTotalEntries() {
        return 0;
    }

    private void sortResults() {
        results.sort(Comparator.comparingInt(QuizResult::getScore).reversed()); // sorting results from best to worst

    }
}