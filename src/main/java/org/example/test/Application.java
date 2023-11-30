package org.example.test;

import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        System.out.println("Démarrage de l'application ...");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le code du compte : ");
        Long code = scanner.nextLong();
        System.out.println("Veuillez saisir le solde initiale du compte : ");
        double solde = scanner.nextDouble();
        IMetierBanque metierBanque = new MetierBanqueImpl();
        metierBanque.addCompte(new Compte(code, solde));
        while (true){
            try {
                System.out.println("Type Opération : ");
                String type = scanner.next();
                if(type.equals("quitter")) break;
                System.out.println("Montant :");
                double montant = scanner.nextDouble();
                if (type.equals("v")) {
                    metierBanque.verser(code, montant);
                } else if (type.equals("r")) {
                    metierBanque.retirer(code, montant);
                }
                Compte compte = metierBanque.consulter(code);
                System.out.println("Etat du compte : " + compte.toString());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Fin de l'application");
    }
}
