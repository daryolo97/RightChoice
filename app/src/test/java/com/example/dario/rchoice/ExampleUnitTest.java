package com.example.dario.rchoice;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadow.api.Shadow;

import java.util.ArrayList;

import androidx.test.platform.app.InstrumentationRegistry;
import database.DatabaseHelper;
import entità.Corso;
import facade.GestoreRightChoice;
import gestori.GestioneAdmin;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static java.security.AccessController.getContext;
import static org.junit.Assert.*;
import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {

    private DatabaseHelper databaseHelper;
    private Context context;

    @Before
    public void setUp() {
        context = getInstrumentation().getContext();
        databaseHelper = new DatabaseHelper(context);

    }

    @Test
    public void inserimentoCorsoTest() {
        Corso corso = new Corso("codice", "nome", "docente", "descrizione", "link");
        GestoreRightChoice gestoreRightChoice = new GestoreRightChoice(context);

        gestoreRightChoice.inserisciCorso(corso);
        ArrayList<String> listaNomiCorsi = gestoreRightChoice.getNomeCorsi();

        assertThat(listaNomiCorsi, hasItems("nome"));
    }


}