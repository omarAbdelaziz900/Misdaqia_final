package com.example.misdaqia.Adapters;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.transition.TransitionManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.misdaqia.Helper.HeaderFontTextview;
import com.example.misdaqia.Model.NavigationDrawerItem;
import com.example.misdaqia.R;
import com.example.misdaqia.SharedPreferences.PreferenceHelper;


import java.util.Collections;
import java.util.List;

public class NavigationDrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    //    private HomePresenter presenter;
    private int selectedItem = 1;
    private static final int HEADER_VIEW_TYPE = 1;
    private static final int MENU_TYPE = 2;
    private List<NavigationDrawerItem> data = Collections.emptyList();
    NavigationDrawerItem[] drawerItem=new NavigationDrawerItem[3];
    private LayoutInflater inflater;
    private Context context;

    itemClicked onitemClicked;
    //    public NavigationDrawerAdapter(Context context, HomePresenter presenter, List<NavigationDrawerItem> data) {
//        this.presenter = presenter;
//        this.context = context;
//        this.data = data;
//        inflater = LayoutInflater.from(context);
//    }
    public NavigationDrawerAdapter(Context context, List<NavigationDrawerItem> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void setSelectedItem(int selectedItem) {
        int oldSelected = this.selectedItem;
        this.selectedItem = selectedItem;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case HEADER_VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_header_navigation_view, parent, false);
                return new HeaderViewHolder(view);
            case MENU_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_navigation_drawer, parent, false);
                return new MenuViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        NavigationDrawerItem object = data.get(position);
//        Log.d("local", UserData.getLocalization(context) + "");
        if (object != null) {
            switch (object.getType()) {
                case HEADER_VIEW_TYPE:
                    ((HeaderViewHolder) holder).img_close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            presenter.closeDrawer();
                            if (onitemClicked != null)
                                onitemClicked.onCloseImageClicked(((HeaderViewHolder) holder).img_close,position);
                        }
                    });

                    if (PreferenceHelper.getUserFirstName(context)!=null){
                        ((HeaderViewHolder) holder).txt_userName.setText(PreferenceHelper.getUserFirstName(context));
                    }

                    break;
                case MENU_TYPE:
//                    if (position == selectedItem) {
//                        ((MenuViewHolder) holder).background.setBackgroundColor(ContextCompat.getColor(context, R.color.menu_item_selected));
//                    } else {
//                        ((MenuViewHolder) holder).background.setBackgroundColor(ContextCompat.getColor(context, R.color.menu_item_unselected));
//                    }
                    ((MenuViewHolder) holder).mTitle.setText(object.getTitle());
                    ((MenuViewHolder) holder).mImage.setImageResource(object.getImage());
                    ((MenuViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (onitemClicked != null) onitemClicked.onItemClicked(((MenuViewHolder) holder).view,position);
                        }
                    });
//                    setSelectedItem(position);
//                    ((MenuViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            setSelectedItem(position);
//                            switch (position) {
//                                case 1:
//                                    presenter.openHome();
//                                    break;
//                                case 2:
//                                    presenter.openFragment(new NearbyFragment());
//                                    break;
//                                case 3:
//                                    presenter.openFragment(new FavoriteFragment());
//                                    break;
//                                case 4:
//                                    presenter.openFragment(new NewsFragment());
//                                    break;
//                                case 5:
//                                    presenter.openFragment(new TransportFragment());
//                                    break;
//                                case 6:
//                                    presenter.openFragment(new AboutUSFragment());
//                                    break;
//                                case 7:
//                                    presenter.openFragment(new ContactUSFragment());
//                                    break;
//                                case 8:
//                                    presenter.openFragment(new FAQFragment());
//                                    break;
//                                case 9:
//                                    presenter.openFragment(new SettingsFragment());
//                                    break;
//                                case 10:
//                                    presenter.openFragment(new EmergencyFragment());
//                                    break;
//                            }
//                        }
//                    });
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (data != null) {
            NavigationDrawerItem object = data.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        return data.size();
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        ImageView img_close;
        HeaderFontTextview txt_userName;

        HeaderViewHolder(View itemView) {
            super(itemView);
            txt_userName=itemView.findViewById(R.id.txt_userName);
            img_close=itemView.findViewById(R.id.img_close);


//            menu.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (onitemClicked != null)
//                        onitemClicked.onCloseImageClicked(menu,getAdapterPosition());
//                    Log.e("kkkk","kkkk");
//                }
//            });
        }
//        @OnClick(R.id.close)
//        public void removeItem() {
//            if (onitemClicked != null)
//                onitemClicked.onCloseImageClicked(menu,getAdapterPosition());
//            Log.e("kkkk","kkkk");
//        }
    }


    public class MenuViewHolder extends RecyclerView.ViewHolder {
        HeaderFontTextview mTitle;
        ImageView mImage;
        RelativeLayout background;;
        boolean visible;
        View view;
        MenuViewHolder(View itemView) {
            super(itemView);
            mTitle=itemView.findViewById(R.id.menu_item_text_view);
            mImage=itemView.findViewById(R.id.menu_item_image_view);
            background=itemView.findViewById(R.id.background);
            view=itemView;
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (onitemClicked != null) onitemClicked.onItemClicked(itemView,getAdapterPosition());
//                }
//            });

            background.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });

        }
    }

    public void setOnitemClicked(itemClicked onitemClicked) {
        this.onitemClicked = onitemClicked;
    }

    public interface itemClicked {
        void onItemClicked(View itemView,int position);
        void onCloseImageClicked(ImageView imageView,int position);
    }

}
