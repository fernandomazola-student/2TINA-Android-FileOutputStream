package br.com.fiap.a2tina_android_fileoutputstream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void criar(View view) {
        //Tratamos a excecao por que vamos tentar escrever algo e da excecao
        try{
            FileOutputStream fos = openFileOutput("teste.txt", MODE_PRIVATE);
            String texto = "Bom dia !!";
            fos.write(texto.getBytes());
            fos.close();
        }catch (Exception e){
            Toast.makeText(this, "Erro Inesperado!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void ler(View view) {
        try{
            FileInputStream fis = openFileInput("teste.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            //Lendo um arquivo
            String texto = br.readLine();//Cada vez que chamamos o readline ele vai para outra linha
            fis.close();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        }catch (Exception e){

        }
    }
}
