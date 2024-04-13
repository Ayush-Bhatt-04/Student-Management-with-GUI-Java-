import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("all")
public class Student_Management {
    static FileWriter file;

    public static void Add() {// COMPLETED
        Frame f = new Frame();
        f.setTitle("ADD A RECORD");
        f.setBackground(Color.GREEN);
        Label l = new Label("    NAME");
        l.setBounds(500, 100, 100, 100);
        l.setBackground(Color.cyan);
        TextField t = new TextField();
        t.setBounds(700, 100, 200, 50);
        Label l1 = new Label("     I.D.");
        l1.setBounds(500, 250, 100, 100);
        l1.setBackground(Color.cyan);
        TextField t1 = new TextField();
        t1.setBounds(700, 250, 200, 50);
        Label l2 = new Label("      COURSE");
        l2.setBounds(500, 400, 100, 100);
        l2.setBackground(Color.cyan);
        TextField t2 = new TextField();
        t2.setBounds(700, 450, 200, 50);
        Button b = new Button("SAVE AND BACK");
        b.setBounds(700, 600, 100, 100);
        b.setBackground(Color.PINK);
        f.add(b);
        f.add(l2);
        f.add(t2);
        f.add(l1);
        f.add(t1);
        f.add(l);
        f.add(t);

        f.setSize(1800, 1200);
        f.setLayout(null);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    file = new FileWriter("Record.txt", true);
                    file.write(t.getText() + "\t\t\t\t" + t1.getText() + "\t\t\t\t" + t2.getText() + "\n");
                    file.close();

                } catch (Exception E) {
                    System.out.println(E);
                }

                f.dispose();
            }
        });

    }

    public static void Show() {// COMPLETED
        Frame f = new Frame("SHOW ALL RECORDS");
        Label l = new Label();
        l.setBounds(10, 100, 2000, 500);
        Button b = new Button("SHOW RECORDS");
        b.setBounds(700, 700, 150, 100);
        b.setBackground(Color.LIGHT_GRAY);
        f.setBackground(Color.pink);
        Button b1 = new Button("BACK");
        b1.setBounds(1000, 750, 50, 50);
        b1.setBackground(Color.DARK_GRAY);
        f.add(b1);
        f.add(b);
        f.add(l);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(1800, 1200);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setForeground(Color.black);
                l.setBackground(Color.GREEN);
                File fil = new File("Record.txt");
                try {
                    String s = "";
                    Scanner sc = new Scanner(fil);
                    while (sc.hasNextLine()) {
                        s = s + sc.nextLine()
                                + "                                                                                                           ";

                    }
                    l.setText(s);

                } catch (Exception E) {
                    System.out.println(E);
                }
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }

    public static void Delete() {// COMPLETED
        Frame f = new Frame("DELETE A RECORD");
        Label l = new Label("     GIVE A NAME TO SEARCH : ");
        f.setBackground(Color.PINK);
        l.setBounds(550, 350, 300, 100);
        l.setBackground(Color.GREEN);
        f.add(l);
        TextField t = new TextField();
        t.setBounds(850, 350, 300, 100);
        f.add(t);
        Button b = new Button("DELETE");
        b.setBounds(650, 600, 150, 50);
        f.add(b);
        Button b1 = new Button("BACK");
        b1.setBounds(650, 700, 150, 50);
        Label l1 = new Label();
        l1.setBounds(650, 500, 300, 100);
        f.add(l1);
        f.add(b1);
        f.setSize(1800, 1200);
        f.setLayout(null);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent E) {
                File x = new File("Record.txt");
                int i = 0;
                String s, s1 = "";
                try {
                    Scanner sx = new Scanner(x);
                    while (sx.hasNextLine()) {
                        s = sx.next();
                        if (t.getText().equalsIgnoreCase(s)) {
                            s = sx.nextLine();
                            i++;
                        } else {
                            s1 = s1 + s;
                            s1 = s1 + sx.nextLine() + "\n";
                        }
                    }
                    if (i == 0) {
                        l1.setText("RECORD NOT PRESENT");
                    }
                }

                catch (Exception e) {
                    System.out.println(e);
                }
                try {
                    if(i>=1){
                    FileWriter a = new FileWriter("Record.txt", false);
                    a.write(s1);
                    a.close();
                    l1.setText("RECORD DELETED SUCCESSFULLY");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });
    }

    public static void Search() {// COMPLETED
        Frame f = new Frame("SEARCH A RECORD ");
        f.setBackground(Color.CYAN);
        Label l = new Label("Enter the name to Search : ");
        l.setBounds(500, 300, 150, 60);
        l.setBackground(Color.DARK_GRAY);
        TextField t = new TextField();
        t.setBounds(700, 300, 300, 50);
        Button b = new Button("SEARCH");
        b.setBounds(600, 600, 200, 100);
        b.setBackground(Color.GREEN);
        Button b1 = new Button("BACK");
        b1.setBounds(600, 720, 150, 70);
        Label l1 = new Label();
        l1.setBounds(600, 450, 300, 100);
        f.add(l1);
        f.add(b1);
        f.add(b);
        f.add(t);
        f.add(l);
        f.setLayout(null);
        f.setSize(1800, 1200);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File ft = new File("Record.txt");
                try {
                    Scanner sc = new Scanner(ft);
                    int i = 0;
                    String s, s1;
                    while (sc.hasNextLine()) {
                        s = sc.next();
                        if (t.getText().equalsIgnoreCase(s)) {
                            l1.setForeground(Color.blue);
                            s1 = sc.nextLine();
                            l1.setText(s + s1);
                            i++;
                            break;
                        } else {
                            s = sc.nextLine();
                        }
                    }
                    if (i == 0) {
                        l1.setForeground(Color.red);
                        l1.setText("RECORD NOT FOUND");
                    }
                } catch (Exception E) {
                    System.out.println(E);
                }
            }
        });
    }

    public Student_Management() {// COMPLETED
        Frame f = new Frame();
        f.setTitle("Student Management");
        f.setBackground(Color.LIGHT_GRAY);
        Button b1 = new Button("ADD A RECORD");
        b1.setBounds(650, 120, 300, 100);
        b1.setBackground(Color.cyan);
        Button b2 = new Button("Show ALL RECORD");
        b2.setBounds(650, 240, 300, 100);
        b2.setBackground(Color.cyan);
        Button b3 = new Button("DELETE A RECORD");
        b3.setBounds(650, 350, 300, 100);
        b3.setBackground(Color.cyan);
        Button b4 = new Button("SEARCH A RECORD");
        b4.setBounds(650, 460, 300, 100);
        b4.setBackground(Color.cyan);
        Button b5 = new Button("EXIT");
        b5.setBounds(650, 570, 300, 100);
        b5.setBackground(Color.cyan);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Show();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete();
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search();
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        Label l = new Label("WELCOME TO OUR PROGRAM !!!!!!!");
        l.setBounds(700, 600, 300, 300);
        l.setForeground(Color.RED);
        f.add(l);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setSize(1800, 1200);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Student_Management();
    }
}
