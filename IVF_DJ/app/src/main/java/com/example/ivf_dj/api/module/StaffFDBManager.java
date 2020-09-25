package com.example.ivf_dj.api.module;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.ivf_dj.model.Staff;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import io.reactivex.Observable;

public class StaffFDBManager {
    public static final String NOT_STAFF = "NOT_STAFF";
    private DatabaseReference staffReference;
    private static StaffFDBManager instance;
    private Gson gson = new Gson();

    public static StaffFDBManager getInstance() {
        if (instance == null) {
            instance = new StaffFDBManager();
        }
        return instance;
    }

    private StaffFDBManager() {
        staffReference = FirebaseDatabase.getInstance().getReference().child("staff");
    }

    public Observable<String> isStaff(String gMail) {
        return Observable.create(emitter -> {
            staffReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        String json = gson.toJson(data.getValue());
                        Staff staff = gson.fromJson(json, Staff.class);

                        if (staff.getMail().equals(gMail)) {
                            emitter.onNext(staff.getName());
                            emitter.onComplete();
                        }
                    }
                    emitter.onNext(NOT_STAFF);
                    emitter.onComplete();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.d("error", "isStaff onCancelled: " + error.getMessage());
                }
            });
        });
    }

    public void addStaff(Staff staff) {
        String lectureKey = staffReference.push().getKey();
        Log.d("test_by_sungchul", "addLecture: key : " + lectureKey);
        if (lectureKey != null) {
            staffReference.child(lectureKey).setValue(staff);
        }
    }
}
