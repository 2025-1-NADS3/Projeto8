package com.example.bancouni; 

import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.ImageButton; 

import androidx.appcompat.app.AppCompatActivity; 

public class DashboardActivity extends AppCompatActivity { 

private boolean isSaldoVisivel = false; 
private EditText saldoEditText; 
private ImageButton btnToggleSaldo; 
 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_dashboard); 
 
    saldoEditText = findViewById(R.id.saldoEditText); 
    btnToggleSaldo = findViewById(R.id.btnToggleSaldo); 
 
    Button btnVoltar = findViewById(R.id.btnVoltar); 
    Button btnPagamentos = findViewById(R.id.btnPagamentos); 
    Button btnPagamentosAgendados = findViewById(R.id.btnPagamentosAgendados); 
    Button btnHistoricoPagamentos = findViewById(R.id.btnHistoricoPagamentos); 
    Button btnEducacaoFinanceira = findViewById(R.id.btnEducacaoFinanceira); 
 
    btnToggleSaldo.setOnClickListener(v -> { 
        isSaldoVisivel = !isSaldoVisivel; 
        saldoEditText.setInputType(isSaldoVisivel ? 
                android.text.InputType.TYPE_CLASS_TEXT : 
                android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD); 
        saldoEditText.setSelection(saldoEditText.getText().length()); 
    }); 
 
    btnVoltar.setOnClickListener(v -> finish()); 
 
    btnPagamentos.setOnClickListener(v -> { 
        Intent intent = new Intent(this, PagamentoActivity.class); 
        startActivity(intent); 
    }); 
 
 
    btnPagamentosAgendados.setOnClickListener(v -> { 
        startActivity(new Intent(this, PagamentoActivity.class)); 
    }); 
 
    btnHistoricoPagamentos.setOnClickListener(v -> { 
        startActivity(new Intent(this, HistoricoActivity.class)); 
    }); 
 
 
    Button btnEducacao = findViewById(R.id.btnEducacaoFinanceira); 
 
    btnEducacao.setOnClickListener(view -> { 
        Intent intent = new Intent(DashboardActivity.this, EducacaoFinanceiraActivity.class); 
        startActivity(intent); 
    }); 
 
} 
  

} 

 
