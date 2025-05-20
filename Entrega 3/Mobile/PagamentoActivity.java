package br.fecap.ads.bancounicomdebitosaldo;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class PagamentoActivity extends AppCompatActivity {

    private boolean isSaldoVisivel = false;
    private EditText editSaldoPagamentos;
    private EditText inputTransferir;
    private LinearLayout layoutHistorico;
    private double saldoAtual = 1000.00; // saldo inicial fixo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVoltar = findViewById(R.id.btnVoltarPagamentos);
        ImageButton btnToggle = findViewById(R.id.btnToggleSaldoPagamentos);
        editSaldoPagamentos = findViewById(R.id.editSaldoPagamentos);
        inputTransferir = findViewById(R.id.inputTransferir);
        Button btnPagar = findViewById(R.id.btnPagar);
        layoutHistorico = findViewById(R.id.layoutHistorico);

        btnVoltar.setOnClickListener(v -> finish());

        // Inicializa campo saldo com valor novo e oculto
        atualizarSaldoNaTela();

        btnToggle.setOnClickListener(v -> {
            isSaldoVisivel = !isSaldoVisivel;
            if (isSaldoVisivel) {
                editSaldoPagamentos.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                editSaldoPagamentos.setText(formatarValor(saldoAtual));
            } else {
                editSaldoPagamentos.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                editSaldoPagamentos.setText("••••");
            }
            editSaldoPagamentos.setSelection(editSaldoPagamentos.getText().length());
        });

        btnPagar.setOnClickListener(v -> {
            String valorStr = inputTransferir.getText().toString().trim();

            if (valorStr.isEmpty()) {
                Toast.makeText(this, "Informe o valor a transferir", Toast.LENGTH_SHORT).show();
                return;
            }

            double valorTransferir;
            try {
                // Tenta converter o valor digitado para double
                valorTransferir = Double.parseDouble(valorStr.replace(",", "."));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            if (valorTransferir <= 0) {
                Toast.makeText(this, "Informe um valor maior que zero", Toast.LENGTH_SHORT).show();
                return;
            }

            if (valorTransferir > saldoAtual) {
                Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show();
                return;
            }

            // Debita do saldo
            saldoAtual -= valorTransferir;
            atualizarSaldoNaTela();

            inputTransferir.setText("");

            // Adiciona histórico
            adicionarHistorico("Transferência de R$ " + formatarValor(valorTransferir));

            Toast.makeText(this, "Transferência realizada com sucesso!", Toast.LENGTH_SHORT).show();
        });
    }

    private void atualizarSaldoNaTela() {
        if (isSaldoVisivel) {
            editSaldoPagamentos.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            editSaldoPagamentos.setText(formatarValor(saldoAtual));
        } else {
            editSaldoPagamentos.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editSaldoPagamentos.setText("••••");
        }
        editSaldoPagamentos.setSelection(editSaldoPagamentos.getText().length());
    }

    private void adicionarHistorico(String texto) {
        TextView tvHistorico = new TextView(this);
        tvHistorico.setText(texto);
        tvHistorico.setTextColor(getResources().getColor(android.R.color.white));
        tvHistorico.setTextSize(14);
        tvHistorico.setPadding(0, 8, 0, 8);

        layoutHistorico.addView(tvHistorico);
    }

    private String formatarValor(double valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor);
    }
}

