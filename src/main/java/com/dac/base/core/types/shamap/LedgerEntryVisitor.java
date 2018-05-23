package com.dac.base.core.types.shamap;

import com.dac.base.core.types.known.sle.LedgerEntry;

public interface LedgerEntryVisitor {
    public void onEntry(LedgerEntry entry);
}
