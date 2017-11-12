package com.runachaqui.runachaqui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.runachaqui.runachaqui.adapter.CapsAdapter;
import com.runachaqui.runachaqui.models.CapsAdministrator;
import com.runachaqui.runachaqui.models.CapsModel;

import java.util.ArrayList;
import java.util.List;

public class CapsActivity extends Activity {
    private List<CapsModel> capsModelsList = new ArrayList<>();
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caps);

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.rvCaps);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        capsModelsList = CapsAdministrator.getAllCaps(this);
        CapsAdapter capsAdapter = new CapsAdapter(capsModelsList);

        context = this;

        mRecyclerView.setAdapter(capsAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                CapsModel publicacionModel = (CapsModel) capsModelsList.get(position);
                Intent intent = new Intent(context, TriviaActivity.class);
                intent.putExtra("id_capitulo", publicacionModel.getId_capitulo());
                startActivity(intent);
                //Comunicacion.getInstance(getApplicationContext()).abrirNavegador(publicacionModel.getUrlPublicacion());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
}
