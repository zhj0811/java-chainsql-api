package com.dac.base.client.subscriptions;
import com.dac.base.core.types.known.tx.result.TransactionResult;

public interface TransactionSubscriptionManager {
    public void notifyTransactionResult(TransactionResult tr);
}
