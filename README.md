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

Wird verwendet um einen Datentyp zu erstellen, der nur die definierten Werte annehmen kann.

```java
// Definition
public enum HimmelsRichtung{
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

### switch-case Anweisung

Wird verwendet um mögliche Fälle zu behandlen. Kann mit  If-Abfragen ersetzt werden.

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
  } else if ( hr == SUEDEN) {
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
class Person{
  // Eigenschaften/Attribute
  private String firstName;
  private String lastName;

  // Methoden (Funktionen der Klasse)
  public void printFirstName(){
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

Wird verwendet um eine Instanz einer Klasse zu erstellen, die definierten Parameter des Konstruktors können verwendet werden um die Eigenschaften des Objektes zu setzen.

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

tbc...