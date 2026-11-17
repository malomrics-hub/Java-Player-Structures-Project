/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectcocs304;
public class StackList {
    Node top; 
    
    public boolean isEmpty() {
        return top == null; // check stack is empty or not empty;
    }
    //To add name,score and date to stack list;
    public void push(String name, int score, String DateJoined) {
        Node newNode = new Node(name, score, DateJoined);
        newNode.next = top; //To linked newNode to top;
        top = newNode;
    }
    // To be used in sort score;
    public int peekScore() {
        return top.score; 
    }
    //Mwthod sort score
    public void sortByScoreDescending() {
        StackList tempStack = new StackList(); //Create a temp stack;
        while (!this.isEmpty()) // Check original stack;
        {
            int score = this.top.score; // pop score from original stack;
            String name = this.top.name; // pop name from original stack;
            String DateJoined = this.top.DateJoined; // pop date Joined from original stack;
            this.top = this.top.next; // Change the top;
            while (!tempStack.isEmpty() && tempStack.peekScore() < score) //In the event that the temp stack is not empty
                //and also the first element in it is smaller than the element extracted from the original stack;
            {
                this.push(tempStack.top.name, tempStack.top.score, tempStack.top.DateJoined); // push to original stack;
                tempStack.top = tempStack.top.next; // Change the top in the temp stack;
            }
            tempStack.push(name, score, DateJoined); //Push to temp stack;
        }
        while (!tempStack.isEmpty()) // Check temp stack;
        {
            this.push(tempStack.top.name, tempStack.top.score, tempStack.top.DateJoined); // push to original stack;
            tempStack.top = tempStack.top.next;// Change the top in the temp stack;
        }
    }
    //Method to compare two dates;
    public int compareDatesDateJoined(String DateJoined1, String DateJoined2) {
        return DateJoined1.compareTo(DateJoined2); // A negative integer if DateJoined1 less than DateJoined2;
        // A positive integer if DateJoined1 greater than DateJoined2;
        // zero if DateJoined1 is equal to DateJoined2;;
    } //DateJoined1.olderThan(DateJoined2)?;
     // To be used in sort DateJoined;
    public String peekDateJoined() {
        return top.DateJoined;
    }
    //Method sort DateJoined (descending);
    public void sortByDateJoinedDescending() {
        StackList tempStack = new StackList(); //Create a temp stack;
        while (!this.isEmpty()) // Check original stack;
        {
            int score = this.top.score; // pop score from original stack;
            String name = this.top.name; // pop name from original stack;
            String DateJoined = this.top.DateJoined; // pop date Joined from original stack;
            this.top = this.top.next; // Change the top;
            while (!tempStack.isEmpty()&&compareDatesDateJoined(tempStack.peekDateJoined(), DateJoined) < 0) //In the event that the temp stack is not empty
                //and also the compareDatesDateJoined(tempStack.peekDateJoined(), DateJoined)= negative 
                //This means that the date at the top of the temp stack is older than the date coming from the original stack;
            {
                this.push(tempStack.top.name, tempStack.top.score, tempStack.top.DateJoined); // push to original stack;
                tempStack.top = tempStack.top.next; // Change the top in the temp stack;
            }

            tempStack.push(name, score, DateJoined); //Push to temp stack;
        }
        while (!tempStack.isEmpty()) // Check temp stack;
        {
            this.push(tempStack.top.name, tempStack.top.score, tempStack.top.DateJoined); // push to original stack
            tempStack.top = tempStack.top.next; // Change the top in the temp stack;
        }
    }
     //Method sort DateJoined (ascending);
    public void sortByDateJoinedAscending() {
        StackList tempStack = new StackList();
        while (!this.isEmpty()) {

            int score = this.top.score;
            String name = this.top.name;
            String DateJoined = this.top.DateJoined;
            this.top = this.top.next;
            while (!tempStack.isEmpty() && compareDatesDateJoined(tempStack.peekDateJoined(), DateJoined) > 0) //In the event that the temp stack is not empty
                //and also the compareDatesDateJoined(tempStack.peekDateJoined(), DateJoined)= positive 
                //This means that the date at the top of the temp stack is newer than the date coming from the original stack;
            {
                this.push(tempStack.top.name, tempStack.top.score, tempStack.top.DateJoined);
                tempStack.top = tempStack.top.next;
            }

            tempStack.push(name, score, DateJoined);
        }
        while (!tempStack.isEmpty()) {
            this.push(tempStack.top.name, tempStack.top.score, tempStack.top.DateJoined);
            tempStack.top = tempStack.top.next;
        }
    }
    //Method sort DateJoined;
     public void sortByNameAlphabetical() {
       if(isEmpty()) //check stack is empty or not empty;
       {
           System.out.println("The list dose not contain players.");
           return;
       }
       boolean swap=true; //We start by assuming that a swap will occur;
       while(swap){
           swap=false; //We change the probability so that if it does not happen;
           Node ptr =top; 
           while(ptr!=null&&ptr.next!=null) //We check the current node and the next node;
           {
               if(ptr.name.compareTo(ptr.next.name)>0)// we use compareTo method, positive: if ptr.name greater than ptr.newxt.name(meaning the names are out of order) 
                   //negative: if ptr.name smaller(meaning the names are already in the correct order) | zero if both names are identical;
                  
               {   // We keep the contents of the current node in temp variables(ptrName,ptrScore,ptrDateJoined);
                   String ptrName=ptr.name; 
                   int ptrScore=ptr.score;
                   String ptrDateJoined=ptr.DateJoined;
                   //We assign the values of ptr.next to ptr;
                   ptr.name=ptr.next.name;
                   ptr.score=ptr.next.score;
                   ptr.DateJoined=ptr.next.DateJoined;
                   // We assign the stored temporary values to ptr.next;
                   ptr.next.name=ptrName;
                   ptr.next.score=ptrScore;
                   ptr.next.DateJoined=ptrDateJoined;
                   swap=true; //After swapping the nods, we set swap=true , so we need to repeat sorting process;
               }
               ptr=ptr.next;
           }
       }
    }
     //Method for printing stack list;
    public void printAllStack() {
        if(isEmpty()) // check stack is empty or not empty;
        {
        System.out.println("The list has no players.");  
        return;
        }
         Node ptr=top;
        while (ptr != null)
        {
            System.out.println("name: "+ptr.name+" | score: "+ptr.score+" | dateJoined: "+ptr.DateJoined);
            ptr = ptr.next; //Moving to the next node;
        }
    }
    /*Method is linked to Class Linkedlist to sync the data
    so that if Node is deleted in Linkedlist, we delete the same Node in Class Stacklist;*/
    public void removePlayerFromStackList(String name) {
        if (top.name.equals(name)) {
            top = top.next;
            return;
        }
        Node ptr = top;
        Node prev = null;
        while (ptr != null && !ptr.name.equals(name)) {
            prev = ptr;
            ptr = ptr.next;
        }
        if (ptr != null) {
            prev.next = ptr.next;
        }
    }
    /*Method is linked to the Linkedlist Class,
    if the Score player is updated to what is updated the same player in the Stacklist Class*/
    public void updatePlayerScoreFromStackList(String n, int newscore) {
        Node ptr = top;
        while (ptr != null) {
            if (ptr.name.equals(n)) {
                ptr.score = newscore;
                return;
            }
            ptr = ptr.next;
        }
        if (ptr == null) {
        }
    }

}
