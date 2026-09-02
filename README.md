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
src/
└── main/
    ├── java/
    │   └── com/example/
    │       ├── controller/    # JavaFX Controllers
    │       ├── model/         # Package domain model with JavaFX Properties
    │       └── Main.java      # Application entry point
    └── resources/
        ├── views/             # FXML layout files
        └── styles/            # CSS styling files
```
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
