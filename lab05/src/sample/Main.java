package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField sid;
    private TextField assgn;
    private TextField midterm;
    private TextField exam;
    private Button add;

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane bp = new BorderPane();

        ObservableList<StudentRecord> marks = DataSource.getAllMarks();

        // Create table
        TableView table = new TableView();

        // Create and fill columns
        TableColumn<StudentRecord, String> sid_col = new TableColumn<>("SID");
        sid_col.setPrefWidth(120);
        sid_col.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<StudentRecord, Float> assign_col = new TableColumn<>("Assignments");
        assign_col.setPrefWidth(120);
        assign_col.setCellValueFactory(new PropertyValueFactory<>("assignments"));

        TableColumn<StudentRecord, Float> mt_col = new TableColumn<>("Midterm");
        mt_col.setPrefWidth(120);
        mt_col.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        TableColumn<StudentRecord, Float> exam_col = new TableColumn<>("Final Exam");
        exam_col.setPrefWidth(120);
        exam_col.setCellValueFactory(new PropertyValueFactory<>("exam"));

        TableColumn<StudentRecord, Float> final_col = new TableColumn<>("Final Mark");
        final_col.setPrefWidth(120);
        final_col.setCellValueFactory(new PropertyValueFactory<>("finalmark"));

        TableColumn<StudentRecord, Character> grade_col = new TableColumn<>("Letter Grade");
        grade_col.setPrefWidth(120);
        grade_col.setCellValueFactory(new PropertyValueFactory<>("lettergrade"));


        table.getColumns().addAll(sid_col, assign_col, mt_col, exam_col, final_col, grade_col);

        table.setItems(marks);

        this.sid = new TextField();
        this.sid.setPromptText("SID");

        this.assgn = new TextField();
        this.assgn.setPromptText("Assignments");

        this.midterm = new TextField();
        this.midterm.setPromptText("Midterm");

        this.exam = new TextField();
        this.exam.setPromptText("Exam");

        this.add = new Button("Add");
        this.add.setDefaultButton(true);

        GridPane bottom = new GridPane();
        bottom.setPadding(new Insets(10));
        bottom.setHgap(10);
        bottom.setVgap(10);

        bp.setCenter(table);
        bp.setBottom(bottom);


        primaryStage.setTitle("Lab 05 Solutions");
        primaryStage.setScene(new Scene(bp, 720, 300));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
