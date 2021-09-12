package com.blorfer.main.ItemCheckout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCheckoutRepository extends JpaRepository<ItemCheckout, Long> {
}
