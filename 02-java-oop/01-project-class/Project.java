public class Project {
    private String name;
    private String description;
    private double initialCost = 0;

    public String elevatorPitch(){
        return String.format("%s (%02f); %s", getName(), getCost(), getDescription());
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getCost(){
        return this.initialCost;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String descrption){
        this.description = descrption;
    }
    public void setCost(double cost){
        this.initialCost = cost;
    }


    public Project() {
        this.name = "Insert Name";
        this.description = "Insert Description";
        this.initialCost = 0;
    }
    public Project(String name) {
        this.name = name;
        this.description = "Insert Description";
        this.initialCost = 0;
    }
    public Project(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.initialCost = cost;
    }


}
