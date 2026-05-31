# Quiz App

A Java Swing quiz application for testing knowledge in IT, Mathematics, and Geography.

## Features
- Multiple choice and true/false questions
- Three difficulty levels: Easy, Medium, Hard
- Timer for each question
- Scoreboard with top results saved between sessions
- Settings (player name, resolution)
- Questions loaded from JSON file

## How to run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Make sure you have JDK 21 installed
4. Run `Main.java`

## Technologies
- Java 21
- Swing
- Gson 2.13.1

## Project structure
src/
├── Interface/  – Answerable, Saveable
├── Model/      – Question, MultipleChoiceQuestion, TrueFalseQuestion,
│                 Category, Player, QuizResult
├── Logic/      – QuizManager, QuestionBank, QuestionParser,
│                 ScoreBoard, Timer
└── Windows/    – MainFrame, MainMenuPanel, GamePanel, ResultPanel,
ScoreBoardWindow, SettingsFrame

## How to add a custom question

Open `src/resources/questions.json` and add a new entry to the JSON array.

### Multiple choice question
```json
{
    "type": "multiple",
    "text": "Your question here?",
    "category": "IT",
    "difficulty": "Easy",
    "timeLimit": 30,
    "options": [
        "Correct answer",
        "Wrong answer 1",
        "Wrong answer 2",
        "Wrong answer 3"
    ],
    "correctIndex": 0
}
```

### True/False question
```json
{
    "type": "truefalse",
    "text": "Your statement here.",
    "category": "IT",
    "difficulty": "Easy",
    "timeLimit": 20,
    "correctAnswer": true
}
```

### Rules
- `type` – `"multiple"` or `"truefalse"`
- `category` – `"IT"`, `"Mathematics"` or `"Geography"`
- `difficulty` – `"Easy"`, `"Medium"` or `"Hard"`
- `correctIndex` – index of the correct answer (0-3)
- `correctAnswer` – `true` or `false`
- Category and difficulty are case-sensitive!

## Design Patterns
- Observer – `Timer` notifies `GamePanel` via callbacks
- MVC – Model/Logic/Windows separation
- Factory – `QuestionParser` creates question objects

## Author
Kosmický Petr