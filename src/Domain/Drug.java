package Domain;

public class Drug {
    private String id, name, manufacturer;
    private double price;
    private boolean neeedRecipe;

    public Drug(String id, String name, String manufacturer, double price, boolean neeedRecipe) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.neeedRecipe = neeedRecipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return id.equals(drug.id);
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", neeedRecipe=" + neeedRecipe +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
