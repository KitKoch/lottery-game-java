package com.kitkoch;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class TwoDigitsLotteryGame {

    public TwoDigitsLotteryGame(){}

    private static final int LOTTERY_SIZE = 100;
    private static final int DIGITS = 2;
    private static final String DIGIT_REGEX = "\\d{" + DIGITS + '}';
    private static final Pattern DIGIT_PATTERN = Pattern.compile(DIGIT_REGEX);

    public static final int PRIZE_MAX = 10_000;
    public static final int PRIZE_MID = 3_000;
    public static final int PRIZE_MIN = 1_000;


    public static String generateLottery() {
        int lottery = (int) (Math.random() * LOTTERY_SIZE);
        return "%02d".formatted(lottery);
    }

    private static String userPrompt(Scanner input, String msg) {
        while(true) {
            System.out.print(msg);
            if(input.hasNext()) {
                String guess = input.nextLine().trim();
                if(DIGIT_PATTERN.matcher(guess).matches()) {
                    return guess;
                }
                System.out.println("Invalid entry");
            } else {
                System.out.println("Invalid entry");
                input.next();
            }
        }
    }

    public static int evaluateGuess(String lottery, String guess) {
        if(lottery.equals(guess)) {
            return PRIZE_MAX;
        }

        if(lottery.charAt(0) == guess.charAt(1) && lottery.charAt(1) == guess.charAt(0)) {
            return PRIZE_MID;
        }

        if(lottery.indexOf(guess.charAt(0)) >= 0 || lottery.indexOf(guess.charAt(1)) >= 0) {
            return PRIZE_MIN;
        }
        return 0;
    }

    private static void announceResult(int prize, String lotteryNum) {
        System.out.println("Lottery number: " + lotteryNum);
        if(prize == 0) {
            System.out.println("Sorry no match");
        } else {
            System.out.printf("You win $%,d%n", prize);
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String lottery = generateLottery();
            String guess = userPrompt(input, "Enter your lottery pick (" + DIGITS + " digits 00-" + (LOTTERY_SIZE - 1) + "): ");
            int prize = evaluateGuess(lottery, guess);
            announceResult(prize, lottery);
        }
    }
}
