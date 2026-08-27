assignment: Registrovanje prodaje internet-paketa
iz kursa: JavaFX 
za modul: JavaFX funkcionalnosti

# Postavka zadataka:

Potrebno je napraviti formu za registrovanje prodaje internet-paketa.

Internet-paket se sastoji iz sledećih parametara:

brzina;
protok;
trajanje ugovora;
ime i prezime korisnika;
adresa korisnika.

Pritom:

Brzina interneta (u Mbit/s) može biti 2, 5, 10, 20, 50 ili 100.
Protok interneta (u GB) može biti 1, 5, 10 ili 100 ili "Flat".
Trajanje ugovora može biti jedna ili dve godine.
Ime, prezime i adresa korisnika se upisuju kao tekst.

Potrebno je omogućiti evidenciju kreiranja ugovora i prodatih paketa i to:

pregled svih prodaja; 
dodavanje novih prodaja;
brisanje postojećih prodaja.

# Arhitektura aplikacije

Standardni i visoko preporučeni pristup za izradu ovog zadatka je korišćenje FXML-a za definisanje korisničkog interfejsa (View) i posebne kontroler klase za upravljanje događajima i logikom (Controller), prateći principe MVC obrasca. Za domenski model, obavezno je kreirati klasu koja predstavlja internet-paket. Aplikaciju je poželjno stilizovati korišćenjem CSS-a.

<img width="809" height="505" alt="image" src="https://github.com/user-attachments/assets/9633d487-aa50-43ef-8985-fc97c3506e91" />

Zadatak je kompletan Maven Java projekat.

# Osnovna logika i model:

Potrebno je implementirati kompletan model (klasu za internet-paket) sa JavaFX Properties i osnovni kontroler koji omogućava sledeće operacije, sa ispisom rezultata u konzoli:

Dodavanje novog paketa (podaci mogu biti statički definisani u kodu).
Prikaz (ispis) svih unetih paketa.

# Kompletan korisnički interfejs:

Nadograditi rešenje kreiranjem kompletnog korisničkog interfejsa pomoću FXML-a. Interfejs treba da sadrži sva polja za unos (tekstualna polja, ChoiceBox ili ComboBox za brzinu/protok) i dugmad. Logika iz kontrolera treba da bude povezana sa interfejsom tako da se podaci unose preko forme.

# Prikaz podataka u tabeli i brisanje:

Nadograditi rešenje tako da se svi uneti paketi prikazuju u TableView kontroli. Tabela treba da bude povezana (bind) sa ObservableList-om u kontroleru. Omogućiti brisanje selektovanog reda iz tabele.
