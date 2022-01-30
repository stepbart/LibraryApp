package pl.kodilla.library.enums;

import lombok.Getter;

@Getter
public enum Status {

    FREE(0),
    RESERVED(1);

    Status(int statusNumber) {
        this.statusNumber = statusNumber;
    }

    private int statusNumber;
}
