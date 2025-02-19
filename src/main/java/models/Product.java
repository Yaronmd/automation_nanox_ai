package models;

public class Product {
    private String name;
    private String price;
    private String description;

    // Constructor
    public Product(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public Integer getPriceNumber() {
        String[] temp = price.split("\\$");

        if (temp.length < 2) {
            throw new NumberFormatException("Price format is incorrect: " + price);
        }

        return Integer.parseInt(temp[1].trim());
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String category) {
        this.description = category;
    }

    // toString method to display product details
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
