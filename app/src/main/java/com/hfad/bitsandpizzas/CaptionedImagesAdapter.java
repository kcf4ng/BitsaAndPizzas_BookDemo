package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{
    private  String[] captions;
    private int[] imageIds;
    private Listener listener;

    interface  Listener{
        void onClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CaptionedImagesAdapter(String[] captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        CardView cv = (CardView) LayoutInflater.from( viewGroup.getContext())
                .inflate(R.layout.card_captioned_image,viewGroup,false) ;

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final CardView cardView = holder.cardView;
        ImageView imageView  = cardView.findViewById(R.id.info_image);
        TextView textView = cardView.findViewById(R.id.info_text);

        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);

        textView.setText(captions[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(position);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }


}
