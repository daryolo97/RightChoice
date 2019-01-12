package gestori;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import database.DatabaseHelper;
import entità.Admin;
import entità.Corso;
import entità.Feedback;
import facade.GestoreRightChoice;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class GestioneAdminTest {
    private DatabaseHelper databaseHelper;
    private Context context;
    private GestoreRightChoice gestoreRightChoice;
    private Admin admin,admin1;
    private Feedback feedback;

    @Before
    public void setUp() throws Exception {
        context = getInstrumentation().getContext();
        databaseHelper = new DatabaseHelper(context);
        gestoreRightChoice = new GestoreRightChoice(context);
        admin =  new Admin("admin1","admin");
        feedback = new Feedback();

    }

    @Test
    public void inserisciAdmin() {
        gestoreRightChoice.inserisciAdmin(admin);
        assertNotNull(gestoreRightChoice.getAdmin());
    }


    @Test
    public void loginAdmin() {
        gestoreRightChoice.inserisciAdmin(admin);
        assertTrue(gestoreRightChoice.loginAdmin("admin1","admin"));
        assertFalse(gestoreRightChoice.loginAdmin("test","test"));
    }

    @Test
    public void convalidaFeedback() {
        gestoreRightChoice.convalidaFeedback(feedback);
        assertTrue(feedback.getStato()==1);
        assertFalse(feedback.getStato()==0);
    }

    @Test
    public void verificaUsernameAdmin() {
        gestoreRightChoice.inserisciAdmin(admin);
        assertTrue(gestoreRightChoice.verificaUsernameAdmin("admin1"));
        assertFalse(gestoreRightChoice.verificaUsernameAdmin(admin.getUsername()));
    }
}