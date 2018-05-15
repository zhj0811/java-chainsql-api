package com.idac.base.core.types.shamap;
import com.idac.base.core.types.known.tx.result.TransactionResult;

public interface TransactionResultVisitor {
    public void onTransaction(TransactionResult tx);
}
