
public class Rocket implements SpaceShip {
    private int cost;
    private int weight;
    private int maxWeight;



    // Constructor for Rocket Class

    public Rocket(int cost, int weight, int maxWeight) {

        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    //Methods get


    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public boolean land() {

        return true;
    }


    @Override
    public boolean launch() {
        return true;
    }
    @Override

    public int carry(Item item) {
        return weight += item.getWeight();

    }

    @Override
    public boolean canCarry(Item item) {

        return (weight + item.getWeight()) <= maxWeight;

    }

}
