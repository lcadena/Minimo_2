package com.example.lizeth.minim_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button catalogo;
    private ProgressBar progressBar;

    private APIService srAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catalogo = (Button) findViewById(R.id.button1);

        progressBar = (ProgressBar) findViewById(R.id.progresBar);
        catalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getList(v);
            }
        });
    }

    public void getList(View view){
        APIAdapter.getInstance().api.getLibro(et.getText().toString()).enqueue(new Callback<Libro>(){

            @Override
            public void onResponse(Call<Libro> call, Response<Libro> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Hecho", Toast.LENGTH_SHORT ).show();
                    Intent i = new Intent(getApplicationContext(),Libros.class);
                    Libro p = (Libro) response.body();
                    i.putExtra("titulo", p.getRegistro());
                    i.putExtra("avatar_url", p.getAvatar_url());
                    i.putExtra("libroID", p.getLibroID());
                    i.putExtra("titulo", p.getTitulo());
                    i.putExtra("autor", p.getAutor());
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No hecho",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Libro> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Problema al conectar",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
