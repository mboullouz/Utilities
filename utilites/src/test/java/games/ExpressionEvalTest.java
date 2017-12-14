package games;

import game.card.ExpressionEvaluator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ExpressionEvalTest {

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

       /* Assert.assertEquals(new Integer(20), ExpressionEvaluator.doMath(
                ExpressionEvaluator.numbers(in),
                ExpressionEvaluator.operators(in)
        )); */
        /*Assert.assertEquals(new ExpressionEvaluator.SResult(
                ExpressionEvaluator.numbers("(1+2+3+4)*(4+6)"),
                ExpressionEvaluator.operators(in)
        ), new ExpressionEvaluator.SResult(
                ExpressionEvaluator.numbers(in),
                ExpressionEvaluator.operators(in)
        ));*/
        ExpressionEvaluator.SResult p1 = ExpressionEvaluator.doMath(
                ExpressionEvaluator.numbers(in),
                ExpressionEvaluator.operators(in)
        );
//        Assert.assertEquals(p1, new ExpressionEvaluator.SResult(
//                ExpressionEvaluator.numbers("10"),
//                ExpressionEvaluator.operators("*")
//        ));

        ExpressionEvaluator.SResult p2 = ExpressionEvaluator.doMath(
                p1.otherRs,
                p1.otherOps
        );

//        Assert.assertEquals(p2, new ExpressionEvaluator.SResult(
//                ExpressionEvaluator.numbers("10"),
//                ExpressionEvaluator.operators("")
//        ));
        ExpressionEvaluator.SResult merge = p1.merge(p2);
        Assert.assertEquals(new Integer(100), ExpressionEvaluator.simple(
                merge.rs,merge.ops
        ) );

    }
}
