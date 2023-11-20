import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Calculator extends JPanel implements ActionListener {
        JFrame frame;
        JTextField textField; 
        //array to set numbers and functions to jbuttons object
        JButton[] functionsButtons = new JButton[7];  
        JButton[] numberButtons = new JButton[10];
        JButton addButton, subButton, mulButton, divButton;
        JButton decButton, equButton, clrButton;
        JRadioButton radioButton;
        double num1=0, num2=0, result=0;
        char operator;
        JPanel panel;
    

    Calculator() {
        
        frame = new JFrame("Calculator");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(125,25,350,50);
        textField.setEditable(false);

        radioButton = new JRadioButton("Quit");
        radioButton.setBounds(250,410,145,50);
        radioButton.addActionListener(this);
        //radioButton.setEditable(false);

        //initializing variables
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        clrButton = new JButton("clear");
        equButton = new JButton("=");


        functionsButtons[0] = addButton;
        functionsButtons[1] = subButton;
        functionsButtons[2] = mulButton;
        functionsButtons[3] = divButton;
        functionsButtons[4] = decButton;
        functionsButtons[5] = clrButton;
        functionsButtons[6] = equButton;

        //functions buttons array must equal to array int size or arrayoutofbound expection
        for(int i = 0; i < 7; i++) {
            functionsButtons[i].addActionListener(this);
            //removes outline on buttons
            functionsButtons[i].setFocusable(false);
        }

        //number buttons array must equal to array int size or arrayoutofbound expection
        for(int i = 0; i <10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        clrButton.setBounds(310,410,145,50);

        //panel holds all the different number buttons 
        panel = new JPanel();
        //withing calculator for room for the buttons
        panel.setBounds(150,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        //similar to html & css you have the whole background and then sections such as divs,
        //the frame is the background and the panel is the div to have certain 
        //objects in the panel;
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);        
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(clrButton);
        frame.add(radioButton);
        frame.add(textField);
        frame.setVisible(true);
    }


public static void main(String[] args) {
    Calculator calculator = new Calculator();
}
    

    //use an action event when user performs an action e.g clicks buttons,etc.
    @Override
    public void actionPerformed(ActionEvent e) {

        //gets value from numberbuttons to display on textfield
        for(int i = 0; i < 10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton) {
            textField.setText(textField.getText().concat("."));
        }
        
        if(e.getSource()==addButton) {
            //returns a new double initialized to the value represented by the specified String
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()==mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==clrButton) {
            textField.setText("");
        }
        if(e.getSource()==equButton) {
            num2 = Double.parseDouble(textField.getText());
            
            switch(operator) {
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
        }
        //converts int into string in textfield
        textField.setText(String.valueOf(result));
        num1 = result; 
        
        
    }

    if(e.getSource()==radioButton) {
        System.exit(0);
    }
    }
}