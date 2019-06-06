package com.example.bolsa;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name, valor, cap, acc, totaA;
    Handler handler;
    int val, valaux, total, n1, c = 0, tva, auxii = 0, contadorsubida = 0, contadorbajada = 0;
    Button comprar, vender;
    boolean compra = false, sube = false;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nombre);
        valor = findViewById(R.id.txtvalor);
        comprar = findViewById(R.id.btnComprar);
        cap = findViewById(R.id.txtCap);
        acc = findViewById(R.id.txtnAcciones);
        totaA = findViewById(R.id.txtAV);
        vender = findViewById(R.id.btnVender);
        image = findViewById(R.id.img);
        handler = new controlador();

        Bundle bundle = getIntent().getExtras();
        val=(int)Math.round(Math.random() * 100);

        valor.setText("Valor: " + val + ".00");

        name.setText(bundle.getString("nombre", ""));

        Hilo mihilo = new Hilo(5, 3000);
        mihilo.start();

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!compra){
                    n1 = Integer.parseInt(cap.getText().toString());
                    tva += valaux;
                    total = n1 - valaux;
                    cap.setText(total + "");

                    c++;
                    acc.setText(c+"");
                    totaA.setText(tva+"");

                    compra = true;
                }


            }
        });

        vender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(c > 0){
                    auxii = tva;
                    auxii -= valaux;
                    c--;
                    acc.setText(c+"");

                    tva -= valaux;
                    if(auxii < 0){
                        tva = 0;
                    }
                    totaA.setText(tva+"");

                    n1 = Integer.parseInt(cap.getText().toString());
                    total = n1 + valaux;
                    cap.setText(total + "");
                }
            }
        });

    }

    public class Hilo extends Thread{
        int maximo;
        int tiempo;

        public Hilo(int maximo, int tiempo){
            this.maximo = maximo;
            this.tiempo = tiempo;
        }

        public void run(){

            for(int i=0;i<=maximo;i++){

                try {
                    val =(int)Math.round(Math.random() * 100);
                    Thread.sleep(tiempo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message msg = handler.obtainMessage();

                Bundle bundle= new Bundle();
                bundle.putInt("total", i);
                bundle.putString("thread", currentThread().toString());
                msg.setData(bundle);
                handler.sendMessage(msg);
            }


        }
    }

    class controlador extends Handler {
        @Override
        public void handleMessage(Message msg) {
            int total;
            total = msg.getData().getInt("total");
            String thread = msg.getData().getString("thread");
            valor.setText("Valor: " + val + ".00");
            valaux = val;
        }
    }
}
