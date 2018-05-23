package com.dac.base.core.types.shamap;
import com.dac.base.core.types.known.tx.result.TransactionResult;

public interface TransactionResultVisitor {
    public void onTransaction(TransactionResult tx);
}
