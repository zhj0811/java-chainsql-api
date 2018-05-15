package com.idac.base.client.subscriptions;
import com.idac.base.core.types.known.tx.result.TransactionResult;

public interface TransactionSubscriptionManager {
    public void notifyTransactionResult(TransactionResult tr);
}
