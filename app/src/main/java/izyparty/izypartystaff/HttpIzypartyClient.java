package izyparty.izypartystaff;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by grego on 12/19/2015.
 */
public class HttpIzypartyClient {
    public static String MAIN_URL = "http://202.78.200.117/izyapi/index.php?id=";


    public String getUserData (String idusers) {
        HttpURLConnection con = null;
        InputStream is = null;

        try {
            con = (HttpURLConnection) (new URL(MAIN_URL + idusers)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine())!=null)
                buffer.append(line+"\r\n");
            is.close();
            con.disconnect();
            return buffer.toString();
        }
        catch (Throwable t){
            t.printStackTrace();
        }
        finally {
            try{
                if (is !=null)
                    is.close();
            } catch (Throwable t) {t.printStackTrace();}
            try {
                if (con !=null)
                    con.disconnect();
            } catch (Throwable t) {t.printStackTrace();}
        }
        return null;
    }
}
