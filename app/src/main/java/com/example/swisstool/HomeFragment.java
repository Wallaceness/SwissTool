package com.example.swisstool;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeAdapter.HomeAdapterInteraction {

    private RecyclerView rvHome;
    private HomeAdapter adapter;
    private HomeFragmentInteraction listener;

    public HomeFragment() {
        // Required empty public constructor
    }

    HomeFragment(HomeFragmentInteraction listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHome = view.findViewById(R.id.rvHome);
        rvHome.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvHome.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));
        adapter = new HomeAdapter(
                Arrays.asList(HomeOptions.ALPHABET_VIEWER, HomeOptions.STRESS_TAPPER, HomeOptions.BIRTHSTONES)
        );
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.setListener(this);
        rvHome.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(HomeOptions itemName) {
        Toast.makeText(requireContext(), itemName.getName(), Toast.LENGTH_SHORT).show();
        if (listener == null) {
            return;
        }
        switch (itemName) {
            case ALPHABET_VIEWER:
                listener.loadAlphabetViewer();
                break;
            case STRESS_TAPPER:
                listener.loadStressTapper();
                break;
            case BIRTHSTONES:
                listener.loadBirthstones();
                break;
        }
    }

    interface HomeFragmentInteraction {
        void loadAlphabetViewer();

        void loadStressTapper();

        void loadBirthstones();
    }
}
