# SWP2Stoff

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
  public void printfirstName(){
    System.out.println(this.firstName);
  }
}
```

Klasse *Person* mit 2 Eigenschaften (vorName, nachName).

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