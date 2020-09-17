package com.simpleprogrammer.programs;

// Creating a structure for Node
class Node {
  Node next;
  int n;

  public Node(int value) {
    this.n = value;
    this.next = null;
  }
}

public class LinkedList {

  Node head = null;

  Node getPrevNode() {
    if (head == null) {
      return null;
    }
    Node tmpNode = head;
    while (tmpNode.next != null) {
      tmpNode = tmpNode.next;
    }
    return tmpNode;
  }

  public void add(int value) {
    Node prevNode = getPrevNode();
    if (prevNode == null) {
      head = new Node(value);
    } else prevNode.next = new Node(value);
  }

  public void delete(int value) {
    if (head == null) {
      System.out.println("Deletion failed: No element in List");
      return;
    }
    Node currNode = head;
    Node prevNode = null;
    while (currNode != null && currNode.n != value) {
      prevNode = currNode;
      currNode = currNode.next;
    }
    if (prevNode == null) {
      head = head.next;
      return;
    }
    if (currNode == null) {
      System.out.println("No such value present");
      return;
    }
    prevNode.next = currNode.next;
  }

  public void search(int value) {
    if (head == null) {
      System.out.println("No element in List");
      return;
    }
    Node currNode = head;
    try {
      while (currNode != null && currNode.n != value) {
        currNode = currNode.next;
      }
      if (currNode.n == value) {
        System.out.println("Searched value found");
      } else {
        System.out.println("Searched value not found");
      }
      return;
    } catch (Exception e) {
      System.out.println("Searched value not found");
      return;
    }
  }

  private void print() {
    if (head == null) {
      System.out.println("List is Empty");
    } else {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.n + " ");
        temp = temp.next;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    list.print();
    list.delete(5);
    list.search(6);
    list.search(5);
    list.print();
  }
}
