public class U1 extends Rocket {

    public U1(int cost, int weight, int maxWeight) {
        super( cost, weight, maxWeight );
    }

    public U1() {
        super(100,10,18);
    }
    // Chance of launch explosion = 5% * (cargo carried / cargo limit)
    // Chance of landing crash = 1% * (cargo carried / cargo limit)




    @Override
    public boolean land() {
        double random = Math.random();
        double landChance = 0.01 * ((double) super.getWeight() / super.getMaxWeight());

        if (landChance <= random) {
            return true;
        } else {
            System.out.println( "Rocket crashed!" );
            return false;
        }
    }

    @Override
    public boolean launch() {
        double rand = Math.random();
        double launchChance = 0.05 * ((double) super.getWeight() / super.getMaxWeight());

        if (launchChance <= rand) {

            return true;
        } else {
            System.out.println( "Rocket exploded!" );
            return false;
        }


    }
}
