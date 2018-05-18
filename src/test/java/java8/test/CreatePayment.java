package java8.test;


import static java8.test.Print.print;
import static java8.test.Print.printErr;

import com.peersafe.base.client.Account;
import com.peersafe.base.client.Client;
import com.peersafe.base.client.requests.Request;
import com.peersafe.base.client.responses.Response;
import com.peersafe.base.client.transactions.ManagedTxn;
import com.peersafe.base.client.transactions.TransactionManager;
import com.peersafe.base.client.transport.impl.JavaWebSocketTransportImpl;
import com.peersafe.base.core.coretypes.AccountID;
import com.peersafe.base.core.coretypes.Amount;
import com.peersafe.base.core.coretypes.uint.UInt32;
import com.peersafe.base.core.types.known.tx.result.TransactionResult;
import com.peersafe.base.core.types.known.tx.txns.Payment;

public class CreatePayment {

	    public static void main(String[] args) {
	        // We need a valid seed

	           new Client(new JavaWebSocketTransportImpl())
	                    .connect("ws://192.168.0.89:6007", (c) ->
	                        new CreatePayment(c, "xxprJNCURq7J9BVpeox38CGq2nwLM"));
	 
	    }

	    public CreatePayment (Client client, String secret) {
	        Account account = client.accountFromSeed(secret);
	        TransactionManager tm = account.transactionManager();

	        Request.setTimeOut(10000);
	        Payment payment = new Payment();

	        payment.as(AccountID.Account,     "zHyz3V6V3DZ2fYdb6AUc5WV4VKZP1pAEs9")
	             	.as(AccountID.Destination, "zfrsNqJBE6kBUUYngMZYLZJR28hHvJ8aES")
	             	.as(Amount.Fee,            "100")
	             	.as(UInt32.Sequence,        1579)
	             	.as(Amount.Amount, "100000000");

	        tm.queue(tm.manage(payment)
	            .onValidated(this::onValidated)
	            .onTimeOut(new ManagedTxn.OnTimeOut() {
					
					@Override
					public void called(Request args) {
						
						print("timeout!");
						print(args);
					}
				})
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
