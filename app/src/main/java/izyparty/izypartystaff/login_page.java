package izyparty.izypartystaff;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login_page extends AppCompatActivity {

    EditText passworduser;
    EditText emailuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        passworduser = (EditText) findViewById(R.id.password);
        emailuser = (EditText) findViewById(R.id.email);

    }


    public void login(View view){

        Intent mainpage = new Intent(this,edit_content.class);
        String emailID = emailuser.getText().toString();
        String passwordID = passworduser.getText().toString();
        String emailIDcheck = "";
        String passwordIDcheck = "";
        if(!emailID.equals(emailIDcheck) && !passwordID.equals(passwordIDcheck))
        {
            Toast.makeText(this, "welcome " + emailID, Toast.LENGTH_LONG).show();
            startActivity(mainpage);
        }
        else {
            Context Mynewcontext = login_page.this;
            new AlertDialog.Builder(Mynewcontext).setMessage("Your email or your password is wrong. Please input it again with the right ID.").setPositiveButton(R.string.confirmation, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    }
            }).show();
        }
    }



}
