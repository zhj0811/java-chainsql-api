package com.dac.base.core.types.known.tx.txns;

import com.dac.base.core.serialized.enums.TransactionType;
import com.dac.base.core.types.known.tx.Transaction;

public class OfferCancel extends Transaction {
    public OfferCancel() {
        super(TransactionType.OfferCancel);
    }
}
