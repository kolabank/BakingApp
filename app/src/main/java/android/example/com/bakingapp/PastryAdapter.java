package android.example.com.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

class PastryAdapter extends RecyclerView.Adapter<PastryAdapter.ViewHolder> {

    private ArrayList<String> pastryCaption;

  //final private Listener mListener;
    Listener listener;

  private Context context;

   public interface Listener{
        void onClick (int position);


    }

    public PastryAdapter(ArrayList<String> pastryCaption, Context context) {
        this.pastryCaption = pastryCaption;

        listener = (Listener) context;
     //   mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CardView cv = (CardView)LayoutInflater.
                from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        CardView cardView = holder.cardView;
        TextView textView = cardView.findViewById(R.id.txt_pastry);
        textView.setText(pastryCaption.get(position));

    }

    @Override
    public int getItemCount() {
        return pastryCaption.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;

    public ViewHolder(CardView view){
        super (view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClick(getAdapterPosition());

            }
        });
        cardView = view;

    }

  /*      @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
          //  mListener.onClick(clickedPosition);
        }

       */


    }


}



