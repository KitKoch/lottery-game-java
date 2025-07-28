package test.java.com.kitkoch;

import com.kitkoch.ThreeDigitsLotteryGame;
import com.kitkoch.ThreeDigitsLotteryGame.Rewards;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ThreeDigitsLotteryGameTest {

    @ParameterizedTest
    @CsvSource({
            "123, 123, MAX",
            "123, 132, MID",
            "123, 345, MIN",
            "123, 879, NONE"
    })
    void evaluateGuess_differentCases(String lottery, String guess, ThreeDigitsLotteryGame.Rewards expected) {
        assertEquals(expected, ThreeDigitsLotteryGame.evaluateGuess(lottery, guess));
    }
}