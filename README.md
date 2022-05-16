# SWP2Stoff

## coding guidelines

### CamelCase

Start abhängig von Typ, jedes weitere Wort groß.

```java
String firstName;
```

Alle Typen in CamelCase start mit:

- Klassenname groß
- Eigenschaften klein
- Methoden klein
- Enum Groß (Werte alle UPPERCASE)

## Enums

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

### switch-case Anweisung

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


# Objektorientierte Programmierung

dient zur besseren Strukturierung von Programmmen.
Durch definieren eines "Bauplans", werden Eigenschaften und Funktionen eines Objektes definiert.

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

## Sichtbarkeit

definiert wer von wo auf das Element zugreifen kann.
Es gibt folgende Sichtbarkeiten:

- private --> nur in der gleichen Klasse sichtbar
- public --> von überall sichtbar
- (protected) --> sichtbar im gleichen Package und Subklassen
- default --> entspricht für uns derzeit protected

## Überladen von Funktionen

Funktionen und Konstruktoren dürfen den gleichen Namen haben, müssen sich aber über die Parameter unterscheiden. Nur das ändern des Rückgabetyps reicht nicht.

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
  public Person( int age ) {
    this.age = age;
    this.fname = "Sepp";
  }

  // Konstruktor 3
  public Person( int age, String fname ) {
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
  void ueTest(){
    System.out.println("test");
  }

  // ueberladen der Funktion
  void ueTest(int parameter){
    System.out.println("test " + parameter);
  }

  // funktioniert nicht, weil Unterscheidung nur über Rückgabetyp, Parameter sind gleich wie vorhandene Funktion
  int ueTest(int parameter){
    return 42;
  }
}
```

## Zufallszahlen (Random)
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
		System.out.println(randomZahl); // Zahl zwischen 10 - 110 exclusive
		
		double randDouble = rand.nextDouble();
		System.out.println(randDouble); // Zahl zwischen 0.0 und 1.0 exclusive 
		
//		Ziel ist es einen Double von 10.0 - 20.0 zu machen
		int randomZahl2 = rand.nextInt(9) + 10;
		double randDouble2 = rand.nextDouble();
		double res = randDouble2 + randomZahl2;
		System.out.println(res);
		
		//Alternative
		double randDouble3 = rand.nextDouble()*10.0 + 10.0;
		System.out.println(randDouble3);
	}
}
```
