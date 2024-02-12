package com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Embeddable
public class Price {

    private Double msrp;
    private Double cost;
    private Double totalOptionsCost; //note this invariant will need to be handled at some point.

    public Price() {

    }

    public Price(@NotNull Double msrp, @NotNull Double cost, @NotNull Double totalOptionsCost) {
        Objects.requireNonNull(this.msrp = msrp);
        Objects.requireNonNull(this.cost = cost);
        Objects.requireNonNull(this.totalOptionsCost = totalOptionsCost);
    }

    public @NotNull Double getMsrp() {
        return msrp;
    }

    public @NotNull Double getCost() {
        return cost;
    }

    public @NotNull Double getTotalOptionsCost() {
        return totalOptionsCost;
    }
}
