package izyparty.izypartystaff;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONException;

import izyparty.izypartystaff.model.Users;

import static android.widget.Toast.*;

public class login_page extends AppCompatActivity {

    EditText passworduser;
    EditText emailuser;
    String iduser,passwordvalue,idvalue;
    private ImageButton Loginpageconf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        passworduser = (EditText) findViewById(R.id.password);
        emailuser = (EditText) findViewById(R.id.email);
        Loginpageconf = (ImageButton) findViewById(R.id.loginbutton);
        Intent mainpage = new Intent(this,edit_content.class);
    }


    public void login(View view) {

        try {

            idvalue = emailuser.getText().toString();
            iduser = idvalue;
            JSONTask task = new JSONTask();
            task.execute(iduser);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private class JSONTask extends AsyncTask<String,Void,Users> {

        @Override
        protected Users doInBackground(String... params){
            Users users = new Users();
            String data = new HttpIzypartyClient().getUserData(params[0]);
            try{
                users = JsonUserParser.getUsersData(data);
            } catch (JSONException e){
                e.printStackTrace();
            }
            return users;
        }
        @Override
        protected void onPostExecute(Users users){
            super.onPostExecute(users);
            Context context = login_page.this;
            try {
                if (passwordvalue != Users.getPasswordUsers())
                {
                    new AlertDialog.Builder(context).setMessage("Your email or your password is wrong. Please input it again with the right ID.").setPositiveButton(R.string.confirmation, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            }
                    }).show();
                }
                else
                {
                    Toast.makeText(context, "welcome " + Users.getIdUsers(), LENGTH_LONG).show();
                    startActivity(new Intent(login_page.this,edit_content.class));
                    }
            } catch (NullPointerException ex) {
            ex.printStackTrace();
            }


        }
    }



//        Intent mainpage = new Intent(this,edit_content.class);
//        String emailID = emailuser.getText().toString();
//        String passwordID = passworduser.getText().toString();
//        String emailIDcheck = "";
//        String passwordIDcheck = "";
//        if(!emailID.equals(emailIDcheck) && !passwordID.equals(passwordIDcheck))
//        {

//        }
//        else {
//            Context Mynewcontext = login_page.this;
//
//        }
//    }



}
