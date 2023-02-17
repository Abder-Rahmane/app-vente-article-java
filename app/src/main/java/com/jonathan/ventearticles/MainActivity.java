package com.jonathan.ventearticles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NumberPicker produit, quantit;
    private TextView prixu, pht, tva, rem, pttc;
    private Button btn;
    private int q, prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produit = findViewById(R.id.np_pd);
        quantit = findViewById(R.id.np_qte);
        prixu = findViewById(R.id.tv_pu);
        pht = findViewById(R.id.tv_pht);
        tva  = findViewById(R.id.tv_tva);
        rem = findViewById(R.id.tv_remise);
        pttc = findViewById(R.id.tv_prixttc);
        btn = findViewById(R.id.btn_calculer);

        //Number Picker quantité

        quantit.setValue(1);
        quantit.setMaxValue(100);

        quantit.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldv, int newv) {
                q = newv;
            }
        });

        // numberpiker produits

        final String [] produits = {"Ordinateur", "Imprimante", "Scanner", "Smartphone"};
        produit.setValue(0);
        produit.setMaxValue(produits.length-1);
        produit.setDisplayedValues(produits);

        produit.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldv, int newv) {
                prix = 0;
                if (newv==0)
                    prix = 7500;
                else
                if (newv==1)
                    prix = 2540;
                else
                if (newv==2)
                    prix = 800;
                else
                if (newv==3)
                    prix = 3489;
                prixu.setText(""+prix);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float phht = prix *q;
                float tvaa = prix *q *0.2f;
                float rr = prix *q *0.1f;
                float prix_ttc = phht + tvaa-rr;
                pht.setText(""+phht);
                tva.setText(""+tvaa);
                rem.setText(""+rr);

                pttc.setText(""+ prix_ttc);
            }
        });
    }
}