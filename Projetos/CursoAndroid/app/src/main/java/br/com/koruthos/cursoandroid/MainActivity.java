package br.com.koruthos.cursoandroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import br.com.koruthos.cursoandroid.activities.LoginActivity;
import br.com.koruthos.cursoandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Main";

    /** Objeto que contem todas as amarracoes de layout */
    private ActivityMainBinding mBinding;

    private View.OnClickListener mEventoBotao3 = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Log.d(TAG, "onClick: ");
            Toast.makeText(MainActivity.this, "Botao 3 - Clicado!", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Comentado pq vamos usar o databinding
        //        setContentView(R.layout.activity_main);

        // -- Modo de acesso MVVM <- modo a ser seguido --
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.mainBtnBotao7.setOnClickListener(v -> onBotao7Click());
        mBinding.mainBtnBotao8.setOnClickListener(v -> onBotao8Click());
        mBinding.mainBtnGoogle.setOnClickListener(v -> onGoogleClick());


        // -- Modo de acesso tradicional --
        // findViewById: recupera o objeto de um arquivo de layout

        // cadastro de eventos tradicional
        Button botao1 = findViewById(R.id.main_btn_botao1);
        botao1.setOnClickListener(this);

        // cadastro de eventos com classe anonima
        Button botao2 = findViewById(R.id.main_btn_botao2);
        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                clicouBotao2();
            }
        });

        // cadastro de eventos com classe anonima de um objeto
        Button botao3 = findViewById(R.id.main_btn_botao3);
        botao3.setOnClickListener(mEventoBotao3);

        // cadastro usando funcao lambda
        Button botao4 = findViewById(R.id.main_btn_botao4);
        botao4.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: ");
            Toast.makeText(this, "Botao 4 - Clicado!", Toast.LENGTH_SHORT).show();
        });

        // cadastro usando funcao lambda
        Button botao5 = findViewById(R.id.main_btn_botao5);
        botao5.setOnClickListener(v -> Toast.makeText(this, "Botao 5 - Clicado!", Toast.LENGTH_SHORT).show());

        // cadastro usando funcao lambda
        Button botao6 = findViewById(R.id.main_btn_botao6);
        botao6.setOnClickListener(MainActivity::onBotaoClick);


    }

    private void onGoogleClick() {
        Log.d(TAG, "onGoogleClick: ");
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.google.com"));
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private void onCameraClick() {
        Log.d(TAG, "onCameraClick: ");
        try {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private void onBotao7Click() {
        Log.d(TAG, "onBotao7Click: ");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void onBotao8Click() {
        Log.d(TAG, "onBotao8Click: ");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish(); // Finaliza a activity
    }

    @Override
    public void onClick(final View v) {
        Log.d(TAG, "onClick: ");
        Toast.makeText(this, "Botao 1 - Clicado!", Toast.LENGTH_SHORT).show();
    }

    private void clicouBotao2() {
        Log.d(TAG, "clicouBotao2: ");
        Toast.makeText(this, "Botao 2 - Clicado!", Toast.LENGTH_SHORT).show();
    }

    public static void onBotaoClick(final View v) {
        Log.d(TAG, "onBotaoClick: ");
        Toast.makeText(v.getContext(), "Botao 6 - Clicado!", Toast.LENGTH_SHORT).show();
    }
}
