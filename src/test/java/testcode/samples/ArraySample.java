package testcode.samples;

public class ArraySample {

    private void oneDimensionalArray() {
        // Создаем массив, в котором будут храниться оценки студентов
        int[] grades = {85, 90, 75, 95, 80};

        // Обращаемся к элементам массива по их индексам
        System.out.println("Оценка студента с индексом 2: " + grades[2]); // Выведет "75"
    }

    private void bubbleSort() {
        // Сортировка массива методом пузырька
        int[] array = {5, 2, 9, 1, 5};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // Вывод отсортированного массива
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            System.out.print(num + " ");
        }
    }

    private void selectionSort() {
        // Создаем массив для сортировки
        int[] array = {64, 25, 12, 22, 11};

        // Реализуем сортировку выбором
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Обмен значениями
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        // Выводим отсортированный массив
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            System.out.print(num + " ");
        }
    }

    private void insertionSort() {
        // Создаем массив для сортировки
        int[] array = {12, 11, 13, 5, 6};

        // Реализуем сортировку вставками
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Перемещаем элементы больше key на одну позицию вперед
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

        // Выводим отсортированный массив
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            System.out.print(num + " ");
        }
    }

    private void multiDimensionalArray() {
        // Объявление и инициализация 3-мерного массива размером 2x3x4
        int[][][] threeDimensionalArray = new int[2][3][4];

        // Заполнение массива значениями
        int value = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    threeDimensionalArray[i][j][k] = value;
                    value++;
                }
            }
        }

        // Вывод массива
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.print(threeDimensionalArray[i][j][k] + " ");
                }
                System.out.println(); // Переход на новую строку после вывода каждой строки
            }
            System.out.println(); // Переход на новую строку между 2D-слоями массива
        }
    }

    private void copyArray() {
        // Копирование массива
        int[] sourceArray = {1, 2, 3, 4, 5};
        int[] targetArray = new int[sourceArray.length];

        System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);

        // Вывод элементов скопированного массива
        for (int i = 0; i < targetArray.length; i++) {
            int num = targetArray[i];
            System.out.print(num + " ");
        }
    }
}
