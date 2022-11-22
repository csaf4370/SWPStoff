# SWPStoff

## Table of Contents

- [SWPStoff](#swpstoff)
  - [Table of Contents](#table-of-contents)
- [coding guidelines](#coding-guidelines)
  - [CamelCase](#camelcase)
- [String formatierung mit printf](#string-formatierung-mit-printf)
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
  - [Keyword *static*](#keyword-static)
  - [DRY - Don't Repeat Yourself](#dry---dont-repeat-yourself)
  - [ArrayList](#arraylist)
  - [Vererbung](#vererbung)
    - [Keyword *abstract*](#keyword-abstract)
    - [Annotation *@Override*](#annotation-override)
    - [instanceof - überprüfen der Klasse bzw. der Vaterklasse](#instanceof---überprüfen-der-klasse-bzw-der-vaterklasse)
- [Zufallszahlen (Random)](#zufallszahlen-random)


# coding guidelines

## CamelCase

Start abhängig von Typ, jedes weitere Wort groß.

```java
String firstName;
```

Alle Typen in CamelCase start mit:

- Klassenname groß
- Eigenschaften klein
- Methoden klein
- Enum Groß (Werte alle UPPERCASE)

# String formatierung mit printf

Alternativ zu der Ausgabe auf der Konsole zu ```println``` gibt es die Funktion ```printf```.
Sie ermöglicht das schreiben eines kompletten Strings mit *Platzhaltern*.

```java
public void print() {
		System.out.println("Schüler: " + this.vName + " " + this.nName);
		System.out.printf("Schüler: %s %s", this.vName, this.nName);
	}
```

Auffällig sind die *Ersetzungsmarken* im String. In unserem Beispiel verwenden wir ```%s``` um
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

Wird verwendet, um mögliche Fälle zu behandlen. Kann mit If-Abfragen ersetzt werden.

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

```java
// Tiere ist eine Klasse mit name als Attribut

public static void main(String[] args) {
  for (Tier t : tiere) { // forEach loop
			System.out.println(t.getName());
		}

		// equivalent
		for (int i = 0; i < tiere.size(); i++) {
			Tier t = tiere.get(i);
			System.out.println(t.getName());
		}
}
```


# Objektorientierte Programmierung

Dient zur besseren Strukturierung von Programmmen.
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

Klasse *Person* mit 2 Eigenschaften (firstName, lastName).

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

## toString() Methoden - Ausgabe eines Objektes

Wenn man versucht eine Objekt einer selbst-definierten Klasse auszugeben wird man meist mit einer Ausgabe ala.
```Auto@677327b6``` überrascht. Um die Ausgabe zu verbessern, ist es möglich in der jeweiligen Klasse eine *toString()*-Methode zu erstellen, welche einen String zurück, welche das Objekt beschreibt.

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

Wird verwendet, um Eigenschaften einer Klasse mit Hilfe der Sichtbarkeit zu verbergen. Eigenschaften einer Klasse sind demnach meistens *privat*. Zugriff von Außen wird über Funktionen geregelt (Getter und Setter). Wenn diese angeboten werden, können von außen Werte ausgelesen bzw. gesetzt werden.

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

## Keyword *static*

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

Wird benötigt um Arrays zu erzeugen, welche zur Laufzeit erweitert werden können. Wird auch als dynamischer Array bezeichnet. **Wichtig**: eine ArrayList kann nur Objektdatentypen (keine primitive Datentypen) speichern. Java stellt für genau diesen Zweck *Wrapperklassen* zur Verfügung. *Integer* beinhaltet einen *int*, oder *Float* beinhaltet einen *float*, usw.

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

Wird verwendet um Code besser strukturieren zu können. Öfter verwendete Attribute und Methoden können in einer Klasse zusammengefasst werden um Fehler zu vermeiden und dem *DRY*-Prinzip zu folgen.
Um von Klassen erben zu können, wird das keyword *extends* verwendet.

### Keyword *abstract*

Markiert die Klasse, dass sie nicht instanziiert werden kann(es kann kein Objekt dieser Klasse erzeugt werden).

### Annotation *@Override*

Steht über einer Funktion, welche überschrieben werden soll. Es kann auch ohne *@Override* überschrieben werden. *@Override* erstellt einen Vertrag, dass genau die Signatur der Funktion entsprechen muss. Ohne diesem Keyword, läuft man Gefahr, dass wenn die Signatur einer Methode der Vaterklasse sich verändert, ich die Methode nur überlade und nicht überschreibe.

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
//		this.currentVelocity += this.getPs()/40.0;
	}

}

```

### instanceof - überprüfen der Klasse bzw. der Vaterklasse

wird verwendet um während der Laufzeit zu überprüfen ob, das Objekt in eine bestimmte Klasse ***gecastet*** werden kann, also ob die Klasse des Objekts dem gecasteten entpricht bzw. in der Vererbungshirarchie anzutreffen ist.

```java
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

//		// alternative 
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
//		Tier t = new Tier("tiere=i", "1.1.1111");

		printHundeRasse(tiere);

		kratzi.getRasse();

	}

}
```


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
