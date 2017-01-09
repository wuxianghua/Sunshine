package com.example.administrator.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.sunshine.WeatherEntity.EveryDayData;
import com.example.administrator.sunshine.WeatherEntity.Weather;

import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */

class ForeCastAdapter extends RecyclerView.Adapter<ForeCastAdapter.MyViewHolder> {
    private List<EveryDayData> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public ForeCastAdapter(Context context, List<EveryDayData> datas){
        this. mContext=context;
        this. mDatas=datas;
        inflater=LayoutInflater. from(mContext);
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    @Override
    public int getItemCount() {

        return mDatas.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv.setText( mDatas.get(position).weather.get(0).description);
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item_forecast,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv=(TextView) view.findViewById(R.id.list_item_forecast_textview);
        }

    }
}
