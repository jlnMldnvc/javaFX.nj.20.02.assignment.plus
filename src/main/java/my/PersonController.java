package my;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PersonController implements Initializable {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private ToggleGroup gender;

    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    private TableView<Person> personTableView;

    ObservableList<Person> persons;
    Person person;

    public PersonController() {
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        persons = FXCollections.<Person>observableArrayList();

        person = new Person();

        firstName.textProperty().bindBidirectional(person.firstNameProperty());
        lastName.textProperty().bindBidirectional(person.lastNameProperty());
        email.textProperty().bindBidirectional(person.emailProperty());

        gender.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {

                ToggleButton selected = (ToggleButton) newValue;

                switch (selected.getId()) {
                    case "male":
                        person.genderProperty().set(Gender.MALE);
                        break;
                    case "female":
                        person.genderProperty().set(Gender.FEMALE);
                        break;
                }
            }
        });

        personTableView.prefWidthProperty().bind(personTableView.getColumns().get(2).widthProperty().multiply(2.6));

    }

    @FXML
    private void savePerson() {
        if (person.isValid()) {

            persons = personTableView.getItems();

            ToggleButton selected = (ToggleButton) gender.getSelectedToggle();
            switch (selected.getId()) {
                case "male":
                    persons.add(new Person(firstName.getText(), lastName.getText(), email.getText(), Gender.MALE));
                    break;
                case "female":
                    persons.add(new Person(firstName.getText(), lastName.getText(), email.getText(), Gender.FEMALE));
                    break;
            }

            personTableView.setItems(persons);
        } else {

            StringBuilder errMsg = new StringBuilder();

            ArrayList<String> errList = person.errorsProperty().get();

            for (String errList1 : errList) {
                errMsg.append(errList1);
            }

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Person can be saved!");
            alert.setHeaderText(null);
            alert.setContentText(errMsg.toString());
            alert.showAndWait();
            errList.clear();
        }
    }

    @FXML
    private void closeForm() {
        Platform.exit();
    }

    @FXML
    private void clearPerson() {

        person.firstNameProperty().set("");
        person.lastNameProperty().set("");
        person.emailProperty().set("");
        person.genderProperty().set(Gender.FEMALE);

        if (gender.getSelectedToggle() != null) {
            gender.getSelectedToggle().setSelected(false);
        }
    }

    @FXML
    private void deletePerson() {
        persons = personTableView.getItems();

        int index = personTableView.selectionModelProperty().getValue().getSelectedIndex();
        persons.remove(index);

        personTableView.setItems(persons);
    }
}