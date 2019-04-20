package com.example.cesaro.cloudfirestore;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    FirebaseFirestore db;
    RecyclerView recyclerView;


    ArrayList<Disco> discoArrayList;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        discoArrayList = new ArrayList<>();

        sup();
        supFB();
     //   addDataTest();
        loadDatafFB();
    }

    private void loadDatafFB() {


        if (discoArrayList.size()>0){
            discoArrayList.clear();
        }

        db.collection("Disco")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot doc: task.getResult()){

                            Disco disco = new Disco(doc.getString("name"), doc.getString("desc"),
                                    doc.getString("time"), doc.getString("urlImage"));

                            discoArrayList.add(disco);
                        }

                        adapter = new Adapter(RecyclerViewActivity.this,discoArrayList);
                        recyclerView.setAdapter(adapter);
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RecyclerViewActivity.this, "fuck", Toast.LENGTH_SHORT).show();
                        Log.w("--1--",e.getMessage());
                    }
                });
    }

    private void addDataTest() {

        Random r = new Random();


        for (int i= 0; i<2; i++) {

            Map<String,String> dataMap = new HashMap();
            dataMap.put("name","Yo" + r.nextInt(50));
            dataMap.put("desc","Cesar"  + r.nextInt(50));
            dataMap.put("time","1:20"  + r.nextInt(50));
            db.collection("Disco")
                    .add(dataMap)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(RecyclerViewActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    }

    private void supFB() {

        db = FirebaseFirestore.getInstance();

    }

    private void sup() {

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
