package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CharacterService extends Remote {
    public String requestCharacter(String stuCode,String qCode) throws RemoteException;
    public void submitCharacter(String stuCode, String qCode, String result) throws RemoteException;
}
