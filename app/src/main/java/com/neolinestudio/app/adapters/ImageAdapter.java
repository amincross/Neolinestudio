package com.neolinestudio.app.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.neolinestudio.app.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private final List<Integer> imageList;
    private final List<String> textList;
    private final Context context;

    public ImageAdapter(List<Integer> imageList,List<String> textList, Context context) {
        this.imageList = imageList;
        this.textList = textList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int imageResource = imageList.get(position);

        holder.imageView.setImageResource(imageResource);


        if(imageResource==R.drawable.ic_add){
            holder.imageView.setBackgroundResource(R.drawable.add_bg);
            holder.imageView.setPadding(34,34,34,34);
            holder.textView.setText(R.string.your_cut);
        }else{
            holder.imageView.setBackgroundResource(R.drawable.other_bg);

            Drawable originalDrawable = holder.imageView.getDrawable();
            Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();
            RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), originalBitmap);
            roundedDrawable.setCornerRadius(250f);
            holder.imageView.setImageDrawable(roundedDrawable);

            holder.textView.setText(textList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}

