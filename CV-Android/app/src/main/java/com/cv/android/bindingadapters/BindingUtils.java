package com.cv.android.bindingadapters;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.cv.android.R;
import com.squareup.picasso.Picasso;

public class BindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .fit()
                .centerInside()
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerInside()
                .into(view);
    }
}