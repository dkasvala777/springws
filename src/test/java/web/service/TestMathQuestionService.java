package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1Addition() {
        Assert.assertEquals(8.0, MathQuestionService.q1Addition("5", "3"), 0);
    }

    @Test
    public void testQ1AdditionInvalidInput() {
        Assert.assertNull(MathQuestionService.q1Addition("5", "abc"));
    }

    @Test
    public void testQ2Subtraction() {
        Assert.assertEquals(5.0, MathQuestionService.q2Subtraction("9", "4"), 0);
    }

    @Test
    public void testQ2SubtractionInvalidInput() {
        Assert.assertNull(MathQuestionService.q2Subtraction("9", "xyz"));
    }

    @Test
    public void testQ3Division() {
        Assert.assertEquals(3.0, MathQuestionService.q3Division("6", "2"), 0);
    }

    @Test
    public void testQ3DivisionInvalidInput() {
        Assert.assertNull(MathQuestionService.q3Division("6", "0")); // Assuming division by zero returns null
    }
}
