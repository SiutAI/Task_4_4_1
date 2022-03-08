import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    int number;
    String phoneNumber;

    public Phone(int No) {
        this.number = No;
    }

    public boolean isFound(String newString) {
        Pattern pattern = Pattern.compile("(\\+[ ]?[2-9])[\\- ]?(([(][0-9]{3,16}[)])?([\\- ]*[0-9])){1,16}\\b");
        Matcher matcher = pattern.matcher(newString);
        if (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            phoneNumber = clearNums(newString.substring(start, end));
            return (true);
        }
        return (false);
    }

    String clearNums(String phoneBefore) {
        StringBuffer phoneBuffer = new StringBuffer();
        for (int i = 0; i < phoneBefore.length(); i++) {
            if (Character.isDigit(phoneBefore.charAt(i))) {
                phoneBuffer.append(phoneBefore.charAt(i));
            }
        }
        return (phoneBuffer.toString());
    }

    public String getPhoneNumber() {
        StringBuilder phoneBuffer = new StringBuilder(phoneNumber);
        if (phoneNumber.length() > 14) {
            phoneBuffer.insert(phoneBuffer.length() - 8, ") ");
            phoneBuffer.insert(phoneBuffer.length() - 4, '-');
        } else {
            phoneBuffer.insert(phoneBuffer.length() - 7, ") ");
            phoneBuffer.insert(phoneBuffer.length() - 4, '-');
            phoneBuffer.insert(phoneBuffer.length() - 2, '-');
        }

        if (phoneNumber.length() > 13) {
            phoneBuffer.insert(4, " (");
        } else {
            phoneBuffer.insert(phoneNumber.length() - 10, " (");
        }

        phoneBuffer.insert(0, '+');
        return (phoneBuffer.toString());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
