package br.com.example.brunovitor.aula06;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {

    EditText txtNome;
    Button btnSelecionar;
    CheckBox chkSelecionar;
    String mResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        if (savedInstanceState != null){
            mResultado= savedInstanceState.getString("resultado");
        }

        txtNome = (EditText) findViewById(R.id.editTextNome);
        btnSelecionar = (Button) findViewById(R.id.buttonSelecionar);
        chkSelecionar = (CheckBox) findViewById(R.id.checkBox_Notificacao);




       btnSelecionar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent it = new Intent(Tela1.this, Tela2.class);
               startActivityForResult(it, 2);
           }

       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2){

            String resultadoSocial = data.getStringExtra("RESULTADO SOCIAL");
            btnSelecionar.setText(resultadoSocial);
            mResultado = resultadoSocial;



        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultado", mResultado);
    }
}
