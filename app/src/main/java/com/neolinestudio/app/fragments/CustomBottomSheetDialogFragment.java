package com.neolinestudio.app.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.neolinestudio.app.R;

public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        // Set custom background
        Window window = getDialog().getWindow();
        if (window != null) {
            Drawable background = ContextCompat.getDrawable(requireContext(), R.drawable.bottom_sheet_background);
            if (background != null) {
                background.setAlpha(255); // You can adjust the alpha value if needed
                window.setBackgroundDrawable(background);
            }
        }

        // Other setup code...

        return view;
    }

    // Other methods...
}
