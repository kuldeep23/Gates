package com.example.gates.myvisitor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gates.controller.Controller;
import com.example.gates.myvisitor.adapter.AllVisitorAdaptar;
import com.example.gates.R;
import com.example.gates.myvisitor.model.AllVisitorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllVisitor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllVisitor extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ImageView imageView;
    public AllVisitor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static AllVisitor newInstance(String param1, String param2) {
        AllVisitor fragment = new AllVisitor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab1, container, false);
        recyclerView = view.findViewById(R.id.recview);
        imageView = view.findViewById(R.id.img);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        processdata();
        return view;
    }

    public void processdata(){
        Call<List<AllVisitorModel>> call = Controller
                .getInstance()
                .getapi()
                .all_visitors
                        ("CP",
                        "360",
                        "1");

        call.enqueue(new Callback<List<AllVisitorModel>>() {
            @Override
            public void onResponse(Call<List<AllVisitorModel>> call, Response<List<AllVisitorModel>>response) {
                List<AllVisitorModel> data = response.body();
                if(data!=null){
                    recyclerView.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                    AllVisitorAdaptar myAdaptar = new AllVisitorAdaptar(data);
                    recyclerView.setAdapter(myAdaptar);
                }
                else {
                    recyclerView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call <List<AllVisitorModel>>call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}