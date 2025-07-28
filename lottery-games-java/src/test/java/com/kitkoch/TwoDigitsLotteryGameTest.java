package test.java.com.kitkoch;

import com.kitkoch.TwoDigitsLotteryGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoDigitsLotteryGameTest {

    @ParameterizedTest
    @CsvSource({
            "12, 12, 10000",
            "12, 21, 3000",
            "12, 18, 1000",
            "12, 87, 0"
    })
    void evaluateGuess_differentCases(String lottery, String guess, int expected) {
        assertEquals(expected, TwoDigitsLotteryGame.evaluateGuess(lottery, guess));
    }
}