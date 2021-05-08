package lk.sanchana_bag_shop.asset.invoice_ledger.dao;

import lk.sanchana_bag_shop.asset.invoice_ledger.entity.InvoiceLedger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InvoiceLedgerDao extends JpaRepository< InvoiceLedger, Integer > {
  List< InvoiceLedger > findByCreatedAtIsBetween(LocalDateTime from, LocalDateTime to);
}