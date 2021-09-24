import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443", 409673, "2767089e5cf71e412e23e3e9cafe974f");

        System.out.println("Please, print phone number:");
        String phoneNumber = reader.readLine().trim();
        //String phoneNumber = "+79272827037";

        AuthCheckedPhone checkedPhone = bridge.authCheckPhone(phoneNumber);
        System.out.println(checkedPhone.isRegistered());

        bridge.authSendCode(phoneNumber);
        System.out.println("Please, print code:");
        AuthAuthorization err = bridge.authSignIn(reader.readLine().trim());

        System.out.println(err.getUser()); //result
        System.out.println("------------------------------"); //line for easier finding result
    }
}
