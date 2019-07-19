public class U2 extends Rocket {


    public U2(int cost, int weight, int maxWeight) {
        super( cost, weight, maxWeight );
    }
    //Constructor for U2 Class
    public U2(){
        super(120,18,29);
    }

    //Chance of launch explosion = 4% * (cargo carried / cargo limit)
    //Chance of landing crash = 8% * (cargo carried / cargo limit)


    @Override
    public boolean land(){
        double random = Math.random()*0.1;
        double landChance = 0.08 * ((double) super.getWeight()/super.getMaxWeight());
        if(landChance > random){
            System.out.println( "Rocket crashed!" );
            return false;
        }
        else return true;
    }

    @Override
    public boolean launch(){
        double random = Math.random()*0.1;
        double launchChance = 0.04 * ((double) super.getWeight()/super.getMaxWeight());
        if(launchChance > random){
            System.out.println( "Rocket exploded!" );
            return false;
        }
        else return true;
    }
}


