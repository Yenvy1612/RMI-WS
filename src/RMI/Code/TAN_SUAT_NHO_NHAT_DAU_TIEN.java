package RMI.Code;

import RMI.ByteService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class TAN_SUAT_NHO_NHAT_DAU_TIEN {
    public static void main(String[] args) throws Exception{

        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] data = sv.requestData("B23DCCN952", "3JgtjxAN");

        System.out.println(Arrays.toString(data));

        int[] count = new int[256];

        for(byte b : data){
            count[b & 0xFF] ++;
        }

        byte selected = data[0];
        int minC = Integer.MAX_VALUE;

        for(byte b : data){
            int freq = count[b& 0xFF];

            if(minC > freq){
                minC = freq;
                selected = b;
            }
        }

        byte[] res = {selected, (byte) minC};

        System.out.println("Result: " + Arrays.toString(res));

        sv.submitData("B23DCCN952", "3JgtjxAN", res);

    }
}
