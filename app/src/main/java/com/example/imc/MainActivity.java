package com.example.imc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.imc.MaskEditUtil.*;

public class MainActivity extends AppCompatActivity {
    Button btnWoman;
    Button btnMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String cor = "#565B5F";
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(cor)));

        EditText txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtAltura.addTextChangedListener(MaskEditUtil.mask(txtAltura, FORMAT_FLOAT));

        EditText txtSexo = (EditText) findViewById(R.id.sexo);
        txtSexo.setVisibility(View.INVISIBLE);

        btnWoman = (Button)findViewById(R.id.buttonWoman);
        btnWoman.setOnClickListener(buttonHandlerWoman);

        btnMan = (Button)findViewById(R.id.buttonMan);
        btnMan.setOnClickListener(buttonHandlerMan);
    }

    View.OnClickListener buttonHandlerWoman = new View.OnClickListener() {
        public void onClick(View v) {
            btnWoman.setBackground((Drawable)btnWoman.getTag());
            btnWoman.setBackgroundResource(R.drawable.woman2);
            btnMan.setBackgroundResource(R.drawable.man1);

            EditText sexo = (EditText) findViewById(R.id.sexo);
            sexo.setText("F");
        }
    };

    View.OnClickListener buttonHandlerMan = new View.OnClickListener() {
        public void onClick(View v) {
            btnMan.setBackground((Drawable)btnMan.getTag());
            btnMan.setBackgroundResource(R.drawable.man2);
            btnWoman.setBackgroundResource(R.drawable.woman1);

            EditText sexo = (EditText) findViewById(R.id.sexo);
            sexo.setText("M");
        }
    };

    public void btnLimparOnClick(View v) {
        TextView lblResultado = (TextView) findViewById(R.id.lblResultado);

        EditText txtIdade = (EditText) findViewById(R.id.txtIdade);
        EditText txtPeso = (EditText) findViewById(R.id.txtPeso);
        EditText txtAltura = (EditText) findViewById(R.id.txtAltura);
        EditText sexo = (EditText) findViewById(R.id.sexo);
        ImageView img = (ImageView) findViewById(R.id.imageViewResultado);

        txtIdade.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
        sexo.setText("");
        lblResultado.setText("");

        btnMan.setBackgroundResource(R.drawable.man1);
        btnWoman.setBackgroundResource(R.drawable.woman1);

        img.setImageResource(R.drawable.imc00);

        txtIdade.requestFocus();
    }

    public void btnCalcularOnClick(View v){
        TextView lblResultado = (TextView)findViewById(R.id.lblResultado);

        EditText txtIdade = (EditText) findViewById(R.id.txtIdade);
        EditText txtSexo = (EditText) findViewById(R.id.sexo);
        EditText txtPeso = (EditText) findViewById(R.id.txtPeso);
        EditText txtAltura = (EditText) findViewById(R.id.txtAltura);

        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(txtPeso.getWindowToken(), 0);

        if (txtIdade.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Informe a idade.", Toast.LENGTH_SHORT).show();
            txtIdade.requestFocus();
        }else if (txtAltura.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Informe a altura.", Toast.LENGTH_SHORT).show();
            txtAltura.requestFocus();
        }else if (txtPeso.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Informe o peso.", Toast.LENGTH_SHORT).show();
            txtPeso.requestFocus();

        }else{
            String sexo  = txtSexo.getText().toString();
            float peso = Float.parseFloat(txtPeso.getText().toString());
            float altura = Float.parseFloat(txtAltura.getText().toString());
            int idade = Integer.parseInt(txtIdade.getText().toString());
            float resultado = peso / (altura * altura);

            ImageView img = (ImageView) findViewById(R.id.imageViewResultado);

            if(idade <= 15){
                if (txtSexo.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Por favor, selecione um sexo.", Toast.LENGTH_SHORT).show();
                }

                if (sexo.equals("M")) {
                    if(idade == 6){
                        if(resultado <= 14.5 && resultado <= 16.6){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 16.6 && resultado <= 17.9){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 18){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 7){
                        if(resultado <= 15 && resultado <= 17.3){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 17.3 && resultado <= 19){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 19.1){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 8){
                        if(resultado <= 15.6 && resultado <= 16.7){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 16.7 && resultado <= 20.2){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 20.3){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 9){
                        if(resultado <= 16.1 && resultado <= 18.8){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 18.8 && resultado <= 21.3){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 21.4){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 10){
                        if(resultado <= 16.7 && resultado <= 19.6){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 19.6 && resultado <= 22.4){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 22.5){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 11){
                        if(resultado <= 17.2 && resultado <= 20.3){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 20.3 && resultado <= 23.6){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 23.7){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 12){
                        if(resultado <= 17.8 && resultado <= 21.1){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 21.1 && resultado <= 24.7){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 24.8){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 13){
                        if(resultado <= 18.5 && resultado <= 21.9){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 21.9 && resultado <= 25.8){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 25.9){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 14){
                        if(resultado <= 19.2 && resultado <= 22.7){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 22.7 && resultado <= 26.8){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 26.9){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 15){
                        if(resultado <= 19.9 && resultado <= 23.6){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 23.6 && resultado <= 27.6){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 27.7){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }

                }else if (sexo.equals("F")){
                    if(idade == 6){
                        if(resultado <= 14.3 && resultado <= 16.1){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 16.1 && resultado <= 17.3){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 17.4){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 7){
                        if(resultado <= 14.9 && resultado <= 17.1){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 17.1 && resultado <= 18.8){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 18.9){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 8){
                        if(resultado <= 15.6 && resultado <= 18.1){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 18.1 && resultado <= 20.2){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 20.3){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 9){
                        if(resultado <= 16.3 && resultado <= 19.1){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 19.1 && resultado <= 21.6){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 21.7){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 10){
                        if(resultado <= 17 && resultado <= 20.1){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 20.1 && resultado <= 23.1){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 23.2){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 11){
                        if(resultado <= 17.6 && resultado <= 21.1){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 21.1 && resultado <= 24.4){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 24.5){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 12){
                        if(resultado <= 18.3 && resultado <= 22.1){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 22.1 && resultado <= 25.8){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 25.9){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 13){
                        if(resultado <= 18.9 && resultado <= 23){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 23 && resultado <= 27.6){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 27.7){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 14){
                        if(resultado <= 19.3 && resultado <= 23.8){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 23.8 && resultado <= 27.8){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 27.9){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }else if (idade == 15){
                        if(resultado <= 19.6 && resultado <= 24.2){
                            img.setImageResource(R.drawable.imc_c01);
                        }else if(resultado > 24.2 && resultado <= 28.7){
                            img.setImageResource(R.drawable.imc_c02);
                        }else if(resultado >= 28.8){
                            img.setImageResource(R.drawable.imc_c03);
                        }
                    }
                }
                String resultadoFormat = String.format("%.02f", resultado);
                lblResultado.setText("IMC: " + resultadoFormat);
            }else{
                if(resultado < 17){
                    img.setImageResource(R.drawable.imc01);
                }else if(resultado >= 17 && resultado <= 18.49){
                    img.setImageResource(R.drawable.imc02);
                }else if(resultado >= 18.5 && resultado <= 24.99){
                    img.setImageResource(R.drawable.imc03);
                }else if(resultado >= 25 && resultado <= 29.99){
                    img.setImageResource(R.drawable.imc04);
                }else if(resultado >= 30 && resultado <= 34.99){
                    img.setImageResource(R.drawable.imc05);
                }else if(resultado >= 35 && resultado <= 39.99){
                    img.setImageResource(R.drawable.imc06);
                }else if(resultado >= 40){
                    img.setImageResource(R.drawable.imc07);
                }

                float peso_ideal = 21 * (altura * altura);
                String resultadoFormat = String.format("%.02f", resultado);
                String pesoidealFormat = String.format("%.02f", peso_ideal);
                lblResultado.setText("IMC: " + resultadoFormat + "\n" + "Peso Ideal: " + pesoidealFormat );
            }
        }
    }
}
