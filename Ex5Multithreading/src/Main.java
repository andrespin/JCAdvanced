/*
1. Необходимо написать два метода, которые делают следующее:
1) Создают одномерный длинный массив, например:
static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];
2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

Пример деления одного массива на два:
System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h);

Пример обратной склейки:
System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);

Примечание:
System.arraycopy() копирует данные из одного массива в другой:
System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
По замерам времени:
Для первого метода надо считать время только на цикл расчета:
for (int i = 0; i < size; i++) {
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
}
Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.


 */

public class Main {

    static final private int size = 10000000;
    static final private int h = size / 2;

    public static void main(String[] args) {
        method1();
        method2();

    }

    private static void method1()
    {
        float[] arr = new float[size];

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        oneCurrent(arr);

        System.out.println(System.currentTimeMillis() - a);
    }


    private static void oneCurrent(float[] arr){
        Thread t = new Thread( () -> {
            System.out.println("Thread начал работу");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Thread закончил работу");
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void method2()
    {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        twoCurrents(arr, arr1, arr2);

        System.out.println(System.currentTimeMillis() - a);

    }

    private static void twoCurrents(float [] arr, float [] arr1, float [] arr2){
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 начал работу");
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Thread1 закончил работу");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread2 начал работу");
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Thread2 закончил работу");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

    }



}
