package com.mseptember.tubefav.ui.listvideos;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mseptember.tubefav.R;
import com.mseptember.tubefav.entity.Video;
import com.mseptember.tubefav.injection.Injectable;
import com.mseptember.tubefav.injection.YouFavViewModelFactory;
import com.mseptember.tubefav.ui.addvideos.VideoAddActivity;
import com.mseptember.tubefav.ui.detailvideos.VideoDetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class VideoListFragment extends Fragment implements Injectable {

    private static String selectedVideoId = "selectedVideoId";
    @Inject
    YouFavViewModelFactory youFavViewModelFactory;
    private VideoAdapter adapter;
    private VideoListViewModel videoListViewModel;
    private View.OnClickListener itemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Video video = (Video) v.getTag();

            Intent vid = new Intent(getActivity(), VideoDetailActivity.class);
            vid.putExtra(selectedVideoId, video.getId());
            startActivity(vid);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_video, container, false);

        setupRecyclerView(view);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab_add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                VideoListFragment.this.startActivity(new Intent(VideoListFragment.this.getContext(), VideoAddActivity.class));
            }
        });
        videoListViewModel = ViewModelProviders.of(this, youFavViewModelFactory).get(VideoListViewModel.class);

        videoListViewModel.getVideos().observe(this, new Observer<List<Video>>() {
            @Override
            public void onChanged(@Nullable List<Video> events) {
                adapter.setItems(events);
            }
        });

        return view;
    }

    private void setupRecyclerView(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_list_video);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new VideoAdapter(new ArrayList<Video>(), getContext(), itemClickListener);
        recyclerView.setAdapter(adapter);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}
