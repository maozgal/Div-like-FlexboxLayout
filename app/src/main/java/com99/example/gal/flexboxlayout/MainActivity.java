package com99.example.gal.flexboxlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.CENTER);
        recyclerView.setLayoutManager(layoutManager);

        final ArrayList<String> DivLikeContent = new ArrayList<>();
        DivLikeContent.add("Route");
        DivLikeContent.add("No calls during the ride");
        DivLikeContent.add("Smell");
        DivLikeContent.add("Less talk");
        DivLikeContent.add("Safety");

        final RecyclerView.Adapter adapter = new DivLikeAdapter(DivLikeContent);

        recyclerView.setAdapter(adapter);

        Button addButton = findViewById(R.id.add_item_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DivLikeContent.add(generateRandonText());
                recyclerView.setAdapter(adapter);
            }
        });
    }

    private String generateRandonText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1 + (int) (Math.random() * 20); i > 0; i--) {
            sb.append("a");
        }
        return sb.toString();
    }
}
