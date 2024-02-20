/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phonebook;

/**
 *
 * @author Abhi
 */
import java.util.Scanner;

class Node {

    String name;
    String email;
    String num;
    Node next;

    Node(String name, String email, String num) {
        this.name = name;
        this.email = email;
        this.num = num;
        this.next = null;
    }
}

public class PhoneBook {

    static Node head = null;
    static Scanner sc = new Scanner(System.in);

    public static void insert() {
        System.out.print("\nENTER NAME :\t");
        String name = sc.next();
        System.out.print("\nENTER EMAIL :\t");
        String email = sc.next();
        System.out.print("\nENTER VALID MOBILE NUMBER :\t");
        String num = sc.next();
        Node newNode = new Node(name, email, num);
        newNode.next = head;
        head = newNode;
        System.out.println("\n--------DO YOU WANT TO ADD MORE--------\n");
        System.out.println("|                                     |");
        System.out.println("|      1. ADD MORE                    |");
        System.out.println("|      2. GO TO HOME                  |");
        System.out.println("---------------------------------------\n");
        int ch = sc.nextInt();
        if (ch == 1) {
            insert();
        }
    }

    public static void display() {
        int i = 1;
        Node temp = head;
        if (head == null) {
            System.out.println("\n---------------------------------------");
            System.out.println("|           NO CONTACT FOUND          |");
            System.out.println("---------------------------------------\n");
            System.out.println("\n----------DO YOU WANT TO ADD ----------\n");
            System.out.println("|                                     |");
            System.out.println("|         1. ADD CONTACT              |");
            System.out.println("|         2. GO TO HOME               |");
            System.out.println("|                                     |");
            System.out.println("---------------------------------------\n");
            int ch = sc.nextInt();
            if (ch == 1) {
                insert();
            }
        } else {
            sort();
            System.out.println("\n***********YOUR CONTACTS ARE ***********\n");
            while (temp != null) {
                System.out.println("\n" + i + ". NAME---->" + temp.name);
                System.out.println("   EMAIL--->" + temp.email);
                System.out.println("   NUMBER-->" + temp.num + "\n");
                System.out.println("****************************************\n");
                temp = temp.next;
                i++;
            }
        }
    }

    public static void sort() {
        Node t1, t2;
        String n, e, m;
        for (t1 = head; t1 != null; t1 = t1.next) {
            for (t2 = t1.next; t2 != null; t2 = t2.next) {
                if (t1.name.compareTo(t2.name) > 0) {
                    n = t1.name;
                    t1.name = t2.name;
                    t2.name = n;
                    e = t1.email;
                    t1.email = t2.email;
                    t2.email = e;
                    m = t1.num;
                    t1.num = t2.num;
                    t2.num = m;
                }
            }
        }
    }

    public static void search() {
        System.out.print("\nENTER NAME, EMAIL, OR NUMBER TO SEARCH:\n");
        String key = sc.next();
        Node temp = head;
        int found = 0;
        while (temp != null) {
            if ((temp.name).equalsIgnoreCase(key) || (temp.email).equalsIgnoreCase(key) || (temp.num).equalsIgnoreCase(key)) {
                System.out.println("\nCONTACT FOUND:");
                System.out.println("   NAME---->" + temp.name);
                System.out.println("   EMAIL--->" + temp.email);
                System.out.println("   NUMBER-->" + temp.num + "\n");
                found = 1;
                break;
            }
            temp = temp.next;
        }
        if (found == 0) {
            System.out.println("\nCONTACT NOT FOUND!");
        }
    }

    public static void delete() {
        System.out.print("\nENTER NAME, EMAIL, OR NUMBER TO DELETE:\n");
        String key = sc.next();
        Node temp = head;
        Node prev = null;
        int found = 0;
        while (temp != null) {
            if (temp.name.equals(key) || temp.email.equals(key) || temp.num.equals(key)) {
                if (prev == null) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("\nCONTACT DELETED:");
                System.out.println("   NAME---->" + temp.name);
                System.out.println("   EMAIL--->" + temp.email);
                System.out.println("   NUMBER-->" + temp.num + "\n");
                found = 1;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (found == 0) {
            System.out.println("\nCONTACT NOT FOUND!");
        }
    }

    public static void update() {
        System.out.print("\nENTER NAME, EMAIL, OR NUMBER TO UPDATE:\n");
        String key = sc.next();
        Node temp = head;
        int found = 0;
        while (temp != null) {
            if ((temp.name).equalsIgnoreCase(key) || (temp.email).equalsIgnoreCase(key) || (temp.num).equalsIgnoreCase(key)) {
                System.out.println("\n--------WHAT YOU WANT TO UPDATE--------\n");

                System.out.println("|         1. NAME                     |\n");
                System.out.println("|         2. EMAIL                    |\n");
                System.out.println("|         3. NUMBER                   |\n");
                System.out.println("---------------------------------------\n");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.print("\nENTER NEW NAME:\n");
                        temp.name = sc.next();
                        break;
                    case 2:
                        System.out.print("\nENTER NEW EMAIL:\n");
                        temp.email = sc.next();
                        break;
                    case 3:
                        System.out.print("\nENTER NEW NUMBER:\n");
                        temp.num = sc.next();
                        break;
                    default:
                        System.out.println("\nINVALID OPTION!");
                        break;
                }
                System.out.println("\n*********CONTACT AFTER UPDATE*********\n");
                System.out.println("   NAME---->" + temp.name);
                System.out.println("   EMAIL--->" + temp.email);
                System.out.println("   NUMBER-->" + temp.num + "\n");
                found = 1;
                break;
            }
            temp = temp.next;
        }
        if (found == 0) {
            System.out.println("\nCONTACT NOT FOUND!");
        }
    }

    public static void main(String args[]) {
        System.out.println("\n************            PHONE BOOK            ************");
        System.out.println("\nWHAT IS YOUR NAME?");
        String name = sc.next();
        System.out.println("\n!!!!!!!!!!!!!a!!!  WELCOME  " + name + "  !!!!!!!!!!!!!!");
        System.out.println("\nLET'S CREATE OUR PHONEBOOK " + name + "  \n");

        while (true) {
            System.out.println("\n-------------- HOME PAGE --------------\n");
            System.out.println("|                                     |");
            System.out.println("|   1.CREATE NEW CONTACT              |");
            System.out.println("|   2.DISPLAY ALL CONTACTS            |");
            System.out.println("|   3.SEARCH A CONTACT INFORMATION    |");
            System.out.println("|   4.DELETE A CONTACT FROM LIST      |");
            System.out.println("|   5.UPDATE ANY CONTACT              |");
            System.out.println("|   6.CLOSE                           |");
            System.out.println("|                                     |");
            System.out.println("---------------------------------------\n");

            System.out.println("ENTER YOUR CHOICE:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    insert();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    System.out.println("\n**************         CLOSING PHONE BOOK           **************");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n**********ENTER A VALID CHOICE**********\n");
            }
        }
    }
}
