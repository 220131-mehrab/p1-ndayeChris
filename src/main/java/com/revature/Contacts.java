package com.revature;

public class Contacts {
    private int contact_id;
    private String name;
    private String email;
    private String phone_number;
    
    public Contacts() {
    }

    public Contacts(int contact_id, String name, String email, String phone_number) {
        this.contact_id = contact_id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Contacts [contact_id=" + contact_id + ", email=" + email + ", name=" + name + ", phone_number="
                + phone_number + "]";
    }
    
}
