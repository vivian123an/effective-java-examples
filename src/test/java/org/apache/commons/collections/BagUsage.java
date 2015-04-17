package org.apache.commons.collections;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BagUsage {
	public static void main(String[] args) {
        demoBagUsage();
    }
 
    public static void demoBagUsage() {
 
        System.out.println(StringUtils.center(" demoBagUsage ", 40, "="));
 
        // data setup
        Book book1 = new Book("RefactoringWorkbook", "7-5083-2208-8",29.8);
        Book book2 = new Book("J2EEDesign Patterns", "7-5083-3099-4",45);
        Book book3 = new Book("AgileSoftware Development", "7-5083-1503-0",59);
 
        // create a bag
        Bag myBag = BagUtils.typedBag(new HashBag(), Book.class);
        myBag.add(book1, 360);
        myBag.add(book2, 500);
        myBag.add(book3, 170);
 
        // calculations for a bag
        double price1 = book1.getRetailPrice();
        double price2 = book2.getRetailPrice();
        double price3 = book3.getRetailPrice();
        int book1Count = myBag.getCount(book1);
        int book2Count = myBag.getCount(book2);
        int book3Count = myBag.getCount(book3);
        double totalValue = (price1 * book1Count) +(price2 * book2Count)+ (price3 * book3Count);
 
        // dispaly results
        System.out.println("There are " + book1Count + " copies of "+ book1.getName() + ".");
        System.out.println("There are " + book2Count + " copies of "+ book2.getName() + ".");
        System.out.println("There are " + book3Count + " copies of "+ book3.getName() + ".");
        System.out.println("The total value of these books is: " +totalValue);
 
        System.out.println();
 
    }
}

class Book {
	   
    private String name;
    private String isbn;
    private double retailPrice;
   
    public Book() {
    }
   
    public Book(String name, String isbn, double retailPrice) {
        this.name = name;
        this.isbn = isbn;
        this.retailPrice = retailPrice;
    }
   
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.DEFAULT_STYLE)
        .append("name",name)
        .append("ISBN",isbn)
        .append("retailPrice",retailPrice)
        .toString();
    }
 
    public String getIsbn() {
        return isbn;
    }
 
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getRetailPrice() {
        return retailPrice;
    }
 
    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
   
}