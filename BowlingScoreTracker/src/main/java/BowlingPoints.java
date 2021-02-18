import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BowlingPoints {

    private int[][] points;
    private String token;

    public BowlingPoints(){
    }

    public int[][] getPoints() {
        return points;
    }

    public String getToken() {
        return token;
    }

    public void setPoints(int[][] points) {
        this.points = points;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int[] getSum(){
        int previous_sum = 0;
        int sum_length = points.length;
        if(sum_length>10){
            sum_length=10;
        }
        int[] sum = new int[sum_length];
        for (int round = 0; round < sum_length; round++) {
            sum[round] = getPins(round,2)+previous_sum;
            previous_sum = sum[round];
        }
        return sum;
    }

    private int getPins(int round, int bonus_rolls){
        if(bonus_rolls<0 || round >= points.length) return 0;
        int ball0 = points[round][0] , ball1 = points[round][1];
        if(bonus_rolls == 0){
            return ball0;
        }
        int pins = ball0+ball1;
        //strike
        if(ball0==10){
            pins += getPins(round+1,bonus_rolls-1);
        }
        //spare
        else if(pins==10){
            pins += getPins(round+1,bonus_rolls-2);
        }
        return pins;
    }

    @Override
    public String toString() {
        int[] sum = getSum();
        StringBuilder sb_game = new StringBuilder();
        StringBuilder sb_sum = new StringBuilder();
        sb_game.append("game:[");
        sb_sum.append("points:[");

        for (int round = 0; round < points.length; round++) {
            sb_game.append("[");
            sb_game.append(points[round][0]);
            sb_game.append(",");
            sb_game.append(points[round][1]);
            sb_game.append("]");
        }
        for (int round = 0; round < sum.length; round++) {
            sb_sum.append(sum[round]);
            if(round+1<sum.length){
                sb_sum.append(",");
            }
        }
        sb_game.append("]");
        sb_sum.append("]");

        return "token='" + token + '\''+'\n' +
                sb_game + '\n' +
                sb_sum;
    }
}
