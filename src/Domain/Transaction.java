package Domain;

import java.util.Objects;

public class Transaction {
    private String id, idDrug, idClientCard, date, time;
    private int numberOfItems;
    private double basePrice;
    private double discount;

    public Transaction(String id, String idDrug, String idClientCard, String date, String time, int numberOfItems, double basePrice, double discount) {
        this.id = id;
        this.idDrug = idDrug;
        this.idClientCard = idClientCard;
        this.date = date;
        this.time = time;
        this.numberOfItems = numberOfItems;
        this.basePrice = basePrice;
        this.discount = discount;
    }
    /**
     * Custom getter for the discounted price.
     * @return the price after applying the discount.
     */
    public double getDiscountedPrice() {
        return basePrice*numberOfItems - discount * basePrice*numberOfItems;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", idDrug='" + idDrug + '\'' +
                ", idClientCard='" + idClientCard + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", numberOfItems=" + numberOfItems +
                ", basePrice=" + basePrice +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClientCard, idClientCard, numberOfItems, date, time, basePrice, discount);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(String idDrug) {
        this.idDrug = idDrug;
    }

    public String getIdClientCard() {
        return idClientCard;
    }

    public void setIdClientCard(String idClientCard) {
        this.idClientCard = idClientCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
