package com.test.alodoktertes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.test.alodoktertes.R;

import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder> {
    List<String> listHome;
    private Context context;
    private HomeFragmentAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(String listHome);
    }


    public HomeFragmentAdapter(List<String> listHome, Context context , HomeFragmentAdapter.OnItemClickListener listener) {
        super();
        this.listHome = listHome;
        this.context = context;
        this.mListener = listener;

    }

    @Override
    public HomeFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentAdapter.ViewHolder holder, int position) {
        final String gambar = listHome.get(position);
        if (gambar.equals("cat"))
            holder.imgHome.setImageResource(R.mipmap.cat_home);
        else if (gambar.equals("dog"))
            holder.imgHome.setImageResource(R.mipmap.dog_home);
        else if (gambar.equals("bird"))
            holder.imgHome.setImageResource(R.mipmap.bird_home);
        else if (gambar.equals("bear"))
            holder.imgHome.setImageResource(R.mipmap.bear_home);

        holder.imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(gambar);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHome.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHome;
        public ViewHolder(View itemView) {
            super(itemView);
            imgHome = itemView.findViewById(R.id.img_home);

        }
    }
}
