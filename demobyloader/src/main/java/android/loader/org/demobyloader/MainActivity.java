package android.loader.org.demobyloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter = new MyAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);

        final CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.ctl);
        ctl.setTitle("Cool UI");
        setContentScrim(ctl);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setContentScrim(final CollapsingToolbarLayout layout) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.banner);
        Palette.generateAsync(bmp, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getDarkMutedSwatch();
                layout.setContentScrimColor(swatch.getRgb());
            }
        });
    }

    public void add(View view) {
        Snackbar.make(view, "真要添加？", Snackbar.LENGTH_LONG)
                .setAction("添加", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int random = new Random().nextInt(100);
                        mAdapter.insertData("恭喜您，获得" + random + "L币", 0);
                        mRecyclerView.smoothScrollToPosition(0);
                    }
                }).show();
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private ArrayList<String> mData = new ArrayList<String>();

        public MyAdapter() {
            for (int i=0;i<100;i++) mData.add("loader最帅");
        }

        public void insertData(String data, int index) {
            mData.add(index, data);
            notifyItemInserted(index);
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
            TextView tv = new TextView(viewGroup.getContext());
            tv.setPadding(50, 50, 50, 50);
            return new ViewHolder(tv);
        }

        @Override
        public void onBindViewHolder(final MyAdapter.ViewHolder viewHolder, int i) {
            viewHolder.view.setText(mData.get(i));
            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int pos = viewHolder.getLayoutPosition();
                    Toast.makeText(viewHolder.view.getContext(),
                            mData.get(pos), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView view;
            public ViewHolder(View itemView) {
                super(itemView);
                view = (TextView) itemView;
            }
        }
    }
}
