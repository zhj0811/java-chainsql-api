package com.dac.base.core.coretypes;

import com.dac.base.core.fields.Field;
import com.dac.base.core.serialized.enums.LedgerEntryType;
import com.dac.base.core.serialized.enums.TransactionType;
import com.dac.base.core.types.known.sle.LedgerEntry;
import com.dac.base.core.types.known.sle.LedgerHashes;
import com.dac.base.core.types.known.sle.entries.AccountRoot;
import com.dac.base.core.types.known.sle.entries.DirectoryNode;
import com.dac.base.core.types.known.sle.entries.Offer;
import com.dac.base.core.types.known.sle.entries.OfferDirectory;
import com.dac.base.core.types.known.sle.entries.RippleState;
import com.dac.base.core.types.known.tx.Transaction;
import com.dac.base.core.types.known.tx.result.AffectedNode;
import com.dac.base.core.types.known.tx.result.TransactionMeta;
import com.dac.base.core.types.known.tx.txns.AccountSet;
import com.dac.base.core.types.known.tx.txns.OfferCancel;
import com.dac.base.core.types.known.tx.txns.OfferCreate;
import com.dac.base.core.types.known.tx.txns.Payment;
import com.dac.base.core.types.known.tx.txns.SQLStatement;
import com.dac.base.core.types.known.tx.txns.TableListSet;
import com.dac.base.core.types.known.tx.txns.TicketCancel;
import com.dac.base.core.types.known.tx.txns.TicketCreate;
import com.dac.base.core.types.known.tx.txns.TrustSet;

public class STObjectFormatter {
    public static STObject doFormatted(STObject source) {
        // This would need to go before the test that just checks
        // for ledgerEntryType
        if (AffectedNode.isAffectedNode(source)) {
            return new AffectedNode(source);
        }

        if (TransactionMeta.isTransactionMeta(source)) {
            TransactionMeta meta = new TransactionMeta();
            meta.fields = source.fields;
            return meta;
        }

        LedgerEntryType ledgerEntryType = STObject.ledgerEntryType(source);
        if (ledgerEntryType != null) {
            return ledgerFormatted(source, ledgerEntryType);
        }

        TransactionType transactionType = STObject.transactionType(source);
        if (transactionType != null) {
            return transactionFormatted(source, transactionType);
        }

        return source;
    }

    private static STObject transactionFormatted(STObject source, TransactionType transactionType) {
        STObject constructed = null;
        switch (transactionType) {
            case Invalid:
                break;
            case Payment:
                constructed = new Payment();
                break;
//            case SuspendedPaymentCreate:
//                break;
//            case SuspendedPaymentFinish:
//                break;
            case AccountSet:
                constructed = new AccountSet();
                break;
//            case SuspendedPaymentCancel:
//                break;
            case SetRegularKey:
                break;
            case NickNameSet:
                break;
            case OfferCreate:
                constructed = new OfferCreate();
                break;
            case OfferCancel:
                constructed = new OfferCancel();
                break;
            case unused:
                break;
            case TicketCreate:
                constructed = new TicketCreate();
                break;
            case TicketCancel:
                constructed = new TicketCancel();
                break;
            case SignerListSet:
                break;
            case TrustSet:
                constructed = new TrustSet();
                break;
            case EnableAmendment:
                break;
            case SetFee:
                break;
            case TableListSet:
                constructed = new TableListSet();
                break;
            case SQLStatement:
                constructed = new SQLStatement();
                break;
            default:
            	break;

        }
        if (constructed == null) {
            constructed = new Transaction(transactionType);
        }

        constructed.fields = source.fields;
        return constructed;

    }

    private static STObject ledgerFormatted(STObject source, LedgerEntryType ledgerEntryType) {
        STObject constructed = null;
        switch (ledgerEntryType) {
            case Offer:
                constructed = new Offer();
                break;
            case RippleState:
                constructed = new RippleState();
                break;
            case AccountRoot:
                constructed = new AccountRoot();
                break;
            case Invalid:
                break;
            case DirectoryNode:
                if (source.has(Field.Owner)) {
                    constructed = new DirectoryNode();
                } else {
                    constructed = new OfferDirectory();
                }

                break;
            case GeneratorMap:
                break;
            case Contract:
                break;
            case LedgerHashes:
                constructed = new LedgerHashes();
                break;
            case Amendments:
                break;
            case FeeSettings:
                break;
			default:
				break;
        }
        if (constructed == null) {
            constructed = new LedgerEntry(ledgerEntryType);
        }
        constructed.fields = source.fields;
        return constructed;
    }
}
