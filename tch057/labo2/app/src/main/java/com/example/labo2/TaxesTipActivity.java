package com.example.labo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TaxesTipActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ok;
    private EditText pourboire;
    private TextView texteMontantAvecTaxes;
    private double MontantAvecTaxes;

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxes_tip);
        Intent intention = getIntent();
        double MontantAvecTaxes = intention.getDoubleExtra("Montant avec taxes", 0);

        ok = (Button)findViewById(R.id.boutonTaxTipActivity);
        pourboire = (EditText)findViewById(R.id.Pourboire);
        texteMontantAvecTaxes = (TextView)findViewById(R.id.textMontantAvecTaxes);

        texteMontantAvecTaxes.setText(Double.toString(MontantAvecTaxes) + "$");

        ok.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double montantTotal = Double.parseDouble(pourboire.getText().toString());
        montantTotal += MontantAvecTaxes;

        Intent intentResultat = new Intent();
        intentResultat.putExtra("Montant total", montantTotal);

        setResult(RESULT_OK, intentResultat);
        finish();
    }
}