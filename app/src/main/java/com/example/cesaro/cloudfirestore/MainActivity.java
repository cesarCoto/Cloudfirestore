package com.example.cesaro.cloudfirestore;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();


        textView = findViewById(R.id.title);


        /**Objetos**/
        DocumentReference c = db.collection("Books").document("1");
        c.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Book readC = documentSnapshot.toObject(Book.class);
                StringBuilder data = new StringBuilder("");
                data.append("Name: ").append(readC.getName());
                data.append("\nEmail: ").append(readC.getEmail());
                data.append("\nNumber: ").append(readC.getNumber());


                textView.setText(data.toString());

            }
        });

        /** Leer datos simples**/
        /*
        DocumentReference contact = db.collection("Books").document("1");
        contact.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder data = new StringBuilder("");
                    data.append("Name: ").append(doc.getString("name"));
                    data.append("\nEmail: ").append(doc.getString("email"));
                    data.append("\nNumber: ").append(doc.getString("number"));


                    textView.setText(data.toString());
                }
            }
        });
*/

       /** Codigo para agregar datos**/
      /*  Map<String,Object> newContact = new HashMap<>();

        newContact.put("name", "Cesar");
        newContact.put("email", "Cesar@gmail.com");
        newContact.put("number", "9821061395");

        db.collection("Books").document("1")
                .set(newContact)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Error",e.getMessage());
                    }
                });

        */


    }
}
