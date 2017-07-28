/*
 * MenuInterface.java 28/07/2017
 *
 * Created by Bondarenko Oleh
 */


package com.boast.menu;

import com.boast.buyer.*;

/**
 * Created by Bondarenko Oleh on 24.07.2017.
 */

interface MenuInterface {
    void showAll(Buyer[] buyers);
    void showSurnamesStartFrom(Buyer[] buyers, String start);
    void showCardsFromDiapason(Buyer[] buyers, long start, long end);
    void sortByAddress(Buyer[] buyers);
}