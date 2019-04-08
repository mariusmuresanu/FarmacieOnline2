package Domain;

import java.util.Objects;

public class Drug extends Entity {
    private String name, manufacturer;
    private double price;
    private boolean neeedRecipe;

    public Drug(String id, String name, String manufacturer, double price, boolean neeedRecipe) {
        super(id);
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.neeedRecipe = neeedRecipe;
    }



    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, manufacturer, price, neeedRecipe);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return getId().equals(drug.getId());
    }

    @Override
    public String toString() {
        return "Drug{" +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", neeedRecipe=" + neeedRecipe +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNeeedRecipe() {
        return neeedRecipe;
    }

    public void setNeeedRecipe(boolean neeedRecipe) {
        this.neeedRecipe = neeedRecipe;
    }
}
