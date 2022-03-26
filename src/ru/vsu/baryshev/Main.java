package ru.vsu.baryshev;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

import static java.lang.System.out;

public class Main {


    public static Queue<Double> sortOfJavaQueue(Queue<Double> queue){
        Queue<Double> forNegative = new LinkedList<Double>();
        Queue<Double> forP = new LinkedList<Double>();
        Queue<Double> forNull = new LinkedList<Double>();

        for (Double i : queue){
            if (i<0) {
                forNegative.add(i);
            }else if (i>0){
                forP.add(i);
            } else forNull.add(i);
        }

        for (Double i : forNull){
            forNegative.add(i);
        }
        for (Double i : forP){
            forNegative.add(i);
        }

        return forNegative;
    }

    public static Queue<Double> arrayToQueue(double[] input){
        Queue<Double> queue = new LinkedList<Double>();
        for (double d : input){
            queue.add(d);
        }
        return queue;
    }

    public static double[] queueToArray(Queue<Double> queue){
       double[] array = new double[queue.size()];
       for (int i=0;i<array.length;i++){
           array[i]=queue.remove();
       }
       return array;

    }

    public static String toString(Queue<Double> queue){
        String str = new String();
        for (Double i : queue){
            str+=" "+i;
        }
        return str;
    }



    public static void main(String[] args) throws IllegalAccessException {
	// write your code here
        Locale.setDefault(Locale.ENGLISH);

        Queue<Integer> queue2 = new LinkedList<Integer>();
        queue2.add(1);
        queue2.add(2);
        queue2.add(3);

        for (Integer item: queue2) {
            System.out.println(item);
        }

        out.println();


        myLinkedList.myQueue queue = new myLinkedList.myQueue();



        queue.add(-10);
        queue.add(0);
        queue.add(-20);
        queue.add(-10);
        queue.add(-30);
        queue.add(10);
        queue.add(-140);
        queue.add(400);
        queue.add(30);
        queue.add(-410);
        queue.add(-160);
        out.println(queue.toString());
        queue=queue.sort();
        out.println(queue.toString());
        out.println();

        out.println(queue.element());
        out.println(queue.peek());

        out.println();
        out.println();
        out.println();

        Queue<Double> newQueue = new LinkedList<Double>();

        newQueue.add((double) -10);
        newQueue.add((double) 0);
        newQueue.add((double)-20);
        newQueue.add((double)-10);
        newQueue.add((double)-30);
        newQueue.add((double)10);
        newQueue.add((double)-140);
        newQueue.add((double)400);
        newQueue.add((double)30);
        newQueue.add((double)-410);
        newQueue.add((double)-160);

        newQueue= sortOfJavaQueue(newQueue);
        out.println(toString(newQueue));



        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
}
