
package com.exemplo.bancouni;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {
    private EditText etEmail, etUsuario, etSenha, etConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etEmail = findViewById(R.id.etEmail);
        etUsuario = findViewById(R.id.etUsuario);
        etSenha = findViewById(R.id.etSenha);
        etConfirmar = findViewById(R.id.etConfirmarSenha);
    }

    public void cadastrar(View view) {
        String email = etEmail.getText().toString();
        String usuario = etUsuario.getText().toString();
        String senha = etSenha.getText().toString();
        String confirmar = etConfirmar.getText().toString();

        if (!senha.equals(confirmar)) {
            Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show();
            return;
        }

        UsuarioDAO dao = new UsuarioDAO(this);
        if (dao.inserirUsuario(email, usuario, senha)) {
            Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erro ao cadastrar!", Toast.LENGTH_SHORT).show();
        }
    }

    public void voltar(View view) {
        finish();
    }
}
