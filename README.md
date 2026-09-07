# 🌐 Internet Package Sales Tracker (`java-fx-sales-tracker`)

A JavaFX desktop application built for registering, viewing, and managing internet service package contracts. Designed with **JavaFX (FXML)** and **SceneBuilder** following the strict **Model-View-Controller (MVC)** architectural pattern.
---
## ✨ Features
- 📝 **New Contract Registration:** Form with input validation for adding new sales contracts.
- 📊 **Table View Overview:** Displays all registered contracts in a dynamic `TableView` control bound to an `ObservableList`.
- 🗑️ **Delete Sales Record:** Allows quick removal of any selected contract row from the table.
- 📐 **MVC Architecture:** Complete decoupling of FXML UI, Controller logic, and Domain Model using JavaFX Properties.
---
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
---
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
---
## KLJUČNE TEHNIKE 

✅ Property Binding
✅ ObservableList
✅ CellValueFactory
✅ Validacija
✅ Independent Instances
---
## 📊 ZAHTEVI ZADATKA
Za Ocenu 3/5 ✅ 
 Model (Person, NetPackage),
 JavaFX Properties,
 Kontroler (dodavanje, ispis),
 Validacija,
 Ispis u konzolu
 
Za Ocenu 4/5 ✅ 
 FXML interfejs,
 Sva polja za unos,
 ComboBox-ovi za izbor,
 Buttons za akcije,
 CSS stilizacija
 
Za Ocenu 5/5 ✅ 
 TableView sa paketima,
 ObservableList binding,
 Brisanje paketa,
 Refresh tabele,
 Kompletan sistem
---
## 🧪 Speed testing
1. Pokreni aplikaciju: mvn javafx:run
2. Prikaži se sample data (3 paketa) ✓
3. Dodaj novi paket - pojavljuje se u tabeli ✓
4. Odaberi paket - klikni Delete - briše se ✓
5. Clear Person - briše person polja ✓
6. Clear Package - briši package polja ✓
7. Provera validacije - stavi prazna polja - error! ✓
---
## 🎓 ŠTa POSEBNO ŠTITI  PROJEKAT
* Sample Data - Tabela nije prazna pri pokretanju
* Separate Clear Buttons - Clear Person i Clear Package
* Binding - Čist kod bez ručnog kopiranja
* Independent Instances - Svaki paket je nezavisan
* Null Checks - Nema NPE (NullPointerException)
* Error Handling - Sve greške su uhvaćene
* Professional UI - Tamna tema sa hoover efektima
* Complete Validation - Pre čuvanja se validira
---
## 🎁 BONUS KARAKTERISTIKE U  KODU

✅ Draggable window (scene drag listeners)
✅ Undecorated stage (moderni izgled)
✅ Try-catch za close button ikonu
✅ Sample data pri pokretanju
✅ Helper safe() metoda za TextField
✅ Separate clear buttons (UX best practice)
✅ Null checks u CellValueFactory (error prevention)
---
## 🚀 Getting Started
### Prerequisites
- JDK 17+
- Apache Maven
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
---
### 📞 BRZE PROVERE 
- Projekat se kompajlira bez greške: mvn clean compile
- Pokušaj: mvn javafx:run
- Tabela prikazuje sample data
- Dodaj novi paket - pojavljuje se
- Obriši paket - uklanja se
- Validacija radi - stavi prazno polje
- Close button radi - prozor se zatvara
---
## 📸 Screenshots
<img width="1089" height="599" alt="Screenshot 2026-09-07 135617" src="https://github.com/user-attachments/assets/3847d6e9-fd8a-4f2d-a050-1fa9eb4bba86" />
<img width="1079" height="428" alt="Screenshot 2026-09-07 135757" src="https://github.com/user-attachments/assets/9a1709cd-7548-4131-a35f-7b88d884d203" />
