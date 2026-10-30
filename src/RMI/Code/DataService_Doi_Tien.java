package RMI.Code;

import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DataService_Doi_Tien {
    public static void main(String[] args) throws Exception{
        String studentCode = "B23DCCN952", qCode = "local-rmi-data-coins";

        Registry rg = LocateRegistry.getRegistry("127.0.0.1", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");

        int tien = (int) sv.requestData(studentCode, qCode);

        int count = 0;
        StringBuilder res = new StringBuilder();
        while(tien > 0){
            while(tien >= 10){
                tien -= 10;
                count++;
                if(tien > 0) res.append(10 + ",");
                else res.append("10");
            }
            while(tien >= 5){
                tien -= 5;
                count++;
                if(tien > 0) res.append(5 + ",");
                else res.append("5");
            }
            while(tien >= 2){
                tien -= 2;
                count++;
                if(tien > 0) res.append(2 + ",");
                else res.append("2");
            }
            while(tien >= 1){
                tien -= 1;
                count++;
                if(tien > 0) res.append(1 + ",");
                else res.append("1");
            }
        }
        String ans = count + "; " + res.toString();
        sv.submitData(studentCode, qCode, ans);
    }
}
