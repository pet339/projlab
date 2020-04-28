package hu.bme.team5;

import java.util.Random;

public class PolarBear {
    Field currentField;
    public Field getRandomNeighbor(){
        Random rand = new Random();

        int size = currentField.neighbors.size();

        int rnd = rand.nextInt(size);
        return currentField.neighbors.get(rnd);
    }

    public void kill(){
        if (currentField.characters.size() > 1){
           if(!currentField.igloo){
              currentField.gameEnded(false);
           }
            
        }
    }
    public void move(){
        Field nextField = getRandomNeighbor();
        System.out.print("bear moves");
         //remove polarbear
        currentField.polarBear = false;
        setCurrentField(nextField);
        currentField.polarBear = true;
        kill();
        System.out.println("Hello!");
    }
    public void setCurrentField(Field f){
        currentField = f;
    }
}
