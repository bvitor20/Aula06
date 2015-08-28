package br.com.example.brunovitor.aula06;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tela2 extends AppCompatActivity {


    Button okSocial;
    RadioButton escolhaSocialFace;
    RadioButton escolhaSocialTwitter;
    RadioButton escolhaSocialG;
    String mResultadoSocial;
    RadioButton escolhi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        if (savedInstanceState != null){
            mResultadoSocial = savedInstanceState.getString("resultado");
            if (mResultadoSocial != null){
                okSocial.setText(mResultadoSocial);
            }
        }

        escolhaSocialFace = (RadioButton) findViewById(R.id.radioButtonFace);
        escolhaSocialTwitter = (RadioButton) findViewById(R.id.radioButtonTwitter);
        escolhaSocialG = (RadioButton) findViewById(R.id.radioButtonG);
        okSocial = (Button)findViewById(R.id.buttonOkSocial);
        okSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rd = (RadioGroup) findViewById(R.id.rGroup);
                switch (rd.getCheckedRadioButtonId()){
                    case R.id.radioButtonFace:
                        escolhaSocialFace.getText().toString();
                        escolhi = escolhaSocialFace;
                        escolhi.isChecked();
                        break;
                    case R.id.radioButtonTwitter:
                        escolhaSocialTwitter.getText().toString();
                        escolhi = escolhaSocialTwitter;
                        break;
                    case R.id.radioButtonG:
                        escolhaSocialG.getText().toString();
                        escolhi = escolhaSocialG;
                        break;
                }
                mResultadoSocial = escolhi.getText().toString();
                Intent it = new  Intent();
                it.putExtra("RESULTADO SOCIAL", mResultadoSocial);
                setResult(RESULT_OK, it);
                finish();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultado", mResultadoSocial);

    }
}





