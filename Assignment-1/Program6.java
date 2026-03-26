//Problem Statement:
//Implement a Cipher system using an abstract class and method overriding to perform encryption and decryption of text.
import java.util.Scanner;

// Abstract class
abstract class Cipher {

    // abstract methods
    abstract String encrypt(String text, int key);

    abstract String decrypt(String text, int key);
}

// Child class implementing cipher logic
class CaesarCipher extends Cipher {

    // method overriding for encryption
    String encrypt(String text, int key) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {

                char base = Character.isUpperCase(ch) ? 'A' : 'a';

                ch = (char) ((ch - base + key) % 26 + base);
            }

            result += ch;
        }

        return result;
    }

    // method overriding for decryption
    String decrypt(String text, int key) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {

                char base = Character.isUpperCase(ch) ? 'A' : 'a';

                ch = (char) ((ch - base - key + 26) % 26 + base);
            }

            result += ch;
        }

        return result;
    }
}

// Main class
public class Program6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CaesarCipher cipher = new CaesarCipher();

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter key value: ");
        int key = sc.nextInt();

        String encrypted = cipher.encrypt(text, key);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = cipher.decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}