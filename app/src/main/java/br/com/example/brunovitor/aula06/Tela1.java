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
import android.widget.RadioButton;

public class Tela1 extends AppCompatActivity {

    EditText txtNome;
    Button btnSelecionar;
    CheckBox chkSelecionar;
    String mResultado;
    String mResultadoSocial;
    Button mProximo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Deixar esse botão antes pq senão ele retorna null
        btnSelecionar = (Button) findViewById(R.id.buttonSelecionar);
        mProximo = (Button) findViewById(R.id.buttonProxima);
        txtNome = (EditText) findViewById(R.id.editTextNome);
        chkSelecionar = (CheckBox) findViewById(R.id.checkBox_Notificacao);
        //Verificando instancia e setando variavel
        if (savedInstanceState != null){
            mResultado= savedInstanceState.getString("resultado");
            if (mResultado != null){
                btnSelecionar.setText(mResultado);
            }
        }

        //Método para Chamar a outra tela com parametros
        btnSelecionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Tela1.this, Tela2.class);
                startActivityForResult(it, 2);
           }

       });

        mProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it3 = new Intent (Tela1.this, Tela3.class);
                Bundle extras = new Bundle();

                String nome = txtNome.getText().toString();

                extras.putString("RESULTADO NOME", nome);
                extras.putString("RESULTADO SOCIAL",mResultado);
                extras.putBoolean("RESULTADO NOTIFICACAO", chkSelecionar.isChecked());

                it3.putExtras(extras);
                startActivity(it3);
            }

        });
    }
    //Pegando valor da outra tela
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK){
            mResultadoSocial = data.getStringExtra("RESULTADO SOCIAL");
            btnSelecionar.setText(mResultadoSocial);
            mResultado = mResultadoSocial;
        }
    }
    //Metodo para Instancia
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultado", mResultado);
    }
}
