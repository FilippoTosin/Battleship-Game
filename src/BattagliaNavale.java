/* Tosin Filippo 3AI 27/12/2021 */
import java.util.*;

public class BattagliaNavale {


    // Metodo che crea la matrice del campo
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


    // Metodo che inserisce le navi nel campo del PC
    public static int[][] riempimentoCampo (int[][] campoPc, int[][] navi){
        int i, j;
        Random rand = new Random();
        int[] infoNave = new int [4];

        for(i=0;i<4;i++)
            for(j=0;j<navi[1][i];j++) {
                infoNave[0]=rand.nextInt(10);
                infoNave[1]=rand.nextInt(10);
                infoNave[2]=rand.nextInt(2);
                infoNave[3]=navi[0][i];
                if(controlloCelle(campoPc,infoNave)==true)
                    campoPc=inserimentoNave(campoPc, infoNave);
            }
        return campoPc;
    }


    // Metodo riempimento campo del giocatore
    public static int[][] riempimentoCampoPlayer(int[][] campoPlayer, int[][] navi){


        return campoPlayer;
    }



    public static void main (String[] args){

        Scanner in = new Scanner (System.in);

        int i, j;

        int[][] campoPlayer = new int [10][10];
        int[][] campoPC = new int [10][10];
        int[][] campoColpi = new int [10][10];
        int[][] listaNavi = new int [2][4];      // Riga zero lunghezza, riga uno quantità
        int[] infoNave = new int [4];     // Riga, colonna, direzione, lunghezza

        for(i=0,j=4; i<4; i++,j--){     // Assegnamento valori nella matrice navi
            listaNavi[0][i]=j;
            if(i==0)
                listaNavi[1][i]=1;
            else
                listaNavi[1][i]=2;
        }

        campoPlayer=creazioneCampo();
        campoPC=creazioneCampo();
        campoColpi=creazioneCampo();


    }
}
