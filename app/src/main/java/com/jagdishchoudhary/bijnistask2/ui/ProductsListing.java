package com.jagdishchoudhary.bijnistask2.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jagdishchoudhary.bijnistask2.R;
import com.jagdishchoudhary.bijnistask2.adapters.CarAdapter;
import com.jagdishchoudhary.bijnistask2.entity.Car;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductsListing.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductsListing#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductsListing extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Car> carArrayList;
    CarAdapter carAdapter;

    private OnFragmentInteractionListener mListener;

    public ProductsListing() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductsListing.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductsListing newInstance(String param1, String param2) {
        ProductsListing fragment = new ProductsListing();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_products_listing, container, false);

        recyclerView = view.findViewById(R.id.products_recycler_view);
        recyclerView.setHasFixedSize(true);
        carArrayList = new ArrayList<>();

        Toast.makeText(getActivity(), "You are on Product listing fragment", Toast.LENGTH_SHORT).show();

        prepareData();

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        carAdapter = new CarAdapter(getActivity(), carArrayList, mListener);
        recyclerView.setAdapter(carAdapter);




        return view;
    }

    private void prepareData() {

        Car car1 = new Car("Baleno", R.drawable.baleno, "Price : 5L");
        carArrayList.add(car1);

        Car car2 = new Car("Brezza", R.drawable.breza, "Price : 8L");
        carArrayList.add(car2);

        Car car3 = new Car("Elite", R.drawable.elite, "Price : 9L");
        carArrayList.add(car3);




    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String name, String price) {
        if (mListener != null) {
            mListener.onFragmentInteraction(name, price);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
//
//    FragmentCommunication communication=new FragmentCommunication() {
//        @Override
//        public void respond(int position,String name,String job) {
//            FragmentB fragmentB=new FragmentB();
//            Bundle bundle=new Bundle();
//            bundle.putString("NAME",name);
//            bundle.putString("JOB",job);
//            fragmentB.setArguments(bundle);
//            FragmentManager manager=getFragmentManager();
//            FragmentTransaction transaction=manager.beginTransaction();
//            transaction.replace(R.id.dumper,fragmentB).commit();
//        }
//
//    };



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String name, String price);

    }
}
