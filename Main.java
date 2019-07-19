public class Main {
    public static void main(String[] args) {

        Simulation sim = new Simulation(); //Create new Simulation object

        //Load items
        sim.loadItems("src/phase-1.txt");

        sim.loadItems("src/phase-2.txt");

        System.out.println("Running simulation for U1 rockets------>");

        //Store the cost of launching and landing U1 type rockets
        int cost_U1 = sim.runSimulation(sim.loadU1());
        System.out.println("Total cost for U1 rockets: " + cost_U1 + " millions");

        System.out.println("Running simulation for U2 rockets------>");

        //Store the cost of launching and landing U1 type rockets
        int cost_U2 = sim.runSimulation(sim.loadU2());
        System.out.println("Total cost for U2 rockets: " + cost_U2 + " millions");
    }
}


