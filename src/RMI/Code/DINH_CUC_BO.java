package RMI.Code;

import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class DINH_CUC_BO {
    public static void main(String[] args) throws Exception{

        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);

        DataService sv = (DataService) rg.lookup("RMIDataService");

        int[] data = (int[]) sv.requestData("B23DCCN952", "FluSeAkh");

        List<Integer> res = new ArrayList<>();
        int l = data.length;
        for(int i = 0; i< data.length; ++i){
            if(i == 0 && i < l-1){
                if(data[i] > data[i+1]){
                    res.add(i+1);
                }
            } else if (i == l-1 && i > 0) {
                if(data[i] > data[i-1]){
                    res.add(i+1);
                }
            }
            else{
                if(data[i] > data[i+1] && data[i] > data[i-1]){
                    res.add(i+1);
                }
            }
        }

        sv.submitData("B23DCCN952", "FluSeAkh", res);
    }
}
