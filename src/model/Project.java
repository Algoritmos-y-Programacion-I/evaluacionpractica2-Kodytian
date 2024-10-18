package model;

public class Project {

    private String id;
    private String name;
    private String description;
    private boolean status;
    private String realStatus;

    public Project(String id, String name, String description, boolean status) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Descripción: Asignadependiendo del boolean status un string indicando si esta
     * activo o inactivo.
     */
    public void statusString() {

        if (status) {
            realStatus = "activo";
        } else {
            realStatus = "inactivo";
        }
    }

    @Override
    public String toString() {
        return "Project " + name + " con ID " + id + " que esta actualmente " + realStatus + ".";
    }
}
