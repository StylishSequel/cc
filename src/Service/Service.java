package Service;
public class Service {
    private int id;
    private String name;
    private double price;
    private String date;

    public Service(int id, String name, double price,String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public Service(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Service(){
        this.id = 0;
        this.name = "";
        this.price = 0.0;
        this.date = "";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Service [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}