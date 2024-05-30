package testcode.samples;

public class ControlStatementSample {

    private void conditionalStatement() {
        int age = 20;

        if (age >= 18) {
            System.out.println("Вы совершеннолетний");
        } else {
            System.out.println("Вы несовершеннолетний");
        }
    }

    private void loopOperatorFor() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Значение i: " + i);
        }
    }

    private void loopOperatorWhile() {
        int i = 0;
        while (i < 5) {
            System.out.println("Значение i: " + i);
            i++;
        }
    }

    private void loopOperatorDoWhile() {
        int i = 0;
        do {
            System.out.println("Значение i: " + i);
            i++;
        } while (i < 5);
    }

    private void transitionOperatorBreak() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println("Значение i: " + i);
        }
    }

    private void transitionOperatorContinue() {
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue;
            }
            System.out.println("Значение i: " + i);
        }
    }

    private void selectionOperator() {
        int day = 3;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Понедельник";
                break;
            case 2:
                dayName = "Вторник";
                break;
            case 3:
                dayName = "Среда";
                break;
            default:
                dayName = "День недели не определен";
        }
        System.out.println("Сегодня " + dayName);
    }

    private void exceptionOperator() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } finally {
            System.out.println("Блок finally всегда выполнится");
        }
    }

    private void averageGrade() {
        int[] grades = {85, 90, 75, 60, 95};
        int sum = 0;
        double average;

        // Вычисляем сумму всех оценок
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            sum += grade;
        }

        // Вычисляем средний балл
        average = (double) sum / grades.length;

        // Проверяем, прошел ли студент экзамен
        if (average >= 70) {
            System.out.println("Студент прошел экзамен со средним баллом " + average);
        } else {
            System.out.println("Студент не прошел экзамен со средним баллом " + average);
        }
    }
}
