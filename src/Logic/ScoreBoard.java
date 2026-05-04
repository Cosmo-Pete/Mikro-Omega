package Logic;

import Interface.Saveable;
import Model.QuizResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreBoard implements Saveable {

    private List<QuizResult> results;
    private int maxEntries;             // max počet záznamů (např. top 10)

    public ScoreBoard(int maxEntries) {
        this.results = new ArrayList<>();
        this.maxEntries = maxEntries;
    }

    // Správa výsledků
    public void addResult(QuizResult result) {
        // TODO: Implementace
    }

    public void clearAll() {
        // TODO: Implementace
    }

    // Získání výsledků
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
    public int getTotalEntries() {
        return 0;
    }

    private void sortResults() {
        // TODO: Implementace
    }
}