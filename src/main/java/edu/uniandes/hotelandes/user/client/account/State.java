package edu.uniandes.hotelandes.user.client.account;

public enum State {
    OPEN("OPEN"),
    CLOSED("CLOSED");

    String value;
    
    State(String v){
        this.value = v;
    }
}
