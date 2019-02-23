package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class AddressBookView  extends JFrame implements ActionListener {

    private JButton add , remove ,save;
    private JPanel panel, panel2;
    private JTextField name ,phoneNum;
    private List<BodyInfo> contacts;
    private JFrame f = new JFrame("Body Info ");

    public AddressBookView(){
        super("app.AddressBook");
        contacts = new ArrayList<>();
    }
    public void init(){
        setLayout(new FlowLayout());

        panel = new JPanel();
        panel2 = new JPanel();

        name = new JTextField();
        name.setText("Name");
        name.setPreferredSize(new Dimension(300, 50));
        phoneNum = new JTextField();
        phoneNum.setText("Phone#");
        phoneNum.setPreferredSize(new Dimension(300,50));
        panel.add(name);
        panel.add(phoneNum);

        add = new JButton("Add");
        save = new JButton("Save");
        remove = new JButton("Remove");

        add.addActionListener(this);
        save.addActionListener(this);

        panel2.add(add);
        panel2.add(save);
        //panel2.setLayout(new GridLayout());
        panel.add(panel2);
        //panel.setLayout(new SpringLayout());

        this.add(panel);
        this.pack();
        this.setVisible(true);
        //this.setSize(600,600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        String contact_name;
        int phone;
        BodyInfo new_contact;

        if(action.equals("Add")){

            contact_name = name.getText();
            phone = Integer.parseInt(phoneNum.getText());
            new_contact = new BodyInfo(contact_name, phone);
            contacts.add(new_contact);
            // panel.add(new JTextField(contact_name));

            displayContacts();

        }else if (action.equals("save")){

            System.out.println(action);
            displayContacts();
        }
    }
    public void displayContacts(){
        f.setLayout(new FlowLayout());
        JPanel p =  new JPanel();
        //BoxLayout boxlayout = new BoxLayout(p, BoxLayout.Y_AXIS);
        //p.setLayout(boxlayout);

        JTextField name, phone;


        for(BodyInfo b : contacts){
            name = new JTextField();
            name.setPreferredSize(new Dimension(300, 50));
            phone = new JTextField();
            phone.setPreferredSize(new Dimension(300, 50));

            name.setText(b.getName());
            phone.setText(b.getPhoneNum()+"");
            p.add(name);
            p.add(phone);
            System.out.println(contacts.size());
            System.out.println(b);
        }
        f.add(p);
        f.pack();
        f.setVisible(true);
        f.setSize(600,600);

    }
    public static void main(String[] args){
        AddressBookView ui = new AddressBookView();
        ui.init();
    }
}
