import java.util.Scanner;

public class Enter {

    public void multiEnter() {
        String newString;
        int stepsCount = 1;
        do {
            newString = enterText();
            System.out.println(newString);
            Phone newPhone = new Phone(stepsCount);
            if (newPhone.isFound(newString)) {
                System.out.println("Обнаружен номер телефона: " + newPhone.phoneNumber);
                System.out.println(newPhone.getPhoneNumber());
                stepsCount++;
            } else if (!(newString.equals("q"))) {
                System.out.println("Номер телефона не распознан, повторите ввод.");
            }
        }
        while (!(newString.equals("q"))) ;
    }

    private String enterText() {
        Scanner newScanner =new Scanner(System.in);
        return (newScanner.nextLine());
    }

}
