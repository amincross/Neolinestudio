package com.neolinestudio.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.neolinestudio.app.R;
import com.neolinestudio.app.fragments.CustomBottomSheetDialogFragment;
import com.neolinestudio.app.models.MyData;

import java.util.List;

// MyAdapter.java
public class MainPostAdapter extends RecyclerView.Adapter<MainPostAdapter.ViewHolder> {
    private List<MyData> items;
    private Context context;
    private FragmentManager fragmentManager;

    public MainPostAdapter(List<MyData> items, FragmentManager fragmentManager) {
        this.items = items;
        this.fragmentManager = fragmentManager;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyData item = items.get(position);

        // Bind data to the views
        holder.avatarImageView.setImageResource(item.getAvatar());
        holder.usernameTextView.setText(item.getUsername());
        holder.onlineTimeTextView.setText(item.getOnlineTime());
        holder.longTextView.setText(item.getLongText());
        holder.bigImageView.setImageResource(item.getBigImage());

        holder.viewCountTextView.setText(getCount(item.getViewCount()) +" View");
        holder.likeCountTextView.setText(String.valueOf(getCount(item.getLikeCount())));
        holder.commentCountTextView.setText(String.valueOf(getCount(item.getCommentCount())));
        holder.retweetCountTextView.setText(String.valueOf(getCount(item.getRetweetCount())));


        holder.llBid.setVisibility((item.isCanBid())?View.VISIBLE:View.GONE);
        holder.line.setVisibility((item.isCanBid())?View.VISIBLE:View.GONE);

        holder.btnBid.setOnClickListener(view -> {
            _showBottomSheet();
        });


        holder.commentCountTextView.setOnClickListener(view -> {

            BottomSheetDialog commentSheetDialog = new BottomSheetDialog(context);
            View successBottomSheetView = LayoutInflater.from(context).inflate(R.layout.comment_bottom_sheet_layout, null);
            commentSheetDialog.setContentView(successBottomSheetView);
            commentSheetDialog.show();

            Button btnPost=successBottomSheetView.findViewById(R.id.btnPost);
            btnPost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    commentSheetDialog.dismiss();
                }
            });

        });

        // Set click listeners for the buttons if necessary
    }

    private void _showBottomSheet() {

        // Create a BottomSheetDialog instance
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);

        // Inflate the layout for the bottom sheet
        View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout, null);

        // Set the view for the bottom sheet dialog
        bottomSheetDialog.setContentView(bottomSheetView);

        // Show the bottom sheet dialog
        bottomSheetDialog.show();

        AppCompatButton btnSubmit=bottomSheetView.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();

                BottomSheetDialog successBottomSheetDialog = new BottomSheetDialog(context);
                View successBottomSheetView = LayoutInflater.from(context).inflate(R.layout.success_bottom_sheet_layout, null);
                successBottomSheetDialog.setContentView(successBottomSheetView);
                successBottomSheetDialog.show();

                Button btnSubmit=successBottomSheetView.findViewById(R.id.btnSubmit);
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        successBottomSheetDialog.dismiss();
                    }
                });

            }
        });




        /*CustomBottomSheetDialogFragment bottomSheetDialogFragment = new CustomBottomSheetDialogFragment();
        bottomSheetDialogFragment.show(fragmentManager, "custom_bottom_sheet");*/

    }

    private String getCount(int number) {
        if (number >= 1000) {
            int quotient = number / 1000;
            int remainder = number % 1000;
            String result = quotient + "k";

            if (remainder > 0) {
                result += remainder;
            }

            return result;
        } else {
            return String.valueOf(number);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    // ViewHolder class for caching the views
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatarImageView;
        private TextView usernameTextView;
        private TextView onlineTimeTextView;
        private TextView longTextView;
        private ImageView bigImageView;

        private TextView viewCountTextView;
        private TextView likeCountTextView;
        private TextView commentCountTextView;
        private TextView retweetCountTextView;

        private LinearLayoutCompat llBid;
        private FrameLayout line;
        private AppCompatButton btnBid;

        public ViewHolder(View itemView) {
            super(itemView);

            avatarImageView = itemView.findViewById(R.id.avatarImageView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            onlineTimeTextView = itemView.findViewById(R.id.onlineTimeTextView);
            longTextView = itemView.findViewById(R.id.longTextView);
            bigImageView = itemView.findViewById(R.id.bigImageView);

            likeCountTextView = itemView.findViewById(R.id.likeCountTextView);
            commentCountTextView = itemView.findViewById(R.id.commentCountTextView);
            retweetCountTextView = itemView.findViewById(R.id.retweetCountTextView);
            viewCountTextView = itemView.findViewById(R.id.viewCountTextView);

            llBid = itemView.findViewById(R.id.llBid);
            line = itemView.findViewById(R.id.line);
            btnBid = itemView.findViewById(R.id.btnBid);
        }
    }
}
