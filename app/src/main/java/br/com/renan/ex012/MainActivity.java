package br.com.renan.ex012;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 *@author: renan santos carvalho
 */
public class MainActivity extends AppCompatActivity {


    private TextView tvError;
    private EditText etCodigo;
    private EditText etValor;
    private EditText etVipFunction;
    private EditText etTaxa;
    private CheckBox ckVip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etCodigo = findViewById(R.id.etCodigo);
        etValor = findViewById(R.id.etValor);
        etTaxa = findViewById(R.id.etTaxa);
        ckVip = findViewById(R.id.ckVip);
        etVipFunction = findViewById(R.id.etVipFunction);
        findViewById(R.id.button).setOnClickListener(e -> buy(ckVip.isChecked()));
        ckVip.setOnCheckedChangeListener((btnView, isChecked) -> alternateFunctionVisibility(isChecked));
    }


    private void alternateFunctionVisibility(boolean isChecked) {
        if (isChecked) {
            etVipFunction.setVisibility(TextView.VISIBLE);
        } else {
            etVipFunction.setVisibility(TextView.GONE);
        }
    }


    private void buy(boolean vip) {
        String c = etCodigo.getText().toString();
        float v = parseFloatSafe(etValor.getText().toString());
        String f = vip ? etVipFunction.getText().toString() : "...";
        float t = parseFloatSafe(etTaxa.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putBoolean("vip", vip);
        bundle.putString("codigo", c);
        bundle.putString("funcao", f);
        bundle.putFloat("valor", v);
        bundle.putFloat("taxa", t);

        switchView(bundle);
    }

    private void switchView(Bundle bundle) {
        Intent i = new Intent(this, OutputActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }

    private float parseFloatSafe(String value) {
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            return 0f;
        }
    }
}