/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectcocs304;
public class Node {
    String name;
    int score;
    String DateJoined;
    Node next;

    public Node(String name, int score, String DateJoined) {
        this.name = name;
        this.score = score;
        this.DateJoined = DateJoined;
        this.next=null;
    }
}
