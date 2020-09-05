package sanchana.bagShop.asset.purchaseOrder.entity;


import com.fasterxml.jackson.annotation.JsonFilter;

import sanchana.bagShop.asset.payment.entity.Payment;
import sanchana.bagShop.asset.purchaseOrder.entity.Enum.PurchaseOrderPriority;
import sanchana.bagShop.asset.purchaseOrder.entity.Enum.PurchaseOrderStatus;
import sanchana.bagShop.asset.purchaseOrderItem.entity.PurchaseOrderItem;
import sanchana.bagShop.asset.supplier.entity.Supplier;
import sanchana.bagShop.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("PurchaseOrder")
public class PurchaseOrder extends AuditEntity {

    private String remark;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private PurchaseOrderPriority purchaseOrderPriority;

    @Enumerated(EnumType.STRING)
    private PurchaseOrderStatus purchaseOrderStatus;

    @ManyToOne
    private Supplier supplier;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.PERSIST)
    private List< PurchaseOrderItem > purchaseOrderItems;

    @OneToMany(mappedBy = "purchaseOrder")
    private List< Payment > payments;

    @Transient
    private BigDecimal paidAmount;

    @Transient
    private BigDecimal needToPaid;

    @Transient
    private LocalDateTime grnAt;
}
