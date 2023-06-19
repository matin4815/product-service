package com.matin.productservice.enums;

public enum VoteState {
    UNACCEPTED("UNACCEPTED"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED");

    private final String state;

    VoteState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
