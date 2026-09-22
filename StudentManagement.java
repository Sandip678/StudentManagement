import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class StudentManagement extends JFrame implements ActionListener{

private JTextField nameField, rollField, gradeField;
private JTextArea studentList;

public StudentManagement(){

setLayout(null);
setSize(600, 500);
setTitle("Student Management");
setLocation(300, 150);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
JLabel nameLabel = new JLabel("Name : ");
nameLabel.setBounds(20, 20, 100, 25);
add(nameLabel);

nameField = new JTextField();
nameField.setBounds(100, 20, 150, 25);
add(nameField);

JLabel rollLabel = new JLabel("Roll no. : ");
rollLabel.setBounds(20, 60, 100, 25);
add(rollLabel);

 rollField = new JTextField();
rollField.setBounds(100, 60, 150, 25);
add(rollField);

JLabel gradeLabel = new JLabel("Grade : ");
gradeLabel.setBounds(20, 100, 100, 25);
add(gradeLabel);

gradeField = new JTextField();
gradeField.setBounds(100, 100, 150, 25);
add(gradeField);

JButton addButton = new JButton("Add Student");
addButton.setBounds(20,140, 230, 30);
addButton.addActionListener(this);
add(addButton);

JButton sortButton = new JButton("Sort Student");
sortButton.setBounds(20, 180, 230, 30);
add(sortButton);

JLabel sortLabel = new JLabel("Sort By : ");
sortLabel.setBounds(20, 220, 100, 25);
add(sortLabel);

JComboBox<String> sortCriteria = new JComboBox<>(new String []{"Name","Roll Number","Grade"});
sortCriteria.setBounds(120, 220, 100, 25);
add(sortCriteria);

JRadioButton ascending = new JRadioButton("Ascending");
ascending.setSelected(true);
ascending.setBounds(20, 260, 100, 25);
add(ascending);

JRadioButton descending = new JRadioButton("Descending");
descending.setBounds(140, 260, 100, 25);
add(descending);

studentList = new JTextArea();
studentList.setEditable(false);
JScrollPane scrollpane = new JScrollPane(studentList);
scrollpane.setBounds(300, 20, 270, 400);
add(scrollpane);

ButtonGroup sortOrder = new ButtonGroup();
sortOrder.add(ascending);
sortOrder.add(descending);


loadStudentData();

setVisible(true);

}

private Connection getConnection(){

String url = "jdbc:mysql://localhost:3306/student_management";
String username = "MYSQL-username";
String password = "MYSQL-password";

Connection conn = null;

try{

conn = DriverManager.getConnection(url, username, password);

}
catch(Exception e){

JOptionPane.showMessageDialog(null, "Database Connection Error" + e.getMessage());

}

return conn;

}

@Override
public void actionPerformed(ActionEvent es){

String query = "INSERT INTO student(name, roll_number, grade) VALUES(?, ?, ?)";

try{

Connection conn = getConnection();

PreparedStatement pstm = conn.prepareStatement(query);

String name = nameField.getText();
int roll = Integer.parseInt(rollField.getText());
double grade = Double.parseDouble(gradeField.getText());


pstm.setString(1, name);
pstm.setInt(2, roll);
pstm.setDouble (3, grade);

pstm.executeUpdate();

studentList.append("Name: "+name+", Roll No. : "+roll+", Grade: "+grade+"\n");

JOptionPane.showMessageDialog(null, "Student added Successfully..!!");

clearField();

pstm.close();
conn.close();

}catch(Exception e){

JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
}

}

private void clearField(){

nameField.setText("");
rollField.setText("");
gradeField.setText("");

}

private void loadStudentData(){

String query = "SELECT name, roll_number, grade FROM  student";

try{

 Connection conn = getConnection();

if(conn != null){
 PreparedStatement pstm = conn.prepareStatement(query);

 ResultSet rs = pstm.executeQuery();

while(rs.next()){

String name = rs.getString("name");
int roll = rs.getInt("roll_number");
double grade = rs.getDouble("grade");

studentList.append("Name: "+name+", Roll No. : "+roll+", Grade: "+grade+"\n");

}

}


}catch(Exception e){

JOptionPane.showMessageDialog(null, "Error in loading data"+e.getMessage());

}


}


public static void main(String[]args){

new StudentManagement();
}

}


















