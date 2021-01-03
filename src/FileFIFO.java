import java.util.Arrays;
import java.util.Scanner;

public class FileFIFO {

    public static int [] tab = new int[4];
    public static int tete = 0;
    public static int queue = 0;
    public static int entries = 0;


    public static void afficherTableau(){
        System.out.println("Tableau : " + Arrays.toString(tab));
    }

    public static void afficherFile(){
        System.out.print("File : ");
        int i;
        if (tete == queue){
            if (entries == 0) {
                System.out.print("vide");
            }else{
                for (i = queue; i < 4; i++)
                {
                    System.out.print(tab[i] + " ");
                }
                for (i = 0; i < tete; i++)
                {
                    System.out.print(tab[i] + " ");
                }

            }
        }else if (tete>queue){
            for (i = queue; i<tete; i++){

                System.out.print(tab[i] + " ");
            }
        }else {
            for (i = queue; i<4; i++){

                System.out.print(tab[i] + " ");
            }
            for (i = 0; i<tete; i++){

                System.out.print(tab[i] + " ");
            }
        }
        System.out.println("");
    }

    public static int input(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        return a;
    }

    public static void offer(int valeur) {
        if (entries < 4) {
            if (tete == 4) {
                tete = 0;
            }
            tab[tete] = valeur;
            tete++;
            entries++;
        }
    }

    public static int poll(){
        if (entries>0) {
            if (queue == 4) {
                queue = 0;
            }
            int a = tab[queue];
            queue++;
            entries--;
            return a;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++){
            int a = input();
            offer(a);
            afficherTableau();
            afficherFile();
            System.out.println("position de la tete : " + tete);
            System.out.println("position de la queue : " + queue);
        }

        for (int i = 0; i < 4; i++){
            System.out.println("Valeure retirée : " + poll());
            afficherTableau();
            afficherFile();
            System.out.println("position de la tete : " + tete);
            System.out.println("position de la queue : " + queue);
        }

        for (int i = 0; i < 4; i++){
            int a = input();
            offer(a);
            afficherTableau();
            afficherFile();
            System.out.println("position de la tete : " + tete);
            System.out.println("position de la queue : " + queue);
        }
    }
}
