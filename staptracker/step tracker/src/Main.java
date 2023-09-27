import java.util.Scanner;

public class Main {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        printMenu();
        int chosenActivity = sc.nextInt();
        while (chosenActivity != 0){
            switch (chosenActivity){
                case 1:
                    System.out.println("Введите цифру месяца");
                    int activityMonth = sc.nextInt();
                    if (activityMonth > 11 || activityMonth < 0){
                        System.out.println("Введите корректный месяц");
                        activityMonth = sc.nextInt();
                    }
                    System.out.println("Введите цифру дня");
                    int activityDay = sc.nextInt();
                    if (activityDay > 29 || activityDay < 0){
                        System.out.println("Введите корректный месяц");
                        activityDay = sc.nextInt();
                    }
                    System.out.println("Введите количество пройденных шагов");
                    int activitySteps = sc.nextInt();
                    tracker.setActivityData(activityMonth, activitySteps, activityDay);
                    break;
                case 2:
                    System.out.println("Введите цифру месяца");
                    activityMonth = sc.nextInt();
                    tracker.printInfoByDay(activityMonth);
                    tracker.printStatistic(activityMonth);
                    break;
                case 3:
                    int newTarget = sc.nextInt();
                    tracker.setTargetForDay(newTarget);
                    break;
                default:
                    System.out.println("Повторите, пожалуйста, попытку");
            }
            printMenu();
            chosenActivity = sc.nextInt();
        }

    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
