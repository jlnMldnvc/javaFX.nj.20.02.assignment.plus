# 🌐 Internet Package Sales Tracker (`java-fx-sales-tracker`)

A JavaFX desktop application built for registering, viewing, and managing internet service package contracts. Designed with **JavaFX (FXML)** and **SceneBuilder** following the strict **Model-View-Controller (MVC)** architectural pattern.

---

## ✨ Features

- 📝 **New Contract Registration:** Form with input validation for adding new sales contracts.
- 📊 **Table View Overview:** Displays all registered contracts in a dynamic `TableView` control bound to an `ObservableList`.
- 🗑️ **Delete Sales Record:** Allows quick removal of any selected contract row from the table.
- 📐 **MVC Architecture:** Complete decoupling of FXML UI, Controller logic, and Domain Model using JavaFX Properties.

## 📋 Data Model Parameters

Each internet package subscription contains the following specified attributes:

- **Speed (Mbit/s):** 2, 5, 10, 20, 50, or 100
- **Bandwidth (GB):** 1, 5, 10, 100, or "Flat"
- **Contract Duration:** 1 Year or 2 Years
- **User Information:** Full Name (Ime i prezime) & Address (Adresa)

---

## 🛠 Tech Stack

- **Language:** Java (JDK 17+)
- **UI Framework:** JavaFX (Controls, TableView, FXML, SceneBuilder)
- **Build System:** Maven

---

## 📁 Project Structure

```text
src/main/java/my/
  ├── Launcher.java      # Application entry point
  ├── MainApplication.java
  ├── models/         # Package domain models with JavaFX Properties
  │   ├── Person.java
  │   ├── NetPackage.java
  │   ├── Gender.java
  │   ├── Speed.java
  │   ├── Bandwidth.java
  │   └── Duration.java
  └── controllers/    # JavaFX Controllers
      ├── NetPackageController.java
      └── ShowAlerts.java

src/main/resources/my/
  ├── netpackage_view.fxml             # FXML layout file
  └── style.css            # CSS styling file

pom.xml
.gitignore
module-info.java
```
## 🎯 KEY POINTS

1. Model Klase

- Person.java          // 4 Properties + validacija
- NetPackage.java      // 5 Properties sa Person
- Gender.java          // Enum za pol
- Speed.java           // Enum za brzinu
- Bandwidth.java       // Enum za protok
- Duration.java        // Enum za trajanje

2. Controller

- NetPackageController.java    // Sve čini pravo
- initialize()               // Popuni ComboBoxove
- saveNetPackage()           // Dodaj paket
- deleteNetPackage()         // Obriši paket
- clearNetPackage()          // Čisti paket polja
- clearPerson()              // Čisti person polja
  
3. UI (FXML)

- netpackage_view.fxml         // Odličan layout
- GridPane za formu          // 4 kolone
- ComboBox-ovi za enume      // Speed, Bandwidth, Duration
- TableView sa 7 kolona      // Sve potrebne kolone
- CSS stilovi                // Tamna tema
  
4. Utility Klase

- ShowAlerts.java              // Za error i info poruke
- Launcher.java                // Entry point
- MainApplication.java         // Scene i CSS

## 🚀 Getting Started

### Prerequisites
-JDK 17+
-Apache Maven

### Running the Application
1.Clone the repository:

```Bash
git clone https://github.com/jlnMldnvc/fx.nj.20.02.sb.git
cd fx.nj.20.02.sb
```
2.Run via Maven:

```Bash
mvn clean javafx:run
```
##📸 Screenshots
