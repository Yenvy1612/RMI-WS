package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ByteService extends Remote {
    public byte[] requestData(String stuCode,String qCode) throws RemoteException;
    public void submitData(String stuCode, String qCode, byte[] data) throws RemoteException;
}
