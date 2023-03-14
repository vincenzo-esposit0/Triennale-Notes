package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static android.content.Context.MODE_PRIVATE;

public class AreaUtenteFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle transb = getArguments();
        trans = transb.getBoolean("trans", false);
        if(trans){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new CarrelloVuotoFragment()).commit();
        } else {
            rootView = inflater.inflate(R.layout.area_utente, container, false);
            sqliteHelper = new SqliteHelper(getActivity());

            nome = rootView.findViewById(R.id.areaNome);
            cognome = rootView.findViewById(R.id.areaCognome);
            mail = rootView.findViewById(R.id.areaMail);
            modB = rootView.findViewById(R.id.modB);
            modNome = rootView.findViewById(R.id.modNome);
            modCognome = rootView.findViewById(R.id.modCognome);
            modMail = rootView.findViewById(R.id.modMail);
            buttonSave = rootView.findViewById(R.id.saveB);
            ultimoOrdine = rootView.findViewById(R.id.ultimoOrdine);
            acquistaDiNuovo = rootView.findViewById(R.id.acquistaDiNuovo);

            final Bundle b = getArguments();
            final User u = sqliteHelper.getUtente(b.getString("email"));

            final String id = u.id;
            nome.setText(u.userName);
            cognome.setText(u.surname);
            mail.setText(u.email);

            modB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nome.setVisibility(View.INVISIBLE);
                    modNome.setVisibility(View.VISIBLE);
                    cognome.setVisibility(View.INVISIBLE);
                    modCognome.setVisibility(View.VISIBLE);
                    mail.setVisibility(View.INVISIBLE);
                    modMail.setVisibility(View.VISIBLE);
                    modB.setVisibility(View.INVISIBLE);
                    buttonSave.setVisibility(View.VISIBLE);

                    modNome.setText(nome.getText());
                    modCognome.setText(cognome.getText());
                    modMail.setText(mail.getText());
                }
            });
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sqliteHelper.upUser(new User(id, modCognome.getText().toString(), modNome.getText().toString(), u.soul, modMail.getText().toString(), u.password));
                    nome.setText(modNome.getText());
                    cognome.setText(modCognome.getText());
                    mail.setText(modMail.getText());

                    nome.setVisibility(View.VISIBLE);
                    modNome.setVisibility(View.INVISIBLE);
                    cognome.setVisibility(View.VISIBLE);
                    modCognome.setVisibility(View.INVISIBLE);
                    mail.setVisibility(View.VISIBLE);
                    modMail.setVisibility(View.INVISIBLE);
                    modB.setVisibility(View.VISIBLE);
                    buttonSave.setVisibility(View.INVISIBLE);
                }
            });

            flag = b.getBoolean("ultimoOrd", false);
            if(true){
                GregorianCalendar oggi = new GregorianCalendar();
                int giorno = oggi.get(Calendar.DAY_OF_MONTH);
                int mese = oggi.get(Calendar.MONTH);
                int anno = oggi.get(Calendar.YEAR);
                ultimoOrdine.setText("Acquisto del: "+giorno+"/"+mese+"/"+anno+" ");
                acquistaDiNuovo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bo = new Bundle();
                        bo.putBoolean("ultimoOrdine", true);
                        if(getActivity().getSupportFragmentManager().findFragmentByTag("carrello") == null){
                            CarrelloFragment carrelloFragment = new CarrelloFragment();
                            carrelloFragment.setArguments(bo);
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, carrelloFragment, "carrello").addToBackStack("carrello").commit();
                        } else{
                            CarrelloFragment carrelloFragment = (CarrelloFragment) getActivity().getSupportFragmentManager().findFragmentByTag("carrello");
                            carrelloFragment.setArguments(bo);
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, carrelloFragment, "carrello").addToBackStack("carrello").commit();
                        }
                    }
                });
            } else {
                ultimoOrdine.setText("Nessun ordine effettuato");
            }
        }
        return rootView;
    }
    private boolean trans = false;
    private boolean flag = false;
    private Button acquistaDiNuovo;
    private TextView ultimoOrdine;
    private SqliteHelper sqliteHelper;
    private TextView nome;
    private TextView cognome;
    private TextView mail;
    private Button modB;
    private View rootView;
    private EditText modNome;
    private EditText modCognome;
    private EditText modMail;
    private Button buttonSave;
}
