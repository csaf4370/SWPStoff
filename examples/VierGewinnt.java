import java.util.Scanner;

public class VierGewinnt {

    private char[][] spielFeld;

    public VierGewinnt(){
        spielFeld = new char[6][7];
        for (int i=0; i < 6; i++){
            for (int j=0; j<7; j++){
                spielFeld[i][j] = '_';
            }
        }
    }

    public void printSpielFeld(){
        for (int i=0; i < 6; i++){
            for (int j=0; j<7; j++){
                System.out.print(spielFeld[i][j]);
            }
            System.out.println();
        }
    }

    public void setzeSpielstein(Player player, int spalte) throws IllegalMoveException{
        if (spalte < 0 || spalte > this.spielFeld[0].length-1){
            throw new IllegalMoveException("Diese Spalte is ausserhalb des Spielfeldes!");
        }
        int setzten = this.spielFeld.length-1;
        for(int i=0; i<this.spielFeld.length;i++){
            if (this.spielFeld[i][spalte] != '_'){
                setzten = i-1;
                break;
            }
        }
        if (setzten < 0){
            throw new IllegalMoveException("Diese Spalte is voll!");
        }
        this.spielFeld[setzten][spalte] = player.symbol;
    }

    private boolean gameFinished(){
        char currentChar = ' ';
        int occurences = 0;
        // find horizontal win
        for(int i = 0; i < this.spielFeld.length; i++){
            for (int j = 0; j < this.spielFeld[i].length; j++) {
                if (j == 0 || currentChar != this.spielFeld[i][j]){
                    currentChar = this.spielFeld[i][j];
                    occurences = 1;
                } else {
                    if (currentChar!= '_'){
                        occurences++;
                    }
                }
                if (occurences == 4) {
                    return true;
                }
            }
        }
        // find vertical win
        for(int i = 0; i < this.spielFeld[0].length; i++){
            for (int j = 0; j < this.spielFeld.length; j++) {
                if (j == 0 || currentChar != this.spielFeld[j][i]){
                    currentChar = this.spielFeld[j][i];
                    occurences = 1;
                } else {
                    if (currentChar!= '_'){
                        occurences++;
                    }
                }
                if (occurences == 4) {
                    return true;
                }
            }
        }

        // find diagonal right
        for(int i = 0; i < this.spielFeld[i].length; i++){ // ueber zeile
            // to be filled
        }

        return false;
    }

    public static void main(String[] args) {
        VierGewinnt vg = new VierGewinnt();
        vg.printSpielFeld();
        System.out.println("--------------------------------------");

        Player player1 = new Player('x', "Sepp");
        Player player2 = new Player('o', "Staud");

//        vg.setzeSpielstein(player1, 3);
//        vg.setzeSpielstein(player2, 3);
//        vg.printSpielFeld();

        Scanner scan = new Scanner(System.in);
        boolean gameNotFinished = true;
        Player activePlayer = player1;
        while (gameNotFinished) {
            System.out.println("Bitte gibt die Spalte ein " + activePlayer.name);
            try {
                int spalte = scan.nextInt();
                vg.setzeSpielstein(activePlayer, spalte);
            } catch (IllegalMoveException e) {
                System.out.println(e.getMessage());
                continue;
            }
            vg.printSpielFeld();

            // gewinnbedingung ...
            gameNotFinished = !vg.gameFinished();
            if (activePlayer == player1) {
                activePlayer = player2;
            } else {
                activePlayer = player1;
            }
        }

    }


}
