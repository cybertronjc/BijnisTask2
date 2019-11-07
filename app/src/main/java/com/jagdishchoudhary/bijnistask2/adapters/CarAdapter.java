package com.jagdishchoudhary.bijnistask2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.jagdishchoudhary.bijnistask2.R;
import com.jagdishchoudhary.bijnistask2.entity.Car;
import com.jagdishchoudhary.bijnistask2.ui.ProductDetails;
import com.jagdishchoudhary.bijnistask2.ui.ProductsListing;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder>{
    private List<Car> carsList;
    private Context context;
    ProductsListing.OnFragmentInteractionListener mListner;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public ImageView imageView;
        public CardView carCard;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.carname);
            price  = view.findViewById(R.id.carprice);
            imageView = view.findViewById(R.id.car_image);
            carCard = view.findViewById(R.id.car_card);
        }
    }


    public CarAdapter(Context context, List<Car> carsLists, ProductsListing.OnFragmentInteractionListener onFragmentInteractionListener) {
        this.context = context;
        this.carsList = carsLists;
        this.mListner = onFragmentInteractionListener;
    }

    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new CarAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CarAdapter.MyViewHolder holder, int position) {
        final Car car = carsList.get(position);

        holder.title.setText(car.getCar_name());
        holder.price.setText(car.getCar_price());

        Picasso.get().load(car.getCar_image()).into(holder.imageView);

        holder.carCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((FragmentActivity)view.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.rootLayout, new ProductDetails()).addToBackStack("product").commit();
                mListner.onFragmentInteraction(car.getCar_name(), car.getCar_price());
            }
        });




    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }
}