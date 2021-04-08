package Entities;

public class Seller {
    public int ID;
    public String Name;

    public Seller(){ }

    public Seller(int ID, String name) {
        this.ID = ID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seller seller = (Seller) o;

        if (ID != seller.ID) return false;
        return Name != null ? Name.equals(seller.Name) : seller.Name == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
