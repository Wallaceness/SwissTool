package com.example.swisstool.views;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.swisstool.R;
import com.example.swisstool.adapter.AnimalAdapter;
import com.example.swisstool.model.Animal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {

    private RecyclerView rvAnimals;
    private FloatingActionButton fabAddNewAnimal;
    private AnimalAdapter animalAdapter;
    private ArrayList<Animal> randomAnimals;
    AnimalInputFragment input;

    public AnimalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randomAnimals = new ArrayList();
        randomAnimals.add(new Animal("Amur Leopard", "Panthera pardus orientalis", "Critically Endangered"));
        randomAnimals.add(new Animal("Black Rhino", "Diceros bicornis", "Critically Endangered"));
        randomAnimals.add(new Animal("Bornean Orangutan", "Pongo pygmaeus", "Critically Endangered"));
        randomAnimals.add(new Animal("Cross River Gorilla", "Gorilla gorilla diehli", "Critically Endangered"));
        randomAnimals.add(new Animal("Eastern Lowland Gorilla", "Gorilla beringei graueri", "Critically Endangered"));
        randomAnimals.add(new Animal("Hawksbill Turtle", "Eretmochelys imbricata", "Critically Endangered"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        fabAddNewAnimal = view.findViewById(R.id.fabNewAnimal);
        rvAnimals = view.findViewById(R.id.rvAnimals);
        rvAnimals.setLayoutManager(new LinearLayoutManager(requireContext()));
        animalAdapter = new AnimalAdapter();
        input = new AnimalInputFragment();
        rvAnimals.setAdapter(animalAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fabAddNewAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().add(R.id.animal_parent, input).addToBackStack(null).commit();
            }
        });
    }

    public void createAnimal(Animal animal){
        animalAdapter.addNewAnimal(animal);
    }

    public void createRandomAnimal(){
        Animal species = randomAnimals.get((int)(Math.random()*randomAnimals.size()));
        Toast.makeText(this.getContext(), "YOU ADDED ANIMAL "+species.getName(), Toast.LENGTH_SHORT).show();
        animalAdapter.addNewAnimal(species);
    }
}
