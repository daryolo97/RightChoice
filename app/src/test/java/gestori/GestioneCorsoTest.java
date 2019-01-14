package gestori;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import database.DatabaseHelper;
import entity.Corso;
import facade.GestoreRightChoice;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class GestioneCorsoTest {
  private DatabaseHelper databaseHelper;
  private Context context;
  private  GestoreRightChoice gestoreRightChoice;
  private Corso corso;
  private Corso corso1;

  @Before
  public void setUp() throws Exception {
    context = getInstrumentation().getContext();
    databaseHelper = new DatabaseHelper(context);
    corso = new Corso("test", "nome", "docente", "descrizione", "link");
    corso1 = new Corso("test1", "nome", "docente", "descrizione", "link");
    gestoreRightChoice = new GestoreRightChoice(context);
  }

  @Test
  public void inserisciCorso() {
    gestoreRightChoice.inserisciCorso(corso);
    ArrayList<String> listaNomiCorsi = gestoreRightChoice.getNomeCorsi();

    /* Caso in cui il corso è stato correttamente inserito */
    assertThat(listaNomiCorsi, hasItems("nome"));
  }

  @Test
  public void listaCorsi(){
    /* Creo una lista di corsi vuota dove non aggiungo corsi */
    ArrayList<Corso> listavuota = gestoreRightChoice.listaCorsi();

    /* Aggiungo un corso richiamando il metodo */
    gestoreRightChoice.inserisciCorso(corso);

    /* Creo una lista di corsi aggiornata con il corso inserito precedentemente */
    ArrayList<Corso> lista = gestoreRightChoice.listaCorsi();

    /* Caso in cui il database ritorna una lista vuota */
    assertTrue(listavuota.isEmpty());

    /* Caso in cui il database ritorna una lista piena */
    assertFalse(lista.isEmpty());
  }

  @Test
  public void verificaCodiceCorso(){
    /* Inserisco "corso1" nella lista dei corsi*/
    gestoreRightChoice.inserisciCorso(corso1);

    /* Caso il cui il codice del corso non è già presente nel database */
    assertTrue(gestoreRightChoice.verificaCodiceCorso(corso));

    /* Caso il cui il codice del corso è già presente nel database */
    assertFalse(gestoreRightChoice.verificaCodiceCorso(corso1));
  }

  @Test
  public void modificaCorso() {
    gestoreRightChoice.inserisciCorso(corso);
    gestoreRightChoice.modificaCorso(corso,"testmodifica","test","test","test");
    ArrayList<String> listaNomiCorsi = gestoreRightChoice.getNomeCorsi();
    assertThat(listaNomiCorsi, hasItems("testmodifica"));
  }


  @Test
  public void cancellaCorso() {
    gestoreRightChoice.inserisciCorso(corso);
    gestoreRightChoice.cancellaCorso(corso);
    ArrayList<Corso> lista = gestoreRightChoice.listaCorsi();
    assertThat(lista,not(hasItems(corso)));
  }
}