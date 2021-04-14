package functional.interface_;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {

    @Test
    public void shouldPrintATextByUsingConsumerWithoutLambdaExpression() throws Exception {
        Consumer<String> printIt = new Consumer<String>() {

            @Override
            public void accept(String hero) {
                System.out.println("Justice League:" + hero);
            }
        };

        printIt.accept("Batman");
    }

    @Test
    public void shouldPrintATextByUsingConsumerWithLambdaExpression() throws Exception {
        Consumer<String> printIt = hero -> System.out.println("Justice League:" + hero);

        printIt.accept("Wonder woman");
    }


    @Test
    public void shouldSendAnEmail() throws Exception {
        User cyborg = new User("cyborg");
        User aquaman = new User("aquamen");
        User flash = new User("flash");

        List<User> javaFans = Arrays.asList(cyborg, aquaman, flash);

        javaFans.forEach(user -> EmailSender.sendFor(user));
    }
}

class EmailSender {

    public static void sendFor(User user) {
        System.out.println("Sending email to: " + user.getEmail());
    }

}

class User {

    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
