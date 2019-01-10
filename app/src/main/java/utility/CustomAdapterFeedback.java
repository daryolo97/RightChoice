package utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dario.rchoice.R;

import java.util.List;

import entità.Feedback;

public class CustomAdapterFeedback extends ArrayAdapter<Feedback> {

    private Context context;

    public CustomAdapterFeedback(Context context, int resource, List<Feedback> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.layout_feedback, null);
        TextView TVtitoloFeedback = convertView.findViewById(R.id.titoloFeedbackListView);
        TextView TVmessaggioFeedback = convertView.findViewById(R.id.messaggioFeedbackListView);


        Feedback feedback = getItem(position);
        TVtitoloFeedback.setText(feedback.getTitolo());
        TVmessaggioFeedback.setText(feedback.getDescrizione());

        return convertView;

    }

}
