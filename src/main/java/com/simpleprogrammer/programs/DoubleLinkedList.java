package com.simpleprogrammer.programs;

// cerner_2^5_2020

// Creating a structure for Node

class DNode {
  String val;
  DNode prev;
  DNode next;

  public DNode(String val) {
    this.val = val;
  }
}

public class DoubleLinkedList {

  DNode head = null;
  DNode top = null, bot = null;

  public void add(String val) {
    try {
      top = getTop();
      if (top == null) {
        head = new DNode(val);
      } else {
        top.next = new DNode(val);
        top.next.prev = top;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage().toString());
    }
  }

  private DNode getTop() {
    if (head == null) {
      return null;
    }
    DNode tmpNode = head;
    while (tmpNode.next != null) {
      tmpNode = tmpNode.next;
    }
    return tmpNode;
  }

  private void revPrint() {
    DNode temp = head;
    DNode tail = null;
    while (temp != null) {
      tail = temp;
      temp = temp.next;
    }
    while (tail != null) {
      System.out.print(tail.val + " ");
      tail = tail.prev;
    }
    System.out.println();
  }

  private void print() {
    if (head == null) {
      System.out.println("List is Empty");
    } else {
      DNode temp = head;
      while (temp != null) {
        System.out.print(temp.val + " ");
        temp = temp.next;
      }
      System.out.println();
    }
  }

  private void delete(String val) {
    if (head == null) {
      System.out.println("No item present to delete");
    } else {
      DNode tempNode = head;
      while (tempNode.val != val) {
        if (tempNode.next == null) {
          System.out.println("No such Val to delete");
          return;
        }
        tempNode = tempNode.next;
      }
      DNode prevNode = tempNode.prev;
      DNode nextNode = tempNode.next;
      DNode temp = tempNode;
      if (prevNode != null) prevNode.next = temp.next;
      else head = temp.next;
      if (nextNode != null) nextNode.prev = temp.prev;
      System.out.println("Value: " + val + " deleted");
    }
  }

  private void deleteTail() {
    if (head == null) {
      System.out.println("No Tail to delete");
    } else {
      DNode tempNode = head;
      while (tempNode.next != null) {
        tempNode = tempNode.next;
      }
      System.out.println("Current Tail: " + tempNode.val);
      tempNode.prev.next = null;
      System.out.println("Deleted Tail");
    }
  }

  private void deletecurrentHead() {
    if (head == null) {
      System.out.println("No head to delete");
    } else {
      System.out.println("Current Head: " + head.val);
      DNode temp = head.next;
      head = temp;
      head.prev = null;
      System.out.println("Deleted Head");
    }
  }

  private void search(String val) {
    if (head == null) {
      System.out.println("No values in list to search");
    } else {
      DNode temp = head;
      while (temp.val != val && temp.next != null) {
        temp = temp.next;
      }
      if (temp.next == null) {
        System.out.println("Value: " + val + " not found");
        return;
      }
      System.out.println("Value: " + val + " found");
    }
  }

  public static void main(String[] args) {
    DoubleLinkedList list = new DoubleLinkedList();

    list.add("fan");
    list.add("got");
    list.add("hit");
    list.add("jet");
    list.add("kit");
    list.add("lol");
    list.add("mat");
    list.print();
    System.out.println("***************************************");
    list.deletecurrentHead();
    list.print();
    System.out.println("***************************************");
    list.deleteTail();
    list.print();
    System.out.println("***************************************");
    list.delete("kit");
    System.out.println("***************************************");
    list.delete("lol");
    System.out.println("***************************************");
    list.delete("hit");
    System.gc();
    list.print();
    System.out.println("***************************************");
    System.out.println("Reverse print");
    list.revPrint();
    System.out.println("***************************************");
    list.search("fan");
    list.search("mat");
    System.out.println("***************************************");
  }
}
