package RMI.Code;

import RMI.CharacterService;

import java.net.URI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CharacterService_MA_HOA_URI {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);

        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");

        String data = sv.requestCharacter("B23DCCN952", "slqIx1Ca");

        System.out.println(data);

        String res = new URI(null, null, data, null).toASCIIString();

        System.out.println(res);

        sv.submitCharacter("B23DCCN952", "slqIx1Ca", res);


    }
}
