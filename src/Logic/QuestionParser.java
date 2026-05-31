package Logic;

import Model.*;
import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses quiz questions from a JSON file.
 * Supports multiple choice and true/false question types.
 */
public class QuestionParser {

    /**
     * Parses questions from a JSON file and returns them as a list.
     * @param filePath path to the JSON file
     * @return list of parsed questions, empty list if file not found
     */
    public List<Question> parse(String filePath) {
        List<Question> questions = new ArrayList<>();

        try (Reader reader = new FileReader(filePath)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                Question question = parseQuestion(element.getAsJsonObject());
                if (question != null) {
                    questions.add(question);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Questions file not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading questions file: " + e.getMessage());
        }

        return questions;
    }

    /**
     * Parses a single question from a JsonObject.
     * Reads type, text, category, difficulty and timeLimit fields.
     * @param obj the JsonObject to parse
     * @return parsed Question or null if type is unknown or parsing fails
     */
    private Question parseQuestion(JsonObject obj) {
        try {
            String type = obj.get("type").getAsString();
            String text = obj.get("text").getAsString();
            String categoryName = obj.get("category").getAsString();
            String difficulty = obj.get("difficulty").getAsString();
            int timeLimit = obj.get("timeLimit").getAsInt();

            Category category = new Category(categoryName, "", "");

            if (type.equals("multiple")) {
                return parseMultipleChoice(obj, text, difficulty, category, timeLimit);
            } else if (type.equals("truefalse")) {
                return parseTrueFalse(obj, text, difficulty, category, timeLimit);
            } else {
                System.err.println("Unknown question type: " + type);
                return null;
            }

        } catch (Exception e) {
            System.err.println("Error parsing question: " + e.getMessage());
            return null;
        }
    }

    /**
     * Parses a multiple choice question from a JsonObject.
     * Reads options array and correctIndex fields.
     * @param obj the JsonObject containing question data
     * @param text question text
     * @param difficulty difficulty level
     * @param category question category
     * @param timeLimit time limit in seconds
     * @return MultipleChoiceQuestion object
     */
    private MultipleChoiceQuestion parseMultipleChoice(JsonObject obj, String text,
                                                       String difficulty, Category category, int timeLimit) {
        List<String> options = new ArrayList<>();
        for (JsonElement opt : obj.get("options").getAsJsonArray()) {
            options.add(opt.getAsString());
        }
        int correctIndex = obj.get("correctIndex").getAsInt();
        return new MultipleChoiceQuestion(text, difficulty, category, timeLimit, options, correctIndex);
    }

    /**
     * Parses a true/false question from a JsonObject.
     * Reads correctAnswer boolean field.
     * @param obj the JsonObject containing question data
     * @param text question text
     * @param difficulty difficulty level
     * @param category question category
     * @param timeLimit time limit in seconds
     * @return TrueFalseQuestion object
     */
    private TrueFalseQuestion parseTrueFalse(JsonObject obj, String text,
                                             String difficulty, Category category, int timeLimit) {
        boolean correctAnswer = obj.get("correctAnswer").getAsBoolean();
        return new TrueFalseQuestion(text, difficulty, category, timeLimit, correctAnswer);
    }
}