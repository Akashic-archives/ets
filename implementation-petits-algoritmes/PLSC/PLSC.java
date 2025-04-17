/**
 * J'ai réalisé ce programme après avoir assisté à un cours de inf2010 de Tarek Oulad-Bachir.
 * J'ai vu la programmation dynamique dans le contexte de la PLSC et le fait que la complexité
 * peut être réduite d'exponentielle à linéaire ou quasi-linéaire, et ça m'a inspiré.
 *
 * @author M'hamed Battioui
 */


public class PLSC {
    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];

        int tab[][] = new int[s1.length() + 1][s2.length() + 1];

        initialiserTab(tab);

        System.out.println(PLSC(s1, s2, tab));
    }

    public static String PLSC(String s1, String s2, int tab[][]) {
        String sousSequenceCommune = "";

        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab[i].length - 1; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    tab[i+1][j+1] = tab[i][j] + 1;
                    sousSequenceCommune = sousSequenceCommune + s1.charAt(i); // a revoir
                } else if (tab[i][j + 1] >= tab[i + 1][j]) {
                    tab[i+1][j+1] = tab[i][j+1];
                } else {
                    tab[i+1][j+1] = tab[i+1][j];
                }
            }
        }

        return String.valueOf(tab[tab.length - 1][tab[0].length - 1]) + 
                "\n" + sousSequenceCommune; // la sous sequence commune n'est pas bien en terme de logique
    }

    public static void initialiserTab(int tab[][]) {
        for (int i = 0; i < tab.length; i++) {
            tab[i][0] = 0;
        }
        for (int i = 0; i < tab[0].length; i++) {
            tab[0][i] = 0;
        }
    }
}