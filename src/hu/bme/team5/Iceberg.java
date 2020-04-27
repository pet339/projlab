package hu.bme.team5;

public abstract class Iceberg extends Field {
    private Item frozenItem; //Befagyott item

    public Iceberg() {
        super();
    }

    @Override
    void stepOn(Movable m){}

    //Getter setterek
    public void setIgloo(boolean igloo) {
        this.igloo = igloo;
    }

    public Item getFrozenItem() {
        return frozenItem;
    }

    public void setFrozenItem(Item i){
        frozenItem = i;
    }


}
