package app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;


@Entity
public class BodyInfo {

    //@GeneratedValue(strategy=GenerationType.AUTO);
    @Id
    @GeneratedValue
    private  int id ;

    private String name ;



    @ManyToOne
    private AddressBook ab ;

    private int phoneNum ;

    public BodyInfo (String name , int phoneNum){
        this.id = 0;
        this.name = name ;
        this.phoneNum = phoneNum;
    }
    public BodyInfo() {

    }

    public AddressBook getAb() {
        return ab;
    }

    public void setAb(AddressBook ab) {
        this.ab = ab;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return this.name ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNum(){
        return this.phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString(){
        return "Name:"+ name + " PHone Number: "+phoneNum+"\n";
    }
}

