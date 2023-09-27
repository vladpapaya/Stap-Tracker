public class StepTracker {
    private int targetForDay;
    private MonthData[] months;

    StepTracker() {
        this.months = new MonthData[12];
        for (int i = 0; i < this.months.length; i++) {
            this.months[i] = new MonthData();
        }
    }

    void setTargetForDay (int newTarget){
        this.targetForDay = newTarget;
    }

    void printInfoByDay(int month) {
        int[] days = months[month].getDays();
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + " день: " + days[i]);
        }
    }

    int getSum(int month) {
        int[] days = months[month].getDays();
        int sum = 0;
        for (int j = 0; j < days.length; j++) {
            sum = sum + days[j];
        }
        return sum;
    }

    void printStatistic(int month) {
        int calories = Converter.calories(getSum(month));
        int distance = Converter.convertToKm(getSum(month));
        System.out.println("Всего пройдено: " + getSum(month));
        System.out.println("Среднее количество шагов за месяц = " + calories);
        System.out.println("Всего калорий сожжено = " + getAvg(month));
        System.out.println("Вся пройденная дистанция = " + distance);
        System.out.println("Максимальное количество дней подряд = " + getMaximumStreak(month));
        System.out.println("Максимальное количество шагов за день=" + getMaxStep(month));
        // javaFX
    }

    public int getAvg (int month){
        int avg = getSum(month) / 30;
        return avg;
    }

    public int getMaxStep (int month){
        int[] days = months[month].getDays();
        int max = 0;
        for (int i = 0; i < days.length; i++) {
            if (max < days[i]) {
                max = days[i];
            }
        }
        return max;
    }

    public int getMaximumStreak (int month) {
        int[] days = months[month].getDays();
        int maxdaystr = 0;
        int maximumStreak = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > 0) {
                maxdaystr++;
            }
            if ((days[i] <= 0 || i == days.length - 1) && maximumStreak < maxdaystr) {
                maximumStreak = maxdaystr;
                maxdaystr = 0;
            }
        }
        return maximumStreak;
    }

    void setActivityData (int month, int steps, int day){
        months[month].setSteps(steps, day);
    }
}
