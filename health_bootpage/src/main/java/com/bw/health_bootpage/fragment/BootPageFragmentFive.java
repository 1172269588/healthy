package com.bw.health_bootpage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bw.health_bootpage.R;
import com.bw.health_homepage.view.activity.MyActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BootPageFragmentFive extends Fragment {

    private Button btn_go_homepage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_bootpagefive, container, false);
        btn_go_homepage = inflate.findViewById(R.id.btn_go_homepage);
        btn_go_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyActivity.class));
            }
        });
        return inflate;
    }
}
