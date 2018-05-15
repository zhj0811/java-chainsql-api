package com.idac.base.core.types.known.tx.txns;

import com.idac.base.core.coretypes.AccountID;
import com.idac.base.core.coretypes.Amount;
import com.idac.base.core.coretypes.Blob;
import com.idac.base.core.coretypes.PathSet;
import com.idac.base.core.coretypes.STArray;
import com.idac.base.core.coretypes.hash.Hash256;
import com.idac.base.core.coretypes.uint.UInt16;
import com.idac.base.core.coretypes.uint.UInt32;
import com.idac.base.core.fields.Field;
import com.idac.base.core.formats.Format.Requirement;
import com.idac.base.core.serialized.enums.TransactionType;
import com.idac.base.core.types.known.tx.Transaction;

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
