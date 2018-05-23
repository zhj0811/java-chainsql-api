package com.dac.base.core.types.known.tx.txns;

import com.dac.base.core.coretypes.AccountID;
import com.dac.base.core.coretypes.Amount;
import com.dac.base.core.coretypes.Blob;
import com.dac.base.core.coretypes.PathSet;
import com.dac.base.core.coretypes.STArray;
import com.dac.base.core.coretypes.hash.Hash256;
import com.dac.base.core.coretypes.uint.UInt16;
import com.dac.base.core.coretypes.uint.UInt32;
import com.dac.base.core.fields.Field;
import com.dac.base.core.formats.Format.Requirement;
import com.dac.base.core.serialized.enums.TransactionType;
import com.dac.base.core.types.known.tx.Transaction;

public class SQLStatement  extends Transaction {

	public SQLStatement() {
		 super(TransactionType.SQLStatement);
	}
	public AccountID owner() {return get(AccountID.Owner);}
    public STArray tables() {return get(STArray.Tables);}
    public Blob raw() {return get(Blob.Raw);}
    public UInt16 opType() {return get(UInt16.OpType);}
    public void owner(Blob val) {put(Field.Owner, val);}
    public void tables(AccountID val) {put(Field.Tables, val);}
    public void raw(Blob val) {put(Field.Raw, val);}
    public void opType(UInt16 val) {put(Field.OpType, val);}

}
