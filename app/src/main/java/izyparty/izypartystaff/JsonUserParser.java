package izyparty.izypartystaff;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import izyparty.izypartystaff.model.Users;


public class JsonUserParser {
    public static Users getUsersData(String data) throws JSONException {
        Users users = new Users();
        JSONObject jobj = new JSONObject(data);
        JSONArray arrayuser = jobj.getJSONArray("users");
        JSONObject JSONusers = arrayuser.getJSONObject(0);
        Users.setIdUsers(getString("id", JSONusers));
        Users.setPasswordUsers(getString("passwords", JSONusers));
        return users;
    }
    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

}
