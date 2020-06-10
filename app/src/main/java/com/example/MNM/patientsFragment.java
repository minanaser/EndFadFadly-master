package com.example.MNM;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class patientsFragment extends Fragment {

    RecyclerView recyclerView;
    AdapterPatients adapterPatients;
    List<ModelPatient>modelPatientList;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    public patientsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        modelPatientList =new ArrayList<>();
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_patients, container, false);
         recyclerView = view.findViewById(R.id.patient_fragment_recyclerView);
         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
         adapterPatients = new AdapterPatients(view.getContext(),modelPatientList);
         recyclerView.setAdapter(adapterPatients);
         databaseReference = FirebaseDatabase.getInstance().getReference("user");
         databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelPatientList.clear();
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    ModelPatient modelUser = ds.getValue(ModelPatient.class);
                    modelPatientList.add(modelUser);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
         return view;
    }

  /*  private void getAllPatient() {
        final FirebaseUser fuser = firebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelPatientList.clear();
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    ModelPatient modelUser = ds.getValue(ModelPatient.class);

                    if(!modelUser.getPaientID().equals(fuser.getUid())){
                        modelPatientList.add(modelUser);
                    }

                    adapterPatients = new AdapterPatients(getActivity(),modelPatientList);

                    recyclerView.setAdapter(adapterPatients);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

*/
}
