package module3;
import com.sun.media.sound.InvalidDataException;
import module4.ConsoleReader;
import module6.InvalidInstrumentName;

import java.util.*;

/**
 * Created by home on 07.03.2016.
 */
public class MusicalInstrumentsShop {
    List<MusicalInstrument> avaibleInstruments;

    public MusicalInstrumentsShop(){
        this.avaibleInstruments = new ArrayList<MusicalInstrument>();
    }

    public MusicalInstrumentsShop(List<MusicalInstrument> avaibleInstruments) {
        this.avaibleInstruments = avaibleInstruments;
    }

    public List<MusicalInstrument> getAvaibleInstruments() {
        return avaibleInstruments;
    }

    public void makeInstrumentsSupply(List<MusicalInstrument > supplyList ) {
        this.avaibleInstruments.addAll(supplyList);
    }

    public Map<String,Integer> makeOrder() {
        Map<String, Integer> order = new HashMap<String, Integer>();
        boolean exit = false;

        while (!exit) {
            //order.put(ConsoleReader.readString("What instrument you want to order?"), ConsoleReader.readInt("How many?", 1)[0]);
            try {
                int number = 0;
                switch (ConsoleReader.readString("Add instrument to order? (y/n)\n")) {

                    case "y":
                        String instrument = ConsoleReader.readString("What instrument you want to order?");

                        while (true) {
                            number = ConsoleReader.readInt("How many?", 1)[0];

                            if (number <= 0) {
                                throw new InvalidDataException("Input error: Number should be >0.");
                            } else {
                                order.put(instrument, number);
                                break;
                            }
                        }
                        break;
                    case "n":

                    default:
                        exit = true;
                        if (order.size() == 0) {
                            throw new InvalidDataException("Input error: Number should be >0.");
                        } else {
                            break;
                        }
                }

                System.out.println("Your order: " + order.entrySet());

            } catch (InvalidDataException e) {
                System.err.println(e.getMessage());
            }
        }
        return order;
    }


    public List<MusicalInstrument> prepareInstruments(Map<String,Integer> order) throws IllegalArgumentException, InvalidInstrumentName {
        List<MusicalInstrument> orderedInstruments = new ArrayList<>();

            for (Map.Entry<String, Integer> orderEntry : order.entrySet()
                    ) {
                String type = orderEntry.getKey();
                int quantityNeeded = orderEntry.getValue();
                int numberOfInstrumentsAvaible = 0;

                for (MusicalInstrument avaibleInstrument : avaibleInstruments
                        ) {
                    if (avaibleInstrument.getType().equals(type) && quantityNeeded > numberOfInstrumentsAvaible) {
                        numberOfInstrumentsAvaible++;
                        orderedInstruments.add(avaibleInstrument);
                    }
                }
                /*for (MusicalInstrument instrument:orderedInstruments
                     ) {
                    System.out.println(instrument.getType() + ":" + instrument.getId());

                }*/


                if (numberOfInstrumentsAvaible == 0) {
                    throw new InvalidInstrumentName("No such instrument!");

                } else if (numberOfInstrumentsAvaible < quantityNeeded) {
                    throw new IllegalArgumentException("Not enough " + type + "s in this shop. You want " + quantityNeeded + " There is " + numberOfInstrumentsAvaible);

                }
            }

        return orderedInstruments;

    }

    public void removeInstrument(List<MusicalInstrument> orderedInstruments){

        for (MusicalInstrument orderEntry:orderedInstruments
             ) {
            Iterator<MusicalInstrument> avaibleInstrumentsIterator = this.avaibleInstruments.iterator();

            while (avaibleInstrumentsIterator.hasNext()){
                MusicalInstrument instrumentToRemove = avaibleInstrumentsIterator.next();
                System.out.println(instrumentToRemove.getId());
                if (instrumentToRemove.getType().equals(orderEntry.getType())){
                    System.out.println( instrumentToRemove.getType()+ ", id:" + instrumentToRemove.getId() +  ": removed");
                    avaibleInstrumentsIterator.remove();
                    break;
                }
            }
        }

    }



}
