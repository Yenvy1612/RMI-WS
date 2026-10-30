package RMI.Code;

import RMI.CharacterService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CHUYEN_LATIN_VE_LA_MA {
    public static void main(String[] args) throws Exception{

        Registry rg = LocateRegistry.getRegistry("36.50.135.242",1099);

        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");

        String data = sv.requestCharacter("B23DCCN952", "pMWbXlFc");

        int n = Integer.parseInt(data);

        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] roman = {
            "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV",
                "I"
        };

        StringBuilder res = new StringBuilder();

        for(int i = 0; i<values.length; ++i){
            while(n >= values[i]){
                res.append(roman[i]);
                n -= values[i];
            }
        }

        System.out.println(res.toString());

        sv.submitCharacter("B23DCCN952", "pMWbXlFc", res.toString());
    }
}
