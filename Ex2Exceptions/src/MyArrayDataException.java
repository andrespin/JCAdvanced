public class MyArrayDataException extends Exception {

    private int number;

    public int getNumber(){return number;}

    public MyArrayDataException(String message, int number){
        super(message);
        this.number = number;
    }

    public MyArrayDataException(int i, int j){
        super("Ошибка находится в элементе с индексами i: " + Integer.toString(i) + " j: " + Integer.toString(j));
    }

    public MyArrayDataException(int number){
        super("Ошибка тут епта: " + Integer.toString( number));
    }


}


