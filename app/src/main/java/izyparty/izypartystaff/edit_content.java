package izyparty.izypartystaff;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;

public class edit_content extends AppCompatActivity {

    TextView nilaikecil, nilaisedang, nilaibesar;
    ImageButton minusSmall,plusSmall, minusMedium, plusMedium, minusLarge, plusLarge;
    int smallvalue, mediumvalue,largevalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_content);

        initObject();
    }

    public void initObject() {
        nilaikecil = (TextView) findViewById(R.id.nilaismall);
        nilaisedang = (TextView) findViewById(R.id.nilaimedium);
        nilaibesar = (TextView) findViewById(R.id.nilailarge);
        minusSmall = (ImageButton) findViewById(R.id.mminusbuttonsmall);
        plusSmall = (ImageButton) findViewById(R.id.plusbuttonsmall);
        minusMedium = (ImageButton) findViewById(R.id.minusmediumbutton);
        plusMedium = (ImageButton) findViewById(R.id.plusmediumbutton);
        minusLarge = (ImageButton) findViewById(R.id.minusbuttonlarge);
        plusLarge = (ImageButton) findViewById(R.id.plusbuttonlarge);

        smallvalue = 0;
        mediumvalue = 0;
        largevalue = 0;

        nilaikecil.setText(String.valueOf(smallvalue));
        nilaisedang.setText(String.valueOf(mediumvalue));
        nilaibesar.setText(String.valueOf(largevalue));
    }


    public void minussmall(View v)
    {
        smallvalue = smallvalue - 1;
        if (smallvalue<0)
            smallvalue = 0;
        nilaikecil.setText(String.valueOf(smallvalue));
    }
    public void minusmedium(View minmed)
    {
        mediumvalue = mediumvalue - 1;
        if (mediumvalue<0)
            mediumvalue = 0;
        nilaisedang.setText(String.valueOf(mediumvalue));
    }
    public void minuslarge(View minlar)
    {
        largevalue = largevalue - 1;
        if(largevalue<0)
            largevalue = 0;
        nilaibesar.setText(String.valueOf(largevalue));
    }
    public void plussmall(View plusma)
    {
        smallvalue = smallvalue + 1;
        nilaikecil.setText(String.valueOf(smallvalue));
    }
    public void plusmedium(View plumed)
    {
        mediumvalue = mediumvalue + 1;
        nilaisedang.setText(String.valueOf(mediumvalue));
    }
    public void pluslarge(View plular)
    {
        largevalue = largevalue + 1;
        nilaibesar.setText(String.valueOf(largevalue));
    }

    public void confirm(View confirm1) {
        Context myContext_1 = edit_content.this;
    new AlertDialog.Builder(myContext_1).setTitle("Confirmation input").setMessage("Are you sure your input is right?").setPositiveButton(R.string.confirmation, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        }
    }).setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }).show();
    }

}
