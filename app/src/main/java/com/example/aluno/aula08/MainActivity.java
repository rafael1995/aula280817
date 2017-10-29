package com.example.aluno.aula08;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,R.array.unidades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) parent.getItemAtPosition(position);
        Toast.makeText(this, item + " - selecionado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void radioClick(View view) {
        // usa o método isChecked() para saber se o
        // radioClick está selecionado
        RadioButton controle = (RadioButton) view;
        boolean checado = controle.isChecked();
        // testa qual radioClick foi clicado
        switch(controle.getId()) {
            case R.id.radioPerecivel:
                if (checado)
                    Toast.makeText(this,"Perecível - selecionado",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioNaoPerecivel:
                if (checado)
                    Toast.makeText(this,"Não perecível - selecionado",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void checkbox(View view) {
        // usa o método isChecked() para saber se o
        // checkbox está selecionado
        CheckBox controle = (CheckBox) view;
        boolean checado = controle.isChecked();
        // testa qual checkbox foi clicado
        switch(controle.getId()) {
            case R.id.checkBoxPromo:
                if (checado)
                    Toast.makeText(this,"Pode participar de promoções - selecionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxLimiteEstoque:
                if (checado)
                    Toast.makeText(this,"Pode ter limite de estoque - selecionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxLocalRefrigerado:
                if (checado)
                    Toast.makeText(this,"Deve ser guardado em local refrigerado - selecionado", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
