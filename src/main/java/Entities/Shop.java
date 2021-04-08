package Entities;

public class Shop {
    public int ID;
    public String Address;

    public Shop(){ }

    public Shop(int ID, String address) {
        this.ID = ID;
        Address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (ID != shop.ID) return false;
        return Address != null ? Address.equals(shop.Address) : shop.Address == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "ID=" + ID +
                ", Address='" + Address + '\'' +
                '}';
    }
}
