/*
1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения
 MySizeArrayException и MyArrayDataException и вывести результат расчета.
*/

public class Main {

    private static String [] [] str = new String [4][4];

    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                str [i][j] = "1";
            }
        }

        System.out.println(method(str));
    }

    private static int method(String [] [] str) throws MyArraySizeException, MyArrayDataException {
        int arraySum = -1;
        int [][] a = new int[4][4];
        int size1 = str.length;
        int size2 = str[0].length;
        if (size1 != 4 || size2 != 4)
        {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {

                try{
                    arraySum += Integer.parseInt(str[i][j]);
                }
                catch(NumberFormatException e)
                {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return arraySum;
    }
}



