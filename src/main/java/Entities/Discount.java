package Entities;

public class Discount {
    public int ID;
    public String TypeOfDiscount;
    public int AmountOfDiscount;

    public Discount(){ }

    public Discount(int ID, String typeOfDiscount, int amountOfDiscount) {
        this.ID = ID;
        TypeOfDiscount = typeOfDiscount;
        AmountOfDiscount = amountOfDiscount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTypeOfDiscount() {
        return TypeOfDiscount;
    }

    public void setTypeOfDiscount(String typeOfDiscount) {
        TypeOfDiscount = typeOfDiscount;
    }

    public int getAmountOfDiscount() {
        return AmountOfDiscount;
    }

    public void setAmountOfDiscount(int amountOfDiscount) {
        AmountOfDiscount = amountOfDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        if (ID != discount.ID) return false;
        if (AmountOfDiscount != discount.AmountOfDiscount) return false;
        return TypeOfDiscount != null ? TypeOfDiscount.equals(discount.TypeOfDiscount) : discount.TypeOfDiscount == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (TypeOfDiscount != null ? TypeOfDiscount.hashCode() : 0);
        result = 31 * result + AmountOfDiscount;
        return result;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "ID=" + ID +
                ", TypeOfDiscount='" + TypeOfDiscount + '\'' +
                ", AmountOfDiscount=" + AmountOfDiscount +
                '}';
    }
}
