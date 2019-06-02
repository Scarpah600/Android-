package br.com.koruthos.cursoandroid.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import br.com.koruthos.cursoandroid.R;
import br.com.koruthos.cursoandroid.databinding.ActivityLoginBinding;
import br.com.koruthos.cursoandroid.model.Login;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Login";
    private ActivityLoginBinding mBindind;
    private Login mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Documentação Databinding: https://developer.android.com/topic/libraries/data-binding/index.html

        // Amarração dos componentes do layout
        mBindind = DataBindingUtil.setContentView(this, R.layout.activity_login);

        mBindind.loginBtnLogin1.setOnClickListener(v -> onBtn1Click());
        mBindind.loginBtnLogin2.setOnClickListener(v -> onBtn2Click());

        // Instancia os objetos
        mLogin = new Login();
//        mLogin.setUsuario("user_default");
//        mLogin.setSenha("senha_default");

        mBindind.setLogin(mLogin);


    }



    private void onBtn1Click() {
        Log.d(TAG, "onBtn1Click: ");
        // Modo tradicional de recuperar dados dos componentes
        String nome = mBindind.loginEditUsuario.getText().toString();
        String senha = mBindind.loginEditSenha.getText().toString();

        Toast.makeText(this, "usuario: " + nome, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "senha: " + senha, Toast.LENGTH_SHORT).show();

    }

    private void onBtn2Click() {
        Log.d(TAG, "onBtn2Click: ");

        Log.d(TAG, "onBtn2Click: NOME: " + mLogin.getUsuario());
        Log.d(TAG, "onBtn2Click: SENHA: " + mLogin.getSenha());


        String nome = mBindind.loginEditUsuario.getText().toString();
        String senha = mBindind.loginEditSenha.getText().toString();

        if (senha.isEmpty()) {
            mBindind.loginEditSenha.requestFocus();
            mBindind.loginEditSenha.setError("Campo obrigatório!");
        }
        if (nome.isEmpty()) {
            mBindind.loginEditUsuario.requestFocus();
            mBindind.loginEditUsuario.setError("Campo obrigatório!");
        }
        else {
            // Validacao do usuario e senha
            if (nome.equals("joao") && senha.equals("123")) {
                Toast.makeText(this, "Continua na proxima tela", Toast.LENGTH_SHORT).show();
            } else {
                mBindind.loginEditUsuario.requestFocus();
                mBindind.loginEditUsuario.setError("Usuário inválido");
            }
        }



    }
}
