package ru.vsu.baryshev;

import java.util.NoSuchElementException;

class myLinkedList {

    private class ListNode {

        private double value;

        private ListNode nextCell;
        private ListNode previousCell;

        public ListNode(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public ListNode getNextCell() {
            return nextCell;
        }

        public void setNextCell(ListNode nextCell) {
            this.nextCell = nextCell;
        }

        public ListNode getPreviousCell() {
            return previousCell;
        }

        public void setPreviousCell(ListNode previousCell) {
            this.previousCell = previousCell;
        }

    }

    private ListNode head;
    private ListNode tail;

    public void addFromHead(double value){
        ListNode tempCell = new ListNode(value);

        if (this.head !=null){
            head.setPreviousCell(tempCell);
            tempCell.setNextCell(head);
            head=tempCell;
        }else {
            head=tail=tempCell;
        }
    }

    public void addFromTail(double value){
        ListNode helpCell = new ListNode(value);

        if (this.tail != null){
            tail.setNextCell(helpCell);
            helpCell.setPreviousCell(tail);
            tail = helpCell;
        }else {
            head=tail=helpCell;
        }
    }

    public double popHead() throws NoSuchElementException {

        if (head == null) {
            throw new NoSuchElementException();
        }

        double value = head.getValue();

        if (head.getNextCell() != null) {
            head = head.getNextCell();
            head.setPreviousCell(null);
        }
        else {
            head = tail = null;
        }

        return value;
    }

    public double popTail(){

        if (tail == null) {
            throw new IllegalArgumentException();
        }

        double value = tail.getValue();

        if (tail.getPreviousCell() != null){
            tail=tail.getPreviousCell();
            tail.setNextCell(null);
        }
        else {
            head=tail=null;
        }

        return value;

    }

    public ListNode findCell(double searchingValue){

        ListNode tempCell = head;
        ListNode answerCell = null;

        while (tempCell != null) {
            if (Math.abs(tempCell.getValue() - searchingValue) <= 1E-5) {
                answerCell=tempCell;
                tempCell = tempCell.getNextCell();
            }
            else {
                tempCell = tempCell.getNextCell();
            }
        }

        return answerCell;
    }

    public String toString(){
        ListNode tempCell = this.head;
        String answer = new String();

        while(tempCell.getNextCell() !=null ){
            answer = answer + " " + tempCell.getValue();

            tempCell = tempCell.getNextCell();
        }
        answer += " " + tempCell.getValue();
        return answer;
    }

    public void removeCell(ListNode removingCell) throws IllegalAccessException {
        if (removingCell.equals(this.head)){
            popHead();
        }else if (removingCell.equals(this.tail)){
            popTail();
        }
        else {
            ListNode previousCell = removingCell.getPreviousCell();
            ListNode nextCell = removingCell.getNextCell();

            nextCell.setPreviousCell(previousCell);
            previousCell.setNextCell(nextCell);
        }
    }

    public int searchForNumOfLocalMax(){

        int answer =0;
        if (this.getSize() !=1) {
            ListNode tempCell = this.head.getNextCell();

            while (tempCell.getNextCell() != null) {

                if ((tempCell.getValue() > tempCell.getNextCell().getValue()) && (tempCell.getValue() > tempCell.getPreviousCell().getValue())) {
                    answer++;
                }
                tempCell = tempCell.getNextCell();
            }
        }
        return answer;

    }

    public int searchForNumOfLocalMin(){
        int answer =0;

        if (this.getSize()!=1) {
            ListNode thisCell = this.head.getNextCell();

            while (thisCell.getNextCell() != null ) {

                if ((thisCell.getValue() < thisCell.getNextCell().getValue()) && (thisCell.getValue() < thisCell.getPreviousCell().getValue())) {
                    answer++;

                }
                thisCell = thisCell.getNextCell();
            }
        }
        return answer;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize(){
        int size = 0;
        ListNode thisCell = this.head;

        while( thisCell != null){
            size++;
            thisCell = thisCell.getNextCell();
        }
        return size;
    }






    public static double[] listToArray(myLinkedList list){
        double[] array = new double[list.getSize()];
        ListNode thisCell = list.head;

        int i=0;
        while( thisCell != null){
            array[i]= thisCell.getValue();
            i++;
            thisCell = thisCell.getNextCell();
        }
        return array;
    }

    public static myLinkedList arrayToList(double[] array){

        myLinkedList list = new myLinkedList();
        for (int i=0; i< array.length;i++){
            list.addFromTail(array[i]);
        }
        return list;
    }




    static class myQueue {


        private myLinkedList list = new myLinkedList();


        public myLinkedList getList() {
            return list;
        }

        public void setList(myLinkedList list) {
            this.list = list;
        }

        public myQueue() {

        }


        public void add(double value){
            list.addFromTail(value);
        }

        public void remove(){ // возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
            list.popHead();
        }

        public Object poll(){ // возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
            if (this.list.head == null) {
                return null;
            }

            double value = this.list.head.getValue();

            if (this.list.head.getNextCell() != null) {
                this.list.head = this.list.head.getNextCell();
                this.list.head.setPreviousCell(null);
            }
            else {
                this.list.head = this.list.tail = null;
            }

            return value;

        }

        public Object peek(){ // возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
            if (!this.list.isEmpty()){
               return this.list.head.getValue();
            }
         //   return this.list.head.getValue();
            return null;
        }

        public Object element(){
            if (this.list.head == null) {
                throw new NullPointerException();
            }
            return this.list.head.getValue();
        }

        public String toString(){
            return this.list.toString();
        }

        public myQueue sort(){

            ListNode temp = this.list.head;
            myQueue queueForNegative = new myQueue();
            myQueue queueForPositive = new myQueue();
            myQueue queueForNull = new myQueue();

            while (temp!=null){
                if (temp.getValue() <0){
                    queueForNegative.add(temp.getValue());
                }else if (temp.getValue()>0){
                    queueForPositive.add(temp.getValue());
                }
                else queueForNull.add(temp.getValue());
                temp=temp.getNextCell();
            }

            temp=queueForNull.list.head;
            while (temp!=null){
                queueForNegative.add(temp.getValue());
                temp=temp.getNextCell();
            }
            temp = queueForPositive.list.head;

            while (temp!=null){
                queueForNegative.add(temp.getValue());
                temp=temp.getNextCell();
            }

            return queueForNegative;
        }

    }

}

