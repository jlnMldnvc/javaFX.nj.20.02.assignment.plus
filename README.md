> [!IMPORTANT]
> assignment: Registrovanje prodaje internet-paketa\
iz kursa: **JavaFX**\
za modul: JavaFX funkcionalnosti<br/>
---
# Postavka zadataka:

Potrebno je napraviti formu za registrovanje prodaje internet-paketa.

Internet-paket se sastoji iz sledećih parametara:

+ brzina;
+ protok;
+ trajanje ugovora;
+ ime i prezime korisnika;
+ adresa korisnika<br/>

Pritom:

* Brzina interneta (u Mbit/s) može biti 2, 5, 10, 20, 50 ili 100.
* Protok interneta (u GB) može biti 1, 5, 10 ili 100 ili "Flat".
* Trajanje ugovora može biti jedna ili dve godine.
* Ime, prezime i adresa korisnika se upisuju kao tekst.<br/>

Potrebno je omogućiti evidenciju kreiranja ugovora i prodatih paketa i to:

- pregled svih prodaja;
- dodavanje novih prodaja;<br/>
- brisanje postojećih prodaja<br/>

# Arhitektura aplikacije

Standardni i visoko preporučeni pristup za izradu ovog zadatka je korišćenje FXML-a za definisanje korisničkog interfejsa (View) i posebne kontroler klase za upravljanje događajima i logikom (Controller), prateći principe MVC obrasca. Za domenski model, obavezno je kreirati klasu koja predstavlja internet-paket. Aplikaciju je poželjno stilizovati korišćenjem CSS-a.

<img width="809" height="505" alt="image" src="https://github.com/user-attachments/assets/9633d487-aa50-43ef-8985-fc97c3506e91" />

Zadatak je kompletan Maven Java projekat.

## Osnovna logika i model:

Potrebno je implementirati kompletan model (klasu za internet-paket) sa JavaFX Properties i osnovni kontroler koji omogućava sledeće operacije, sa ispisom rezultata u konzoli:

Dodavanje novog paketa (podaci mogu biti statički definisani u kodu).
Prikaz (ispis) svih unetih paketa.

## Kompletan korisnički interfejs:

Nadograditi rešenje kreiranjem kompletnog korisničkog interfejsa pomoću FXML-a. Interfejs treba da sadrži sva polja za unos (tekstualna polja, ChoiceBox ili ComboBox za brzinu/protok) i dugmad. Logika iz kontrolera treba da bude povezana sa interfejsom tako da se podaci unose preko forme.

## Prikaz podataka u tabeli i brisanje:

Nadograditi rešenje tako da se svi uneti paketi prikazuju u TableView kontroli. Tabela treba da bude povezana (bind) sa ObservableList-om u kontroleru. Omogućiti brisanje selektovanog reda iz tabele.
---
# 🌐 Internet Package Sales Tracker (`java-fx-sales-tracker`)

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![JavaFX](https://img.shields.io/badge/JavaFX-SceneBuilder-FF0000?style=for-the-badge&logo=java&logoColor=white)](https://openjfx.io/)

A JavaFX desktop management application built for logging, processing, and recording internet service package sales. Designed using **JavaFX SceneBuilder (FXML)** to ensure a clean Model-View-Controller (MVC) architecture by decoupling UI layout from core application logic.

---

## ✨ Key Features & Architecture

- 📝 **Sales Registration:** User-friendly form interface for registering new internet package subscriptions and sales data.
- 📐 **FXML & SceneBuilder UI:** Declarative user interface created with JavaFX SceneBuilder for clean layout design.
- 🧱 **MVC Design Pattern:** Strict separation between UI controllers, event handlers, and data models.
- 🎨 **Responsive Controls:** Form validations and interactive input handling for seamless user experience.

---

## 🛠 Tech Stack

- **Language:** Java (JDK 17+)
- **UI Framework & Tools:** JavaFX, SceneBuilder (FXML)
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

---

## ⚙️ How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com/jlnMldnvc/fx.nj.20.02.sb.git
      ```
