package RMI.Code;

import RMI.ObjectService;
import RMI.TicketSla;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ObjectService_TicketSLA_THIET_LAP_NGUONG {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");

        TicketSla tk = (TicketSla) sv.requestObject("B23DCCN952", "uLjCFWX3");

        if(tk.getPriority().equals("CRITICAL") && tk.getOpenedHoursAgo() > 2){
            tk.setBreached(true);
        } else if (tk.getPriority().equals("HIGH") && tk.getOpenedHoursAgo() > 8) {
            tk.setBreached(true);
        } else if (tk.getPriority().equals("MEDIUM") && tk.getOpenedHoursAgo() > 24) {
            tk.setBreached(true);
        } else if (tk.getPriority().equals("LOW") && tk.getOpenedHoursAgo() > 72) {
            tk.setBreached(true);
        }
        else {
            tk.setBreached(false);
            tk.setAction("MONITOR");
        }

        if(tk.isBreached() == true){
            if(tk.getPriority().equals("CRITICAL") && tk.getOpenedHoursAgo() > 96){
                tk.setAction("ESCALATE_L2");
            }
            else {
                tk.setAction("ESCALATE_L1");
            }
        }

        sv.submitObject("B23DCCN952", "uLjCFWX3", tk);
    }
}
