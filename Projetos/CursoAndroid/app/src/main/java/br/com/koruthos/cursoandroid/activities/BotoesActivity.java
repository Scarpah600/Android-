package br.com.koruthos.cursoandroid.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import br.com.koruthos.cursoandroid.R;
import br.com.koruthos.cursoandroid.databinding.ActivityBotoesBinding;

public class BotoesActivity extends AppCompatActivity {

    private static final String TAG = "Botoes";
    private ActivityBotoesBinding mBindind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Amarração dos componentes do layout
        mBindind = DataBindingUtil.setContentView(this, R.layout.activity_botoes);

        mBindind.botoesBtn1.setOnClickListener(v -> {
            // Componente fica invisivel mas se mantem no layout
            mBindind.botoesBtn2.setVisibility(View.INVISIBLE);
        });

        mBindind.botoesBtn3.setOnClickListener(v -> {
            // Exibe o componente
            mBindind.botoesBtn2.setVisibility(View.VISIBLE);
        });

        mBindind.botoesBtn4.setOnClickListener(v -> {
            // Componente fica invisivel e some do layout
            mBindind.botoesBtn2.setVisibility(View.GONE);
        });

        mBindind.botoesLayoutBtn.setVisibility(View.GONE);

        // Timer para executar um processo em background
        




    }


}
