import javax.persistence.*;

@Entity
@Table (name = "korisnici")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "korisnikId")
    private int id;
    @Column (name = "ime")
    private String name;
    @Column (name = "prezime")
    private  String surname;
    @Column (name = "age")
    private int age;
    @Column (name = "adress")
    private String adress;
    @Column (name = "income")
    private int income;

    public Person() {
    }

    public Person(String name, String surname, int age, String adress, int income) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adress = adress;
        this.income = income;
    }

    public Person(int id, String name, String surname, int age, String adress, int income) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adress = adress;
        this.income = income;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return
                id +". " + name +" "+ surname +" , god " + age +", adresa " + adress +", prihod " + income
                ;
    }
}
