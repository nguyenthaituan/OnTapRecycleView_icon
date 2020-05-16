package vn.edu.ntu.ontaprecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FaceAdapter.OnCallBack {

    private RecyclerView mRcvFace;
    private FaceAdapter madapter;
    private List<Face> mListFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mListFace = new ArrayList<>();
        for(int i= 0; i<20;i++){
            mListFace.add(new Face("Laugh", R.drawable.laugh));
            mListFace.add(new Face("Angry", R.drawable.angry));
            mListFace.add(new Face("Nerd", R.drawable.nerd));
            mListFace.add(new Face("Angel", R.drawable.angel));
            mListFace.add(new Face("Smile", R.drawable.smile));
            mListFace.add(new Face("Smiley", R.drawable.smiley));
        }

        mRcvFace = findViewById(R.id.rcv_face);
        mRcvFace.setHasFixedSize(true); //tang toc do xu li
      //  mRcvFace.setLayoutManager(new LinearLayoutManager(this));
      mRcvFace.setLayoutManager(new GridLayoutManager(this, 3));

      madapter= new FaceAdapter(this, mListFace);

      mRcvFace.setAdapter(madapter);

    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "ban chon " + position ,Toast.LENGTH_SHORT).show();
    }
}
