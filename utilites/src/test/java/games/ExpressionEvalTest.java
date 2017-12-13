package games;

import game.card.ExpressionEvaluator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ExpressionEvalTest {

    @Test
    public void stringTo2Stacks() {
        String in = "1 + 2";
        Stack<Integer> exp = new Stack<>();
        exp.push(1);
        exp.push(2);
        Assert.assertEquals(exp, ExpressionEvaluator.numbers(in));

        Stack<String> expSymbols = new Stack<>();
        expSymbols.push("+");
        Assert.assertEquals(expSymbols, ExpressionEvaluator.operators(in, ExpressionEvaluator.operatorPredicate()));
    }
}
