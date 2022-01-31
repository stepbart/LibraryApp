package pl.kodilla.library.enums;

import lombok.Getter;

@Getter
public enum Status {

    FREE(0),
    BORROWED(1);

    Status(int statusNumber) {
        this.statusNumber = statusNumber;
    }

    public static Status getStatus(int value){
        if (value==0){
            return FREE;
        }
        else {
            return BORROWED;
        }
    }

    private int statusNumber;
}
