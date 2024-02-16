package com.gouriny.cardealershipws.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class VehicleIdentifier {

    private String vin;

    public VehicleIdentifier() {

    }

    public VehicleIdentifier(String vin) {
        this.vin = vin;
    }


}