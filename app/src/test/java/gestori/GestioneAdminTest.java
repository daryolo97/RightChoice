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
import facade.GestoreRightChoice;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class GestioneAdminTest {
    private DatabaseHelper databaseHelper;
    private Context context;
    private GestoreRightChoice gestoreRightChoice;
    private Admin admin,admin1;

    @Before
    public void setUp() throws Exception {
        context = getInstrumentation().getContext();
        databaseHelper = new DatabaseHelper(context);
        gestoreRightChoice = new GestoreRightChoice(context);
        admin =  new Admin("admin1","admin");
        admin1 =  new Admin();
    }

    @Test
    public void inserisciAdmin() {
        gestoreRightChoice.inserisciAdmin(admin);
        assertNotNull(gestoreRightChoice.getAdmin());
    }
}