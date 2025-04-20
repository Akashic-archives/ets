/**
 * J'ai réalisé ce programme après avoir assisté à un cours de inf2010 de Tarek Oulad-Bachir.
 * J'ai vu la programmation dynamique dans le contexte de la PLSC et le fait que la complexité
 * peut être réduite d'exponentielle à linéaire ou quasi-linéaire, et ça m'a inspiré.
 *
 * @author M'hamed Battioui
 */

import java.io.*;

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
	int tabFleche[][] = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab[i].length - 1; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    tab[i+1][j+1] = tab[i][j] + 1;
		    tabFleche[i+1][j+1] = 1;
                } else if (tab[i][j + 1] >= tab[i + 1][j]) {
                    tab[i+1][j+1] = tab[i][j+1];
		    tabFleche[i+1][j+1] = 2;
                } else {
                    tab[i+1][j+1] = tab[i+1][j];
		    tabFleche[i+1][j+1] = 3;
                }
            }
        }

	// MA LOGIQUE. J'avais une erreur, j'ai demandé à chatgpt comment la résoudre, ce code
	// fonctionne pour aaa et aaa, mais ne fonctionne pas pour d'autres cas.
	/*for (int i = s1.length(); i >= 0; i--) {
		for (int j = s2.length(); j >= 0; j--) {
			if (tabFleche[i][j] == 1) {
				sousSequenceCommune += s1.charAt(i-1);
				break;
			}
		}
	}*/

	// LOGIQUE DE CHATGPT. Je n'aime pas l'utiliser, mais elle est meilleur.
	int i = s1.length();
	int j = s2.length();
	while (i > 0 && j > 0) {
		if (tabFleche[i][j] == 1) {
			sousSequenceCommune += s1.charAt(i-1);
			i--;
			j--;
		} else if (tabFleche[i][j] == 2)
			i--;
		else
			j--;
	}

	StringBuilder reverseSSC = new StringBuilder();
	reverseSSC.append(sousSequenceCommune);
	reverseSSC.reverse();

        return String.valueOf(tab[tab.length - 1][tab[0].length - 1]) + 
                "\n" + reverseSSC;
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
