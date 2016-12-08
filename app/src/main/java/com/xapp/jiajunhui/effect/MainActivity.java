package com.xapp.jiajunhui.effect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import com.kk.taurus.animeffect.EffectFactory;
import com.kk.taurus.animeffect.anims.PropertyType;
import com.kk.taurus.animeffect.base.IAnimators;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EffectAdapter.OnItemClickListener {

    private View mDemoView;
    private RecyclerView mRecycler;
    private List<String> effects = new ArrayList<>();
    private EffectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDemoView = findViewById(R.id.demo_view);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);

        mRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        effects.clear();

        effects.add("FadeIn");
        effects.add("Fall");
        effects.add("FlipH");
        effects.add("FlipV");
        effects.add("NewsPaper");
        effects.add("RotateBottom");
        effects.add("RotateLeft");
        effects.add("ShakeH");
        effects.add("ShakeV");
        effects.add("ShakeHV");
        effects.add("SlideBottom");
        effects.add("SlideFall");
        effects.add("SlideLeft");
        effects.add("SlideRight");
        effects.add("SlideTop");
        effects.add("Slit");
        effects.add("ZoomCenter");
        effects.add("CustomAnimators");

        mAdapter = new EffectAdapter(getApplicationContext(),effects);
        mRecycler.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(EffectAdapter.ItemHolder holder, int position) {
        switch (position){
            case 0:
                // General use , Just specify the Animation View object .
                EffectFactory.FadeIn.getAnimator().invokeAnim(mDemoView);
                break;
            case 1:
                EffectFactory.Fall.getAnimator().invokeAnim(mDemoView);
                break;
            case 2:
                EffectFactory.FlipH.getAnimator().invokeAnim(mDemoView);
                break;
            case 3:
                EffectFactory.FlipV.getAnimator().invokeAnim(mDemoView);
                break;
            case 4:
                EffectFactory.NewsPaper.getAnimator().invokeAnim(mDemoView);
                break;
            case 5:
                EffectFactory.RotateBottom.getAnimator().invokeAnim(mDemoView);
                break;
            case 6:
                EffectFactory.RotateLeft.getAnimator().invokeAnim(mDemoView);
                break;
            case 7:
                EffectFactory.ShakeH.getAnimator().invokeAnim(mDemoView);
                break;
            case 8:
                EffectFactory.ShakeV.getAnimator().invokeAnim(mDemoView);
                break;
            case 9:
                EffectFactory.ShakeHV.getAnimator().invokeAnim(mDemoView);
                break;
            case 10:
                EffectFactory.SlideBottom.getAnimator().invokeAnim(mDemoView);
                break;
            case 11:
                EffectFactory.SlideFall.getAnimator().invokeAnim(mDemoView);
                break;
            case 12:
                EffectFactory.SlideLeft.getAnimator().invokeAnim(mDemoView);
                break;
            case 13:
                EffectFactory.SlideRight.getAnimator().invokeAnim(mDemoView);
                break;
            case 14:
                EffectFactory.SlideTop.getAnimator().invokeAnim(mDemoView);
                break;
            case 15:
                EffectFactory.Slit.getAnimator().invokeAnim(mDemoView);
                break;
            case 16:
                // you can set animation duration .
                EffectFactory.ZoomCenter.getAnimator().setDuration(800).invokeAnim(mDemoView);
                break;
            case 17:
                // you can use this method , custom you animators .
                EffectFactory.NewsPaper.getAnimator().invokeAnim(new IAnimators.AnimatorTogether() {
                    @Override
                    public Animator[] togetherAnimators() {
                        return new Animator[]{
                                ObjectAnimator.ofFloat(mDemoView, PropertyType.Rotation.getValue(), 1080,720,360,0).setDuration(1000),
                                ObjectAnimator.ofFloat(mDemoView, PropertyType.Alpha.getValue(),0,1).setDuration(1000)
                        };
                    }
                });
                break;

        }
    }
}
