package br.com.example.brunovitor.aula06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tela3 extends AppCompatActivity {
    TextView mNome;
    TextView mRedeSocial;
    TextView mNotificacao;
    Button mBtnSair;
    String nome;
    String mResultadoSocial;
    Boolean mNotfy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);


        mNome = (TextView) findViewById(R.id.txt_nome_t3);
        mRedeSocial = (TextView) findViewById(R.id.txt_RedeSocial_t3);
        mNotificacao = (TextView) findViewById(R.id.txt_notificação_t3);


        Bundle extraResultados = getIntent().getExtras();

        nome = extraResultados.getString("RESULTADO NOME");
        mNome.setText(nome);

        mResultadoSocial = extraResultados.getString("RESULTADO SOCIAL");
        mRedeSocial.setText(mResultadoSocial);

        mNotfy = extraResultados.getBoolean("RESULTADO NOTIFICACAO");
        if(mNotfy){
            mNotificacao.setText(R.string.resultYes);
        }else{
            mNotificacao.setText(R.string.resultNo);
        }
    }

}
