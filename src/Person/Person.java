package Person;

public class Person {
    private int ID;
    private String name;
    private boolean gender;
    private String phone;
    private boolean is_active;

    public Person(int ID, String name, boolean gender, String phone, boolean is_active) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.is_active = is_active;
    }

    public Person(String name, boolean gender, String phone, boolean is_active) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.is_active = is_active;
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
    public boolean isIs_active() {
        return is_active;
    }
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
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
