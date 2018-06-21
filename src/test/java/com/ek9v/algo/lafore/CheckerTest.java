package com.ek9v.algo.lafore;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 14.02.2018.
 */
public class CheckerTest {

    @Test
    public void playOne() throws Exception {
        String B[] = new String[] {"..X.","....","X.X.",".O.."};
        int r = solution(B);
        Assert.assertThat(r, is(1));

    }
    @Test
    public void playTwo() throws Exception {
        String B[] = new String[] {"O"};
        int r = solution(B);
        Assert.assertThat(r, is(0));

    }

    @Test
    public void playFour() throws Exception {
        String B[] = new String[] {"O.","XX"};
        int r = solution(B);
        Assert.assertThat(r, is(0));
    }

    @Test
    public void playDouble() throws Exception {
//        String B[] = new String[] {".....","...X.",".....",".X.X.","..O.."};
        String B[] = new String[] {"X....", ".X...", "..O..", "...X.", "....."};
        int r = solution(B);
        Assert.assertThat(r, is(0));
    }

    public int solution(String[] B) {
        String fields = String.join("", B);
        int o = findO(fields);
        int n = B.length;
        int[] nextFields = nextFields(o, B.length);
        return Integer.max(check(nextFields[0], fields, n, -1),
          check(nextFields[1], fields, n, 1));
    }

    private int check(int field, String fields, int n, int dir) {
        if (field < 0 || fields.charAt(field) == '.') {
            return 0;
        }
        if (fields.charAt(field) == 'X') {
            int next = nextAfter(field, n, dir);
            if (next > 0 && fields.charAt(next) == '.') {
                int[] nextFields = nextFields(next, n);
                return 1 + Integer.max(check(nextFields[0], fields, n, dir),
                  check(nextFields[1], fields, n, dir));
            }
        }
        return 0;
    }

    private int nextAfter(int field, int n, int dir) {
        int next = field - n + dir;
        return field < n ? -1 : next;
    }

    private int[] nextFields(int o, int n) {
        int upLeft = o - n - 1;
        int upRight = o - n + 1;
        return new int[] {upLeft, upRight};
    }

    private int findO(String b) {
        return b.indexOf('O');
    }
}
