/*
1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать, сколько раз встречается каждое слово.
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
 Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
  тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно как можно меньше добавлять своего, чего нет в задании
(т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
делать взаимодействие с пользователем через консоль и т.д.).
 Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main(), прописывая add() и get().
 */

import java.util.ArrayList;

public class Main {

    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {

        // Task 1
        taskOne();

        // Task 2
        phoneBook.add("Воронин", 1234);
        phoneBook.add("Иванов", 4321);
        phoneBook.add("Краков", 6789);
        phoneBook.add("Иванов", 6342);
        phoneBook.add("Иванов", 1);

        phoneBook.get("Иванов");

        phoneBook.get("Воронин");

    }


    private static void taskOne()
    {
        ArrayList<String> arrayList = new ArrayList<>();

        ArrayList<String> uniqueWords = new ArrayList<>();
        
        arrayList.add("Пистолет");
        arrayList.add("Собака");
        arrayList.add("Дом");
        arrayList.add("Шалаш");
        arrayList.add("Пистолет");
        arrayList.add("Деревня");
        arrayList.add("Сон");
        arrayList.add("Собака");
        arrayList.add("Кот");
        arrayList.add("Бутерброд");
        arrayList.add("Сосед");
        arrayList.add("Сон");
        arrayList.add("Булава");
        arrayList.add("Скрепка");
        arrayList.add("Скрепка");

        for (String list : arrayList) {
            if (!uniqueWords.contains(list))
            {
                uniqueWords.add(list);
            }
        }

        System.out.println();

        for (String list : uniqueWords) {
            System.out.println(list);
        }

        System.out.println("----------------------------------" + "\n");
    }

}