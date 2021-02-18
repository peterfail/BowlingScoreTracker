import junit.framework.*;

public class AlgorithmTests extends TestCase{

    protected int value1, value2;
    protected BowlingPoints bp1 = new BowlingPoints(), bp2 = new BowlingPoints(), bp3 = new BowlingPoints()
            , bp4 = new BowlingPoints(), bp5 = new BowlingPoints();

    // assigning the values
    protected void setUp(){
        value1 = 3;
        value2 = 3;
        int[][] points = {{1,2},{3,4},{4,5}};
        int[][] points2 = {{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,0},{10,10}};
        int[][] points3 = {{3,7},{0,4},{1,9},{10,0},{8,2},{4,6},{10,0},{10,0},{3,0}};
        int[][] points4 = {{2,0},{8,2}};
        int[][] points5 = {{6,4},{10,0}};
        bp1.setPoints(points);
        bp2.setPoints(points2);
        bp3.setPoints(points3);
        bp4.setPoints(points4);
        bp5.setPoints(points5);
    }

    public void testGeneric(){
        int[] sum = bp1.getSum();
        assertTrue(sum[0]==3 && sum[1]==10 && sum[2]==19);
    }

    public void testPerfectGame(){
        int[] sum = bp2.getSum();
        assertTrue(sum[0]==30 && sum[1]==60 && sum[2]==90 && sum[3]==120 && sum[4]==150 && sum[5]==180 &&
                sum[6]==210 && sum[7]==240 && sum[8]==270 && sum[9]==300);
    }
    public void testSpareStrikeMix(){
        int[] sum = bp3.getSum();
        assertTrue(sum[0]==10 && sum[1]==14 && sum[2]==34 && sum[3]==54 && sum[4]==68 && sum[5]==88 &&
                sum[6]==111 && sum[7]==124 && sum[8]==127);
    }
    public void testEnsWithSpare(){
        int[] sum = bp4.getSum();
        assertTrue(sum[0]==2 && sum[1]==12);
    }
    public void testEnsWithStrike(){
        int[] sum = bp5.getSum();
        assertTrue(sum[0]==20 && sum[1]==30);
    }
}
