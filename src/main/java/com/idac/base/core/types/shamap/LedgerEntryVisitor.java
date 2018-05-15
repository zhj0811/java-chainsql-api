package com.idac.base.core.types.shamap;

import com.idac.base.core.types.known.sle.LedgerEntry;

public interface LedgerEntryVisitor {
    public void onEntry(LedgerEntry entry);
}
