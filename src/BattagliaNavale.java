import java.util.*;

public class BattagliaNavale {

    // Funzione che crea la matrice del campo di battaglia e la restituisce.
    public static int[][] creazioneCampo(){
        int i, j;
        int[][] campoBattaglia = new int [10][10];
        for(i=0; i<10; i++)
            for(j=0; j<10; j++)
                campoBattaglia[i][j]=0;
        return campoBattaglia;
    }

    // Controllo celle libere per l'inserimento della nave.
    public static int[][] inserimentoNave(int[][] campo){
        return campo;
    }

    public static int[][] controlloCelle(int[][] campo, int[] nave){
        return campo;
    }

    public static void main(String[] args){
        int x, y;
        int[][] campoPlayer = new int [10][10];
        int[][] campoPC = new int [10][10];
        int[] elencoNavi = new int [4];
        int[] nave = new int [4];

        Scanner in = new Scanner (System.in);

        campoPlayer = creazioneCampo();
        campoPC = creazioneCampo();

        System.out.println("Inrerire coordinata nave");
        nave[0] = in.nextInt()-1;
        nave[1] = in.nextInt()-1;

    }
}
