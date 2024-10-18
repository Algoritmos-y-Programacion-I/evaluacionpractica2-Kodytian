package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];

    }

    /**
     * Descripción: Inicializa los 4 Pillar ya establecidos.
     * pre: El arreglo "pillars" debe estar inicializado.
     * pos: Se crean cuatro instancias en el arreglo "pillars".
     */
    public void predefinePillars() {

        pillars[0] = new Pillar("Biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Tratamiento de basura");
        pillars[3] = new Pillar("Energía");
    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema.
     * 
     * pre: La lista "pillars" debe estar inciializada.
     * 
     * @return boolean true si se logra añadir el Project en el Pillar, false en
     *         caso contrario.
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,
            boolean realStatus) {
        // Variables de trabajo:
        Project theProject;
        boolean result;

        theProject = new Project(id, name, description, realStatus);

        theProject.statusString();

        result = pillars[pillarType - 1].registerProject(theProject);

        if (result) {
            return result;
        } else {
            return false;
        }
    }

    /**
     * Descripcion: Junta las cadenas de texto del pillar y sus respectivos
     * projectos.
     * pre: El arreglo pillars debe estar inicializado.
     * 
     * @return String cadena en formato lista con la información de los
     *         Project registrados en el Pillar.
     */
    public String showInformation(int pillarType) {
        // Variables de trabajo:
        String pillarName;
        String projectList;
        String information;

        pillarName = pillars[pillarType - 1].toString();
        projectList = pillars[pillarType - 1].getProjectList();

        information = pillarName + projectList;

        return information;
    }
}