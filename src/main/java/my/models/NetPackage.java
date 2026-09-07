package my.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NetPackage {
    private final ObjectProperty<Person> person = new SimpleObjectProperty<>(this, "person");
    private final StringProperty address = new SimpleStringProperty(this, "address", "");
    private final ObjectProperty<Speed> speed = new SimpleObjectProperty<>(this, "speed", Speed.S2);
    private final ObjectProperty<Bandwidth> bandwidth = new SimpleObjectProperty<>(this, "bandwidth", Bandwidth.GB1);
    private final ObjectProperty<Duration> duration = new SimpleObjectProperty<>(this, "duration", Duration.ONE_YEAR);

    private final ObservableList<String> errors = FXCollections.observableArrayList();

    public NetPackage() {
    }

    public NetPackage(Person p, String addr, Speed sp, Bandwidth bw, Duration d) {
        setPerson(p);
        setAddress(addr);
        setSpeed(sp);
        setBandwidth(bw);
        setDuration(d);
    }

    public Person getPerson() {
        return person.get();
    }

    public void setPerson(Person p) {
        person.set(p);
    }

    public ObjectProperty<Person> personProperty() {
        return person;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String a) {
        address.set(a);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public Speed getSpeed() {
        return speed.get();
    }

    public void setSpeed(Speed s) {
        speed.set(s);
    }

    public ObjectProperty<Speed> speedProperty() {
        return speed;
    }

    public Bandwidth getBandwidth() {
        return bandwidth.get();
    }

    public void setBandwidth(Bandwidth b) {
        bandwidth.set(b);
    }

    public ObjectProperty<Bandwidth> bandwidthProperty() {
        return bandwidth;
    }

    public Duration getDuration() {
        return duration.get();
    }

    public void setDuration(Duration d) {
        duration.set(d);
    }

    public ObjectProperty<Duration> durationProperty() {
        return duration;
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
        if (getPerson() == null || !getPerson().isValid()) {
            if (getPerson() != null)
                errors.addAll(getPerson().getErrors());
            else errors.add("Person data missing");
            ok = false;
        }
        if (getAddress() == null || getAddress().trim().isEmpty()) {
            errors.add("Address required");
            ok = false;
        }
        if (getSpeed() == null) {
            errors.add("Speed required");
            ok = false;
        }
        if (getBandwidth() == null) {
            errors.add("Bandwidth required");
            ok = false;
        }
        if (getDuration() == null) {
            errors.add("Duration required");
            ok = false;
        }
        return ok;
    }

    @Override
    public String toString() {
        return "NetPackage { person=" + (getPerson() == null ? "N/A" : getPerson().toString())
                + ", addr=" + getAddress()
                + ", speed=" + (getSpeed() == null ? "" : getSpeed())
                + ", bw=" + (getBandwidth() == null ? "" : getBandwidth())
                + ", dur=" + (getDuration() == null ? "" : getDuration())
                + " }";
    }
}