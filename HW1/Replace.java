package HW1;


public class Replace {
    public static String charReplace(String str, int index, char c) {
        String first = str.substring(0, index);
        String last = str.substring(index + 1);
        return first + c + last;
       
    }
}
