package gestori;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Corso;
import facade.GestoreRightChoice;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class GestioneCorsoTest {

    private DatabaseHelper databaseHelper;
    private Context context;

    @Before
    public void setUp() throws Exception {
        context = getInstrumentation().getContext();
        databaseHelper = new DatabaseHelper(context);
    }

    @Test
    public void inserisciCorso() {
        Corso corso = new Corso("codice", "nome", "docente", "descrizione", "link");
        GestoreRightChoice gestoreRightChoice = new GestoreRightChoice(context);
        gestoreRightChoice.inserisciCorso(corso);
        ArrayList<String> listaNomiCorsi = gestoreRightChoice.getNomeCorsi();
        assertThat(listaNomiCorsi, hasItems("nome"));

    }

    @Test
    public void listaCorsi(){
        Corso corso = new Corso("codicss", "esempio", "ferrucci", "descrizione", "link");
        GestoreRightChoice gestoreRightChoice = new GestoreRightChoice(context);
        gestoreRightChoice.inserisciCorso(corso);
        ArrayList<Corso> lista = gestoreRightChoice.listaCorsi();
        assertFalse(lista.isEmpty());
    }
}