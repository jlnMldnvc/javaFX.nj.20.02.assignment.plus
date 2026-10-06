# 🌐 Internet Package Sales Registration System

A JavaFX desktop application for registering, viewing, and managing internet service package contracts. Built with **JavaFX (FXML)** and **SceneBuilder** following the **Model-View-Controller (MVC)** architectural pattern.

---

## ✨ Features

- 📝 **Contract Registration** - Form with validation for adding new service contracts
- 📊 **Table View Overview** - Dynamic TableView bound to ObservableList for displaying all packages
- 🗑️ **Delete Records** - Quick removal of selected contract rows from the table
- 📐 **MVC Architecture** - Complete separation of concerns with JavaFX Properties

---

## 📋 Internet Package Parameters

Each internet service contract contains the following attributes:

| Parameter | Values |
|-----------|--------|
| **Speed (Mbit/s)** | 2, 5, 10, 20, 50, 100 |
| **Bandwidth (GB)** | 1, 5, 10, 100, or Flat |
| **Contract Duration** | 1 Year or 2 Years |
| **User Information** | First Name, Last Name, Email |
| **Location** | Address |

---

## 🛠 Technology Stack

- **Language:** Java (JDK 17+)
- **UI Framework:** JavaFX 21
- **Build Tool:** Apache Maven 3.6+
- **Architecture:** Model-View-Controller (MVC)

---

## 📁 Project Structure

```
src/main/java/my/
├── Launcher.java                    # Entry point
├── MainApplication.java             # Scene configuration
├── models/                          # Domain models with Properties
│   ├── Person.java
│   ├── NetPackage.java
│   ├── Gender.java
│   ├── Speed.java
│   ├── Bandwidth.java
│   └── Duration.java
└── controllers/                     # MVC Controllers
    ├── NetPackageController.java
    └── ShowAlerts.java

src/main/resources/my/
├── netpackage_view.fxml             # FXML UI layout
└── style.css                        # CSS styling

pom.xml                              # Maven configuration
module-info.java                     # Java Modules
.gitignore
```

---

## 🎯 Key Features

### Model Classes
- **Person** - 4 JavaFX Properties (firstName, lastName, email, gender)
- **NetPackage** - 5 Properties (person, address, speed, bandwidth, duration)
- **Enumerations** - Gender, Speed, Bandwidth, Duration

### Controller (NetPackageController)
```java
- initialize()            // Initialize ComboBoxes and TableView
- saveNetPackage()        // Validate and add new package
- deleteNetPackage()      // Remove selected package
- clearPerson()           // Clear person form fields
- clearNetPackage()       // Clear package form fields
```

### User Interface
- **FXML** - GridPane form with all input fields
- **TableView** - Display all packages with 8 columns
- **CSS** - Modern dark theme with gradients and effects

---

## Origin and my contribution

**Starting point:** an introductory JavaFX exercise (registering internet service packages in a TableView).

**What I added:**
- [MVC refactoring with separate model/controller/view packages]
- [property binding for live totals]
- [input validation and error messages]
- [Maven build, JDK 17+, JavaFX 21]

## What this project demonstrates
JavaFX, MVC, property binding, TableView, Maven.

---

## 🚀 Quick Start

### Prerequisites
- Java Development Kit (JDK) 17 or newer
- Apache Maven 3.6 or newer

### Installation and Running

```bash
# 1. Clone the repository
git clone https://github.com/jlnMldnvc/fx.nj.20.02.sb.git
cd fx.nj.20.02.sb

# 2. Compile the project
mvn clean compile

# 3. Run the application
mvn javafx:run
```

### Alternative: Run from IDE

**IntelliJ IDEA:**
- Open the project
- Right-click on `Launcher.java`
- Select "Run 'Launcher.main()'"

---

## 🧪 Testing

- ✅ Application starts without errors
- ✅ Table displays sample data (3 packages)
- ✅ Add new package → appears in table
- ✅ Delete package → removed from table
- ✅ Validation works → error if fields are empty
- ✅ Clear buttons → clear corresponding fields
- ✅ Close button → closes application

---

## 💡 Key JavaFX Techniques

### Property Binding
```java
firstNameField.textProperty().bindBidirectional(person.firstNameProperty());
// Automatic synchronization between GUI and model
```

### ObservableList & TableView
```java
ObservableList<NetPackage> packages = FXCollections.observableArrayList();
tableView.setItems(packages);
// TableView automatically updates when items are added/removed
```

### CellValueFactory
```java
personFirstNameColumn.setCellValueFactory(cell -> 
    cell.getValue().getPerson().firstNameProperty()
);
// Displays data from model in table format
```

---

## 🎁 Special Features

| Feature | Description |
|---------|-------------|
| 🎨 **Modern Theme** | Dark theme with cyan-blue gradients |
| 📱 **Responsive Layout** | Adapts to different window sizes |
| 🖱️ **Draggable Window** | Window can be dragged with mouse |
| ⚡ **Sample Data** | Table loads with 3 example records |
| 🛡️ **Error Handling** | Comprehensive validation and error handling |
| 🎯 **MVC Architecture** | Clear separation of UI, logic, and model |
| 🔄 **Independent Instances** | Each package is an independent object |

---

## 📊 Build Commands

```bash
# Clean and compile
mvn clean compile

# Run application
mvn javafx:run

# Create JAR file
mvn package

# Run from JAR file
java -jar target/javafx-sales-tracker-1.0-SNAPSHOT.jar
```

---

## 🎨 Modern Color Palette

```
   background: #23282D (dark slate)
   surface:    #1E2428
   primary:    #1E88E5 (blue)
   accent:     #00BFA5 (teal)
   danger:     #FF5252 (red)
   muted text: #B0BEC5
   strong text:#FFFFFF
```

---

## 🎯 Button Actions

| Button | Action | 
|--------|--------|
| **Save Package** | Add new contract | 
| **Delete Selected** | Remove selected | 
| **Clear Person** | Clear person fields | 
| **Clear Package** | Clear package fields | 
| **Close** | Exit application | 


---

## 🎓 About This Project

This project was built as part of a JavaFX course focusing on:
- JavaFX Properties and Binding
- TableView and ObservableList usage
- MVC architecture implementation
- CSS styling in JavaFX
- FXML with SceneBuilder

**Result:** Complete system achieving grade **5/5** that fulfills all course requirements.

---

## 📚 Learning Outcomes

After studying this project, you will understand:
- How JavaFX Properties enable reactive UI programming
- How to bind UI controls to model data
- How ObservableList keeps TableView synchronized
- How to structure applications using MVC pattern
- How to style JavaFX applications with CSS
- How to create professional desktop applications

---

## 🔗 Resources

- [JavaFX Documentation](https://openjfx.io/javadoc/21/)
- [Maven Documentation](https://maven.apache.org/)
- [JavaFX CSS Reference](https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/doc-files/cssref.html)

---

## 📊 Project Statistics

- **Lines of Code:** ~800
- **Classes:** 11
- **Controllers:** 1
- **Models:** 6
- **UI Components:** 4 (Form, Buttons, Table, ComboBoxes)
- **Design Patterns:** MVC
- **Build Time:** ~10 seconds

---

**Ready for production use and educational purposes!** 🚀
---
## 📸 Screenshots
<img width="1094" height="702" alt="Screenshot 2026-09-11 144233" src="https://github.com/user-attachments/assets/76cff105-e770-4611-840c-564a1aa50bff" />

