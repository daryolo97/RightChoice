package utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dario.rchoice.R;

import entity.Feedback;

import java.util.List;

public class CustomAdapterFeedback extends ArrayAdapter<Feedback> {
  private Context context;

  public CustomAdapterFeedback(Context context, int resource, List<Feedback> objects) {
    super(context, resource, objects);
    this.context = context;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    convertView = LayoutInflater.from(context).inflate(R.layout.layout_feedback, null);
    TextView tvTitoloFeedback = convertView.findViewById(R.id.titoloFeedbackListView);
    TextView tvMessaggioFeedback = convertView.findViewById(R.id.messaggioFeedbackListView);

    Feedback feedback = getItem(position);
    tvTitoloFeedback.setText(feedback.getTitolo());
    tvMessaggioFeedback.setText(feedback.getDescrizione());

    return convertView;

  }

}
