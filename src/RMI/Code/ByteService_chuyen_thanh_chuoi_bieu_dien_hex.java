package RMI.Code;

import RMI.ByteService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ByteService_chuyen_thanh_chuoi_bieu_dien_hex {

    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("127.0.0.1", 1099);

        ByteService service = (ByteService) rg.lookup("RMIByteService");

        byte[] data = service.requestData("B23DCCN952", "local-rmi-byte-hex");

        StringBuilder ans = new StringBuilder();

        for(byte b : data){
            ans.append(String.format("%02x", b & 0xFF));
        }

        service.submitData("B23DCCN952", "local-rmi-byte-hex", ans.toString().getBytes());
    }
}
