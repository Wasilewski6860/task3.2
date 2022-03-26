package ru.vsu.baryshev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;

public class MainForm extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JTable table2;
    private JButton loadFromFileButton;
    private JButton sortButton;
    private JButton sortButton1;
    private JButton loadFromFileButton1;
    private JButton removeButton;
    private JButton addButton;
    private JButton addButton1;
    private JButton removeButton1;
    private myLinkedList.myQueue q1 = new myLinkedList.myQueue();
    private myLinkedList list = new myLinkedList();
    private Queue<Double> q2 = new LinkedList<Double>();

    public MainForm(){
        this.setTitle("ТАбличка");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();



        loadFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                fileopen.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int ret = fileopen.showDialog(null, "Открыть файл");

                if (ret == JFileChooser.APPROVE_OPTION) {

                    File file = fileopen.getSelectedFile();
                    String path = file.toString();
                    double []array = ru.vsu.baryshev.util.ArrayUtils.readDoubleArrayFromFile(path);
                    ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table1,array);
                    list=myLinkedList.arrayToList(array);
                    q1.setList(list);


                }

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] array = ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table1);
                    q1.setList(myLinkedList.arrayToList(array));

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                q1.add(0);
                double[] arr = myLinkedList.listToArray(q1.getList());
                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table1,arr);
            }
        });




        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] array = ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table1);
                    q1.setList(myLinkedList.arrayToList(array));

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                q1.remove();
                double[] arr = myLinkedList.listToArray(q1.getList());

                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table1,arr);
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] array = ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table1);
                    q1.setList(myLinkedList.arrayToList(array));

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                q1=q1.sort();
                double[] arr = myLinkedList.listToArray(q1.getList());

                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table1,arr);
            }
        });




        loadFromFileButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                fileopen.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int ret = fileopen.showDialog(null, "Открыть файл");

                if (ret == JFileChooser.APPROVE_OPTION) {

                    File file = fileopen.getSelectedFile();
                    String path = file.toString();
                    double []array = ru.vsu.baryshev.util.ArrayUtils.readDoubleArrayFromFile(path);
                    ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table2,array);
                    q2 = Main.arrayToQueue(array);



                }

            }
        });

        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] array = ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table2);
                    q2 = Main.arrayToQueue(array);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                q2.add((double) 0);
                double[] arr = Main.queueToArray(q2);
                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table2,arr);
            }
        });




        removeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] array = ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table2);
                    q2=Main.arrayToQueue(array);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                q2.remove();
                double[] arr = Main.queueToArray(q2);

                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table2,arr);
            }
        });

        sortButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] array = ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table2);
                    q2=Main.arrayToQueue(array);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                q2=Main.sortOfJavaQueue(q2);
                double[] arr = Main.queueToArray(q2);

                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table2,arr);
            }
        });








    }
}
