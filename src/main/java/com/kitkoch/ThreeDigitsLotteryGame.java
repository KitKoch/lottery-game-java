package com.kitkoch;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public final class ThreeDigitsLotteryGame {

    private ThreeDigitsLotteryGame(){}

    public enum Rewards {
        MAX(10_0000),
        MID(3_000),
        MIN(1_000),
        NONE(0);

        private final int rewardAmount;

        Rewards(int rewardAmount) {
            this.rewardAmount = rewardAmount;
        }

        public int amount() {
            return rewardAmount;
        }
    }

    private static final int DIGITS = 3;

    private static final int LOTTERY_SIZE = (int) Math.pow(10, DIGITS);

    private static final String DIGIT_REGEX = "\\d{" + DIGITS + "}";

    private static String userPromptStr(Scanner input, String msg) {
        while(true) {
            System.out.print(msg);
            if(input.hasNextLine()) {
                String raw = input.nextLine().trim();
                if(raw.matches(DIGIT_REGEX)) {
                    return raw;
                }
                System.out.println("Please enter 3 numbers");
            }
        }
    }

    public static String generateLottery() {
        int lottery = ThreadLocalRandom.current().nextInt(LOTTERY_SIZE);
        return String.format("%03d", lottery);
    }

    private static boolean haveSameDigits(String lottery, String userLottery) {
        char[] a = lottery.toCharArray();
        char[] b = userLottery.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    private static boolean shareAnyDigit(String lottery, String userLottery) {
        for(char digit : userLottery.toCharArray()) {
            if(lottery.indexOf(digit) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static Rewards evaluateGuess(String lottery, String userLottery) {
        if(lottery.equals(userLottery)) {
            return Rewards.MAX;
        }
        if(haveSameDigits(lottery, userLottery)) {
            return Rewards.MID;
        }
        if(shareAnyDigit(lottery, userLottery)) {
            return Rewards.MIN;
        }
        return Rewards.NONE;
    }

    private static void announceResults(Rewards reward, String lottery) {
        System.out.printf("Lottery number: %s%n", lottery);
        if(reward == Rewards.NONE) {
            System.out.println("Sorry no match");
        } else {
            System.out.printf("You win %s%n", reward.amount());
        }
    }

    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)) {
            String lottery = generateLottery();
            String userLottery = userPromptStr(input, "Enter a three-digit integer: ");
            Rewards reward = evaluateGuess(lottery, userLottery);
            announceResults(reward, lottery);
        }
    }

}
