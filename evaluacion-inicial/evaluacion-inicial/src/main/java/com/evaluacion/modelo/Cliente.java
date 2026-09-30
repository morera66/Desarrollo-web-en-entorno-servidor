package com.evaluacion.modelo;

public class Cliente {

    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String city;
    private String country;

    public Cliente(int customerNumber, String customerName, String contactLastName,
                    String contactFirstName, String phone, String city, String country) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.city = city;
        this.country = country;
    }

    public int getCustomerNumber() { return customerNumber; }
    public String getCustomerName() { return customerName; }
    public String getContactLastName() { return contactLastName; }
    public String getContactFirstName() { return contactFirstName; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return customerNumber + " | " + customerName + " | " +
               contactFirstName + " " + contactLastName + " | " +
               phone + " | " + city + ", " + country;
    }
}