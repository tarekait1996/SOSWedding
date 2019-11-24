package com.example.soswedding.ui.all_requests;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soswedding.Interface.RecyclerViewClickListener;
import com.example.soswedding.Interface.VolleyCallback;
import com.example.soswedding.R;
import com.example.soswedding.model.Request;
import com.example.soswedding.service.RequestsService;
import com.example.soswedding.ui.Request.RequestFragment;
import com.example.soswedding.ui.SignIn.SignInFragment;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllRequestsFragment extends Fragment implements RecyclerViewClickListener {

    private AllRequestsViewModel allRequestViewModel;
    private RecyclerView requestsRv;
    RequestAdapter mAdapter;
    private List<Request> requestsList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_all_requests, container, false);
        setUpViewModel();
        initComponents(root);


        return root;
    }

    private void initComponents(View root) {
        requestsRv = root.findViewById(R.id.requestsRv);
        RequestsService.getRequestsOfUser(getContext(), new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                onSuccessReceivedList(result);
            }
        });
    }

    private void onSuccessReceivedList(String result) {
        requestsList = allRequestViewModel.getRequestsObject(result);
        initRecyclerView();
    }

    private void setUpViewModel() {
        allRequestViewModel =
                ViewModelProviders.of(this).get(AllRequestsViewModel.class);
    }


    private void initRecyclerView() {
        requestsRv.setHasFixedSize(true);
        requestsRv.getRecycledViewPool().setMaxRecycledViews(0, 0);
        requestsRv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        initRequestRvAdapter();
    }
    @Override
    public void recyclerViewListClicked(View v, int position){

        Bundle bundle = new Bundle();
        bundle.putSerializable("request", requestsList.get(position));
        Fragment fragment = new RequestFragment();
        fragment.setArguments(bundle);
        RequestFragment.newInstance(requestsList.get(position));
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();

    }

    private void initRequestRvAdapter() {

        mAdapter = new RequestAdapter(getActivity().getApplicationContext(),getActivity(), requestsList, this);
        requestsRv.setAdapter(mAdapter);
    }


}