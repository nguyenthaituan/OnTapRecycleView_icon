package vn.edu.ntu.ontaprecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.ViewHolder> {

    private List<Face> mListFace;
    private OnCallBack mListener;

    public FaceAdapter( OnCallBack Listener, List<Face> listFace) {
        this.mListFace = listFace;
        this.mListener = Listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_face, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Face face = mListFace.get(position);
       holder.ivAvatar.setImageResource(face.getmResID());
       holder.tvName.setText(face.getmName());
    }

    @Override
    public int getItemCount()
    {
        return mListFace.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAvatar;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            ivAvatar = itemView.findViewById(R.id.avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(getPosition());
                }
            });
        }
    }
    public interface  OnCallBack{
        void onItemClicked(int position);
    }
}
