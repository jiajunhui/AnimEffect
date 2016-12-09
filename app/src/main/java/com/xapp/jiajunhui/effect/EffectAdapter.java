package com.xapp.jiajunhui.effect;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taurus on 2016/12/8.
 */

public class EffectAdapter extends RecyclerView.Adapter<EffectAdapter.ItemHolder>{

    private Context mContext;
    private List<Class> effects = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public EffectAdapter(Context context, List<Class> effects){
        this.mContext = context;
        this.effects = effects;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(View.inflate(mContext,R.layout.item_view,null));
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, final int position) {
        holder.itemView.setBackgroundColor(position%2==0?Color.parseColor("#E7DCE0"):Color.parseColor("#F4F4F4"));
        holder.effectType.setText(effects.get(position).getSimpleName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(holder, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return effects.size();
    }

    public interface OnItemClickListener{
        void onItemClick(ItemHolder holder,int position);
    }

    public static class ItemHolder extends RecyclerView.ViewHolder{

        TextView effectType;

        public ItemHolder(View itemView) {
            super(itemView);
            effectType = (TextView) itemView.findViewById(R.id.tv_effect_type);
        }
    }

}
