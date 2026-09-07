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

## ✅ Requirements Implementation

### Grade 3/5 ✅
- [x] Model classes with JavaFX Properties
- [x] Controller with add and display functionality
- [x] Data validation
- [x] Console output (System.out.println)

### Grade 4/5 ✅
- [x] FXML interface with all input fields
- [x] ComboBoxes for enumerations
- [x] Buttons for all actions
- [x] CSS styling

### Grade 5/5 ✅
- [x] TableView with packages
- [x] ObservableList binding
- [x] Delete package functionality
- [x] Table refresh mechanism
- [x] Complete MVC system

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

## 📖 Documentation

For detailed documentation, see:
- [CSS & FXML Improvements](./docs/CSS_FXML_IMPROVEMENTS.md)
- [Advanced JavaFX Concepts](./docs/ADVANCED_CONCEPTS.md)
- [Code Review & Analysis](./docs/PROJECT_REVIEW.md)
- [Icon Suggestions](./docs/ICON_SUGGESTIONS.md)

---

## 🎨 Modern Color Palette

```
Primary Background:  #0f172a (Dark Navy)
Secondary:           #1e293b (Dark Slate)
Accent 1:            #06b6d4 (Cyan)
Accent 2:            #8b5cf6 (Purple)
Danger:              #ef4444 (Red)
Success:             #10b981 (Green)
Warning:             #f59e0b (Orange)
Text:                #f1f5f9 (Light)
```

---

## 🎯 Button Actions

| Button | Action | Color | Icon |
|--------|--------|-------|------|
| **Save Package** | Add new contract | Green (#10b981) | 💾 |
| **Delete Selected** | Remove selected | Red (#ef4444) | 🗑️ |
| **Clear Person** | Clear person fields | Orange (#f59e0b) | ❌ |
| **Clear Package** | Clear package fields | Orange (#f59e0b) | 🔄 |
| **Close** | Exit application | Red (#ef4444) | ✕ |

---

## 📄 License

This project is available for educational purposes.

---

## 👨‍💻 Author

**Jelena Mladenović**

---

## 🤝 Contributing

For bug reports or suggestions, please open a GitHub Issue.

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

**Last Updated:** September 2026

---

**Ready for production use and educational purposes!** 🚀
---
## 📸 Screenshots
<img width="1089" height="599" alt="Screenshot 2026-09-07 135617" src="https://github.com/user-attachments/assets/3847d6e9-fd8a-4f2d-a050-1fa9eb4bba86" />
<img width="1079" height="428" alt="Screenshot 2026-09-07 135757" src="https://github.com/user-attachments/assets/9a1709cd-7548-4131-a35f-7b88d884d203" />
