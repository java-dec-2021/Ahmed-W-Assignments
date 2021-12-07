import java.util.ArrayList;

public class Portfolio {
    public ArrayList<Project> Projects;
    
    public Portfolio() {
        this.Projects = new ArrayList<Project>();
    }
    public void addToPortfolio(Project i){
        Projects.add(i);
    }
    public String getPortfolio(){
        return Projects.toString();

    }
    public double getPortfolioCost(){
        double cost = 0;
        for(Project i : Projects){
            cost += i.getCost();
        }
        return cost;
    }

    public void showPortfolio(){
        System.out.println("Portfolios:");
        for(Project i : Projects){
            System.out.printf(i.elevatorPitch(), getPortfolioCost());
        }
    }
}
