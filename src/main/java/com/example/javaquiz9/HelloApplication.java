package com.example.javaquiz9;

import com.example.javaquiz9.Employee;
import com.example.javaquiz9.EmployeesResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try (
                FileReader fileReader = new FileReader("src/main/resources/com/example/javaquiz9/employee.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                FileReader fileReader1 = new FileReader("src/main/resources/com/example/javaquiz9/employees.json");
                JsonReader jsonReader1 = new JsonReader(fileReader1);
                FileReader fileReader2 = new FileReader("src/main/resources/com/example/javaquiz9/employeesResponse.json");
                JsonReader jsonReader2 = new JsonReader(fileReader2);
        ) {
            Gson gson = new Gson();
            // Read employees from JSON response
            EmployeesResponse employeesResponse = gson.fromJson(jsonReader2, EmployeesResponse.class);
            System.out.println("Number of employees in response: " + employeesResponse.Employees.size());

            for (Employee e : employeesResponse.Employees) {
                System.out.println("Got employee whose name is " + e.getPreferredFullName());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
