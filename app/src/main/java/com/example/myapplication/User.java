package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String profileImageUrl;
    private List<String> favoriteProductIds;
    private List<Product> listings;

    // Add messages for chat
    private List<Message> messages;

    // Constructor
    public User(String userId, String name, String profileImageUrl) {
        this.userId = userId;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.favoriteProductIds = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.listings = new ArrayList<>();
    }

    // Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public List<Product> getListings() {
        return listings;
    }

    public void addListing(Product product) {
        listings.add(product);
    }
    public String getProfileImageUrl() { return profileImageUrl; }
    public List<String> getFavoriteProductIds() { return favoriteProductIds; }
    public List<Message> getMessages() { return messages; }

    // Favorite methods
    public void addFavorite(String productId) {
        if (!favoriteProductIds.contains(productId)) favoriteProductIds.add(productId);
    }
    public void removeFavorite(String productId) { favoriteProductIds.remove(productId); }
    public boolean isFavorite(String productId) { return favoriteProductIds.contains(productId); }

    // Chat methods
    public void addMessage(Message message) { messages.add(message); }
}
