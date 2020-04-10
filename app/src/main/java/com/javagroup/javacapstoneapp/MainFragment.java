package com.javagroup.javacapstoneapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MainFragment extends Fragment {
    int mainResource;
    private View view;
    private static final String TAG = "MainFragment";
    private DatabaseReference ref = FirebaseOperations.strings();

    private TextView workplaceSafety, workPlaceSafetyIntro;
    private TextView findYourVoice,
            findYourVoiceIntro,
            findYourVoiceBtnOne,
            findYourVoiceBtnTwo,
            findYourVoiceBtnThree;
    private TextView resources,
            resourcesIntro,
            resourcesAlbertaTitle,
            resourcesCalgaryWorkersTitle,
            resourcesContentContinuation;

    private String title, introduction;
    private String findYourVoiceBtnOneString,
            findYourVoiceBtnTwoString,
            findYourVoiceBtnThreeString;
    private String resourcesAlbertaString,
            resourcesCalgaryWorkersString,
            resourcesContentContinuationString;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(mainResource, container, false);

        if (view.findViewById(R.id.main_section_workplace_safety) != null) {
            getStringsForWorkplaceSafety();
        } else if (view.findViewById(R.id.main_btm_sheet_finding_your_voice) != null) {
            getStringsForFindingYourVoice();
        } else if (view.findViewById(R.id.main_btm_sheet_resources) != null) {
            getStringsForResources();
        }
        return view;
    }

    private void getStringsForWorkplaceSafety() {
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                workplaceSafety = view.findViewById(R.id.title_WorkplaceSafety);
                workPlaceSafetyIntro = view.findViewById(R.id.content_WorkplaceSafety);

                // getting the strings from firebase
                title = dataSnapshot.child("WorkplaceSafetyTxt").getValue(String.class);
                introduction = dataSnapshot.child("workplaceSafetyIntro").getValue(String.class);

                workplaceSafety.setText(title);
                workPlaceSafetyIntro.setText(introduction);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

    private void getStringsForFindingYourVoice() {
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                findYourVoice = view.findViewById(R.id.btm_sheet_title_finding_your_voice);
                findYourVoiceIntro = view.findViewById(R.id.content_find_your_voice);
                findYourVoiceBtnOne = view.findViewById(R.id.btn_one_find_your_voice);
                findYourVoiceBtnTwo = view.findViewById(R.id.btn_two_find_your_voice);
                findYourVoiceBtnThree = view.findViewById(R.id.btn_three_find_your_voice);

                title = dataSnapshot.child("findYourVoiceTxt").getValue(String.class);
                introduction = dataSnapshot.child("findingYourVoiceIntro").getValue(String.class);
                findYourVoiceBtnOneString = dataSnapshot
                                                .child("findYourVoiceBtnOne")
                                                .getValue(String.class);
                findYourVoiceBtnTwoString = dataSnapshot
                                                .child("findYourVoiceBtnTwo")
                                                .getValue(String.class);
                findYourVoiceBtnThreeString = dataSnapshot
                                                .child("findYourVoiceBtnThree")
                                                .getValue(String.class);

                findYourVoice.setText(title);
                findYourVoiceIntro.setText(introduction);
                findYourVoiceBtnOne.setText(findYourVoiceBtnOneString);
                findYourVoiceBtnTwo.setText(findYourVoiceBtnTwoString);
                findYourVoiceBtnThree.setText(findYourVoiceBtnThreeString);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

    private void getStringsForResources() {
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                resources = view.findViewById(R.id.btm_sheet_title_Resource);
                resourcesIntro = view.findViewById(R.id.content_Resource);
                resourcesAlbertaTitle = view.findViewById(R.id.title_Alberta);
                resourcesCalgaryWorkersTitle = view.findViewById(R.id.title_calgary_workers);
                resourcesContentContinuation = view.findViewById(R.id.content_resources_continuation);

                title = dataSnapshot.child("resourcesTxt").getValue(String.class);
                introduction = dataSnapshot.child("resourcesIntro").getValue(String.class);
                resourcesAlbertaString = dataSnapshot
                                                .child("resourcesAlbertaTitle")
                                                .getValue(String.class);
                resourcesCalgaryWorkersString = dataSnapshot
                                                        .child("resourcesWorkersTitle")
                                                        .getValue(String.class);
                resourcesContentContinuationString = dataSnapshot
                                                        .child("resourcesIntroTwo")
                                                        .getValue(String.class);

                resources.setText(title);
                resourcesIntro.setText(introduction);
                resourcesAlbertaTitle.setText(resourcesAlbertaString);
                resourcesCalgaryWorkersTitle.setText(resourcesCalgaryWorkersString);
                resourcesContentContinuation.setText(resourcesContentContinuationString);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }
}
