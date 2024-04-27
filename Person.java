public class Person {
    private int ID;
    private String name;
    private boolean gender;
    private String phone;

    public Person(int ID, String name, boolean gender, String phone) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }
    public Person() {
        this.ID = 0;
        this.name = "";
    }
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public boolean isGender() {
        return gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }
}
