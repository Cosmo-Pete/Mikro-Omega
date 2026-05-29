rozvržění tříd : 
src/
├── Windows/     – MainFrame, MainPanel, OknoNastaveni,
│                  MainMenuPanel, GamePanel, ResultPanel,
│                  ScoreBoardWindow
├── Model/       – Question, MultipleChoiceQuestion,
│                  TrueFalseQuestion, Category, Player, QuizResult
├── Logic/       – QuizManager, Timer, ScoreBoard, QuestionBank
└── Interface/   – Answerable, Saveable

Vyzkoušeno nastavování vlastního rozlišení : vyhodnoceno jako nepotřebné

# Quiz App

A Java Swing quiz application for testing knowledge in IT, Mathematics, and Geography.

## Features
- Multiple choice and true/false questions
- Three difficulty levels: Easy, Medium, Hard
- Timer for each question
- Scoreboard with top results
- Settings (resolution, player name)

## How to run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run `Main.java`

## Technologies
- Java 21
- Swing
- Gson 2.13.1

## Project structure
- `Interface` – Answerable, Saveable
- `Model` – Question, Player, Category, QuizResult
- `Logic` – QuizManager, QuestionBank, ScoreBoard, Timer
- `Windows` – MainFrame, MainMenuPanel, GamePanel, ResultPanel, ScoreBoardWindow, SettingsFrame

## Author
Kosmický Petr
