package my.controllers;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import my.models.*;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static my.controllers.ShowAlerts.showError;
import static my.controllers.ShowAlerts.showInfo;

public class NetPackageController implements Initializable {

    // form backing for person inputs (so we can bind and clear easily)
    private Person formPerson;

    // packages list (single source of truth for the table)
    private final ObservableList<NetPackage> netPackages = FXCollections.observableArrayList();

    // Person inputs
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private ComboBox<Gender> genderComboBox;

    // Package inputs
    @FXML
    private TextField addressField;
    @FXML
    private ComboBox<Speed> speedComboBox;
    @FXML
    private ComboBox<Bandwidth> bandwidthComboBox;
    @FXML
    private ComboBox<Duration> durationComboBox;

    // Buttons
    @FXML
    private Button saveBtn;
    @FXML
    private Button clearPackageBtn;
    @FXML
    private Button clearPersonBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Button deleteBtn;

    // Table and columns
    @FXML
    private TableView<NetPackage> netPackageTableView;
    @FXML
    private TableColumn<NetPackage, String> personFirstNameColumn;
    @FXML
    private TableColumn<NetPackage, String> personLastNameColumn;
    @FXML
    private TableColumn<NetPackage, String> genderColumn;
    @FXML
    private TableColumn<NetPackage, String> personEmailColumn;
    @FXML
    private TableColumn<NetPackage, String> addressColumn;
    @FXML
    private TableColumn<NetPackage, String> speedColumn;
    @FXML
    private TableColumn<NetPackage, String> bandwidthColumn;
    @FXML
    private TableColumn<NetPackage, String> durationColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // prepare form backing person and bind fields
        formPerson = new Person();

        // Bind TextField with Person model
        firstNameField.textProperty().bindBidirectional(formPerson.firstNameProperty());
        // TextField change → formPerson update, formPerson change → TextField update
        // clearPerson() → formPerson.set("") → TextField is empty
        lastNameField.textProperty().bindBidirectional(formPerson.lastNameProperty());
        emailField.textProperty().bindBidirectional(formPerson.emailProperty());
        addressField.textProperty().bindBidirectional(new SimpleStringProperty());

        // populate enum combo boxes
        speedComboBox.setItems(FXCollections.observableArrayList(Speed.values()));
        bandwidthComboBox.setItems(FXCollections.observableArrayList(Bandwidth.values()));
        durationComboBox.setItems(FXCollections.observableArrayList(Duration.values()));
        genderComboBox.setItems(FXCollections.observableArrayList(Gender.values()));
        //genderComboBox.getSelectionModel().select(Gender.FEMALE);

        // set table columns
        personFirstNameColumn.setCellValueFactory(cell ->
                cell.getValue().getPerson().firstNameProperty());
        personLastNameColumn.setCellValueFactory(cell ->
                cell.getValue().getPerson().lastNameProperty());
        personEmailColumn.setCellValueFactory(cell ->
                cell.getValue().getPerson().emailProperty());
        addressColumn.setCellValueFactory(cell ->
                cell.getValue().addressProperty());

        genderColumn.setCellValueFactory(cell ->
                toStringProperty(cell.getValue().getPerson().getGender()));
        speedColumn.setCellValueFactory(cell ->
                toStringProperty(cell.getValue().getSpeed()));
        bandwidthColumn.setCellValueFactory(cell ->
                toStringProperty(cell.getValue().getBandwidth()));
        durationColumn.setCellValueFactory(cell ->
                toStringProperty(cell.getValue().getDuration()));

        // Force columns to fit the table width (prevents over-wide table)
        netPackageTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        // bind table to list
        netPackageTableView.setItems(netPackages);

        setAllImages();

        // sample data
        addSampleData();

        netPackageTableView.refresh();
    }

    private ReadOnlyStringWrapper toStringProperty(Object value) {
        return new ReadOnlyStringWrapper(value != null ? value.toString() : "");
    }

    private void addSampleData() {
        netPackages.addAll(new NetPackage(new Person("Jacob", "Smith", "jacob@smith.com", Gender.MALE), "Main St 1", Speed.S10, Bandwidth.GB10, Duration.ONE_YEAR), new NetPackage(new Person("Isabella", "Johnson", "isabella@johnson.com", Gender.FEMALE), "Oak Ave 23", Speed.S20, Bandwidth.GB100, Duration.TWO_YEARS), new NetPackage(new Person("Emma", "Jones", "emma@jones.com", Gender.FEMALE), "River Rd 5", Speed.S5, Bandwidth.FLAT, Duration.ONE_YEAR));
    }

    private void setAllImages() {
        setImage("/my/icons/speed_20dp.png", speedColumn);
        setImage("/my/icons/location_city_20dp.png", addressColumn);
        setImage("/my/icons/calendar_month_20dp.png", durationColumn);
        setImage("/my/icons/alternate_email_20dp.png", personEmailColumn);
    }

    private void setImage(String path, TableColumn<NetPackage, String> tableColumn) {
        try {
            Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
            ImageView iv = new ImageView(img);
            iv.setPreserveRatio(true);
            iv.setFitWidth(18);
            iv.setFitHeight(18);
            //closeBtn.setText("");
            tableColumn.setGraphic(iv);
        } catch (NullPointerException e) {
            e.printStackTrace();
            showError("Error", "Invalid image");
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error", "An error occurred");
        }
    }

    private String getErrorsMessage(List<String> errors) {
        return String.join("\n", errors);
    }

    @FXML
    private void saveNetPackage() {
        try {
            // create independent Person instance from current form values
            String fn = safe(firstNameField);
            String ln = safe(lastNameField);
            String em = safe(emailField);

            Gender g = genderComboBox.getSelectionModel().getSelectedItem();
            /*if (g == null)
                g = Gender.FEMALE;*/

            Person p = new Person(fn, ln, em, g);
            if (!p.isValid()) {
                showError("Person invalid", getErrorsMessage(p.getErrors()));
                p.clearErrors();
                return;
            }

            String addr = safe(addressField);
            Speed sp = speedComboBox.getSelectionModel().getSelectedItem();
            Bandwidth bw = bandwidthComboBox.getSelectionModel().getSelectedItem();
            Duration dur = durationComboBox.getSelectionModel().getSelectedItem();

            NetPackage np = new NetPackage(p, addr, sp, bw, dur);   // every package has own person
            if (!np.isValid()) {
                showError("Package invalid", getErrorsMessage(np.getErrors()));
                np.clearErrors();
                return;
            }

            netPackages.add(np);
            // netPackageTableView.refresh();
            showInfo("Saved", "Package saved");

            // keep person fields intact per your request; clear only package inputs
            //clearNetPackage();
        } catch (NullPointerException e) {
            e.printStackTrace();
            showError("Error", "Invalid data");
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error", "An error occurred");
        }
    }

    @FXML
    private void deleteNetPackage() {
        NetPackage sel = netPackageTableView.getSelectionModel().getSelectedItem();
        if (sel == null) {
            showError("Error", "Please select a package to delete");
            return;
        }
        netPackages.remove(sel);
        //netPackageTableView.refresh();
        showInfo("Deleted", "Package removed");
    }

    @FXML
    private void clearNetPackage() {
        addressField.clear();
        clearNetPackageFields();
    }

    private void clearNetPackageFields() {
        speedComboBox.getSelectionModel().clearSelection();
        bandwidthComboBox.getSelectionModel().clearSelection();
        durationComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    private void clearPerson() {
        // clear form backing values by setting fields (they are bound to formPerson)
        clearPersonFields();
        genderComboBox.getSelectionModel().clearSelection();
    }

    private void clearPersonFields() {
        formPerson.firstNameProperty().set("");
        formPerson.lastNameProperty().set("");
        formPerson.emailProperty().set("");
    }

    @FXML
    private void closeForm() {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    // helper
    private String safe(TextField tf) {
        if (tf == null || tf.getText() == null) return "";
        return tf.getText().trim();
    }
}