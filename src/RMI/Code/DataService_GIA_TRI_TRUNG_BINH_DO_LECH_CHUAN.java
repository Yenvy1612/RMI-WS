package RMI.Code;

import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Locale;

public class DataService_GIA_TRI_TRUNG_BINH_DO_LECH_CHUAN {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);

        DataService sv = (DataService) rg.lookup("RMIDataService");

        String data = (String) sv.requestData("B23DCCN952", "Rb4BHYlM");

        String[] ar = data.split(",");
        int n = ar.length;

        double[] a = new double[n];
        double sum = 0;

        for(int i = 0; i<n; ++i){
            a[i] = Double.parseDouble(ar[i]);
            sum += a[i];
        }

        double avg = sum / n, varriance = 0;
        for(int i = 0; i < n; ++i){
            varriance += Math.pow(a[i] - avg, 2);
        }

        double stddev = Math.sqrt(varriance/n);

        Arrays.sort(a);
        double p95 = a[(int) Math.ceil(n * 0.95) - 1];

        String result = String.format(Locale.US, "average=%.2f;stddev=%.2f;p95=%.2f", avg, stddev, p95);

        sv.submitData("B23DCCN952", "Rb4BHYlM", result);
    }
}
