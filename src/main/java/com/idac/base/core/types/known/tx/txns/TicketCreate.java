package com.idac.base.core.types.known.tx.txns;

import com.idac.base.core.serialized.enums.TransactionType;
import com.idac.base.core.types.known.tx.Transaction;

public class TicketCreate extends Transaction {
    public TicketCreate() {
        super(TransactionType.TicketCreate);
    }
}
