package com.kimdohee.assignment.bookstore;

import java.util.List;

public interface GeneralCart {
    void addToCart(Book book);

    void removeFromCart(String id);

    void clearCart();

    List<String> getCartItems();

    double getTotalPrice();
}
