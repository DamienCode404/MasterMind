import java.util.Random;
import java.util.Scanner;

public class MasterMind {
	public static String saisieString(String msg) 
	{
	Scanner sc = new Scanner(System.in);
	System.out.println(msg);
	return sc.nextLine();
	}
	public static int saisieInt(String msg) 
	{
	Scanner sc = new Scanner(System.in);
	System.out.println(msg);
	int var =  sc.nextInt();
	return var;
	}
	public static double saisieDouble(String msg) 
	{
	Scanner sc = new Scanner(System.in);
	System.out.println(msg);
	return sc.nextDouble();
	}
	public static boolean saisieBoolean(String msg) 
	{
	Scanner sc = new Scanner(System.in);
	System.out.println(msg);
	return sc.nextBoolean();
	}
	
	public static void masterMind() {
		String tabJoueur[] = new String[4];
		int nbEssaies = 12;
		int tabIA[] = new int[4];
		String tabIA_String[] = new String[4];
		Random r  = new Random();
		boolean isVictoire = false;
		int countMalPlace = 0;
		
		System.out.print("Bleu (B), Jaune (J), Gris (G), Marron (M), Noir (N), Orange (O), Rouge(R), Vert (V) \n");
		
		for (int i = 0; i < 4; i++) {
			tabIA[i] = r.nextInt(8)+1;
			// System.out.print(tabIA[i]);
			if (tabIA[i] == 1) {
				tabIA_String[i] = "B";
			} else if (tabIA[i] == 2) {
				tabIA_String[i] = "J";
			} else if (tabIA[i] == 3) {
				tabIA_String[i] = "G";
			} else if (tabIA[i] == 4) {
				tabIA_String[i] = "M";
			} else if (tabIA[i] == 5) {
				tabIA_String[i] = "N";
			} else if (tabIA[i] == 6) {
				tabIA_String[i] = "O";
			} else if (tabIA[i] == 7) {
				tabIA_String[i] = "R";
			} else if (tabIA[i] == 8) {
				tabIA_String[i] = "V";
			}
			// Afficher la solution 
			// System.out.print(tabIA_String[i]); 
	    };
	    
	    System.out.print("\n");
	    
        while ((isVictoire==false) && nbEssaies > 0) {
            System.out.println("\nEssai n°" + (13 - nbEssaies) + " / 12 :");
            for (int i = 0; i < 4; i++) {
                String lettre = saisieString("Saisir une lettre " + (i + 1) + " (BJGMNORV) : ");
                tabJoueur[i] = lettre;
            }
            
            int countBienPlace = 0;
            for (int i = 0; i < 4; i++) {
                if (tabJoueur[i].equals(tabIA_String[i])) {
                	countBienPlace++;
                	if (countBienPlace == 4) {
                		isVictoire = true;
                	}
                }
            }
            
            if (isVictoire==false) {    
                boolean checkedIA[] = new boolean[4]; 
                boolean checkedJoueur[] = new boolean[4];

                for (int i = 0; i < 4; i++) {
                    if (tabJoueur[i].equals(tabIA_String[i])) {
                        checkedIA[i] = true;
                        checkedJoueur[i] = true;
                    }
                }
                
                for (int i = 0; i < 4; i++) {
                    if (!checkedJoueur[i]) { 
                        for (int j = 0; j < 4; j++) {
                            if (!checkedIA[j] && tabJoueur[i].equals(tabIA_String[j])) {
                            	countMalPlace++;
                                checkedIA[j] = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (isVictoire==false) {
            	System.out.println("-------------------------------------------");
                System.out.println("Mauvaise combinaison.");
                System.out.println("Vous avez " + countBienPlace + " couleur(s) bien placée(s)");
                System.out.println("Vous avez " + countMalPlace + " couleur(s) correcte(s) mais mal placée(s)");
                System.out.println("-------------------------------------------");
            } else {
            	System.out.println("-------------------------------------------");
            	System.out.println("Félicitations ! Vous avez trouvé la bonne combinaison !");
            	System.out.println("-------------------------------------------");
                return;
            }
            nbEssaies--;
        }
        System.out.println("Vous avez utilise vos 12 essaies, vous avez perdu ...");
        System.out.println("\nLa bonne combinaison était : \n");
        
        for (int i = 0; i < 4; i++) {
        	System.out.println(tabIA_String[i]);
        }
	}
	public static void main(String[] args) {
		masterMind();
	}
}
