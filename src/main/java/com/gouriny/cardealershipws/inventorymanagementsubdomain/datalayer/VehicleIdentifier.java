package com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;

@Embeddable
public class VehicleIdentifier {

    private String vin;

    public VehicleIdentifier() {

    }

    public VehicleIdentifier(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }
}