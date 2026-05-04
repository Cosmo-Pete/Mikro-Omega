package Interface;

public interface Answerable {
    boolean checkAnswer(Object answer);
    Object getCorrectAnswer();
    String getQuestionText();
}
