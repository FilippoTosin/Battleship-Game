/* Tosin Filippo 3AI 27/12/2021 */
import java.util.*;

public class BattagliaNavale {


    // Metodo che stampa a schermo il campo del giocatore
    public static void stampaCampo(int[][] campoPlayer, int[][] campoPc){
        int i, j;
        System.out.println("                     CAMPO                                       CAMPO AVVERSARIO");
        for(i=0;i<=10*2+1;i++){
            if(i%2!=0)
                System.out.println("    + - + - + - + - + - + - + - + - + - + - +        + - + - + - + - + - + - + - + - + - + - +");
            else if (i==0)
                System.out.println("      A   B   C   D   E   F   G   H   I   L            A   B   C   D   E   F   G   H   I   L");
            else {
                if (i<10*2)
                    System.out.print("  ");
                else
                    System.out.print(" ");
                System.out.print((i-1)/2+1+" ");
                for(j=0;j<10;j++) {
                    System.out.print("| ");
                    if(campoPlayer[(i - 1) / 2][j]==1)
                        System.out.print("1 ");
                    else
                        System.out.print("  ");
                }
                System.out.print("|     ");
                if (i<10*2)
                    System.out.print(" ");
                System.out.print((i-1)/2+1+" ");
                for(j=0;j<10;j++) {
                    System.out.print("| ");
                    if(campoPc[(i - 1) / 2][j]<2)
                        System.out.print("  ");
                    else
                        System.out.print(campoPc[(i - 1) / 2][j]+" ");
                }
                System.out.println("|");
            }
        }
    }


    // Metodo che crea la matrice del campo inserendo zeri in ogni cella
    public static int[][] creazioneCampo (){
        int i, j;
        int[][] campo = new int [10][10];
        for(i=0;i<10;i++)
            for(j=0;j<10;j++)
                campo[i][j]=0;
        return campo;
    }


    // Metodo che inserisce la nave
    public static int[][] inserimentoNave (int[][] campo, int[] infoNave){
        int i;
        for(i=0;i<infoNave[3];i++){
            if(infoNave[2]==0){
                campo[infoNave[0]][infoNave[1]+i]=1;
            }
            else if(infoNave[2]==1){
                campo[infoNave[0]+i][infoNave[1]]=1;
            }
        }
        return campo;
    }


    // Metodo che controlla se le celle sono libere per l'inserimento
    public static boolean controlloCelle (int[][] campo, int[] infoNave){
        int i;

        for(i=0;i<infoNave[3];i++){       // infoNave[2] -> 0: orizzontale, 1: verticale
            if(infoNave[1]+i<0 && infoNave[1]+i>=10)
                return false;
            if(infoNave[2]==0 && campo[infoNave[0]][infoNave[1]+i]!=0)
                return false;
            else if (infoNave[2]==1 && campo[infoNave[0]+i][infoNave[1]]!=0)
                return false;
        }
        return true;
    }


    // Metodo che genera un numero casuale dati i due estremi di un range (inclusi)
    public static int numeroRandom(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }


    // Metodo che inserisce le navi nel campo del PC
    public static int[][] riempimentoPc (int[][] campoPc, int[][] listaNavi){
        boolean valido;
        int i, j;
        int[] infoNave = new int [4];       // Riga, colonna, direzione, lunghezza
        Random rand = new Random();

        for(i=0;i<4;i++)
            for(j=0;j<listaNavi[1][i];j++) {
                valido=false;
                do {
                    infoNave[0] = numeroRandom(0,9);
                    infoNave[1] = numeroRandom(0,9);
                    infoNave[2] = numeroRandom(0,1);
                    infoNave[3] = listaNavi[0][i];
                    if (controlloCelle(campoPc, infoNave) == true) {
                        campoPc = inserimentoNave(campoPc, infoNave);
                        valido=true;
                    }
                }
                while(valido==false);
            }
        return campoPc;
    }


    // Metodo riempimento campo del giocatore
    public static int[][] riempimentoPlayer(int[][] campoPlayer, int[][] listaNavi){
        boolean valido;
        int i, j;
        int[] infoNave = new int [4];       // Riga, colonna, direzione, lunghezza
        Scanner in = new Scanner (System.in);

        for(i=0; i<4; i++)
            for(j=0;j<listaNavi[1][i];j++) {
                do {
                    infoNave[3]=listaNavi[0][i];
                    System.out.println("Inserimento nave lunghezza " + listaNavi[0][i]);
                    do {
                        System.out.println("Inserire riga (valore tra 1 e 10 compresi):");
                        infoNave[0] = in.nextInt() - 1;
                    }
                    while (infoNave[0] < 0 || infoNave[0] > 9);
                    do {
                        System.out.println("Inserire colonna (valore tra 1 e 10 compresi):");
                        infoNave[1] = in.nextInt() - 1;
                    }
                    while (infoNave[1] < 0 || infoNave[1] > 9);
                    do {
                        System.out.println("Inserire direzione (0->orizzontale, 1->verticale):");
                        infoNave[2] = in.nextInt();
                    }
                    while (infoNave[2] < 0 || infoNave[2] > 1);
                    valido=controlloCelle(campoPlayer, infoNave);
                    if (valido==false)
                        System.out.println("Inserimento invalido. Riprova");
                }
                while (valido==false);
                inserimentoNave(campoPlayer, infoNave);
                stampaCampo(campoPlayer, campoPlayer);
            }
        return campoPlayer;
    }



    public static void main (String[] args){

        Scanner in = new Scanner (System.in);

        int i, j;

        int[][] campoPlayer = new int [10][10];
        int[][] campoPc = new int [10][10];
        //int[][] campoColpi = new int [10][10];
        int[][] listaNavi = new int [2][4];      // Riga zero lunghezza, riga uno quantità

        for(i=0,j=4; i<4; i++,j--){     // Assegnamento valori nella matrice navi
            listaNavi[0][i]=j;
            if(i==0)
                listaNavi[1][i]=1;
            else
                listaNavi[1][i]=2;
        }

        campoPc=creazioneCampo();
        campoPlayer=creazioneCampo();

        campoPc=riempimentoPc(campoPc, listaNavi);
        campoPlayer=riempimentoPlayer(campoPlayer, listaNavi);

        //campoColpi=creazioneCampo();

        stampaCampo(campoPlayer, campoPc);


    }
}
