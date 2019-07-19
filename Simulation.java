import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private ArrayList<Item> items;

    //Constructor for Simulation Class creates an empty ArrayList of item object
    public Simulation(){
        items = new ArrayList<>();
    }

    //Method to read the text file which contains the list of items and populate the ArrayList
    public void loadItems(String path){
        File phase = new File(path);
        try {
            Scanner fileScanner = new Scanner(phase);
            while (fileScanner.hasNextLine()){
                String value = fileScanner.nextLine();
                int index = value.indexOf("=");
                Item item = new Item(value.substring(0,index), Integer.parseInt(value.substring(index+1))/1000);
                items.add(item);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }

    }

    //Method returns a list of rockets of type U1 which are populated with the limited items each rocket could carry
    public ArrayList<Rocket> loadU1(){
        ArrayList<Rocket> rocketsU1 = new ArrayList<>();
        int i = 0;
        while(i<items.size()){
            Rocket u1 = new U1();
            while(i<items.size() && u1.canCarry(items.get(i))){
                u1.carry(items.get(i));
                i++;
            }
            rocketsU1.add(u1);
        }
        return rocketsU1;
    }

    //Method returns a list of rockets of type U2 which are populated with the limited items each rocket could carry
    public ArrayList<Rocket> loadU2(){
        ArrayList<Rocket> rocketsU2 = new ArrayList<>();
        int i = 0;
        while(i<items.size()){
            Rocket u2 = new U2();
            while(i<items.size() && u2.canCarry(items.get(i))){
                u2.carry(items.get(i));
                i++;
            }
            rocketsU2.add(u2);
        }
        return rocketsU2;
    }

    //Method returns total cost required to land and launch all U1 and U2 rockets including failed attempts
    public int runSimulation(ArrayList<Rocket> rockets){
        int totalBudget = 0;
        int fail = 0;
        for(Rocket r : rockets){
            totalBudget += r.getCost();
            //System.out.println(r.getWeight());
            while (!r.launch() || !r.land()){
                totalBudget +=r.getCost();
                fail++;
            }
        }
        System.out.println("Fails: "+fail);
        return totalBudget;
    }
}