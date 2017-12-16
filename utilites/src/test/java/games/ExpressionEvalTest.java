package games;

import game.card.ExpressionEvaluator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

import static game.card.ExpressionEvaluator.simplePostfixEval;

public class ExpressionEvalTest {

    @Test
    public void prnTest() {
        Assert.assertEquals(new Integer(60), simplePostfixEval("1 2 + 4 6 + * 10 2 * + 10 +"));
    }

    @Test
    public void stringTo2Stacks() {
        String in = "(1+2+3+4)*(10+0)";
        Stack<Integer> exp = new Stack<>();
        exp.push(1);
        exp.push(2);
        // Assert.assertEquals(exp, ExpressionEvaluator.numbers(in));

        Stack<String> expSymbols = new Stack<>();
        expSymbols.push("(");
        expSymbols.push("+");
        expSymbols.push(")");
        // Assert.assertEquals(expSymbols, ExpressionEvaluator.operators(in));
        ExpressionEvaluator.SResult p1 = ExpressionEvaluator.doMath(
                ExpressionEvaluator.numbers(in),
                ExpressionEvaluator.operators(in)
        );

        ExpressionEvaluator.SResult p2 = ExpressionEvaluator.doMath(
                p1.otherRs,
                p1.otherOps
        );
        ExpressionEvaluator.SResult merge = p1.merge(p2);
        Assert.assertEquals(new Integer(100), ExpressionEvaluator.simple(
                merge.rs, merge.ops
        ));

    }
}
