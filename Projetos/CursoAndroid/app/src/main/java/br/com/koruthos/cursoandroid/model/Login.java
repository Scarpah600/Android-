package br.com.koruthos.cursoandroid.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import br.com.koruthos.cursoandroid.BR;

public class Login extends BaseObservable {

    // POJO: Plain Old Java Object
    // - Atributos
    // - Construtor vazio
    // - Getters/ Setters

    private String mUsuario = "";
    private String mSenha = "";

    @Bindable
    public String getUsuario() {
        return mUsuario;
    }

    public void setUsuario(final String usuario) {
        mUsuario = usuario;
        notifyPropertyChanged(BR.login);
    }

    @Bindable
    public String getSenha() {
        return mSenha;
    }

    public void setSenha(final String senha) {
        mSenha = senha;
        notifyPropertyChanged(BR.login);
    }
}
