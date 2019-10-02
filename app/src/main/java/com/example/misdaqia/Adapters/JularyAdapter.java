package com.example.misdaqia.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.misdaqia.Helper.MainFontTextview;
import com.example.misdaqia.Model.JularyModel;
import com.example.misdaqia.R;

import java.util.ArrayList;

public class JularyAdapter extends RecyclerView.Adapter<JularyAdapter.view_holder> {


    class view_holder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        private ImageView jularyImage;
        private MainFontTextview jularyName;
        private MainFontTextview jularyMazadType;
        private MainFontTextview jularyPrice;
        private MainFontTextview jularyViews;
        private MainFontTextview jularyLocation;
        private MainFontTextview jularyTime;




        public view_holder(@NonNull View itemView) {
            super(itemView);

            initView(itemView);
        }

        private void initView(View view) {
//            jularyImage = (ImageView)view.findViewById(R.id.julary_image);
            jularyName = (MainFontTextview)view.findViewById(R.id.julary_name);
            jularyMazadType = (MainFontTextview)view.findViewById(R.id.julary_mazadType);
            jularyPrice = (MainFontTextview)view.findViewById(R.id.julary_price);
            jularyViews = (MainFontTextview)view.findViewById(R.id.julary_views);
            jularyLocation = (MainFontTextview)view.findViewById(R.id.julary_location);
            jularyTime = (MainFontTextview)view.findViewById(R.id.julary_time);
        }

        @Override
        public void onClick(View view) {

        }
    }

    Context context;
    ArrayList<JularyModel> Julary_list;
    JularyAdapter.ClickListener clickListener;

    public JularyAdapter(Context context, ArrayList<JularyModel> julary_list, ClickListener clickListener) {
        this.context = context;
        Julary_list = julary_list;
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position);

    }
    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.julary_item, null);

        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder view_holder, final int i) {

        view_holder.jularyName.setText(Julary_list.get(i).type);
        view_holder.jularyMazadType.setText(Julary_list.get(i).Auction_type);
        view_holder.jularyLocation.setText(Julary_list.get(i).location);
        view_holder.jularyViews.setText(""+Julary_list.get(i).viewers);
        view_holder.jularyTime.setText(Julary_list.get(i).updated_at);
        view_holder.jularyPrice.setText(""+Julary_list.get(i).price);
        view_holder.jularyLocation.setText(Julary_list.get(i).location);

        view_holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Julary_list.size();
    }

}
