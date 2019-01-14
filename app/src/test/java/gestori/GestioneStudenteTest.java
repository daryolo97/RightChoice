package gestori;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Admin;
import entità.Feedback;
import entità.Studente;
import facade.GestoreRightChoice;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class GestioneStudenteTest {
    private DatabaseHelper databaseHelper;
    private Context context;
    private GestoreRightChoice gestoreRightChoice;
    private Studente studentetest,studentetest1,studente;

    @Before
    public void setUp() throws Exception {
        context = getInstrumentation().getContext();
        databaseHelper = new DatabaseHelper(context);
        gestoreRightChoice = new GestoreRightChoice(context);
        studentetest = new Studente(123435,"miky","miky97","michele","ruocco");
        studentetest1 = new Studente(123455,"miky12","miky97","michele","ruocco");
    }
    @Test
    public void inserisciStudente() {
        gestoreRightChoice.inserisciStudente(studentetest);
        ArrayList<Studente> listastudenti = gestoreRightChoice.listaStudenti();
        assertTrue(listastudenti.get(0).getMatricola()==studentetest.getMatricola());
        assertFalse(listastudenti.get(0).getMatricola()==studentetest1.getMatricola());
    }


    @Test
    public void verificaEsistenzaStudenti() {
        gestoreRightChoice.inserisciStudente(studentetest);
        assertTrue(gestoreRightChoice.verificaEsistenzaStudenti("miky","miky97"));
        assertFalse(gestoreRightChoice.verificaEsistenzaStudenti("test","test"));
    }

    @Test
    public void verificaUsernameStudente() {
        gestoreRightChoice.inserisciStudente(studentetest);
        assertFalse(gestoreRightChoice.verificaUsernameStudente(studente));
        assertFalse(gestoreRightChoice.verificaUsernameStudente(studentetest));
        assertTrue(gestoreRightChoice.verificaUsernameStudente(studentetest1));
    }

    @Test
    public void verificaMatricolaStudente() {
        gestoreRightChoice.inserisciStudente(studentetest);
        assertFalse(gestoreRightChoice.verificaMatricolaStudente(studente));
        assertFalse(gestoreRightChoice.verificaMatricolaStudente(studentetest));
        assertTrue(gestoreRightChoice.verificaMatricolaStudente(studentetest1));
    }
}