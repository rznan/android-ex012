package br.com.renan.ex012;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.renan.ex012.model.Ingresso;
import br.com.renan.ex012.model.IngressoVip;

/**
 *@author: renan santos carvalho
 */
public class OutputActivity extends AppCompatActivity {


    private Button returnButton;
    private TextView tvOutput;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_output);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        returnButton = findViewById(R.id.returnButton);
        tvOutput = findViewById(R.id.tvOutput);

        Intent in = getIntent();
        bundle = in.getExtras();

        Ingresso i = getIngressoFromIntent();
        printToScreen(i);
        
        returnButton.setOnClickListener(e -> back());

    }

    private void back() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }

    private Ingresso getIngressoFromIntent() {
        if(bundle.getBoolean("vip")) {
            return new IngressoVip(
                    bundle.getString("codigo"),
                    bundle.getFloat("valor"),
                    bundle.getString("funcao"));
        }
        return new Ingresso(
                bundle.getString("codigo"),
                bundle.getFloat("valor"));
    }

    private void printToScreen(Ingresso i) {
        tvOutput.setText(i.getResumo(bundle.getFloat("taxa")));
    }
}
