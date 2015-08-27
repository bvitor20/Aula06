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
    RadioButton escolhaSocial;
    String mResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        if (savedInstanceState != null){
            mResultado = savedInstanceState.getString("resultado");

        }


        okSocial = (Button)findViewById(R.id.buttonOkSocial);
        okSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup rd = (RadioGroup) findViewById(R.id.rGroup);
                switch (rd.getCheckedRadioButtonId()){
                    case R.id.radioButtonFace:
                        okSocial.setText("Facebook");

                        break;
                    case R.id.radioButtonTwitter:
                        okSocial.setText("Twitter");

                        break;
                    case R.id.radioButtonG:
                        okSocial.setText("G+");

                }
                    String resultadoSocial = okSocial.getText().toString();
                mResultado = resultadoSocial;
                Intent it = new  Intent();
                it.putExtra("RESULTADO SOCIAL", resultadoSocial);
                setResult(2,it);
                finish();

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultado", mResultado);
    }
}





