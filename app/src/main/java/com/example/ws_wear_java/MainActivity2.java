package com.example.ws_wear_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.example.ws_wear_java.databinding.ActivityMain2Binding;
import com.example.ws_wear_java.databinding.ViewStatsItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<StatsModel> items = new ArrayList<>();
        items.add(new StatsModel(80));
        items.add(new StatsModel(50));
        items.add(new StatsModel(30));
        items.add(new StatsModel(60));
        items.add(new StatsModel(100));

        binding.statsRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.statsRecycler.setAdapter(new StatsAdapter(this, items));
    }
}

class StatsModel {
    float percent;

    public StatsModel(int percent) {
        this.percent = percent;
    }
}

class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.ViewHolder> {

    private Context context;
    private List<StatsModel> items;

    public StatsAdapter(Context context, List<StatsModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public StatsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(context)
                        .inflate(R.layout.view_stats_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull StatsAdapter.ViewHolder holder, int position) {
        ViewStatsItemBinding binding = ViewStatsItemBinding.bind(holder.itemView);
        float percent = items.get(position).percent;

        binding.percent.setText(percent + "%");

        binding.progress.post(() -> {
            ViewGroup.LayoutParams layoutParams = binding.progress.getLayoutParams();
            layoutParams.width = (int) (binding.getRoot().getWidth() / 100.0 * percent);
            binding.progress.setLayoutParams(layoutParams);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}