package hu.bme.team5;

public abstract class Iceberg extends Field {
    private boolean igloo; //van e iglu a mezőn
    private Item frozenItem; //Befagyott item

    public Iceberg() {
        super();
    }

    @Override
    void stepOn(Movable m) {

    }

    //Getter setterek
    public void setIgloo(boolean igloo) {
        System.out.println(">setIgloo()");
        this.igloo = igloo;
        System.out.println("<setIgloo()");
    }

    public Item getFrozenItem() {
        return frozenItem;
    }

    public void setFrozenItem(Item i){
        frozenItem = i;
    }


}
