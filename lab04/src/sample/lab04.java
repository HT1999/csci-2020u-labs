package sample;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class lab04 extends Application {

    String checkPhone(String phoneNumber) {

        //String sPhoneNumber = "605-88899991";
        //String sPhoneNumber = "605-888999A";

        Pattern correctPattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Pattern incorrectPattern = Pattern.compile("\\d{10}");


        Matcher correctNumber = correctPattern.matcher(phoneNumber);
        Matcher incorrectNumber = incorrectPattern.matcher(phoneNumber);


        if (correctNumber.matches()) {
            return phoneNumber;
        }
        else if (incorrectNumber.matches()) {
            return new StringBuilder(25).append(phoneNumber.substring(0, 3))
                    .append("-").append(phoneNumber.substring(3, 6))
                    .append("-").append(phoneNumber.substring(6))
                    .toString();
        }
        else
        {
            return "Phone Number must be in the form XXX-XXX-XXXX";
        }
    }

    public void start(Stage stage) {
        Scene scene = new Scene(new Group(), 450, 250);

        TextField user = new TextField ();
        user.setPromptText("Username");
        PasswordField pw = new PasswordField (); //password atstericks field, not text
        pw.setPromptText("Password");
        TextField full = new TextField ();
        full.setPromptText("Full Name");
        TextField email = new TextField ();
        email.setPromptText("E-mail Address");
        TextField phone = new TextField (); //FXML MAKING PHONE NUMBER DASHES
        phone.setPromptText("000-000-0000");
        DatePicker birth = new DatePicker (); //Calendar picker, not normal text
        birth.setPromptText("Date of Birth");
        Button register = new Button("Register");


        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        grid.add(new Label("Username: "), 0, 0);
        grid.add(user, 1, 0);

        grid.add(new Label("Password:"), 0, 1);
        grid.add(pw, 1, 1);

        grid.add(new Label("Full Name:"), 0, 2);
        grid.add(full, 1, 2);

        grid.add(new Label("E-mail"), 0, 3);
        grid.add(email, 1, 3);

        grid.add(new Label("Phone #"), 0, 4);
        grid.add(phone, 1, 4);

        grid.add(new Label("Date of Birth:"), 0, 5);
        grid.add(birth, 1, 5);

        grid.add(register,1,6);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setTitle("Lab 04 Solution"); // Set the stage title
        stage.setScene(scene);
        register.setOnAction(action -> {
            System.out.println(user.getText());
            System.out.println(pw.getText());
            System.out.println(full.getText());
            System.out.println(email.getText());
            System.out.println(checkPhone(phone.getText()));

            System.out.println(birth.getValue());
        });
        stage.show();
    }
}


