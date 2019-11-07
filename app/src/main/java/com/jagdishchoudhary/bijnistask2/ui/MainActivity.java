package com.jagdishchoudhary.bijnistask2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;

import com.jagdishchoudhary.bijnistask2.R;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, ProductsListing.OnFragmentInteractionListener, ProductDetails.OnFragmentInteractionListener{

    final FragmentManager fm = getSupportFragmentManager();

    Fragment homeFragment = new HomeFragment();
    Fragment productsFragment = new ProductsListing();
    Fragment product = new ProductDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm.beginTransaction().add(R.id.rootLayout, homeFragment, "Home").commit();


        //addFragment(homeFragment, true, "home");
    }



    @Override
    public void onFragmentInteraction(String uri) {
            addFragment(homeFragment, false, "Home");
            //fm.popBackStack("ProductListing", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onHomeFragmentInteraction(String uri) {
        addFragment(productsFragment, true, "ProductListing");
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.rootLayout, fragment, tag);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onFragmentInteraction(String name, String price) {
        addFragment(product, true, "ProductDetails");
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("price", price);
        product.setArguments(bundle);
    }
}
