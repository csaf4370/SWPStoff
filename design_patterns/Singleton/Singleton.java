public class Singleton{

  private static Singleton instance = null;

  private Singleton(){
  }

  public void printSomething(){
    System.out.println("something");
  }

  public static Singleton getInstance(){
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
    
  }

  // Verwendung zB in anderer Klasse
  public static void main(String args[]){
        Singleton.getInstance().printSomething();
        
  }
 
}
