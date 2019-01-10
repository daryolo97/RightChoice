package interfacce;

import java.util.ArrayList;

import entità.Corso;
import entità.Feedback;

public interface InterfacciaFeedback {
    long inserisciFeedback(Feedback feedback, Corso corso);
    long inserisciFeedback(Feedback feedback);
    ArrayList<Feedback> getAllFeedback();
    void deleteFeedback(Feedback feedback);
    void setStatoFeedback(Feedback feedback);
    }
