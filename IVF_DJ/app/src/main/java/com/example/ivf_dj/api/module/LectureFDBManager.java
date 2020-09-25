package com.example.ivf_dj.api.module;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.ivf_dj.model.Lecture;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class LectureFDBManager {
    private DatabaseReference lectureReference;
    private static LectureFDBManager instance;
    private Gson gson = new Gson();

    public static LectureFDBManager getInstance() {
        if (instance == null) {
            instance = new LectureFDBManager();
        }
        return instance;
    }

    private LectureFDBManager() {
        lectureReference = FirebaseDatabase.getInstance().getReference().child("lecture");
    }

    public Observable<List<Lecture>> getLectureList(){
        return Observable.create(emitter -> {
            List<Lecture> lectureList = new ArrayList<>();
            lectureReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot data : snapshot.getChildren()){
                        String jsonData = gson.toJson(data.getValue());
                        Lecture lecture = gson.fromJson(jsonData, Lecture.class);
                        lectureList.add(lecture);
                    }

                    emitter.onNext(lectureList);
                    emitter.onComplete();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.d("error", "getLectureList onCancelled: " + error.getMessage());
                }
            });
        });
    }

    public void addLecture(Lecture lecture){
        String lectureKey = lectureReference.push().getKey();
        Log.d("test_by_sungchul", "addLecture: key : " + lectureKey);
        if(lectureKey != null){
            lectureReference.child(lectureKey).setValue(lecture);
        }
    }
}
