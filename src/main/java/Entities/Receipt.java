package Entities;

import java.sql.Time;
import java.util.Date;

public class Receipt {
    public int ID;
    public Date DateOfPurchase;
    public Time TimeOfPurchase;
    public int SellerID;
    public int DiscountID;
    public int ShopID;

    public Receipt(){ }

    public Receipt(int ID, Date dateOfPurchase, Time timeOfPurchase, int sellerID, int discountID, int shopID) {
        this.ID = ID;
        DateOfPurchase = dateOfPurchase;
        TimeOfPurchase = timeOfPurchase;
        SellerID = sellerID;
        DiscountID = discountID;
        ShopID = shopID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDateOfPurchase() {
        return DateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        DateOfPurchase = dateOfPurchase;
    }

    public Time getTimeOfPurchase() {
        return TimeOfPurchase;
    }

    public void setTimeOfPurchase(Time timeOfPurchase) {
        TimeOfPurchase = timeOfPurchase;
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public int getDiscountID() {
        return DiscountID;
    }

    public void setDiscountID(int discountID) {
        DiscountID = discountID;
    }

    public int getShopID() {
        return ShopID;
    }

    public void setShopID(int shopID) {
        ShopID = shopID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (ID != receipt.ID) return false;
        if (SellerID != receipt.SellerID) return false;
        if (DiscountID != receipt.DiscountID) return false;
        if (ShopID != receipt.ShopID) return false;
        if (DateOfPurchase != null ? !DateOfPurchase.equals(receipt.DateOfPurchase) : receipt.DateOfPurchase != null)
            return false;
        return TimeOfPurchase != null ? TimeOfPurchase.equals(receipt.TimeOfPurchase) : receipt.TimeOfPurchase == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (DateOfPurchase != null ? DateOfPurchase.hashCode() : 0);
        result = 31 * result + (TimeOfPurchase != null ? TimeOfPurchase.hashCode() : 0);
        result = 31 * result + SellerID;
        result = 31 * result + DiscountID;
        result = 31 * result + ShopID;
        return result;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "ID=" + ID +
                ", DateOfPurchase=" + DateOfPurchase +
                ", TimeOfPurchase=" + TimeOfPurchase +
                ", SellerID=" + SellerID +
                ", DiscountID=" + DiscountID +
                ", ShopID=" + ShopID +
                '}';
    }
}
