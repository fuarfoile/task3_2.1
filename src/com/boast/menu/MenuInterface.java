/*
 * MenuInterface.java 28/07/2017
 *
 * Created by Bondarenko Oleh
 */


package com.boast.menu;

import com.boast.buyer.*;

interface MenuInterface {
    void showAll(Buyer[] buyers);
    void showSurnamesStartFrom(Buyer[] buyers, String start);
    void showCardsFromDiapason(Buyer[] buyers, long start, long end);
}