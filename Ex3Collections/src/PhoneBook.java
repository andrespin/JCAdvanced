import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private static HashMap<String, ArrayList<Integer>> book;

    public PhoneBook(){
        this.book = new HashMap<>();
    }

    public static void add(String secondName, Integer phoneNumber)
    {
        if (book.containsKey(secondName))
        {
            ArrayList<Integer> list = book.get(secondName);
            list.add(phoneNumber);
        }
        else
            {
                ArrayList<Integer> arList = new ArrayList<>();
                arList.add(phoneNumber);
                book.put(secondName, arList);
            }
    }

    public static void get(String secondName)
    {
            System.out.println(book.get(secondName));
    }
}
