package app;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    private int id ;

    @OneToMany(
            cascade=CascadeType.PERSIST
    )
    private List<BodyInfo>  list ;

    public AddressBook(){
        list = new ArrayList<BodyInfo>();

    }

    public void addBody (BodyInfo b ) {
        list.add(b);
    }
    public int size(){
        return list.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String toString () {
        String s = "";
        for (BodyInfo b: list ) {
            s = s + b.toString();
        }
        return s ;
    }
    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        BodyInfo b = new BodyInfo("C", 123);
        BodyInfo b2 = new BodyInfo("D", 456);
        ab.addBody(b);
        ab.addBody(b2);
        System.out.print(ab.toString());
    }

}
