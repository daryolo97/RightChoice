package interfacce;

import java.util.ArrayList;

import entità.Corso;
import entità.Feedback;

public interface InterfacciaFeedback {
    void inserisciFeedback(Feedback feedback, Corso corso);
    void inserisciFeedback(Feedback feedback);
    ArrayList<Feedback> getAllFeedback();
    void deleteFeedback(Feedback feedback);
    void setStatoFeedback(Feedback feedback);
    }
