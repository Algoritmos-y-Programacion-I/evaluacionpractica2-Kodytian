package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller controller;
    private Scanner reader;

    public Executable() {

        controller = new Controller();
        reader = new Scanner(System.in);
        controller.predefinePillars();

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }

    /**
     * Descripcion: Despliega el menu principal de funcionalidades al usuario. Y
     * dependiendo de la opción redirige al usuario o da un mensaje de error.
     */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\n¿Que desea hacer?\n");
            System.out.println("1) Registrar un Proyecto en un Pillar.");
            System.out.println("2) Consultar Proyectos por Pilar.");
            System.out.println("0) Salir.");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("\nOpcion invalida, intente nuevamente.");
                    break;
            }

        } while (flag);

    }

    /**
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un
     * Project en un Pillar en el sistema.
     * 
     * pre: El Controller controller debe estar inicializado.
     */
    public void registerProject() {
        // Variables de trabajo:
        reader.nextLine();

        int typePillar;
        int status;
        String id;
        boolean realStatus = false;
        String nameProyect;
        String description;
        boolean result;

        System.out.println("\n¿A que Pillar desea asignar este proyecto?");
        System.out.println("\n[1] Biodiversidad.");
        System.out.println("[2] Agua.");
        System.out.println("[3] Tratamiento de basura.");
        System.out.println("[4] Energía.");
        typePillar = reader.nextInt();

        do {
            reader.nextLine();

            System.out.println("\nCree un ID para este proyecto:");
            id = reader.nextLine();

            System.out.println("\nIndique el estado actual del proyecto:");
            System.out.println("\n[1] Activo");
            System.out.println("[2] Inactivo");
            status = reader.nextInt();

            if (status != 1 && status != 2) {

                System.out.println("\nOpción invalida. intentelo nuevamente");
            } else {

                switch (status) {
                    case 1:
                        realStatus = true;
                        break;
                    case 2:
                        realStatus = false;
                        break;
                    default:
                        break;
                }
            }

        } while (status != 1 && status != 2);

        reader.nextLine();

        System.out.println("\nDigite el nombre que se le asignará al nuevo proyecto:");
        nameProyect = reader.nextLine();

        System.out.println("\nIngrese una breve descripción del proyecto:");
        description = reader.nextLine();

        result = controller.registerProjectInPillar(typePillar, id, nameProyect, description, realStatus);

        if (result) {

            System.out.println("\nEl proyecto se asigno correctamente al Pillar.");
        } else {

            System.out.println("\nAlgo salío mal.");
        }
    }

    /**
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar
     * pre: El controller debe estar inicializado.
     */
    public void showProjectsByPillar() {
        // Variables de trabajo:
        int typePillar;
        String finalInformation;

        System.out.println("\n¿De que Pillar desea saber la información?");
        System.out.println("\n[1] Biodiversidad.");
        System.out.println("[2] Agua.");
        System.out.println("[3] Tratamiento de basura.");
        System.out.println("[4] Energía.");
        typePillar = reader.nextInt();

        finalInformation =controller.showInformation(typePillar);

        System.out.println(finalInformation);
    }
}