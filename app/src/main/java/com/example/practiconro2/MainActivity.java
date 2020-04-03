package com.example.practiconro2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDolares, tvEuros, tvTituloResultado, tvResultado;
    private EditText etDolares, etEuros;
    private RadioGroup rgBotones;
    private RadioButton rbEurosADolares, rbDolaresAEuros;
    private Button  btConvertir;
    private MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
        vm = ViewModelProviders.of(this).get(MainViewModel.class);
        vm.getDolaresEuros().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                rbDolaresAEuros.setChecked(aBoolean);
            }
        });
        vm.getEurosDolares().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                rbEurosADolares.setChecked(aBoolean);
            }
        });
        vm.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String aString) {
                tvResultado.setText(aString);
            }
        });
        vm.getTextoDolares().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etDolares.setEnabled(aBoolean);
            }
        });
        vm.getTextoEuros().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etEuros.setEnabled(aBoolean);
            }
        });
    }

    private void configView(){
        tvDolares = findViewById(R.id.tvDolares);
        tvEuros = findViewById(R.id.tvEuros);
        tvTituloResultado = findViewById(R.id.tvTituloResultado);
        etDolares = findViewById(R.id.etDolares);
        etEuros = findViewById(R.id.etEuros);
        tvResultado = findViewById(R.id.tvResultado);
        rgBotones = findViewById(R.id.rgBotones);
        rbEurosADolares = findViewById(R.id.rbEurosADolares);
        rbDolaresAEuros = findViewById(R.id.rbDolaresAEuros);
        btConvertir = findViewById(R.id.btConvertir);

        rbEurosADolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.cambiarEstadoDolaresEuros();
                vm.cambiarEstadoTextoDolares();
            }
        });

        rbDolaresAEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.cambiarEstadoEurosDolares();
                vm.cambiarEstadoTextoEuros();
            }
        });

        btConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.conversion(etDolares.getText().toString(), etEuros.getText().toString());
            }
        });
    }
}
