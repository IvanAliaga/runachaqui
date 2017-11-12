package com.runachaqui.runachaqui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.runachaqui.runachaqui.R;
import com.runachaqui.runachaqui.models.CapsModel;

import java.util.List;

/**
 * Created by Ivan Aliaga on 12/11/2017.
 */

public class CapsAdapter extends RecyclerView.Adapter<CapsAdapter.ViewHolder> {
    private List<CapsModel> mCapsModel;

    public CapsAdapter(List<CapsModel> mCapsModel){
        this.mCapsModel = mCapsModel;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_caps, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mCapitulo.setText("Capítulo " + mCapsModel.get(position).getNumero());
        holder.mDescripcion.setText(mCapsModel.get(position).getDescripcion());
        holder.mImagen.setImageBitmap(mCapsModel.get(position).getBitmap());
    }

    @Override
    public int getItemCount() {
        return mCapsModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mCapitulo;
        public TextView mDescripcion;
        public ImageView mImagen;
        public CardView cvCaps;
        public ViewHolder(View view) {
            super(view);
            cvCaps = (CardView) view.findViewById(R.id.cvCaps);
            mDescripcion = (TextView)view.findViewById(R.id.tviDescripcionCap);
            mCapitulo = (TextView)view.findViewById(R.id.tviNumCap);
            mImagen = (ImageView) view.findViewById(R.id.imvAnimalCap);
        }
    }
}
