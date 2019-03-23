package UI;

import Domain.Drug;
import Service.DrugService;

import java.util.Scanner;

public class Consola2 {

    public Consola2(DrugService drugService) {
        this.drugService = drugService;
    }

    private DrugService drugService;

    private void showOptions() {

        System.out.println("show all -> afiseaza toate medicamentele");
        System.out.println("exit -> inchide aplicatia");
        System.out.println("add <id> <name> <manufacturer> <price> <neeedRecipe> ->adauga");
        System.out.println("remove -> face undo pe ultima modificare");

        System.out.print("> ");
    }


    public void run() {

        Scanner in = new Scanner(System.in);
        while (true) {
            showOptions();
            String option = in.nextLine();

            if (option.equals("show all")) {
                showAll();
            } else if (option.equals("exit")) {
                return;
            } else {
                handleCommand(option);
            }
        }
    }

    private void handleAdd(String[] args) {
        try {
            if (args.length != 6) {
                System.out.println("Eroare: add primeste exact 7 parametri separati prin spatiu!");
            } else {
                String id = args[1];
                String name = args[2];
                String manufacturer = args[3];
                double price = Double.parseDouble(args[4]);
                boolean neeedRecipe = Boolean.parseBoolean(args[5]);


                drugService.addOrUpdate(id, name, manufacturer, price, neeedRecipe);
            }
        } catch (Exception ex) {
            System.out.println("Eroare: " + ex.getMessage());
        }
    }

    private void handleRemove(String[] args)
    {
        try {
            if (args.length < 2) {
                System.out.println("Eroare: remove primeste exact 1 parametru!");
            } else {
                String id = args[1];



                drugService.remove(id);
            }
        } catch (Exception ex) {
            System.out.println("Eroare: " + ex.getMessage());
        }
    }

    private void handleCommand(String cmd) {

        String[] args = cmd.split(" ");
        if (args[0].equals("add")) {
            handleAdd(args);
        }
        if (args[0].equals("remove")) {
            handleRemove(args);
        }
    }
    private void showAll() {
        for (Drug drug : drugService.getAll()) {
            System.out.println(drug);
        }
        System.out.println();
    }
}
