/*
 * ConsoleMenu.java 28/07/2017
 *
 * Created by Bondarenko Oleh
 */


package com.boast.menu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import com.boast.buyer.*;

public class ConsoleMenu implements MenuInterface {

    public ConsoleMenu() {
        help();
    }

    public boolean processCommand(Buyer[] buyers, String command) {

        if(command.equals("help")) {
            help();
            return true;
        }

        if(command.equals("showAll")) {
            showAll(buyers);
            return true;
        }

        if(command.equals("showSurnamesStartFrom")) {
            Scanner in = new Scanner(System.in);
            System.out.print("Start from: ");
            showSurnamesStartFrom(buyers, in.nextLine());
            return true;
        }

        if(command.equals("showCardsFromDiapason")) {
            Scanner in = new Scanner(System.in);
            System.out.print("From: ");
            long start = in.nextLong();
            System.out.print("To: ");
            long end = in.nextLong();
            showCardsFromDiapason(buyers, start, end);
            return true;
        }

        if(command.equals("sortAllByAddress")) {
            sortByAddress(buyers);
            System.out.println("Sorting complete");
            return true;
        }

        if(command.equals("sortAllByName")) {
            sortByFirstName(buyers);
            System.out.println("Sorting complete");
            return true;
        }

        if(command.equals("exit")) {
            return false;
        }

        System.out.println("Unidentified command");
        return true;
    }

    private void help() {
        System.out.println("Menu Commands:");
        System.out.println("showAll");
        System.out.println("showSurnamesStartFrom");
        System.out.println("showCardsFromDiapason");
        System.out.println("sortAllByAddress");
        System.out.println("sortAllByName");
        System.out.println("exit");
    }

    public void showAll(Buyer[] buyers) {
        for (Buyer buyer : buyers) {
            System.out.println(buyer);
        }
    }

    public void showSurnamesStartFrom(Buyer[] buyers, String start) {
        boolean nonFlag = true;
        for (Buyer buyer : buyers) {
            if(buyer.getSecondName().startsWith(start)) {
                System.out.println(buyer);
                nonFlag = false;
            }
        }
        if(nonFlag) {
            System.out.println("No matches");
        }
    }

    public void showCardsFromDiapason(Buyer[] buyers, long start, long end) {
        boolean nonFlag = true;
        for (Buyer buyer : buyers) {
            if(buyer.getCreditCardNumber() >= start && buyer.getCreditCardNumber() <= end) {
                System.out.println(buyer);
                nonFlag = false;
            }
        }
        if(nonFlag) {
            System.out.println("No matches");
        }
    }

    public void sortByAddress(Buyer[] buyers){
        Arrays.sort(buyers, new Comparator<Buyer>() {
            @Override
            public int compare(Buyer o1, Buyer o2) {
                String address1 = o1.getAddress();
                String address2 = o2.getAddress();
                return address1.compareTo(address2);
            }
        });
    }

    public void sortByFirstName(Buyer[] buyers){
        Arrays.sort(buyers, new Comparator<Buyer>() {
            @Override
            public int compare(Buyer o1, Buyer o2) {
                String name1 = o1.getFirstName();
                String name2 = o2.getFirstName();
                return name1.compareTo(name2);
            }
        });
    }
}