package com.gouriny.cardealershipws.inventorymanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Inventory findByInventoryIdentifier_InventoryId(String inventoryId);

    Boolean existsByInventoryIdentifier_InventoryId(String inventoryId);
}
