package com.example.swisstool.views;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.swisstool.R;
import com.example.swisstool.model.Animal;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalInputFragment extends Fragment {
    EditText animalName;
    Button submit;
    Button Random;

    public AnimalInputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =inflater.inflate(R.layout.fragment_animal_input, container, false);
        submit = rootview.findViewById(R.id.button1);
        animalName= rootview.findViewById(R.id.editText1);
        Random = rootview.findViewById(R.id.button2);
        final AnimalFragment parent = (AnimalFragment) getParentFragment();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal newAnimal = new Animal(animalName.getText().toString(), "none", "none");

//                AnimalFragment parent = (AnimalFragment) getParentFragment();
                parent.createAnimal(newAnimal);
                getFragmentManager().beginTransaction().remove(AnimalInputFragment.this).commit();
            }
        });

        Random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.createRandomAnimal();
                getFragmentManager().beginTransaction().remove(AnimalInputFragment.this).commit();
            }
        });
        return rootview;
    }

}
