package com.dac.base.core.types.known.tx.txns;

import com.dac.base.core.serialized.enums.TransactionType;
import com.dac.base.core.types.known.tx.Transaction;

public class TicketCreate extends Transaction {
    public TicketCreate() {
        super(TransactionType.TicketCreate);
    }
}
