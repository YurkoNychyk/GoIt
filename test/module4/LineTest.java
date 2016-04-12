package module4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by home on 11.04.2016.
 */
public class LineTest {

    final double DELTA = 0.01d;

    @Test
    public void getLength() throws Exception {
        final int x1 = 0;
        final int y1 = 0;
        final int x2 = 10;
        final int y2 = 0;

        final Line line = new Line(x1,y1,x2,y2);

        final double length = 10.;

        Assert.assertEquals(length, line.getLength(), DELTA);
    }

}