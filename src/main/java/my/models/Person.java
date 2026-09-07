package my.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {

    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty email = new SimpleStringProperty(this, "email", "");
    private final ObjectProperty<Gender> gender = new SimpleObjectProperty<>(this, "gender", Gender.FEMALE);

    // simple errors list
    private final ObservableList<String> errors = FXCollections.observableArrayList();

    public Person() {
    }

    public Person(String fn, String ln, String em, Gender g) {
        this.firstName.set(fn);
        this.lastName.set(ln);
        this.email.set(em);
        this.gender.set(g);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String v) {
        firstName.set(v);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String v) {
        lastName.set(v);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String v) {
        email.set(v);
    }

    public Gender getGender() {
        return gender.get();
    }

    public ObjectProperty<Gender> genderProperty() {
        return gender;
    }

    public void setGender(Gender g) {
        gender.set(g);
    }

    public ObservableList<String> getErrors() {
        return errors;
    }

    public void clearErrors() {
        errors.clear();
    }

    public boolean isValid() {
        clearErrors();
        boolean ok = true;
        if (getFirstName() == null || getFirstName().trim().isEmpty()) {
            errors.add("First name required");
            ok = false;
        }
        if (getLastName() == null || getLastName().trim().isEmpty()) {
            errors.add("Last name required");
            ok = false;
        }
        if (getEmail() == null || getEmail().trim().isEmpty()) {
            errors.add("Email required");
            ok = false;
        }
        if (getGender() == null) {
            errors.add("Speed must be selected!");
            ok = false;
        }
        return ok;
    }

    @Override
    public String toString() {
        return "First name: " + getFirstName() + "\n" + "Last name: " + getLastName() + "\n" +
                "Email: " + getEmail() + "\n" + "model.Gender: " + getGender();
    }
}