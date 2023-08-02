package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {

    Button btnGrabarUsu;
    EditText txtNomUsu, txtApellUsu, txtUsua, txtPassUsu;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnGrabarUsu=(Button) findViewById(R.id.btnRegistrar);
        txtNomUsu=(EditText) findViewById(R.id.txtNom);
        txtApellUsu=(EditText) findViewById(R.id.txtApe);
        txtUsua=(EditText) findViewById(R.id.txtUsu);
        txtPassUsu=(EditText) findViewById(R.id.txtPass);

        btnGrabarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtNomUsu.getText()),
                        String.valueOf(txtApellUsu.getText()),
                        String.valueOf(txtUsua.getText()),
                        String.valueOf(txtPassUsu.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(), "Registro Exitoso",
                        Toast.LENGTH_LONG) .show();

                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}