package Entities;

public class Seller {
    public int ID;
    public String Name;

    public Seller(){ }

    public Seller(String name) {
//        this.ID = ID;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
