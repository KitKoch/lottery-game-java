# Lottery Games (Java)

A tiny collection of console lottery games written in Java 
(2‑digit and 3‑digit versions) with unit tests using JUnit 5.

## Features
- Two lottery variants: 2-digit and 3-digit
- Input validation
- Unit tests (JUnit 5 + Parameterized tests)

## Project Structure
lottery-games-java/
├─ src/
│   ├─ main/
│   │   └─ java/
│   │       └─ com
│   │           └─ kitkoch
│   │               ├─ TwoDigitsLotteryGame.java
│   │               └─ ThreeDigitsLotteryGame.java
│   ├─ test/
│   │   └─ java/
│   │       └─ com
│   │           └─ kitkoch
│   │               ├─ TwoDigitsLotteryGameTest.java
│   │               └─ ThreeDigitsLotteryGameTest.java
├─ .gitignore
├─ build.gradle
├─ LICENSE.md
├─ README.md
└─ settings.gradle

## Run

```bash
# Clone
git clone https://github.com/KitKoch/lottery-game-java.git
cd lottery-games-java

# Build & Run Tests
./gradlew clean test