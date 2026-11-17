/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectcocs304;

public class LinkedList {
    Node head;
    public LinkedList() {
        head=null;
    }
    public boolean isEmpty() // check LinkedList is empty or not empty;
    {
        return head==null;
    }
    //Method to add Node to the end of Linkedlist;
    public void insrtAtEndPlayers(String name,int score,String DateJoined)
    {
        Node newNode = new Node(name,score,DateJoined); //Add to class Node;
        if(isEmpty()) //check LinkedList is empty or not empty;
        {
         head=newNode; //In the event that there is no Node, the head index refers to Newode;
         return; //To exit Method;
        }
        Node ptr=head; //Temporary pointer to traverse through LinkedList;
        while(ptr.next!=null) //To stop at the last node;
        {
            ptr=ptr.next; //Moving to the next node;
        }
        ptr.next=newNode; //The last node refers to newNode;
    }
    //Method deletes a player based on his name;
    public void removePlayerfromLinkedList(String name){
        if(head.name.equals(name)) //In the event that the player to be deleted is at the first Linkedlist;
        {
            head=head.next;//We make Head refer to the second node;
           System.out.println("Player removed: "+name);
            return;  //To exit Method;
        }
        Node ptr=head; //Temporary pointer to traverse through LinkedList;
        Node prev=null; //A new temporary indicator indicates null at first;
        while(ptr!=null&&!ptr.name.equals(name)) //A condition for navigation via Linkedlist and if it reaches the name of the player to be deleted, he stops;
        {
          prev=ptr; //We make the prev indicator indicate ptr;
          ptr=ptr.next; //We make the ptr index preceded prev;
        }
        if(ptr!=null)
        {
            prev.next=ptr.next; //We make the prev pointer point to the node that the PTR points to so that the node where the PTR stopped is ignored;
            System.out.println("Player removed: "+name);
        }
        else //If the player is not on the list;
        {
            System.out.println("Player not found.");
        }
    }
    //Method updates Score player;
    public void updatePlayerScoreFromLinkedList(String n,int newscore){
        Node ptr=head; //Temporary pointer to traverse through LinkedList;
        while(ptr!=null)
        {
            if(ptr.name.equals(n))//A condition in the event of matching the name sent with the name with ptr.name;
            {
                ptr.score=newscore;//Store new score;
                System.out.println("Updated score,for player: "+n+" to "+newscore);
                return;
            }
            ptr=ptr.next; //Moving to the next node;
        }
        if(ptr==null){
           System.out.println("Player not found.");
        }
    }
    //Mehod to filter players by date joined ;
    public void filterPlayersByDateJoined(int yearJoin) {
        Node ptr = head; //Temporary pointer to traverse through LinkedList;
        boolean found = false; /*In the event that we do not find the player, Found = False 
        will be used and will be used in IF to be printed to the user that we did not find the player;*/
        while (ptr != null) 
        {
            String yearptr = ptr.DateJoined;//We store the history of all Node in the yearptr variable;
            int yearFilter = Integer.parseInt(yearptr.substring(0, 4)); /*After taking the entire date from Ptr.datejoined, we 
            take the year from history and then convert it to Integer to use it in comparison*/
            if (yearFilter == yearJoin) //(The year in Node == The year sent from the user); 
            {
                System.out.println("name: " + ptr.name + " | score: " + ptr.score + " | dateJoined: " + ptr.DateJoined);
                found = true; //We convent found =true;
            }
            ptr = ptr.next; //Moving to the next node;
        }
        if (!found)/*In the absence of the player, Found = False will remain 
            and we will print a message to the user showing him that we did not find the player;*/
        {
            System.out.println("No players found for the given year.");
        }
    }
    //Method filters Score depending on the user's range;
    public void filterPlayersByScore(int minimum , int maximum) {
        Node ptr =head; //Temporary pointer to traverse through LinkedList;
        boolean found = false;  /*In the event that we do not find the player, Found = False 
        will be used and will be used in IF to be printed to the user that we did not find the player;*/
        while(ptr!=null){
            //(The score in the node more than or equal to the minimum sent from the user (AND) the score in the node less than or equal to the maximum sent from the user );
            if(ptr.score>=minimum&&ptr.score<=maximum){
            System.out.println("name: " + ptr.name + " | score: " + ptr.score + " | dateJoined: " + ptr.DateJoined);
            found = true;  //We convent found =true;
                }
            ptr=ptr.next; //Moving to the next node;
        }
        if (!found) /*In the absence of the player, Found = False will remain 
           and we will print a message to the user showing him that we did not find the player;*/
        {
            System.out.println("No players found for the score range.");
        }
    }
    //Method for printing Linked list;
    public void printAllLinkedList(){
        Node ptr =head; //Temporary pointer to traverse through LinkedList;
        while(ptr!=null){
            System.out.println("name: "+ptr.name+" | score: "+ptr.score+" | dateJoined: "+ptr.DateJoined);
            ptr=ptr.next; //Moving to the next node;
        }
    }
    
    
}
