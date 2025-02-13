package com.example.labo2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button suivant;
    private EditText prix, quantite;
    private TextView total;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    public class Taxes {
        public static final double TPS = 0.05;
        public static final double TVQ = 0.09975;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        suivant = (Button)findViewById(R.id.BoutonTaxesEtTip);
        prix = (EditText)findViewById(R.id.Prix);
        quantite = (EditText)findViewById(R.id.Quantite);
        total = (TextView)findViewById(R.id.textMontantTotal);

        suivant.setOnClickListener(this);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            double montantTotal = result.getData().getDoubleExtra("Montant total", 0);
                            total.setText(Double.toString(montantTotal));
                        }
                    }
                }
        );

    }

    @Override
    public void onClick(View v){
        double dPrix = Double.parseDouble(prix.getText().toString());
        double dQuantite =  Double.parseDouble(quantite.getText().toString());
        double montantAvecTaxes = dPrix * dQuantite * (1 + Taxes.TPS + Taxes.TVQ);

        Intent intent = new Intent(MainActivity.this, TaxesTipActivity.class);
        intent.putExtra("Montant avec taxes", montantAvecTaxes);
        activityResultLauncher.launch(intent);
    }

}