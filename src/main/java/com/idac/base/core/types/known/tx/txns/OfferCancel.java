package com.idac.base.core.types.known.tx.txns;

import com.idac.base.core.serialized.enums.TransactionType;
import com.idac.base.core.types.known.tx.Transaction;

public class OfferCancel extends Transaction {
    public OfferCancel() {
        super(TransactionType.OfferCancel);
    }
}
