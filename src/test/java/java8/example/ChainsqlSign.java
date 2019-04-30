package java8.example;

import org.json.JSONObject;
import com.peersafe.chainsql.core.Chainsql;

public class ChainsqlSign {
    public static void main (String[] args){
        Chainsql c = new Chainsql();
        JSONObject tx_json=new JSONObject();
        tx_json.put("Account", "zHb9CJAWyB4zj91VRWn96DkukG4bwdtyTh");
        tx_json.put("Amount","100000000000");
        tx_json.put("Destination", "zcNSghmUVfMPfAC2SMiuhzPrByHVSAqCns");
        tx_json.put("TransactionType","Payment");
        tx_json.put("Fee","10");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tx_json",tx_json);
        JSONObject signRes = c.sign(jsonObject,"xnoPBzXtMeMyMHUVTgbuqAfg1SUTb");
        System.out.println(signRes);
    }
}