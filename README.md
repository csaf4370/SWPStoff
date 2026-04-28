---
author: "Martin Schoepf"
lang: "de-AT"
---

# SWPStoff

## Table of Contents

- [SWPStoff](#swpstoff)
  - [Table of Contents](#table-of-contents)
- [coding guidelines](#coding-guidelines)
  - [CamelCase](#camelcase)
- [String Formatierung mit `printf`](#string-formatierung-mit-printf)
- [Enums](#enums)
  - [switch-case Anweisung](#switch-case-anweisung)
- [forEach Schleife](#foreach-schleife)
- [Objektorientierte Programmierung](#objektorientierte-programmierung)
  - [Konstruktor](#konstruktor)
    - [Standardkonstruktor](#standardkonstruktor)
  - [toString() Methoden - Ausgabe eines Objektes](#tostring-methoden---ausgabe-eines-objektes)
  - [Sichtbarkeit](#sichtbarkeit)
  - [Kapselung](#kapselung)
  - [Überladen von Funktionen](#überladen-von-funktionen)
  - [Keyword _static_](#keyword-static)
  - [DRY - Don't Repeat Yourself](#dry---dont-repeat-yourself)
  - [ArrayList](#arraylist)
  - [Vererbung](#vererbung)
    - [_super_-Keyword](#super-keyword)
    - [Keyword _abstract_](#keyword-abstract)
    - [Annotation _@Override_](#annotation-override)
    - [instanceof - überprüfen der Klasse bzw. der Vaterklasse](#instanceof---überprüfen-der-klasse-bzw-der-vaterklasse)
    - [Interfaces - Schnittstellen](#interfaces---schnittstellen)
  - [UML - unified modeling language (class diagram)](#uml---unified-modeling-language-class-diagram)
- [Zufallszahlen (Random)](#zufallszahlen-random)
  - [Spieleprogrammierung mit Processing](#spieleprogrammierung-mit-processing)
  - [Thanks](#thanks)
    - [Thanks after DRY](#thanks-after-dry)
- [git basics](#git-basics)
    - [Ablaufdiagram eines typischen Workflows](#ablaufdiagram-eines-typischen-workflows)
    - [Ignorieren von Dateien](#ignorieren-von-dateien)
- [Exceptions](#exceptions)
  - [Ein ganzes Beispiel](#ein-ganzes-beispiel)
    - [Programm Argumente](#programm-argumente)
- [JavaFX](#javafx)
  - [Maven](#maven)
    - [Projekt Setup](#projekt-setup)
    - [Ausführen](#ausführen)
  - [SceneBuilder - JavaFX](#scenebuilder---javafx)
- [Bitflags](#bitflags)
- [Datenstrukturen](#datenstrukturen)
  - [Linked List](#linked-list)
  - [Doubly Linked List](#doubly-linked-list)
  - [ArrayList](#arraylist-1)
  - [Stack (LIFO) - Last In First Out](#stack-lifo---last-in-first-out)
  - [Queue (FIFO) - First In First Out](#queue-fifo---first-in-first-out)
  - [Binary Search Tree (BST)](#binary-search-tree-bst)
  - [Set](#set)
  - [Map](#map)
- [Algorithmen](#algorithmen)
  - [Sortieralgorithmen](#sortieralgorithmen)
    - [Eigenschaften](#eigenschaften)
      - [Bestimmung Komplexität](#bestimmung-komplexität)
    - [Bubblesort](#bubblesort)
    - [Insertionsort](#insertionsort)
  - [Divide and Conquer](#divide-and-conquer)
  - [MergeSort](#mergesort)
- [Java Argumenten Logik](#java-argumenten-logik)
- [Rekursion](#rekursion)
  - [Endrekursion](#endrekursion)
    - [Beispiel add bei FIFO - Queue](#beispiel-add-bei-fifo---queue)
    - [Beispiel: Suchen einer Datei von einem Verzeichnis aus](#beispiel-suchen-einer-datei-von-einem-verzeichnis-aus)
- [Generics](#generics)
  - [Bounded Generics](#bounded-generics)
  - [Tests mit JUnit](#tests-mit-junit)
- [Design Patterns](#design-patterns)
  - [Oberserver Pattern](#oberserver-pattern)
- [VueJS](#vuejs)
  - [Installation von nvm, npm und vueJs](#installation-von-nvm-npm-und-vuejs)
    - [nvm - Node Version Manager](#nvm---node-version-manager)
    - [npm - Node Package Manager](#npm---node-package-manager)
    - [Install VueJS / Create a Project](#install-vuejs--create-a-project)
    - [Component](#component)
    - [Reaktivität](#reaktivität)
    - [Properties](#properties)
    - [useTemplateRef](#usetemplateref)
    - [Events](#events)
    - [Computed Properties](#computed-properties)
    - [defineExpose](#defineexpose)
    - [Conditional Rendering](#conditional-rendering)
    - [List Rendering](#list-rendering)
    - [watcher](#watcher)
- [Local Restful Server Test Setup](#local-restful-server-test-setup)
  - [docker-compose](#docker-compose)
    - [Vorteile:](#vorteile)
    - [Beispiel `docker-compose.yaml`:](#beispiel-docker-composeyaml)
    - [Erklärung des Beispiels:](#erklärung-des-beispiels)
    - [Wichtige Befehle:](#wichtige-befehle)
    - [docker-compose für unseren Test-Server](#docker-compose-für-unseren-test-server)
    - [show ip of postgres Server](#show-ip-of-postgres-server)

# coding guidelines

## CamelCase

Start abhängig von Typ, jedes weitere Wort groß.

```java
String firstName;
```

Alle Typen in CamelCase starten mit:

- Klassenname groß
- Eigenschaften klein
- Methoden klein
- Enum Groß (Werte alle UPPERCASE)

# String Formatierung mit `printf`

Alternativ zu der Ausgabe auf der Konsole zu `println` gibt es die Funktion `printf`.
Sie ermöglicht das Schreiben eines kompletten Strings mit _Platzhaltern_.

```java
public void print() {
  System.out.println("Schüler: " + this.vName + " " + this.nName);
  System.out.printf("Schüler: %s %s", this.vName, this.nName);
 }
```

Auffällig sind die _Ersetzungsmarken_ im String. In unserem Beispiel verwenden wir `%s`, um
einen String auszugeben.

Die häufig verwendeten sind:

- %s String
- %d Integer
- %f Float / Double
- %n Newline -ersetzt \n

# Enums

Wird verwendet, um einen Datentyp zu erstellen, der nur die definierten Werte annehmen kann.

```java
// Definition
public enum HimmelsRichtung {
  NORDEN,
  OSTEN,
  SUEDEN,
  WESTEN
}

// Verwendung
public static void main(String[] args) {
  HimmelsRichtung hr = HimmelsRichtung.NORDEN;
}
```

Weiters können Enums mit zusätzlichen Attributen ergänzt werden.

```java
// in Datei Artikel.java
public enum Artikel {
  MAUS(324454),
  LAPTOP(4334);

  // wird verwendet um die Nummer des Enums zu speichern
  private int nummer;

  Artikel(int i) {
    nummer = i;
  }

  public int getNummer() {
    return this.nummer;
  }

  // falls wir einen Enum von einer Nummer erzeugen wollen können wir uns eine Funktion definieren
  public static Artikel fromNummer(int nummer) {
    switch (nummer) {
    case 324454:
      return MAUS;
    case 4334:
      return LAPTOP;
    default:
      return MAUS;
    }
  }

  public static void main(String[] args) {
    Artikel a = MAUS; // entspricht logisch: MAUS(324454)
    System.out.println(a.getNummer());

    Artikel a2 = LAPTOP; // entspricht logisch: LAPTOP(4334)
    System.out.println(a2.getNummer());

    Artikel a3 = Artikel.fromNummer(4334);
    System.out.println(a3);
  }
}
```

## switch-case Anweisung

Wird verwendet, um mögliche Fälle zu behandeln. Kann mit If-Abfragen ersetzt werden.

```java
public void printHimmelsRichtung(HimmelsRichtung hr) {
  switch (hr) {
    case NORDEN: System.out.println("Norden");break;
    case SUEDEN: System.out.println("Sueden");break;
    default: System.out.println("was anderes als Norden und Sueden");
  }
}

public void printHimmelsRichtungIf(HimmelsRichtung hr) {
  if (hr == NORDEN) {
    System.out.println("Norden");
  } else if (hr == SUEDEN) {
    System.out.println("Sueden");
  } else {
    System.out.println("was anderes als Norden und Sueden");
  }
}

public static void main(String[] args) {
  HimmelsRichtung hr = HimmelsRichtung.NORDEN;
  printHimmelsRichtung(hr);
  // prints: Norden
}
```

Falls das **break** vergessen wird, fällt die Auswertung durch => darunter liegende Code-Zeilen werden ausgeführt.

# forEach Schleife

Ist eine Kurzform der normalen for-Schleife und kann verwendet werden, wenn die Zählvariable (meist _i_) nicht gebraucht wird.

```java
// Tiere ist eine Klasse mit name als Attribut

public static void printHundeRasse(ArrayList<Tier> tiere) {
  for (Tier t : tiere) { // forEach loop
    System.out.println(t.getName());
  }

  // equivalent
  for (int i = 0; i < tiere.size(); i++) {
    Tier t = tiere.get(i); // normaler Array tiere[i]
    System.out.println(t.getName());
  }
}
```

# Objektorientierte Programmierung

Dient zur besseren Strukturierung von Programmen.
Durch Definieren eines "Bauplans", werden Eigenschaften und Funktionen eines Objektes definiert.

```java
// in Datein Person.java
class Person {
  // Eigenschaften/Attribute
  private String firstName;
  private String lastName;

  // Methoden (Funktionen der Klasse)
  public void printFirstName() {
    System.out.println(this.firstName);
  }

  // Konstruktor
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public static void main(String[] args) {
    // Erstellung eines Objektes vom Typ Person
    Person p = new Person("Sepp", "Huber");
  }
}
```

Klasse _Person_ mit 2 Eigenschaften (firstName, lastName).

## Konstruktor

Wird verwendet, um eine Instanz einer Klasse zu erstellen. Die definierten Parameter des Konstruktors können verwendet werden, um die Eigenschaften des Objektes zu setzen.

### Standardkonstruktor

Falls kein anderer Konstruktor definiert ist, wird ein Standardkonstruktor erzeugt. Er hat keine Parameter und die Eigenschaften des Objektes entsprechen den Default-Werten.

```java
class Person {
  private String firstName; // Default für String = ""
  private boolean test; // Default für boolean = false

  // Default Konstruktor enspricht
  // public Person() {
  // }

  public static void main(String[] args) {
    // Verwendung des Default-Konstruktors
    Person p = new Person();
    // p.firstName entspricht ""
    // p.test entspricht false
  }
}
```

### Konstruktor mit Argumenten


```java
class Person {
  private String firstName; // Default für String = ""
  private boolean test; // Default für boolean = false

  // Konstruktor mit Argumenten
  public Person(String firstName, boolean test) {
    this.firstName = firstName;
    this.test = test;
  }

  public static void main(String[] args) {
    // Verwendung des Argumenten-Konstruktors
    Person p = new Person("Martin", true);
    // p.firstName entspricht "Martin"
    // p.test entspricht true
  }
}
```
## toString() Methoden - Ausgabe eines Objektes

Wenn man versucht ein Objekt einer selbst-definierten Klasse auszugeben, wird man meist mit einer Ausgabe à la.
`Auto@677327b6` überrascht. Um die Ausgabe zu verbessern, ist es möglich in der jeweiligen Klasse eine _toString()_-Methode zu erstellen, welche einen String zurück, welche das Objekt beschreibt.

```java
class Auto{
  private String marke;
  private int baujahr;

  public Auto(String marke, int baujahr){
    this.marke = marke;
    this.baujahr = baujahr;
  }

  @Override
  public String toString(){
    return "Auto: " + this.marke + " Baujahr: " + this.baujahr;
  }

  public static void main(String[] args) {
    Auto a = new Auto("Ford Escort", 1988);
    System.out.println(a); // gibt aus: Auto: Ford Escort Baujahr: 1988
  }
}
```

## Sichtbarkeit

Definiert, wer von wo auf das Element zugreifen kann.
Es gibt folgende Sichtbarkeiten:

- private --> nur in der gleichen Klasse sichtbar
- public --> von überall sichtbar
- (protected) --> sichtbar im gleichen Package und Subklassen
- default --> entspricht für uns derzeit protected

## Kapselung

Wird verwendet, um Eigenschaften einer Klasse mithilfe der Sichtbarkeit zu verbergen. Eigenschaften einer Klasse sind demnach meistens _privat_. Zugriff von Außen wird über Funktionen geregelt (Getter und Setter). Wenn diese angeboten werden, können von außen Werte ausgelesen bzw. gesetzt werden.

```java
class Person{
  // Eigenschaften privat
  private int age;

  // Getter von age
  public int getAge() {
    return this.age;
  }

  // Setter von age
  public void setAge(int val) {
    this.age = val;
  }
}

```

## Überladen von Funktionen

Funktionen und Konstruktoren dürfen den gleichen Namen haben, müssen sich aber über die Parameter unterscheiden. Nur das Ändern des Rückgabetyps reicht nicht.

```java
class Person{
  private int age;
  private String fname;

  // Konstruktor 1
  public Person() {
    this.age = 12;
    this.fname = "unbestimmt";
  }

  // Konstruktor 2
  public Person(int age) {
    this.age = age;
    this.fname = "Sepp";
  }

  // Konstruktor 3
  public Person(int age, String fname) {
    this.age = age;
    this.fname = fname;
  }

  public static void main(String[] args) {
    Person p1 = new Person();
    // Konstruktor 1 || age=12, fname="unbestimmt"
    Person p2 = new Person(18);
    // Konstruktor 2 || age=18, fname="Sepp"
    Person p3 = new Person(17, "Martin");
    // Konstruktor 3 || age=17, fname="Martin"
  }

  // Funktoniert auch für normale Funktionen
  void ueTest() {
    System.out.println("test");
  }

  // ueberladen der Funktion
  void ueTest(int parameter) {
    System.out.println("test " + parameter);
  }

  // funktioniert nicht, weil Unterscheidung nur über Rückgabetyp, Parameter sind gleich wie vorhandene Funktion
  int ueTest(int parameter) {
    return 42;
  }
}
```

## Keyword _static_

Wird verwendet, um am "Bauplan" der Klasse, Funktionen und Eigenschaften zu definieren, welche ohne Objekt verwendet werden können. Alle Objekte der Klasse können auf statische Funktionen und Variablen zugreifen. Statische Variablen gibt es nur einmal (alle sehen den gleichen Wert).

```java
public class Person {

  private String name;

  private static int anzErstellt; // ist gültig für Bauplan und alle Objekte

  public static int getAnzErstellt() {
    return anzErstellt;
  }

  // Konstruktor: erhöht Anzahl erstellter Personen um 1
  Person() {
    anzErstellt++;
    this.name = "Sepp";
  }

  public String getName() {
    return this.name;
  }


  public static void main(String[] args) {
    Person martin = new Person();
    // hier ist anzErstellt == 1
    Person sepp = new Person();
    // hier ist anzErstellt == 2
    System.out.println(Person.getAnzErstellt()); // von Bauplan

    System.out.println(sepp.getName()); // von Objekt
  }

```

## DRY - Don't Repeat Yourself

Vermeide gleichen oder ähnlichen Code um Fehler zu vermeiden und den Code übersichtlicher und nachvollziehbarer zu gestalten.

```java
// import java.util.Random;
// import java.util.Arrays;

public static void einPaarZahlen(){
  Random rand = new Random();
  int ersteZahlen[] = new int[3];
  for (int i = 0; i < 3; i++) {
    ersteZahlen[i] = rand.nextInt(10);
  }
  int zweiteZahlen[] = new int[5];
  for (int i = 0; i < 5; i++) {
    zweiteZahlen[i] = rand.nextInt(10);
  }
  int dritteZahlen[] = new int[10];
  for (int i = 0; i < 10; i++) {
    dritteZahlen[i] = rand.nextInt(10);
  }
  // .. mache was mit den 3 Variablen ... zB:
  int sumOfArrays[] = new int[3];
  for (int i = 0; i < 3; i++) {
    int sum = 0;
    sum += ersteZahlen[i];
    sum += zweiteZahlen[i];
    sum += dritteZahlen[i];
    sumOfArrays[i] = sum;
  }
  System.out.println(Arrays.toString(sumOfArrays));
}

// nach dem DRY- Optimierung

private static int[] createRandomArray(int length){
  Random rand = new Random();
  int zahlenA[] = new int[length];
  for (int i = 0; i < length; i++) {
    zahlenA[i] = rand.nextInt(10);
  }
  return zahlenA;
}

public static void einPaarZahlen(){
  int ersteZahlen[] = createRandomArray(3);
  int zweiteZahlen[] = createRandomArray(5);
  int dritteZahlen[] = createRandomArray(10)
  // .. mache was mit den 3 Variablen ... zB:
  int sumOfArrays[] = new int[3];
  for (int i = 0; i < 3; i++) {
    int sum = 0;
    sum += ersteZahlen[i];
    sum += zweiteZahlen[i];
    sum += dritteZahlen[i];
    sumOfArrays[i] = sum;
  }
  System.out.println(Arrays.toString(sumOfArrays));
}
```

## ArrayList

Wird benötigt, um Arrays zu erzeugen, welche zur Laufzeit erweitert werden können. Wird auch als dynamischer Array bezeichnet. **Wichtig**: eine ArrayList kann nur Objektdatentypen (keine primitiven Datentypen) speichern. Java stellt für genau diesen Zweck _Wrapperklassen_ zur Verfügung. _Integer_ beinhaltet einen _int_, oder _Float_ beinhaltet einen _float_, usw.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Benutzer gibt beliebig viele Zahlen en
    // werden in Array gespeichert
    ArrayList<Integer> inputsArray = new ArrayList<Integer>();
    int input = 0;
    Scanner scan = new Scanner(System.in);
    while (input != -1) {
      input = scan.nextInt();
      inputsArray.add(input); // erweitern um eine Stelle
    }
    // hiert wird size() anstatt length verwendet
    for (int i = 0; i < inputsArray.size(); i++) {
      System.out.println(inputsArray.get(i));
    }
  }
}
```

weiteres Beispiel:

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> al = new ArrayList<String>();
    String vorName = "";
    boolean cont = false;
    do {
      cont = false;
      vorName = scan.nextLine();
      if (!("".equals(vorName))) {
        al.add(vorName);
        cont = true;
      }
    } while ( cont == true );
    System.out.println(al);
    System.out.printf("Die Laenge der Arraylist %s is %d", al, al.size());
  }
}
```

## Vererbung

Wird verwendet um Code besser strukturieren zu können. Öfter verwendete Attribute und Methoden können in einer Klasse zusammengefasst werden, um Fehler zu vermeiden und dem _DRY_-Prinzip zu folgen.
Um von Klassen erben zu können, wird das keyword _extends_ verwendet.

### _super_-Keyword

_super_ ruft den Konstruktor der vererbten Klasse auf.
Falls eine Methode der Vaterklasse aufgerufen werden soll, obwohl die aktuelle Klasse die Methode überschrieben hat, kann man mit

```java
super.methodenName(...)
```

die ursprüngliche Methode aufrufen.

```java
\\ in Tier.java
public abstract class Tier {

 private String name;
 private String gebTag;

 public String getName() {
  return name;
 }
 public String getGebTag() {
  return gebTag;
 }

 public Tier(String name, String gebTag) {
  this.name = name;
  this.gebTag = gebTag;
 }

  public String gibLaut(){
    return "tierGeräusch";
  }
}

\\in Hund.java
public class Hund extends Tier {

 private String rasse;

 public Hund(String name, String gebTag, String rasse) {
  super(name, gebTag); // Aufruf des Konstruktors der Vaterklasse
  this.rasse = rasse;
 }

 public String getRasse() {
  return rasse;
 }

  @Override
  public String gibLaut(){
    return "wuff";
  }

  public String gibLautVonVater(){
    return super.gibLaut();
  }
}

\\ in Main.java
public class Main {
  public static void main(String[] args) {
    Hund hund = new Hund("Hansi","1.1.2010","Pudel");
    hund.gibLaut(); // gibt aus: wuff
    hund.gibLautVonVater(); // gibt aus: tierGeräusch
  }
}

```

### Keyword _abstract_

Markiert die Klasse, dass sie nicht instanziiert werden kann(es kann kein Objekt dieser Klasse erzeugt werden).

### Annotation _@Override_

Steht über einer Funktion, welche überschrieben werden soll. Es kann auch ohne _@Override_ überschrieben werden. _@Override_ erstellt einen Vertrag, dass genau die Signatur der Funktion entsprechen muss. Ohne diesem Keyword, läuft man Gefahr, dass wenn die Signatur einer Methode der Vaterklasse sich verändert, ich die Methode nur überlade und nicht überschreibe.

```java
// Fahrzeug.java
// Erstellen einer Klasse welche vererbt werden soll. - abstract
public abstract class Fahrzeug {

 private int ps;
 private int baujahr;
 private double currentVelocity;

 public Fahrzeug(int ps, int baujahr) {
  this.ps = ps;
  this.baujahr = baujahr;
  this.currentVelocity = 0.0;
 }

 public void accelerate() {
  this.currentVelocity += this.ps/10.0;
 }

 public int getPs() {
  return ps;
 }

 public int getBaujahr() {
  return baujahr;
 }

 public double getCurrentVelocity() {
  return currentVelocity;
 }

 protected void setCurrentVelocity(double v) {
  this.currentVelocity = v;
 }
}

// Auto.java
// Subklasse (Klasse die von Vaterklasse erbt)
public class Auto extends Fahrzeug{

 private String marke;

 public Auto(int ps, int baujahr, String marke) {
  super(ps, baujahr);
  this.marke = marke;
 }

 public String getMarke() {
  return marke;
 }
}

// Traktor.java
// erbt ebenfalls von Fahrzeug
public class Traktor extends Fahrzeug {
 private double zugKraft;

 public Traktor(int ps, int baujahr, double zugKraft) {
  super(ps, baujahr);
  this.zugKraft = zugKraft;
 }

 public double getZugKraft() {
  return zugKraft;
 }

 @Override
 public void accelerate() {
  this.setCurrentVelocity( this.getCurrentVelocity() + this.getPs()/40.0);
//  this.currentVelocity += this.getPs()/40.0;
 }

}

```

### instanceof - überprüfen der Klasse bzw. der Vaterklasse

Wird verwendet, um während der Laufzeit zu überprüfen ob, das Objekt in eine bestimmte Klasse **_gecastet_** werden kann, also ob die Klasse des Objekts dem gecasteten entspricht bzw. in der Vererbungshirarchie anzutreffen ist.

```java
// in Tier.java
public abstract class Tier{
  protected String name;
  protected String geburtsDatum;

  public getGeburtsDatum() {
    return this.geburtsDatum;
  }

  public String getName(){
    return this.name;
  }

  public Tier(String name, String geburtsDatum){
    this.name = name;
    this.geburtsDatum = geburtsDatum;
  }
}

// in Hund.java
public class Hund extends Tier{
  private String rasse;

  public String getRasse(){
    return this.rasse;
  }

  public Hund(String name, String geburtsDatum, String rasse){
    super(name, geburtsDatum);
    this.rasse = rasse;
  }
}

// in Katze.java
public class Katze extends Tier{

  public Katze(String name, String geburtsDatum){
    super(name, geburtsDatum);
  }
}

// in Klasse Main.java
import java.util.ArrayList;

public class Main {

 public static void printHundeRasse(ArrayList<Tier> tiere) {
  for (Tier t : tiere) { // forEach loop
   if (t instanceof Hund) {
    Hund h = (Hund) t; // cast (umwandlung) zu Hund
    System.out.println(h.getRasse());
   } else {
    System.out.println("leider keine Rasse vorhanden (kein Hund)");
   }
  }

  // alternative
  for (int i = 0; i < tiere.size(); i++) {
   Tier t = tiere.get(i);
   if (t instanceof Hund) {
    Hund h = (Hund) t; // cast (umwandlung) zu Hund
    System.out.println(h.getRasse());
   } else {
    System.out.println("leider keine Rasse vorhanden (kein Hund)");
   }
  }
 }

 public static void main(String[] args) {
  ArrayList<Katze> katzen = new ArrayList<Katze>();
  Katze schmusi = new Katze("Schmusi", "10.10.2010");
  katzen.add(schmusi);

  ArrayList<Hund> hunde = new ArrayList<Hund>();
  Hund kratzi = new Hund("Kratzi", "10.10.2010", "Rotweiler");
  hunde.add(kratzi);

  ArrayList<Tier> tiere = new ArrayList<Tier>();

  tiere.add(schmusi);
  tiere.add(kratzi);

  System.out.println(tiere);

  // geht nicht = abstract
//  Tier t = new Tier("tiere=i", "1.1.1111");

  printHundeRasse(tiere);

  kratzi.getRasse();

 }

}
```

### Interfaces - Schnittstellen | Vertrag

Durch die "Einschränkung", dass Java keine Mehrfachvererbung erlaubt, anders als andere Sprachen wie zb. C++, bedient sich Java eines Konzepts namens Interfaces. Diese dienen der Beschreibung was die Klasse erfüllen muss (wie ein Vertrag). Daher wird im Interface definiert, dass bestimmte Methoden überschrieben werden müssen. Es können beliebig viele Interfaces implementiert (nicht extended - wie bei (abstrakten) Klassen) werden.

Interfaces kann man als Verträge verstehen, welche implementierende Klassen erfüllen müssen.

```java
// in IFahrAmWasser.java
public interface IFahrAmWasser{
  // alle Funktionen müssen von der imlementieren Klasse überschrieben werden
  public void fahrAmWasser(); 
  public void honk(boolean superLaut);
}

// in Amphibien.java
public class Amphibien implements IFahrAmWasser{
  
  public void honk(boolean superL){
    if (superL){
      System.out.println("LAUT HONK");
    } else {
       System.out.println("honk");
     }
  }

  public void fahrAmWasser(){
    System.out.println("brruuumm");
  }
}

// in Main.java
public class Main {

  // Alle Klassen die IFahrAmWasser erfüllen können verwendet werden
  public static void fahrW(IFahrAmWasser i){
    i.fahrAmWasser();
    i.honk(false);
    i.fahren();
  }
  
  public static void main(String[] args) {
  	Amphibien a = new Amphibien();
  	a.honk(true);
  	Boot b = new Boot();
  	b.fahrAmWasser();

  	fahrW(a);
  	fahrW(b);

  	IFahrAmWasser i = new Amphibien();
  }
}
```

## UML - unified modeling language (class diagram)

[https://en.wikipedia.org/wiki/Class_diagram](https://en.wikipedia.org/wiki/Class_diagram)

Wird verwendet um eine einheitliche "Sprache" zu definieren, welche uns erlaubt programmiersprachenunabhängig Klassen und ihre Beziehungen zu beschreiben.

![Beispiel Vererbung](diagrams/inheritance.png)

Hier wird eine abstrakte Klasse Kreatur definiert. Die Klasse Mensch erbt von ihr und die Klasse mein erzeugt ein Objekt der Klasse Mensch.

# Zufallszahlen (Random)

Können von System generiert werden, es gibt mehrere Möglichkeiten, diese zu erzeugen.

```java
import java.util.Random; // wichtig

public class Main {
  public static void main(String[] args) {
    // Erstellen eines int
    Random rand = new Random();
    int randomZahl = rand.nextInt(10); // Zahl zwischen 0 und 10 exclusive

    Random rand = new Random();
    int bound = 1000; // wie weit - exclusive dieser Zahl
    int randomZahl = rand.nextInt(bound) + 10;
    System.out.println(randomZahl); // Zahl zwischen 10 - 1010 exclusive

    double randDouble = rand.nextDouble();
    System.out.println(randDouble); // Zahl zwischen 0.0 und 1.0 exclusive

    // Ziel ist es einen Double von 10.0 - 20.0 zu machen
    int randomZahl2 = rand.nextInt(9) + 10;
    double randDouble2 = rand.nextDouble();
    double res = randDouble2 + randomZahl2;
    System.out.println(res);

    // Alternative
    double randDouble3 = rand.nextDouble()*10.0 + 10.0;
    System.out.println(randDouble3);
  }
}
```

## Spieleprogrammierung mit Processing

erstes Spiel ... Pong (start)

```java
 int posX = 0;
 int posY = 0;
 int accX = 1;
 int accY = 1;
 int accSpeed = 5;

void setup() {
  size(640, 360);
  noStroke();
  rectMode(CENTER);
}

void draw() {

  fill(255, 204);

  if (posX > 640) {
   accX = -accSpeed;
  }
  if (posX <= 0) {
   accX = +accSpeed;
  }
  if (posY > 360) {
   accY = -accSpeed;
  }
  if (posY <= 0) {
   accY = +accSpeed;
  }

  posX = posX + accX;
  posY = posY + accY;
  circle(posX, posY, 10);
}
```

## Thanks

```java
float x = 50;
float y = 50;
float angle = 45;
float force = 100;
boolean shooting = false; // indicator if ball is in the air
int startTime = 0; // start time of fire
float g = 9.81; // gravity

void setup() {
  size(640, 360);
  noStroke();
  background(0);
}

float getVxt(float angle) {
  return force * cos(radians(angle));
}

float getVyt(float angle, float t) {
  return -g*t + force * sin(radians(angle));
}

float getX(float t, float x0, float angle){
  return getVxt(angle)*t+x0;
}

float getY(float t, float y0, float angle){
  return -g/2 * t*t + getVyt(angle,t)*t + y0;
}

void keyPressed() {
  if (key == 'd') {
    angle += 3;
  } else if (key == 'a') {
    angle -= 3;
  } else if (keyCode == RIGHT) {
    x += 3;
  } else if (keyCode == LEFT) {
    x -= 3;
  } else if (key == 'w') {
    force += 10;
  }else if (key == 's') {
    force -= 10;
  } else if (key == ' ') {
    shooting = true;
    startTime = millis();
  }
}

void draw() {
  background(0);
  color(128);
  scale(1, -1);
  translate(0, -height);
  rectMode(CENTER);
  rect(x, y, 30, 30);
  stroke(128);
  float lineEndX = acos(radians(angle))*100+x+15;
  float lineEndY = asin(radians(angle))*100+y+15;
  println(angle,lineEndX, lineEndY);
  line(x+15,y+15,lineEndX,lineEndY);

  text(force,width-100, height-100);

  if (shooting) {
    float deltaT = millis() - startTime;
    float newX = getX(deltaT/1000.0,x,angle);
    float newY = getY(deltaT/1000.0,y,angle);
    println("newX", newX, deltaT, angle, newY);
    circle(newX,newY,30);
  }
}
```

### Thanks after DRY

```java
// main
Tank tank1 = new Tank(50, 50);
Tank tank2 = new Tank(400, 50);
Tank currentTank = tank1;
Bullet bullet;

void setup() {
  size(640, 360);
  noStroke();
  background(0);
}

Tank getOtherTank(){
  if (currentTank == tank1) {
    return tank2;
  } else {
    return tank1;
  }
}

void switchTank() {
  if (currentTank == tank1) {
    currentTank = tank2;
  } else {
    currentTank = tank1;
  }
}

void keyPressed() {
  if (key == 'd') {
    currentTank.angle += 3;
  } else if (key == 'a') {
    currentTank.angle -= 3;
  } else if (keyCode == RIGHT) {
    currentTank.x += 3;
  } else if (keyCode == LEFT) {
    currentTank.x -= 3;
  } else if (key == 'w') {
    currentTank.force += 10;
  } else if (key == 's') {
    currentTank.force -= 10;
  } else if (key == ' ') {
    bullet = new Bullet(currentTank.angle, currentTank.force, currentTank.turretX, currentTank.turretY);
  }
}

void draw() {
  background(0);
  color(128);
  scale(1, -1);
  translate(0, -height);
  rectMode(CENTER);

  tank1.draw();
  tank2.draw();

  if (bullet != null) {
    bullet.draw();
  }
}

// Tank
class Tank {
  float x = 50;
  float y = 50;
  float angle = 45;
  float force = 100;
  final float width_ = 30;
  final float height_ = 30;
  float turretX = 0;
  float turretY = 0;

  Tank(float x, float y, float angle, float force) {
    this.x = x;
    this.y = y;
    this.angle = angle;
    this.force = force;
  }

  Tank(float x, float y) {
    this.x = x;
    this.y = y;
  }

  void draw() {
    rect(x, y, width_, height_);
    stroke(128);
    turretX = cos(radians(angle))*50+x;
    turretY = sin(radians(angle))*50+y;
    //println(angle, lineEndX, lineEndY);
    line(x, y, turretX, turretY);

    translate(0, height);
    scale(1, -1);
    textSize(60);
    text(force, x, height-300);
    scale(1, -1);
    translate(0, -height);
  }
}


// Bullet
class Bullet {
  int startTime = 0; // start time of fire
  final float g = 9.81; // gravity
  float angle = 0;
  float force = 0;
  float x0 = 0;
  float y0 = 0;
  float x = 0;
  float y = 0;
  float width_ = 15;

  Bullet(float angle, float force, float x0, float y0) {
    this.angle = angle;
    this.force = force;
    this.x0 = x0;
    this.y0 = y0;
    this.startTime = millis();
  }

  float getVxt(float angle) {
    return force * cos(radians(angle));
  }

  float getVyt(float angle, float t) {
    return -g*t + force * sin(radians(angle));
  }

  float getX(float t, float x0, float angle) {
    return getVxt(angle)*t+x0;
  }

  float getY(float t, float y0, float angle) {
    return -g/2 * t*t + getVyt(angle, t)*t + y0;
  }

  void draw() {
    float deltaT = millis() - startTime;
    x = getX(deltaT/1000.0, x0, angle);
    y = getY(deltaT/1000.0, y0, angle);
    //println("newX", x, deltaT, angle, y);
    circle(x, y, width_);
    Tank ot = getOtherTank();
    if ( ((x >= ot.x - ot.width_/2.0) && (x <= ot.x + ot.width_/2.0))
      && ((y >= ot.y - ot.height_/2.0) && (y <= ot.y + ot.height_/2.0)) ) {
      println("hit");
      exit();
      bullet = null;
      switchTank();
    }

    if ( x > 655 || x <-width_ / 2.0 || y < -width_ / 2.0 ) {
      bullet = null;
      switchTank();
    }
  }
}

```

# git basics

git ist ein Versionsverwaltungssystem, welches uns erlaubt verschiedene Versionen nachvollziehbar zu speichern und es erlaubt uns einfaches Zusammenarbeiten mit anderen Mitarbeitern.

Es existiert (normalerweise) ein `remote` repository auf zb. Github und ein `lokales` auf unserer Festplatte.

Wenn wir ein Repository angelegt haben (zb. auf Github) können wir es mit:

`git clone https://github.com/username/repositoryName`

auf unser System clonen.

**Wir müssen uns im git Verzeichnis befinden um folgende Befehle ausführen zu können.**

mit `git add dateiname.endung` können wir Dateien zu den "beobachtenden" Dateien hinzufügen.

mit `git commit -m"nachricht welche in de Logs erscheint"` erzeuge ich einen neuen _Busstop_ welcher wie eine Version der Codebasis angesehen werden kann.

Durch `git push` werden die Änderungen meines Repostitories auf das `remote` Repository übertragen.

Um Änderungen von `remote` Repository in mein System zu holen, wir der Befehl `git pull` verwendet.

Jederzeit kann `git status` verwendet werden um den aktuellen Status des Repositories abzufragen.

### Ablaufdiagram eines typischen Workflows

![ablauf diagramm](diagrams/git.png)

### Ignorieren von Dateien

um nicht benötigte Dateien (zB. Dateien, welche beim compilieren erzeugt werden) zu ignorieren können wir im Hauptverzeichnis die Datei _.gitignore_ erzeugen/editieren.

```
**.class
```

ignoriert alle _.class_ Dateien.

# Exceptions

Exception entsprechen Ausnahmen, auf die der Benutzer reagieren kann.
Viele kennen eine der folgenden: _ArrayOutOfBoundsException_ oder _NullPointerException_.
Diese Ausnahmen können entweder mit:

- try/catch
- throws

behandelt werden. Mit try/catch werden die Programmzeilen, welche
eine Exception werfen können in einen Block eingeschlossen.

```java
FileWriter writer = null;
try {
 writer = new FileWriter("myFile.txt");
 writer.write(myString);
 writer.close();
 System.out.println("Successfully wrote to the file.");
} catch (IOException e) {
 System.out.println("Da ist etwas schief gelaufen.");
}
```

hier kann auf den Fehler direkt reagiert werden.
Falls die Aufgabe des Fehlerbehandelns abgegeben werden soll, kann man
die Exception an die aufrufende Funktion weiterreichen --> _throws_

```java
private static void writeToFile(String what) throws IOException {
 FileWriter writer = null;
 writer = new FileWriter("myFile.txt");
 writer.write(what);
 writer.close();
 System.out.println("huhu");
}
```

Exceptions erben von _Throwable_, welche eine Vaterklasse von _Error_ und
_Exception_ ist. _Error_ definiert Fehler, auf die nicht reagiert werden kann/soll.

Man kann Exception einfach als Klasse definieren:

```java
// in class ToExpensiveException
public class ToExpensiveException extends Exception {

}
```

diese kann dann wie folgt verwendet werden:

```java
public static void throwMeMaybeAnException(int price) throws ToExpensiveException {
  if (price > 10) {
   throw new ToExpensiveException(); // hier wird die Exception erzeugt und geworfen
  }
 }
```

## Ein ganzes Beispiel

```java
// in ToExpensiveException.java
public class ToExpensiveException extends Exception {

}

```

```java
import java.io.FileWriter;
import java.io.IOException;

public class Main {

 public static void throwMeMaybeAnException(int price) throws ToExpensiveException {
  if (price > 10) {
   throw new ToExpensiveException();
  }
 }

 private static void writeToFile(String what) throws IOException {
  FileWriter writer = null;
  writer = new FileWriter("myFile.txt");
  writer.write(what);
  writer.close();
  System.out.println("huhu");
 }

 public static void main(String[] args) throws IOException {
  String myString = "Hello, world!";
  // Variante try catch
  FileWriter writer = null;
  try {
   writer = new FileWriter("myFile.txt");
   writer.write(myString);
   writer.close();
   System.out.println("Successfully wrote to the file.");
  } catch (IOException e) {
   System.out.println("Da ist etwas schief gelaufen.");
  }

  // Behandlung des Fehlers
  try {
   throwMeMaybeAnException(11);
   System.out.println("Yeah I have something to eat");
  } catch (ToExpensiveException e) {
   System.out.println("Sorry inflation!");
  }

  try {
   writeToFile("Servas");
  } catch (IOException e) {
   System.out.println("sorry my friend");
  }

 }

}
```

### Programm Argumente

Um unser Programm von außen steuern zu können, gibt uns Java(und sogut wie alle anderen Programmiersprachen)
die Möglichkeit Argument dem Programm beim Start zu übergeben.
Die passiert über die _main_-Methode mit den Argument _String[] args_.
Argumente können in Eclipse unter _Run Configurations..._ unter _Java Applications_ richtiges Programm wählen _Arguments_.
Die Argumente müssen bei Bedarf in den richtigen Datentyp konvertiert werden.
Im folgenden Beispiel wird ein _int_ von einem String konvertiert.

```java
public class Main {
 public static void main(String[] args) {
  int sum = 0;
  for (String s : args) {
   try {
    int intValue = Integer.parseInt(s); // can throw NumberFormatException
    sum += intValue;
   } catch (NumberFormatException e) {
    System.out.println("Not a number in argument");
   }
  }
  System.out.println("Sum of all arguments: " + sum);
 }

}
```

# JavaFX

Um Benutzern mehr Komfort zu bieten werden meist Programm-Interaktionen mit GUIs (Graphical User Interfaces) gelöst.
Java bietet mehrere Möglichkeiten (SWT, AWT, JFace, ...), aber JavaFX wurde gewählt, da es die modernsten Oberflächen
bauen kann.

Um JavaFX verwenden zu können, müssen wir zusätzliche Bibliotheken installieren. Wir können entweder Bibliotheken selber
herunterladen und sie in unseren Projekten dem Build-Path hinzufügen, oder wir verwenden folgende Methode.

## Maven

Maven ist ein Paketmanager für die Programmiersprache Java. Er dient dazu Bibliotheken zentral verfügbar zu machen und
Abhängigkeiten unserer Programme leichter definieren zu können. Daher können wir in einer Textdatei (pom.xml) eintragen, von
welchen Bibliotheken unser Programm abhängt. Maven erledigt dann alle schritte welche sonst von Hand nötig wären:

- herunterladen der Dateien
- eintragen der Bibliotheken im Build-Path

Durch dieses System, können wir also in einer einfachen Textdatei, welche wir auch in unser Versionsverwaltungssystem(git) eintragen können,
alle Abhängigkeiten einfach definieren. Wenn wir uns an einem anderen Computer befinden, übernimmt Maven wieder den Download und weitere
Schritte damit wir direkt weiterarbeiten können.

Um Maven zu installieren, wählen wir die einfache Variante und verwenden [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/release/2023-03/r/eclipse-ide-enterprise-java-and-web-developers)

### Projekt Setup

Um ein Maven Projekt zu erzeugen, wählen _Neues Maven Projekt_, im folgenden Screen einfach next und bei Filter geben wir `javafx` ein. Wir wählen in der List darunter dann das Element `com.gluonhq`-`gluonfx-archetype-javafx` mit der Version 0.0.3.
Im folgenden Fenster geben wir unter `Group ID` den gewünschten Paketnamen an und unter `Artifact Id` den gewünschten Projektnamen.
Nach `Finish` und einem Enter im Consolenfenster indem `Y: :` steht, sollten wir auf der linken Seite das neue Projekt sehen.

### Ausführen

Um das Maven Projekt zu starten, gehen wir über das Projektkontextmenü unter `Run As` -> `Maven build`. Darin schreiben wir unter Goals: `clean javafx:run`

## SceneBuilder - JavaFX

Um da Programm besser aufteilen zu können, und Fehler zu vermeiden werden wird das MVC (Model, View, Controller)- Muster verwendet:

- Model: Datenspeicher des Programms
- View: JavaFX GUI
- Controller: Klassen für das reagieren auf Ereignisse (zb. ActionEvent)

Um eine GUI mit JavaFX mit einem SceneBuilder erzeugen zu können, brauchen wir als erstes das Programm:

[SceneBuilder download](https://gluonhq.com/products/scene-builder/#download)

Dieses Programm wird verwendet um die GUI "zusammen zu klicken". Das Layout (also das Ergebnis) wird in Form einer XML-Datei (.fxml) gespeichert.

![SceneBuilder](scenebuilder.png)

Um die diese Scene verwenden zu können muss:

- Die fxml-Datei in den resources Folder gelegt werden:
  ![Tree View in Eclipse](javafx-tree.png)
- ergänzen der pom.xml unter `<dependencies>`um folgende Zeilen:

  ```xml
  <dependencies>
    ...
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>11.0.1</version>
    </dependency>
  </dependencies>
  ```

- ersetzen des `start` codes in der `HelloFx.java` mit folgenden Code:

  ```java
  public void start(Stage stage) {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("main.fxml"));
    } catch (IOException e) {
      System.out.println("could not load main.fxml");

      e.printStackTrace();
    }
    Scene scene = new Scene(root, 640, 480);
    scene.getStylesheets().add(HelloFX.class.getResource("styles.css").toExternalForm());
    stage.setScene(scene);
    stage.show();
  }
  ```

## Elemente mit Code anlegen

wir können JavaFX auch ohne xml bauen, indem wir die Elemente mit Code erstellen und miteinander verbinden:

In diesem Beispiel erstellen wir das Spiel numberguesser (Erraten der Nummer im Bereeich 1 - 100).
```java
package at.ac.htlinn.numberguesser2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {

    private int randomNumber = 0;
    private Label l = new Label("Rate die Zahl!");
    private TextField tf = new TextField("");
    private Button btn = new Button("rate!");
    private Button btnNochmal = new Button("Nochmal!");

    private void resetGame(){
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        System.out.println(randomNumber);
        l.setText("Rate die Zahl");
        btn.setDisable(false);
        btnNochmal.setVisible(false);
    }

    @Override
    public void start(Stage stage) throws IOException {
        resetGame();

        btn.setOnAction( e -> {
            String fieldText =tf.getText();
            int guessedNumber = Integer.parseInt(fieldText);
            System.out.println(guessedNumber);

            if (guessedNumber > randomNumber){
                l.setText("Zu hoch!");
            } else if (guessedNumber < randomNumber) {
                l.setText("Zu klein!");
            } else {
                l.setText("Du bist ein Wahnsinn!");
                btn.setDisable(true);
                btnNochmal.setVisible(true);
            }
        });

        btnNochmal.setOnAction( e -> {
                resetGame();
           });

        VBox vBox = new VBox(l, tf, btn, btnNochmal);

        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("Numberguesser!");
        stage.setScene(scene);
        stage.show();
    }
}
```

# Bitflags

Werden häufig in C oder C++ Code effizient zu programmieren. Häufig in Kombination mit Microcontrollern um bestimmte Register zu setzen. In java wenig häufig verwerndet.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
  ArrayList<Integer> numbers = new ArrayList<>();
  ArrayList<Integer> fizz = new ArrayList<>();
  ArrayList<Integer> buzz = new ArrayList<>();
  ArrayList<Integer> fizzBuzz = new ArrayList<>();

  System.out.println("Zahl plz");
  Scanner scan = new Scanner(System.in);
  int to = scan.nextInt();

  System.out.println("Bitshift");
  int flag = 1 <<2;
  System.out.println(flag);

  if ((to & flag) > 0) {
   System.out.println("YES");
  }

  for (int i = 1; i <= to; i++) {

   int res = 0;
   int modFizz = i % 3;
   int modBuzz = i % 5;

   if (modFizz == 0) {
    res = 1;
   }

   if (modBuzz == 0) {
    res += 2;
   }

   if ((res & 3) == 0) {
    numbers.add(i);
   }

   if ((res & 1) == 1) {
    fizz.add(i);
   }
   if ((res & 2) == 2) {
    buzz.add(i);
   }

   if ((res & 3) == 3) {// 3 ist binaer 11{
    fizzBuzz.add(i);
   }

  }
  System.out.println("numbers: " + numbers);
  System.out.println("fizz: " + fizz);
  System.out.println("buzz: " + buzz);
  System.out.println("fizzBuzz: " + fizzBuzz);
 }
}
```

# Datenstrukturen

Datenstrukturen dienen dazu Daten abzuspeichern. Es gibt viele verschiedene mit jeweiligen Vor- und Nachteilen. Durch die richtige Wahl der Datenstruktur kann ein Programm viel schneller und effizienter laufen.

## Linked List

Eine der einfachsten Datenstrukturen ist die Linked List. Man kann sich eine Linked List wie eine Kette vorstellen, an die wir beliebig Glieder hinzufügen können. Das löschen eines Gliedes erfordert, dass das vorhergehende Element auf das nachfolgende (des zu löschenden Elements) umgegebogen werden muss.
Es wird jeweils eine Node in die Liste eingegügt, welche einen Wert und den Zeiger (next) auf das nächste Element besitzt. Die Liste beinhaltet immer einen Zeiger (head) welcher auf das erste Element zeigt.
Von diesem Element werden alle Operationen ausgeführt.
Bei einer Linked List zeigt eine Node immer nur zu der nächsten Node.

Linked Lists werden sehr selten verwendet, dienen aber aber gute Basisi für weitere (kompliziertere) Datenstrukturen.

```java
public class Node {

 private int value;
 private Node next;

 public Node(int value) {
  this.value = value;
  // next is automatically null
 }

 public int getValue() {
  return value;
 }

 public void setValue(int value) {
  this.value = value;
 }

 public void setNext(Node next) {
  this.next = next;
 }

 public Node getNext() {
  return this.next;
 }
}
```

```java
public class MyLinkedList {

 private Node head;

 public void add(int value) {
  if (head == null) {
   head = new Node(value);
   return;
  }
  Node current = head;

  while (current.getNext() != null) {
   current = current.getNext();
  }
  // current is the last node without a next
  current.setNext(new Node(value));
 }

 public int get(int pos) {
  Node current = head;
  for( int i =0; i < pos; i++) {
   current = current.getNext();
  }
  return current.getValue();
 }

 public void del(int pos) {
  if (pos < 0) {
   throw new IndexOutOfBoundsException();
  }
  if (pos == 0) {
   head = head.getNext();
   return;
  }

    Node current = this.head;
    for (int i = 0; i < pos-1; i++) {
      if (current.getNext() == null) {
        throw new IndexOutOfBoundsException();
      }
      current = current.getNext();
    }
    // we are no on Node before the Node we want to delete
    current.setNext(current.getNext().getNext());
 }
}
```

## Doubly Linked List

Bei der Doubly Linked List wird der Node ein weiteres Attribut hinzugefügt - der Zeiger zur vorigen Node.
Das ermöglicht uns, dass wir uns nicht nur in eine Richtung bewegen können, sonderen auch zurück gehen können. Nachteil ist, dass mehr Daten (2x Pointer) pro Datenwert, den ich abspeichern will, gebraucht wird. Die Doubly Linked List hat zusätzlich zu dem _head_-Pointer auch einen _tail_-Pointer welcher uns das traversieren (durchgehen) der Daten von hinten ermöglicht.

```java
public class Node {

 private int value;
 private Node next;
  private Node prev;

 public Node(int value) {
  this.value = value;
  // next is automatically null
    // prev is automatically null
 }

 public int getValue() {
  return value;
 }

 public void setValue(int value) {
  this.value = value;
 }

 public void setNext(Node next) {
  this.next = next;
 }

 public Node getNext() {
  return this.next;
 }

  public void setPrev(Node prev) {
  this.prev = prev;
 }

 public Node getPrev() {
  return this.prev;
 }
}
```

```java
public class MyDoublyLinkedList {

 private Node head;
  private Node tail;

 public void add(int value) {
  if (head == null) {
   head = new Node(value);
      tail = head;
   return;
  }
  Node current = head;

  while (current.getNext() != null) {
   current = current.getNext();
  }
  // current is the last node without a next
  current.setNext(new Node(value));
    tail = current.getNext();
 }

 public int get(int pos) {
  Node current = head;
  for( int i =0; i < pos; i++) {
   current = current.getNext();
  }
  return current.getValue();
 }

 public void del(int pos) {
  if (pos < 0) {
   throw new IndexOutOfBoundsException();
  }
  if (pos == 0) {
   head = head.getNext();
   return;
  }

    Node current = this.head;
    for (int i = 0; i < pos-1; i++) {
      if (current.getNext() == null) {
        throw new IndexOutOfBoundsException();
      }
      current = current.getNext();
    }
    // we are no on Node before the Node we want to delete
    Node afterToDelte = current.getNext().getNext();
    current.setNext(afterToDelte);
    afterToDelte.setPrev(current);
 }
}
```

## ArrayList

Schon oft verwendet, bauen wir hier unsere eigene Variante. Im Grunde wird ein normaler Array als Datenspeicher verwendet und wenn die Größe nicht mehr ausreicht muss ein neuer (größerer) Array erzeugt werden und die Daten kopiert. Das alles bekommt der Benutzer nicht mit. Für ihn ist das ein Array der beliebig groß werden kann.

```java
public class MyArraylistInteger {
 int capacity = 8;
 int[] data = new int[capacity];
 int index = 0;

 public void add(int val) {
  if (index + 1 > capacity) {
   this.capacity *= 2;
   int[] data2 = new int[this.capacity];
   for (int i = 0; i < data.length; i++) {
    data2[i] = this.data[i];
   }
   this.data=data2;
  }
  this.data[index++] = val;
 }

 public int get(int index) {
  return this.data[index];
 }

 public int getCapacity() {
  return capacity;
 }

 public int getIndex() {
  return index;
 }

 public static void main(String[] args) {
  MyArraylistInteger mal = new MyArraylistInteger();
  mal.add(3);
  mal.add(7);
  mal.add(10);
  System.out.println(mal.get(2));
 }
}
```

## Stack (LIFO) - Last In First Out

Der Stack ist ähnlich einer LinkedList. Der Unterschied besteht darin dass Elemente immer vorne hinzugefügt werden. Sie werden auf den Stapel gelegt.
Diese Operation wird _push_ genannt. Eine weitere Eigenheit des Stacks ist, dass nur das oberste (erste)- Element genommen werden kann (Operatin _pop_).
Im Prinzip können wir uns einen Stack wie eine LinkedList vorstellen, bei der neue Elemente immer an Position 0 eigefügt werden. Und wenn wir ein
Elemt *pop*en wird es wieder von Position 0 genommen.
Weiters kann beim Stapel das oberste Element angesehen (peek) werden.

```java
public class Node {

 private int value;
 private Node next;

 public Node(int value) {
  this.value = value;
 }

 public int getValue() {
  return value;
 }

 public void setValue(int value) {
  this.value = value;
 }

 public void setNext(Node next) {
  this.next = next;
 }

 public Node getNext() {
  return this.next;
 }
}
```

```java
public class MyStack {

 private Node head;

 public void push(int value) {
  if (head == null) {
   head = new Node(value);
   return;
  } else {
      Node n = new Node(value);
      n.setNext(head);
      this.head = n;
    }
 }

 public int peek() {
    if (head == null) {
   return -1;
  } else {
      return head.getValue();
 }

 public int pop() {
  if (head !== null) {
      int headVal = head.getValue();
   head = head.getNext();
   return headVal;
  } else {
      return -1;
    }
}
```

## Queue (FIFO) - First In First Out

Die Queue ist ähnlich einer LinkedList. Elemente werden immer hinten hinzugefügt (_add_). Und Elemente werden immer von vorne weggenommen (_poll/remove_). Gleich wie der Stack kann auch auf das erste Element geschaut werden (_peek_) ohne es zu entfernen.

```java
public class Node {

 private int value;
 private Node next;

 public Node(int value) {
  this.value = value;
 }

 public int getValue() {
  return value;
 }

 public void setValue(int value) {
  this.value = value;
 }

 public void setNext(Node next) {
  this.next = next;
 }

 public Node getNext() {
  return this.next;
 }
}
```

```java
public class MyQueue {

 private Node head;

 public void add(int value) {
  if (head == null) {
   head = new Node(value);
   return;
  }
  Node current = head;

  while (current.getNext() != null) {
   current = current.getNext();
  }
  // current is the last node without a next
  current.setNext(new Node(value));
 }

 public int peek() {
    if (head == null) {
   return -1;
  } else {
      return head.getValue();
 }

 public int poll() {
  if (head !== null) {
      int headVal = head.getValue();
   head = head.getNext();
   return headVal;
  } else {
      return -1;
    }
}
```

## Binary Search Tree (BST)

Ist eine Datenstruktur, welche effizient eine große Menge an Zahlen durchsuchen kann.
Daten werden in einer Baumstruktur abgespeichert.
Jeder Verzweigungspunkt(Node) hat maximal 2 Kinder (left und right) und einen Wert(value).

Beim durchsuchen des Baumes, wird durch jede Verzweigung, der verbleibenden Suchraumes um die Hälfte reduziert.

Funktionen des BST:

- add
- get
- delete

```java
// Node
public class Node {
 int value;
 Node left;
 Node right;

 public Node(int value) {
  this.value = value;
 }

 public boolean isLeaf() {
  if (this.left == null && this.right == null) {
   return true;
  }
  return false;
 }

 public int getNrOfChilds(){
  int ret = 0;
  if (this.left != null){
   ret++;
  }
  if (this.right != null){
   ret++;
  }
  return ret;

 }

 public int getValue() {
  return value;
 }

 public void setValue(int value) {
  this.value = value;
 }

 public Node getLeft() {
  return left;
 }

 public void setLeft(Node left) {
  this.left = left;
 }

 public Node getRight() {
  return right;
 }

 public void setRight(Node right) {
  this.right = right;
 }

 public void swapValue(Node other){
  int tmp = this.value;
  this.value = other.getValue();
  other.setValue(tmp);
 }
}
```

```java
// BST
public class BST {
 Node root;

 public void add(int value) {
  Node newNode = new Node(value);
  if (root == null) {
   this.root = newNode;
   return;
  }
  Node current = this.root;
  Node parent = null;
  while (current != null) {
   if (value == current.value) {
    return;
   }
   if (value < current.getValue()) {
    parent = current;
    current = current.getLeft();
   } else {
    parent = current;
    current = current.getRight();
   }
  }
  if (value > parent.getValue()) {
   parent.setRight(newNode);
  } else {
   parent.setLeft(newNode);
  }
 }

 public Node get(int value) {
  Node current = this.root;
  while (current != null) {
   if (value == current.getValue()) {
    return current;
   }
   if (value > current.getValue()) {
    current = current.getRight();
   } else {
    current = current.getLeft();
   }
  }
  return null;
 }

 public Node getParrent(int value) {
  Node current = this.root;
  Node parrent = null;
  while (current != null) {
   if (value == current.getValue()) {
    return parrent;
   }
   if (value > current.getValue()) {
    parrent = current;
    current = current.getRight();
   } else {
    parrent = current;
    current = current.getLeft();
   }
  }
  return parrent;
 }

 private void deleteNode(Node nodeToBeDeleted, Node parent){
  System.out.println("recursion called");
  // Abbruchbedingungen
  // node is leaf
  if (nodeToBeDeleted.isLeaf()) {
   if (parent.getValue() > nodeToBeDeleted.getValue()) {
    parent.setLeft(null);
   } else {
    parent.setRight(null);
   }
   return;
  }
  // node has 1 child
  if (nodeToBeDeleted.getNrOfChilds() == 1) {
   Node childOfNode = null;
   if (nodeToBeDeleted.getLeft() != null) {
    childOfNode = nodeToBeDeleted.getLeft();
   } else {
    childOfNode = nodeToBeDeleted.getRight();
   }
   if (parent.getValue() > nodeToBeDeleted.getValue()) {
    parent.setLeft(childOfNode);
   } else {
    parent.setRight(childOfNode);
   }
   return;
  }

  // Recusionsfortschritt
  // node has 2 child
  // 1. find biggest node left of node
  Node nodeToSwap = nodeToBeDeleted.getLeft();
  Node nodeToSwapParent = null;
  while (nodeToSwap.getRight() != null){
   nodeToSwapParent = nodeToSwap;
   nodeToSwap = nodeToSwap.getRight();
  }
  //swap values
  nodeToBeDeleted.swapValue(nodeToSwap);
  deleteNode(nodeToSwap, nodeToSwapParent);
 }

 // user facing
 public void delete(int value) {
  Node nodeToBeDeleted = this.get(value);
  Node parent = this.getParrent(value);

  deleteNode(nodeToBeDeleted, parent);
 }

 public static void main(String[] args){
  BST bst = new BST();
  bst.add(10);
  bst.add(50);
  bst.add(20);
  bst.add(30);
  bst.delete(50);
 }
}
```

alternative Implementierung(Florian)

```java
public class BinarySearchTree {
 private TreeNode root;

 private static class TreeNode {
  int value;
  TreeNode left, right;

  public TreeNode(int value) {
   this.value = value;
   left = right = null;
  }
 }

 public BinarySearchTree() {
  root = null;
 }

 public void insert(int value) {
  root = insertNode(root, value);
 }

 public boolean search(int key) {
  return searchNode(root, key);
 }

 public void delete(int key) {
  root = deleteNode(root, key);
 }

    public void printAll() {
        print2D(this.root, 0);
    }

 public void balance() {
  ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
  storeNodes(this.root, nodes);
  this.root = buildTree(nodes, 0, nodes.size() - 1);
 }

 private TreeNode insertNode(TreeNode root, int value) {
  if (root == null) {
   root = new TreeNode(value);
   return root;
  }

  if (value < root.value) {
   root.left = insertNode(root.left, value);
  } else if (value > root.value) {
   root.right = insertNode(root.right, value);
  }

  return root;
 }

 private TreeNode buildTree(ArrayList<TreeNode> nodes, int start, int end) {
  if (start > end) {
   return null;
  }

  int mid = (start + end) / 2;
  TreeNode root = nodes.get(mid);

  root.left = this.buildTree(nodes, start, mid - 1);
  root.right = this.buildTree(nodes, mid + 1, end);

  return root;
 }

 private void storeNodes(TreeNode root, ArrayList<TreeNode> nodes) {
  if (root == null) {
   return;
  }

  storeNodes(root.left, nodes);
  nodes.add(root);
  storeNodes(root.right, nodes);
 }

 private boolean searchNode(TreeNode root, int key) {
  if (root == null || root.value == key) {
   return root != null;
        }

        if (key < root.value) {
            return searchNode(root.left, key);
        } else {
            return searchNode(root.right, key);
        }
 }

 private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = minValue(root.right);
            root.right = deleteNode(root.right, root.value);
        }

        return root;
    }

 private int minValue(TreeNode root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

 private void print2D(TreeNode root, int space) {
        if (root == null)
            return;

        space += 10;

        print2D(root.right, space);
        System.out.print("\n");

        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");

        print2D(root.left, space);
    }

 public static void main(String[] args) {
  var tree = new BinarySearchTree();
  tree.insert(10);
  tree.insert(7);
  tree.insert(3);
  tree.insert(12);
  tree.insert(11);
  tree.insert(8);
  tree.insert(15);
  tree.insert(20);
  tree.insert(19);
  tree.insert(5);
  tree.insert(9);
  tree.printAll();
  tree.delete(7);
  System.out.println("--------------------------------------------------");
  tree.printAll();
  tree.balance();
  tree.printAll();
 }
}
```

## Set

Ist eine Datenstruktur, welche einen bestimmten Wert nur einmal zulässt.

Ein Set kann mit verschiedenen dahinterliegenden Datenstrukturen programmiert werden, in unseren Beispiel wird eine ArrayList verwendet.

```java
import java.util.ArrayList;

public class Set<T>{
 ArrayList<T> values = new ArrayList<>();

 public boolean add(T val){
  if (!this.values.contains(val)){
   this.values.add(val);
   return true;
  }
  return false;
 }

 public String toString(){
  return this.values.toString();
 }

 public static void main(String[] args){
  Set s = new Set<Integer>();
  s.add(55);
  s.add(4);
  s.add(10);
  s.add(4); // should not add another 4
  System.out.println(s);
  Set names = new Set<String>();
  names.add("Sepp");
  names.add("Martin");
  names.add("Sepp");
  names.add("Josef");
  System.out.println(names);
 }
}
```

## Map

In einer Map wird auf Daten immer über einen Key zugegriffen, dieser liefert den Value zurück.
In einer Map kann der Key und der Value beliebig definiert werden.

Bei einer HashMap wird der Key (intern) gehasht und der Zugriff so verbessert.

siehe <https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html>

# Algorithmen

Algorithmen dienen dazu, Input zu verarbeiten und den gewünschten Output zu produzieren.
Sie sollen folgende Eigenschaften besitzen:

- deterministisch: Für gleiche Inputs sollen immer die gleichen Outputs erstellt werden.
  Bsp.: Beim sortieren von Zahlen, soll der Output immer in der gleichen Reihenfolge passieren. Egal wie oft ich
  den Algorithmus aufrufe, der Output mit dem gleichen Input ist immer der selbe.
- terministisch: durch alle Verzweigungstrukturen soll, der Algorithmus ein Ende finden.

## Sortieralgorithmen

Dienen dazu Zahlen in Datenstrukturen (zb. Array) in einer bestimmten Reihenfolge zu sortieren.

```shell
Bsp.: [7,2,5,4] -> (sortiert) -> [2,4,5,7]
```

### Eigenschaften

<https://en.wikipedia.org/wiki/Sorting_algorithm>

- Stabilität: Wenn die Reihenfolge gleicher Elememte nach der sortiertung erhalten ist, spricht man von einem spabilen SA,
  anderfalls von einem instabilen.
- Speicherbedarf: Wieviel zusätzlichen Speicher der Alogirithmus benötigt, neben den n-Elementen.
- Geschwindigkeit (Komplexität): Wie schnell erfolgt die Sortierung im:
  - besten Fall
  - mittleren Fall
  - schlechtesten Fall
    Wird in Abhängigkeit von _n_ angegeben. Wobei folgende Komplexitätsklassen relevant sind:
  - O(1) zB. Arrayzugriff auf bestimmtes Element, HashMap Zugriff
  - O(log n) zB. Binärsuche, oder Suche im BST
  - O(n) zB. Suche nach Element im unsortiertem Array
  - O(n \* log n) zB: MergeSort in allen Fällen
  - O(n^2) zB: BubbleSort, SelectionSort,...
  - O(n!)

#### Bestimmung Komplexität

```java
public static void insertionSort(ArrayList<Integer> a) { // a enthällt n Elemete
  for (int i = 1; i < a.size(); i++) { // Schleife über n-Elemente
    int j = i - 1;
    int key = a.get(i);
    while (j >= 0 && a.get(j) > key) { // n mal
      a.set(j + 1, a.get(j));
      j = j - 1;
    }
    a.set(j + 1, key);
  }
}
```

```java
for( int i = 0; i < a.size()/2; i++) { // outer loop is n/2
 if ( i % 2 == 0){ // in 1/2 of cases
  for (int j = 0; j < i; j++){ // max. n/2
   //do something
  }
 }
}
// results in: approx. (n/2)*(1/2*n/2) ==> n^2/8 ==> O(n^2)
```

```java
// example presented by Patrik
// n^2
for( int i = 0; i < a.size()*a.size(); i ++){
 // skip odd numbers => /2
 while( i % 2 == 0 ){
  i++; // O(1)
 }
}
// results in n^2/2 ==> O(n^2)
```

```java
// example presented by Patrik
// n^2
for( int i = 0; i < a.size()*a.size(); i ++){
 // skip odd numbers => /2
 while( i % 2 == 0 ){
  i++; // O(1)
 }
}
// results in n^2/2 ==> O(n^2)
```

```java
// in jedem Aufruf wird a um 1 reduziert bis a <= 1 ==> O(a) ==> O(n)
public static int fac(int a, int res){
 if (a <=1) {
  return res;
 }
 return fac(a-1,res*a);
}
```

```java
// Java program for implementation of Heap Sort
public class HeapSort {
    public void sort(int arr[])
    {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }
}
```

### Bubblesort

Daten werden sortiert indem die größten Elemente aufsteigen wie Luftblasen im Wasser.

```java
public static void bubbleSort(int[] a){
  for (int i=0; i< a.length; i++){
    for (jnt j=0; j < a.length-1; j++){
    // Optimierung: Letzte Elemente werden nicht mehr verglichen
    // for (int j=0; j < a.length-1-i; j++){
      if (a[j] > a[j+1]) {
        int tmp = a[j+1];
        a[j+1] = a[j];
        a[j] = tmp;
      }
    }
  }
}
```

### Insertionsort

Elemente werden der Reihe nach verglichen und wenn der Richtige Platz gefunden wurde getauscht.

Given an unsorted array(a): Another array is used as the sorted array (s).

- select the first number out of the array
- compare it with each elements in s and insert it into the appropriate position

e.g.:

```bash
[4,7,23,6] -> [] // pick 4
[4,7,23,6] -> [4] // insert 4 into sorted array
[4,7,23,6] -> [4,7] // insert 7 after 4, after comparison
[4,7,23,6] -> [4,7,23] // insert 23 after 7: after comparing it to 4 and 7
[4,7,23,6] -> [4,6,7,23] // insert 6 after 4: after comparing it to 4 and 7
```

```java
// in place
public static void insertionSort(ArrayList<Integer> a) {
  for (int i = 1; i < a.size(); i++) {
    int j = i - 1;
    int key = a.get(i);
    while (j >= 0 && a.get(j) > key) {
      a.set(j + 1, a.get(j));
      j = j - 1;
    }
    a.set(j + 1, key);
  }
}

// mit Array der das sortierte Ergebnis beinhaltet.
public static ArrayList<Integer> insertionSort2(ArrayList<Integer> a) {
  ArrayList<Integer> result = new ArrayList<>();
  for (int i = 0; i < a.size(); i++) {
    int toSort = a.get(i);
    if (result.isEmpty()) {
      result.add(toSort);
    } else {
      int pos = 0;
      for (int j = 0; j < result.size(); j++) {
        if (result.get(j) < toSort) {
          pos = j + 1;
        }
      }
      result.add(pos, toSort);
    }
  }
  return result;
}
```

## Divide and Conquer

Große Probleme werden in kleinere Stücke zerlegt, welche einfach zu lösen sind.
Werden viel in "schnellen" Sortieralgorithmen verwendet.

## MergeSort

Ist ein Sortieralgorithmus der den Ausgangsarray als erstes in einzel Elemente zerlegt und anschließend diese teile in sortierter Reihenfolge zusammenfügt.

![mergesort funktionsweise](mergesort-blog-1-Image.jpg)

```java
public static void mergeSort(int[] array) {
 if (array.length > 1) {
  int mid = (array.length / 2);
  int[] left = new int[mid];
  int[] right = new int[array.length - mid];

  for (int i = 0; i < mid; i++) {
   left[i] = array[i];
  }

  for (int i = mid; i < array.length; i++) {
   right[i - mid] = array[i];
  }

  mergeSort(left);
  mergeSort(right);

  int i = 0;
  int j = 0;
  int k = 0;
  while (i < left.length && j < right.length) {
   if (left[i] < right[j]) {
    array[k] = left[i];
    i++;
   } else {
    array[k] = right[j];
    j++;
   }
   k++;
  }
  while (i < left.length) {
   array[k] = left[i];
   i++;
   k++;
  }
  while (j < right.length) {
   array[k] = right[j];
   j++;
   k++;
  }
 }
}
```

# Java Argumenten Logik

Argumente in Java haben ihre Eigenheiten. Da Java keine Referenezen (&) oder
Pointer(\*) unterstützt, werden interne Details ausgeblendet.

```java
public class Main{

  public static class Person{
    public int age;
    public String name;

    public Person(int age, String name){
      this.age = age;
      this.name = name;
    }
  }

  // name von a wird überschrieben
  public static void whatHappensPersonName(Person a, Person b){
    a.name = b.name;
  }

  // a ist eine Refenz (intern) und wird wie ein primitiver Datentyp kopiert
  public static void whatHappensPersonFull(Person a, Person b){
    a = b;
  }

  // a ist ein primitiver Datentyp und wird vor dem Aufruf in a kopiert
  public static void whatHappes(int a, int b){
    a = b;
  }

  // Der Inhalt von a wird durch b geändert.
  public static void whatHappensArray(int[] a, int b){
    a[0] = b;
  }

  // Die Referenz auf den Array a wird kopiert und diese Funktion hat keinen Effekt
  public static void whatHappensArrayFull(int[] a, int[] b){
    a = b;
  }

  // Die Referenz auf den String a wird kopiert und diese Funktion hat keinen Effekt
  public static void whatHappensString(String s, String b){
    s = b;
  }

  // Die Referenz auf den Array a wird kopiert und diese Funktion hat keinen Effekt
  public static void whatHappensStringArray(String[] s, String[] b){
    s = b;
  }

  // Die Referenz auf den Integer a wird kopiert und diese Funktion hat keinen Effekt
  public static void whatHappensInteger(Integer a, Integer b){
    a = b;
  }
```

# Rekursion

Rekursion wird verwendet um eine bestimmte Art von Problemlösungen umzusetzen.
Rekursion besteht aus folgenden Teilen:

- Abbruchbedingung(en)
- Rekursionsvortschritt (Aufruf von sich selber mit angepassten Parametern)

```
IS coole isch bei da Rekursion - dass man lei in aufbau herausfinden muss und die rekursion ääähh das Ergebnis selber rausfindet.
```

```
Das Faszinierende an der Rekursion ist, dass man lediglich den Aufbau verstehen muss, und die Rekursion findet dann das Ergebnis eigenständig heraus."
```

```java
// Berechnung Fakultät: 5! = 5 x 4 x 3 x 2 x 1
public static int faculty(int i){
  // Abbruchbedingung
  if (i == 0 || i == 1) {
    return 1;
  }
  // Recursionsvortschritt
  return i*faculty(i-1);
}

// Berechnung Paskalsches Dreieck siehe https://de.wikipedia.org/wiki/Pascalsches_Dreieck
public static int pasD(int zeile, int spalte){
  // Abbruchbedingung
  if (zeile == spalte || spalte == 0 ){
    return 1;
  }
  // Recursionsvortschritt
  return pasD(zeile - 1, spalte) + pasD(zeile - 1, spalte -1);
}
```

## Endrekursion

Recursionsergebnis wird in Aufrufen "mitgeschliffen" - Das Ergebnis ist falls die Abbruchbedingung zutrifft verfügbar. Funktionale Sprachen optimieren oft auf Endrekursion.

```java
// public facing (Diese Funktion wird von Benutzern verwendet)
public static int fac(int val){
  return this.facEndRec(val, 1);
}

// Nur zur internen Verwendung bestimmt.
private static int facEndRec(int val, int result){
  if (val == 0){
    return result;
  }
  return facEndRec(val-1,val*result);
}
```

### Beispiel add bei FIFO - Queue

```java
public class RecQueue {
  private Node head;

  public void add(int value) {
    this.addInternal(value, this.head);
  }

  private void addInternal(int value, Node n) {
    if (n == null) {
      this.head = new Node(value);
      return;
    }
    if (n.next == null) {
      n.next = new Node(value);
      return;
    }
    addInternal(value, n.next);
  }

  public void print() {
    Node c = this.head;
    while (c.next != null) {
      System.out.println(c.value);
      c = c.next;
    }
    System.out.println(c.value);
  }

  public static void main(String[] args) {
    RecQueue r = new RecQueue();
    r.add(10);
    r.add(20);
    r.add(30);
    r.add(40);
    r.add(50);
    r.add(60);
    r.print();
  }
}

```

### Beispiel: Suchen einer Datei von einem Verzeichnis aus

```java
import java.io.File;
import java.util.ArrayList;

public class RecursiveFileSearchArray{

  /// returns Path of found File, if not found return empty Array
  public static ArrayList<String> search(String path, String fileName) {
    System.out.println("searching in" + path);
    ArrayList<String> filesFound = new ArrayList<>();
    // list all files in dir
    File p = new File(path);
    for(File f : p.listFiles()){
      if (f.isFile()) {
        if (f.getName().equals(fileName)){
           filesFound.add(f.getAbsolutePath());
        }
      } else { // is a directory
        ArrayList<String> res = search(f.getAbsolutePath(),fileName);
        if (!res.isEmpty()){
          filesFound.addAll(res);
        }
      }
    }
    return filesFound;
  }

  public static void main(String[] args){
    ArrayList<String> res = search("/home/marcom/htl", "Main.java");
    if (res.isEmpty()){
      System.out.println("File NOT found");
    } else {
      System.out.println("File(s) found at: "+ res);
    }
  }
}
```

# Generics

Generics dienen dazu Klassen oder Funktionen für mehrere Datentypen zu definieren.
Um beispielsweise eine LinkedList für mehr Datentypen als _int_ zu definieren, müssten wir die Node und auch die LinkedList jeweils neu definieren. Als Datentypen dürfen nur Objektdatentypen(alles was eine Klasse ist bzw. von Objekt erbt) verwendet werden. Zb. _Integer_ statt _int_. Es werden keine primitiven Datentypen erlaubt.

```java
class Node {
  Node next;
  int value; // dieser Wert soll nicht fixiert auf int sein.
}
```

Um nicht jeweils eine Klasse Node und LinkedList für alle Datentypen zu schreiben, wurden _Generics_ definiert.

```java
class Node<E> {
  Node<E> next;
  E value; // E wird von außen definiert und hier "eingesetzt"
}
```

Die Node muss dann von außen mit einem Datentyp als "Argument" erstellt werden.

```java
Node<Float> n = new Node<Float>(3.4f);
```

Wir kennen diese Notation, wenn wir eine _ArrayList_ verwendet haben.

Wie oben erwähnt können auch Funktionen/Methoden generic definiert werden:

```java
public <T> T returnFirst(T[] a) {
    return a[0];
}
```

## Bounded Generics

Um einzuschränken welche Datentypen für die Generics verwendet werden können, können wir das Keyword _extends_ verwenden.

```java
class Node<E extends Number> {
  Node<E> next;
  E value;
}
```

Das bedeutet, dass der Datentyp welcher für diese Node verwendet werden kann vom Typ Number ist, oder davon (indirekt) erbt oder das Interface implementiert.
Es kann hier beispielsweise kein _String_ verwendet werden.

Wenn beispielsweise eine Anforderung an unsere Datentypen ist, dass sie verglichen werden müssen, können wir beispielsweise das Interface _Comparable_ verwenden. [Comparable Docu](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)

```java
class Node<E extends Comparable> {
  Node<E> next;
  E value;
}
```

Wie wir in der Dokumentation sehen können, haben alle gängigen (numerischen) Typen dieses Interface implementiert, was zur Folge hat, dass wir die Funktion _compareTo(T o)_ verwerden können (diese ist im _Comparable_-Interface definiert).

## Tests mit JUnit

Um nicht die _main_-Methode verwednen zu müssen um unsere Programme zu testen, haben sich Test-Frameworks etabliert. Sie dienen dazu möglichst viel des Codes zu überprüfen. Durch verschiedene Varianten von _assert_ können wir auch auf das manuelle lesen (des Outputs) und das vergleichen von Sollwert automatisieren.
Weiterer Vorteil ist, dass die Tests immer mehr werden und wenn neue Funktionalitäten dazukommen ich immer noch die Sicherheit habe, dass die alte Funktionalität nicht darunter leidet.
In Java ist JUnit weit verbreitet.

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestMyArraylistInteger {
 MyArraylistInteger mal = new MyArraylistInteger();

 @Test
 void add_get_same_value() {
  mal.add(3);
  assertEquals(mal.get(0), 3);
 }

 @Test
 void add_get_same_value2() {
  mal.add(4);
  assertEquals(mal.get(0), 4);
 }

 @Test
 void add_over_capacity_increases_capacity() {
  int oldCap = mal.getCapacity();
  for (int i = 0; i < 9; i++) {
   mal.add(i);
  }
  int newCap = mal.getCapacity();
  assertEquals((oldCap < newCap), true);
 }

 void printArray() {
  for (int i = 0; i < mal.getIndex(); i++) {
   System.out.println(mal.get(i));
  }
 }
}
```

# Design Patterns

Sind Entwurfsmuster, welche als Lösung für häufig autretende Probleme herangezogen werden.

Sie werden in folgende Kategorien unterteilt:

- Creational Pattern: Dienen zum Erstellen von Objekten
- Structural Pattern: Dienen dazu Klassen in eine Struktur zu bringen
- Behavioural Pattern: Dienen dazu bestimmte Verhalten erzeugen zu können.

## Oberserver Pattern

Fällt unter die Behavioural Patterns und wird verwendet um Änderungen verfolgen zu können.

Prinzipiell wird zwischen Pull- und Push-Nachrichten unterschieden, wobei:

- **Pull**: Der Client fragt (in bestimmten Intervall) beim Server, ob es Änderungen gibt.
- **Push**: Der Server informiert den Client, dass Änderungen vorliegen.

Es gibt Mischformen, bei denen der Server den Client informiert, dass Änderungen vorliegen und der Client dann nur die gewünschten Daten abfragt.

![https://upload.wikimedia.org/wikipedia/commons/0/01/W3sDesign_Observer_Design_Pattern_UML.jpg](https://upload.wikimedia.org/wikipedia/commons/0/01/W3sDesign_Observer_Design_Pattern_UML.jpg)

In diesem Beispiel in das Subject allgemein gehalten und entspricht dem Server. Es existieren auch einfachere Implementierungen wie beispielsweise:

![https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Observer_w_update.svg/750px-Observer_w_update.svg.png](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Observer_w_update.svg/750px-Observer_w_update.svg.png)

# VueJS

## Installation von nvm, npm und vueJs

### nvm - Node Version Manager

- in Windows:

[https://github.com/coreybutler/nvm-windows/releases](nvm-windows) github

- in Linux/Mac/Windows WSL

Installation laut [https://github.com/nvm-sh/nvm](github-nvm)folgen

### npm - Node Package Manager

```bash
  nvm install 20
  nvm use 20
```

### Install VueJS / Create a Project

```bash
  npm create vue@latest
```

select following options:

✔ Project name: … mein-projekt

✔ Add TypeScript? … No / **_Yes_**

✔ Add JSX Support? … **_No_** / Yes

✔ Add Vue Router for Single Page Application development? … No / **_Yes_**

✔ Add Pinia for state management? … No / **_Yes_**

✔ Add Vitest for Unit Testing? … **_No_** / Yes

✔ Add an End-to-End Testing Solution? › **_No_**

✔ Add ESLint for code quality? … No / **_Yes_**

✔ Add Prettier for code formatting? … No / **_Yes_**

✔ Add Vue DevTools 7 extension for debugging? (experimental) … No / **_Yes_**

### Component

Eine Komponente in Vue kann man sich vorstellen, wie eine Java-Klasse. Es definiert ein Konstrukt,
welches folgende Eigenschaften haben kann:

- HTML Struktur (template)
- Programmierblock (script)
- Styling (style)

Die HTML- Struktur definiert, wie diese Komponente dargestellt wird und schlussendlich im DOM eingebaut wird.
Der Programmierblock, dient dazu die Komponente auf verschiedene Sachen reagieren kann.

```html
<script setup lang="ts">
  const props = defineProps<{
    counter: number;
  }>();

  function return42() {
    return 42;
  }
</script>

<template>
  <div class="danger">count: {{ counter }}</div>
  message: {{ msg }}
</template>

<style scoped>
  .danger {
    background-color: red;
  }
</style>
```

In allen Beispielen hier, wird die Composition-API von Vue verwendet. Die Options-API ist immer noch
verwendbar, aber die Composition-API wird empfohlen.

Im obingen Beispiel wird im script- Bereich _setup_ und _lang="ts"_ verwendet. Diese dienen dazu, dass wir nicht
expliziet die _setup_-Funktion aufrufen müssen und alle imports können direkt im _template_-Bereich ohne weiteres
verwendet werden.
Mit _lang="ts"_ wird die script-Sprache auf Typescript gesetzt.

### Reaktivität

Reaktivität in Vue bedeutet, dass sich die Benutzeroberfläche (UI) automatisch anpasst, wenn sich die zugrundeliegenden Daten ändern. Vue überwacht die Daten und sorgt bei Änderungen dafür, dass die UI neu aufgebaut oder angepasst wird.

Beispiel:

```html
<script setup lang="ts">
import { ref } from 'vue';

const count = ref(0);
</script>
```

Hier verwenden wir `ref`, um eine reaktive Variable `count` zu definieren, deren Änderungen automatisch in der UI reflektiert werden.

### Properties

Properties, oder "Props", ermöglichen es, Komponenten zu parametrisieren und mit Daten zu versehen. Props können ebenfalls reaktiv sein.

Beispiel:

```html
<!-- In TestComponent.vue -->
<script setup lang="ts">
  const props = defineProps<{
    counter: number;
  }>();
</script>
```

Die Komponente kann wie folgt verwendet werden:

```html
<template>
  <TestComponent :counter=5/>
</template>

<script setup lang="ts">
import TestComponent from '@/components/TestComponent.vue';
</script>
```

### useTemplateRef

`useTemplateRef` ist eine Methode, um auf ein bestimmtes DOM-Element oder eine Komponente im Template zuzugreifen. Dies ist hilfreich, wenn man direkt mit dem DOM interagieren möchte.

Beispiel:

```html
<template>
  <input ref="myInput" />
</template>

<script setup lang="ts">
import { useTemplateRef, onMounted } from 'vue';

const myInput = useTemplateRef('myInput');

onMounted(() => {
  myInput.value.focus();
});
</script>
```

### Events

Events ermöglichen die Kommunikation zwischen Komponenten. Eine Kind-Komponente kann ein Event an die Eltern-Komponente senden.

Beispiel:

```html
<!-- Kind-Komponente -->
<template>
  <button @click="emit('increment')">Erhöhen</button>
</template>
<script setup lang="ts">
  const emit = defineEmits(['increment'])
</script>
```

In der Eltern-Komponente kann das Event wie folgt abgehört werden:

```html
<template>
  <ChildComponent @increment="handleIncrement" />
</template>

<script setup lang="ts">
import ChildComponent from './ChildComponent.vue';

const handleIncrement = () => {
  console.log('Increment-Event wurde empfangen');
};
</script>
```

### Computed Properties

Mit computed properties kann man Daten berechnen, die von anderen reaktiven Daten abhängen. Computed properties sind effizient, da sie nur neu berechnet werden, wenn sich die zugrunde liegenden Daten ändern.

Beispiel:

```html
<script setup lang="ts">
import { ref, computed } from 'vue';

const count = ref(2);
const doubled = computed(() => count.value * 2);
</script>
```

### defineExpose

`defineExpose` ermöglicht es, bestimmte Methoden oder Variablen aus einer Komponente nach außen hin verfügbar zu machen, sodass andere Komponenten darauf zugreifen können.

Beispiel:

```html
<script setup lang="ts">
function someFunction() {
  console.log('Funktion aufgerufen');
}

defineExpose({
  someFunction,
});
</script>
```

### Conditional Rendering

Mit Bedingtem Rendering kann man Teile der UI abhängig von bestimmten Bedingungen anzeigen oder ausblenden.

Beispiel:

```html
<template>
  <p v-if="isVisible">Ich bin sichtbar</p>
  <p v-else>Ich bin nicht sichtbar</p>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const isVisible = ref(true);
</script>
```

### List Rendering

List Rendering erlaubt es, eine Liste von Elementen basierend auf einem Array oder einer Liste zu rendern.

Beispiel:

```html
<template>
  <ul>
    <li v-for="item in items" :key="item.id">{{ item.name }}</li>
  </ul>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const items = ref([
  { id: 1, name: 'Item 1' },
  { id: 2, name: 'Item 2' },
  { id: 3, name: 'Item 3' },
]);
</script>
```

### watcher

In Vue.js werden Watcher verwendet, um auf Änderungen von Daten oder Berechnungen zu reagieren und daraufhin bestimmte Aktionen auszuführen. Sie sind hilfreich, wenn man auf Datenänderungen hören und darauf basierende Logik implementieren möchte, die nicht direkt in einer Methode oder einer berechneten Eigenschaft (computed property) abgedeckt ist.

```vue
<template>
  <div>
    <input v-model="name" placeholder="Gib deinen Namen ein" />
    <p>{{ message }}</p>
  </div>
</template>

<script lang="ts">
import { ref, watch } from 'vue';

export default {
  setup() {
    // Reactive state
    const name = ref<string>('');
    const message = ref<string>('Willkommen!');

    // Watcher to observe changes in 'name'
    watch(name, (newVal, oldVal) => {
      if (newVal) {
        message.value = `Hallo, ${newVal}!`;
      } else {
        message.value = 'Willkommen!';
      }
      console.log(`Name geändert von ${oldVal} zu ${newVal}`);
    });

    return {
      name,
      message,
    };
  },
};
</script>
```

Erklärung:

- v-model: Bindet die Eingabe des Nutzers direkt an die name-Eigenschaft.
- Watcher name: Wird aufgerufen, wenn sich der Wert der Eigenschaft name ändert.
  - newVal: Der neue Wert der überwachten Eigenschaft.
  - oldVal: Der vorherige Wert der überwachten Eigenschaft.
- Logik im Watcher: Aktualisiert die Nachricht dynamisch basierend auf der Eingabe des Nutzers.

Watcher sind ideal für:

- Asynchrone Datenaufrufe: Reagieren auf Datenänderungen, um z. B. Daten vom Server zu laden.
- Seiteneffekte: Änderungen triggern z. B. Animationen, Logs oder andere Aktionen.


# Local Restful Server Test Setup

## docker-compose
**Docker Compose** ist ein Tool, das es ermöglicht, mehrere Docker-Container gleichzeitig zu definieren, zu starten und zu verwalten. Es verwendet eine **`docker-compose.yml`-Datei**, um die Konfiguration der Container, Netzwerke und Volumes festzulegen.

### Vorteile:
1. **Einfaches Management**: Mehrere Container können mit einem einzigen Befehl (`docker-compose up`) gestartet, gestoppt oder aktualisiert werden.
2. **Deklarative Konfiguration**: Alle Einstellungen (z. B. Ports, Umgebungsvariablen, Volumes) werden in einer YAML-Datei zentralisiert.
3. **Netzwerke und Verknüpfungen**: Compose erstellt automatisch Netzwerke, damit Container einfach miteinander kommunizieren können.

### Beispiel `docker-compose.yaml`:
```yaml
version: '3.8'
services:
  web:
    image: nginx:latest
    ports:
      - "8080:80"
    volumes:
      - ./html:/usr/share/nginx/html
  app:
    build:
      context: ./app
    volumes:
      - ./app:/app
    environment:
      - NODE_ENV=production
    depends_on:
      - db
  db:
    image: postgres:latest
    environment:
      POSTGRES_USER: user
      POSTGRES_PASSWORD: password
```

### Erklärung des Beispiels:
1. **Version**: Gibt die Docker-Compose-Spezifikation an.
2. **Services**: Definiert die Container:
   - **`web`**: Startet einen NGINX-Container und bindet ihn an Port 8080 des Hosts.
   - **`app`**: Startet eine App mit einem benutzerdefinierten Build.
   - **`db`**: Startet eine PostgreSQL-Datenbank mit konfigurierten Umgebungsvariablen.
3. **Volumes**: Bindet Host-Verzeichnisse an Container-Verzeichnisse.
4. **`depends_on`**: Stellt sicher, dass `db` vor `app` gestartet wird.

### Wichtige Befehle:
- **`docker-compose up`**: Startet alle Container.
- **`docker-compose down`**: Stoppt und entfernt Container, Netzwerke und Volumes.
- **`docker-compose logs`**: Zeigt Logs aller Container.
- **`docker-compose ps`**: Listet die laufenden Container auf.

Docker Compose ist ideal für die Entwicklung und das Testen von Multi-Container-Anwendungen!****

### docker-compose für unseren Test-Server

```yaml
# in docker-compose.yaml
version: "3.3"  

services:
  frontend:
    image: postgrest/postgrest
    ports:
      - "3000:3000"
    networks:
      - front-tier
      - back-tier
    environment:
      PGRST_DB_URI: "postgres://postgres:1234@db:5432/postgres"
      PGRST_DB_ANON_ROLE: "web_anon"
      PGRST_JWT_SECRET: "1234"
      PGRST_SERVER_PORT: "3000"
      PGRST_DB_SCHEMAS: "api"

  db:
    image: postgres
    ports:
      - "5432:5432" 
    networks:
      - back-tier
    environment:
      POSTGRES_PASSWORD: "1234"

networks:
  front-tier: {}
  back-tier: {}
```

```shell
# in directory of docker-compose.yaml file
docker-compose up
```

### Show IP of postgres Server

```shell
docker network inspect dc_back-tier
```

execute following sql script in db:

```sql
create role web_anon nologin;

create schema api;
 
grant usage on schema api to web_anon;

create table api.todos (
  id int primary key generated by default as identity,
  done boolean not null default false,
  task text not null,
  due timestamptz
);

insert into api.todos (task) values
  ('finish tutorial 0'), ('pat self on back');

grant select on api.todos to web_anon;

--- dont use this in production
grant insert,update,delete on api.todos to web_anon;

create role authenticator noinherit login password 'mysecretpassword';
grant web_anon to authenticator;
```

Rest server should now run under: <http://localhost:3000>

You can now:

- insert (POST)
- update (PATCH)
- get (GET)
- delete (DELETE)

all resources. e.g: update todo with id=3

```bash
curl -X PATCH -d '{"done":true}' -H "Content-Type: application/json" localhost:3000/todos?id=eq.3
```
