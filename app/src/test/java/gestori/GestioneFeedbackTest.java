package gestori;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Corso;
import entità.Feedback;
import facade.GestoreRightChoice;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class GestioneFeedbackTest {
    private DatabaseHelper databaseHelper;
    private Context context;
    private GestoreRightChoice gestoreRightChoice;
    private Corso corso,corso1;
    private Feedback feedback;

    @Before
    public void setUp() throws Exception {
        context = getInstrumentation().getContext();
        databaseHelper = new DatabaseHelper(context);
        corso = new Corso("test", "nome", "docente", "descrizione", "link");
        corso1 = new Corso("test1", "nome", "docente", "descrizione", "link");
        gestoreRightChoice = new GestoreRightChoice(context);
    }

    @Test
    public void inserisciFeedback() {

        feedback = new Feedback("codice1","brutto","boh",1);
        gestoreRightChoice.inserisciFeedback(feedback);
        ArrayList<Feedback> lista = gestoreRightChoice.listaFeedback();
        String titolo = (lista.get(0).getTitolo());
        assertTrue(feedback.getTitolo().equals(titolo));
    }

    @Test
    public void cancellaFeedback() {
        feedback = new Feedback("codice1","brutto","boh",1);
        gestoreRightChoice.inserisciFeedback(feedback);
        gestoreRightChoice.cancellaFeedback(feedback);
        ArrayList<Feedback> lista = gestoreRightChoice.listaFeedback();
        assertTrue(lista.isEmpty());


    }

    @Test
    public void setStatoFeedback() {
        feedback = new Feedback("codice12","bruttoo","test",0);
        gestoreRightChoice.inserisciFeedback(feedback);
        gestoreRightChoice.setStatoFeedback(feedback);
        ArrayList<Feedback> lista = gestoreRightChoice.listaFeedback();
        assertTrue(lista.get(0).getStato()==1);
    }
}