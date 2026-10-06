# Internet Package Registration (JavaFX)

A JavaFX desktop app for registering internet service contracts: a form with
validation on top, a table of all contracts below. Built with FXML, JavaFX
properties and a custom CSS dark theme, split into models and controllers (MVC).

<img width="1094" height="702" alt="Application screenshot" src="https://github.com/user-attachments/assets/76cff105-e770-4611-840c-564a1aa50bff" />

## Features

- Register a contract: person (first name, last name, email, gender), address, speed, bandwidth, duration
- Validation of the person and the package, with error dialogs listing every problem
- TableView with 8 columns, bound to an `ObservableList`; add and delete update it automatically
- Delete the selected row (with a message if nothing is selected)
- Clear buttons for the person part and the package part of the form
- Custom dark theme (CSS), icon buttons and icon column headers
- Undecorated window with its own close button, draggable with the mouse
- Three sample contracts loaded at start

## Package options

| Parameter | Values |
|---|---|
| Speed (Mbit/s) | 2, 5, 10, 20, 50, 100 |
| Bandwidth (GB) | 1, 5, 10, 100, Flat |
| Duration | 1 year, 2 years |

## Tech

Java 17+, JavaFX 21 (FXML, CSS), Maven. Scene layout can be opened in SceneBuilder.

## Project structure

```
src/main/java/my/
├── Launcher.java              # entry point
├── MainApplication.java       # loads FXML + CSS, window setup, dragging
├── models/                    # Person, NetPackage + enums Gender, Speed, Bandwidth, Duration
└── controllers/               # NetPackageController, ShowAlerts
src/main/resources/my/
├── netpackage_view.fxml       # layout
├── style.css                  # theme
└── icons/                     # button and column icons
```

## Run

Requirements: JDK 17+, Maven 3.6+.

```bash
git clone https://github.com/jlnMldnvc/<repo-name>.git
cd <repo-name>
mvn clean javafx:run
```

Or in IntelliJ IDEA: run `my.Launcher`.

## How it works

**Form bound to a model.** The person fields are bound bidirectionally to a
`Person` object, so clearing the model clears the form:

```java
firstNameField.textProperty().bindBidirectional(formPerson.firstNameProperty());
```

**Table bound to a list.** Each contract is its own object with its own `Person`:

```java
netPackageTableView.setItems(netPackages);          // ObservableList<NetPackage>
personFirstNameColumn.setCellValueFactory(cell ->
        cell.getValue().getPerson().firstNameProperty());
```

**Enums with display labels.** `Speed`, `Bandwidth`, `Duration` and `Gender`
override `toString()`, so the same enum fills the ComboBox and the table cell.

**Validation in the model.** `Person.isValid()` and `NetPackage.isValid()`
collect error messages; `ShowAlerts` shows them in one dialog.

## Starting point and what I changed

The project started from an introductory JavaFX exercise: a single Person form
with a TableView. I extended it into a different application:

| Starting exercise | This project |
|---|---|
| One model (`Person`) | `Person` + `NetPackage` (5 properties) + 4 enums |
| Everything in one package, one controller | `models/` and `controllers/` packages, `ShowAlerts` helper |
| Gender chosen with ToggleButtons, switch on node ids | `ComboBox<Gender>` bound to an enum |
| Delete by selected index (fails with nothing selected) | Delete by selected item, with a check and message |
| Columns via `PropertyValueFactory` | Type-safe lambda cell value factories |
| Default look, SplitPane layout | GridPane/VBox layout, custom CSS theme, icons, draggable undecorated window |
| Errors stored as a list in a property | `ObservableList<String>` of errors inside each model, validated at person and package level |

The original exercise is kept in `examples/person-form/` for comparison.

## Manual test checklist

- App starts, table shows 3 sample contracts
- Valid form → new row appears; empty required fields → error dialog
- Delete with a selection removes the row; without selection shows a message
- Clear Person / Clear Package reset only their own fields
- Close button exits the app

## Known limitations / next steps

- Data is kept in memory only (lost when the app closes)
- Email is only checked for being non-empty
- Next: save to a file or database (SQL via JDBC / Spring Data), unit tests for validation

## Credits

Icons: Google Material Symbols (Apache License 2.0).

## License

MIT
