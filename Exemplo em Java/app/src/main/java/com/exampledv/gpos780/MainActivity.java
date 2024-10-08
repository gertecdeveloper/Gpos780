package com.exampledv.gpos780;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.exampledv.gpos780.Camera.CodigoDeBarras;
import com.exampledv.gpos780.Camera.Scanner;
import com.exampledv.gpos780.Impressora.Printer;
import com.exampledv.gpos780.LeituraMifare.Mifare;
import com.exampledv.gpos780.PagTEF.Tef;

public class MainActivity extends AppCompatActivity {

    private Button btnPrinter, btnScanner, btnCamera, btnSensorBobina,
            btnMifare, btnTef, infor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ativa o modo full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
        }

        View decorView = getWindow().getDecorView();
        WindowInsetsControllerCompat controller = ViewCompat.getWindowInsetsController(decorView);

        if (controller != null) {
            // Oculta as barras de sistema
            controller.hide(WindowInsetsCompat.Type.systemBars());
            // Permite que as barras apareçam com swipe
            controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        }

        btnPrinter = findViewById(R.id.btnPrinter);
        btnScanner = findViewById(R.id.btnScanner);
        btnCamera = findViewById(R.id.btnCamera);
//        btnSensorBobina = findViewById(R.id.btnSensorBobina);
        btnMifare = findViewById(R.id.btnMifare);
        btnTef = findViewById(R.id.btnTef);
        infor = findViewById(R.id.infor);


        // Ação para abrir o diálogo ao clicar no botão "Infor"
        infor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Constrói o AlertDialog
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Informações")
                        .setMessage("Equipamento: GPOS780\nSDK: libgedi-1.16.21-gpos780-payment-release\nLinguagem: Java\nVersão do app: 1.0.0")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss(); // Fecha o diálogo ao clicar em OK
                            }
                        })
                        .create();

                // Exibe o AlertDialog
                alertDialog.show();
            }
        });

        // Configuração dos outros botões
        btnPrinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Printer.class);
                startActivity(intent);
            }
        });

        btnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Scanner.class);
                startActivity(intent);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CodigoDeBarras.class);
                startActivity(intent);
            }
        });

        btnMifare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mifare.class);
                startActivity(intent);
            }
        });
//
//        btnSensorBobina.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SensorBobina.class);
//                startActivity(intent);
//            }
//        });

        btnTef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tef.class);
                startActivity(intent);
            }
        });

    }
}