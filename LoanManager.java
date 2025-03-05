import java.awt.*;
class Home extends Frame{
    Label l;
    Button b;

    public Home(){
        super("Loan Management System");
        setLayout(new FlowLayout());
        l = new Label("Welcome to Loan Management System");
        add(l);
        b = new Button("Click to continue");
        add(b);
    }
}
public class LoanManager{
    public static void main(String[] args){
        Home h = new Home();
        h.setSize(400,400);
        h.setVisible(true);
    }
}
