import java.util.Arrays;

public class MonthData {
    private int[] days;

    MonthData() {
      this.days = new int[30];
        for (int i = 0; i < days.length; i++) {
            this.days[i] = 0;
        }
    }

    public int[] getDays() {
        return days;
    }

    public void setSteps(int steps, int day) {
        this.days[day] = steps;
    }
}
