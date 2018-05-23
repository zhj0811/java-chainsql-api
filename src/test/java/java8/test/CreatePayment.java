package java8.test;


import static java8.test.Print.*;

import com.dac.base.client.Account;
import com.dac.base.client.Client;
import com.dac.base.client.responses.Response;
import com.dac.base.client.transactions.ManagedTxn;
import com.dac.base.client.transactions.TransactionManager;
import com.dac.base.client.transport.impl.JavaWebSocketTransportImpl;
import com.dac.base.core.coretypes.AccountID;
import com.dac.base.core.coretypes.Amount;
import com.dac.base.core.coretypes.uint.UInt32;
import com.dac.base.core.types.known.tx.result.TransactionResult;
import com.dac.base.core.types.known.tx.txns.Payment;

public class CreatePayment {

	    public static void main(String[] args) {
	        // We need a valid seed

//	           new Client(new JavaWebSocketTransportImpl())
//	                    .connect("ws://192.168.0.89:6007", (c) ->
//	                        new CreatePayment(c, "xnoPBzXtMeMyMHUVTgbuqAfg1SUTb"));
	           
	           new Client(new JavaWebSocketTransportImpl())
               .connect("ws://192.168.0.89:6007", (c) ->
                   new CreatePayment().CreatePaymentIDAC(c, "xhW53JaGnb6QePRHz1ysehGNodu4p"));
	    }
	    
	    public CreatePayment() {
	    	
	    }

	    public CreatePayment (Client client, String secret) {
	        Account account = client.accountFromSeed(secret);
	        TransactionManager tm = account.transactionManager();

	        Payment payment = new Payment();
	        payment.as(AccountID.Account,     "zHb9CJAWyB4zj91VRWn96DkukG4bwdtyTh")
	             	.as(AccountID.Destination, "zfrsNqJBE6kBUUYngMZYLZJR28hHvJ8aES")
	             	.as(Amount.Fee,            "100")
	             	.as(UInt32.Sequence,        4)
	             	.as(Amount.Amount, "100000000");

	        tm.queue(tm.manage(payment)
	            .onValidated(this::onValidated)
//	            .onTimeout(this::onTimeout)
	                .onError(this::onError));
	    }
	    
	    public void CreatePaymentIDAC (Client client, String secret) {
	        Account account = client.accountFromSeed(secret);
	        TransactionManager tm = account.transactionManager();

	        Payment payment = new Payment();
	        Amount amount = Amount.fromString("5/GRDX/znbWk4iuz2HL1e1Ux91TzYfFzJHGeYxBA4");
	        
	        payment.as(AccountID.Account,     "zMbBhnQAPu7KHgtRXWFxp4YGX4LjtMpgo1")
	             	.as(AccountID.Destination, "zHYfrrZyyfAMrNgm3akQot6CuSmMM6MLda")
	             	.as(Amount.Fee,            "100")
	             	.as(UInt32.Sequence,        3)
	             	.as(Amount.Amount, amount);

	        tm.queue(tm.manage(payment)
	            .onValidated(this::onValidated)
//	            .onTimeout(this::onTimeout)
	                .onError(this::onError));
	    }


		private void onValidated(ManagedTxn managed) {
	        TransactionResult tr = managed.result;
	        print("Result:\n{0}", tr.toJSON().toString(2));
	        print("Transaction result was: {0}", tr.engineResult);
//	        System.exit(0);
	    }
		
		private void onTimeout(Response response) {
	        print("timeout!");
//	        System.exit(0);
	    }

	    private void onError(Response res) {
	    	System.out.println(res.message);
	        printErr("Transaction failed!");
//	        managed.submissions.forEach(sub ->
//	                printErr("{0}", sub.hash) );
//	        System.exit(1);
	    }


}
