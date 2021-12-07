public class TestProject {
    public static void main(String[] args) {
        Project p1 = new Project();
        Project p2 = new Project("Doughnuts");
        Project p3 = new Project("Pizza", "Secret pizza project", 25.5);
        Portfolio port1 = new Portfolio();
        System.out.println(p1.elevatorPitch());
        System.out.println(p2.elevatorPitch());
        System.out.println(p3.elevatorPitch());
        System.out.println(p3.getName());
        System.out.println(p3.getDescription());
        System.out.println(p3.getCost());
        port1.showPortfolio();
        System.out.println(port1.getPortfolioCost());

    }
}
