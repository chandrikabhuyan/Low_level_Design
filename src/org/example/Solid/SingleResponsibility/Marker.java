package org.example.Solid.SingleResponsibility;

public class Marker {
    private String name;
    private String color;
    int price;
    public Marker(String name,String color,int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }
}

public class Invoice{
    private Marker marker;
    private int quantity;
    public Invoice(Marker marker,int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
    public int calculateTotal() {
        int total = marker.price * quantity;
        return total;
    }
    public void printInvoice(){
        //implement
    }

    public void saveToDB(){
        //implement
    }
}

// The `Invoice' class is about invoices, but we have added print and storage functionality inside it.
// This breaks the SRP rule, which states, "A class should have only one reason to change."
// If we want to change the calculation, logic of the printing or storage functionality in the future, we would need to change the class.


class InvoiceCal{
    private Marker marker;
    private int quantity;
    public InvoiceCal(Marker marker,int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
    public int calculateTotal() {
        int total = marker.price * quantity;
        return total;
    }
}

class InvoiceDao{
    private InvoiceCal invoiceCal;
    public InvoiceDao(InvoiceCal invoiceCal) {
        this.invoiceCal = invoiceCal;
    }

    public void saveToDB() {
        //save to DB
    }
}

class InvoicePrint{
    private InvoiceCal invoiceCal;
    public InvoicePrint(InvoiceCal invoiceCal){
        this.invoiceCal = invoiceCal;
    }
    public void printInvoice(){
        //print
    }
}

