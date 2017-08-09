package collections.expression;

import org.junit.Test;

/**
 * Created by jjxx9 on 2017/3/18.
 */
public class ExpressionTest {
    @Test
    public void infix2Suffix() throws Exception {
        System.out.println(Expression.Infix2Suffix("3+2*5"));
    }

    @Test
    public void computeSuffixExpression() throws Exception {
        System.out.println(Expression.computeSuffixExpression("3 2 5 *+"));
    }

    @Test
    public void Infix2Prefix() throws Exception {
        System.out.println(Expression.computeInfix("3+2*(5+5)"));
    }
}