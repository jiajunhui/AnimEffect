package com.xapp.jiajunhui.effect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import com.kk.taurus.animeffect.anims.AnimatorBookFlipLeft;
import com.kk.taurus.animeffect.anims.AnimatorBookFlipRight;
import com.kk.taurus.animeffect.anims.AnimatorBottomOpen;
import com.kk.taurus.animeffect.anims.AnimatorCalendarFlipBottom;
import com.kk.taurus.animeffect.anims.AnimatorCalendarFlipTop;
import com.kk.taurus.animeffect.anims.AnimatorFadeIn;
import com.kk.taurus.animeffect.anims.AnimatorFall;
import com.kk.taurus.animeffect.anims.AnimatorFlipH;
import com.kk.taurus.animeffect.anims.AnimatorFlipHCircle;
import com.kk.taurus.animeffect.anims.AnimatorFlipV;
import com.kk.taurus.animeffect.anims.AnimatorFlipVCircle;
import com.kk.taurus.animeffect.anims.AnimatorNewsPaper;
import com.kk.taurus.animeffect.anims.AnimatorReboundBottom;
import com.kk.taurus.animeffect.anims.AnimatorReboundLeft;
import com.kk.taurus.animeffect.anims.AnimatorReboundRight;
import com.kk.taurus.animeffect.anims.AnimatorReboundTop;
import com.kk.taurus.animeffect.anims.AnimatorRotateBottom;
import com.kk.taurus.animeffect.anims.AnimatorRotateCardLeftTop;
import com.kk.taurus.animeffect.anims.AnimatorRotateCardRightBottom;
import com.kk.taurus.animeffect.anims.AnimatorRotateLeft;
import com.kk.taurus.animeffect.anims.AnimatorRotateShake;
import com.kk.taurus.animeffect.anims.AnimatorShakeH;
import com.kk.taurus.animeffect.anims.AnimatorShakeHV;
import com.kk.taurus.animeffect.anims.AnimatorShakeV;
import com.kk.taurus.animeffect.anims.AnimatorSlideBottom;
import com.kk.taurus.animeffect.anims.AnimatorSlideFall;
import com.kk.taurus.animeffect.anims.AnimatorSlideLeft;
import com.kk.taurus.animeffect.anims.AnimatorSlideRight;
import com.kk.taurus.animeffect.anims.AnimatorSlideTop;
import com.kk.taurus.animeffect.anims.AnimatorSlitH;
import com.kk.taurus.animeffect.anims.AnimatorSlitHV;
import com.kk.taurus.animeffect.anims.AnimatorSlitV;
import com.kk.taurus.animeffect.anims.AnimatorZoomCenter;
import com.kk.taurus.animeffect.base.BaseAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EffectAdapter.OnItemClickListener {

    private View mDemoView;
    private RecyclerView mRecycler;
    private List<Class> effects = new ArrayList<>();
    private EffectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDemoView = findViewById(R.id.demo_view);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);

        mRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        effects.clear();

        initEffectsList();

        mAdapter = new EffectAdapter(getApplicationContext(),effects);
        mRecycler.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(this);

        // General use , Just specify the Animation View object .
        // EffectFactory.FadeIn.getAnimator().invokeAnim(mDemoView);

        //And you can also use this style.
        // new AnimatorFall().invokeAnim(mDemoView);

        // you can set animation duration .
        // EffectFactory.ZoomCenter.getAnimator().setDuration(800).invokeAnim(mDemoView);

        //you can custom you animator extends BaseAnimator
        //new CustomAnimator().setDuration(300).invokeAnim(mDemoView);

        // you can use EffectFactory , custom you animators .
        //        EffectFactory.NewsPaper.getAnimator().invokeAnim(new IAnimators.AnimatorTogether() {
        //            @Override
        //            public Animator[] togetherAnimators() {
        //                return new Animator[]{
        //                        ObjectAnimator.ofFloat(mDemoView, PropertyType.Rotation.getValue(), 1080,720,360,0).setDuration(1000),
        //                        ObjectAnimator.ofFloat(mDemoView, PropertyType.Alpha.getValue(),0,1).setDuration(1000)
        //                };
        //            }
        //        });

        //you can custom you animator extends BaseAnimator and call back listener
        //        new CustomAnimator().setDuration(300).invokeAnim(mDemoView, new Animator.AnimatorListener() {
        //            @Override
        //            public void onAnimationStart(Animator animator) {
        //
        //            }
        //
        //            @Override
        //            public void onAnimationEnd(Animator animator) {
        //
        //            }
        //
        //            @Override
        //            public void onAnimationCancel(Animator animator) {
        //
        //            }
        //
        //            @Override
        //            public void onAnimationRepeat(Animator animator) {
        //
        //            }
        //        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(EffectAdapter.ItemHolder holder, int position) {
        Class effect = effects.get(position);
        try {
            BaseAnimator animator = (BaseAnimator) effect.newInstance();
            animator.invokeAnim(mDemoView);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void initEffectsList() {
        effects.add(AnimatorFadeIn.class);
        effects.add(AnimatorFall.class);
        effects.add(AnimatorFlipH.class);
        effects.add(AnimatorFlipV.class);
        effects.add(AnimatorSlideBottom.class);
        effects.add(AnimatorSlideFall.class);
        effects.add(AnimatorSlideLeft.class);
        effects.add(AnimatorSlideRight.class);
        effects.add(AnimatorSlideTop.class);
        effects.add(AnimatorSlitH.class);
        effects.add(AnimatorSlitHV.class);
        effects.add(AnimatorSlitV.class);
        effects.add(AnimatorZoomCenter.class);
        effects.add(AnimatorReboundBottom.class);
        effects.add(AnimatorReboundLeft.class);
        effects.add(AnimatorReboundRight.class);
        effects.add(AnimatorReboundTop.class);
        effects.add(AnimatorRotateBottom.class);
        effects.add(AnimatorRotateLeft.class);
        effects.add(AnimatorBookFlipLeft.class);
        effects.add(AnimatorBookFlipRight.class);
        effects.add(AnimatorCalendarFlipBottom.class);
        effects.add(AnimatorCalendarFlipTop.class);
        effects.add(AnimatorBottomOpen.class);
        effects.add(AnimatorRotateCardLeftTop.class);
        effects.add(AnimatorRotateCardRightBottom.class);
        effects.add(AnimatorFlipHCircle.class);
        effects.add(AnimatorFlipVCircle.class);
        effects.add(AnimatorNewsPaper.class);
        effects.add(AnimatorShakeH.class);
        effects.add(AnimatorShakeHV.class);
        effects.add(AnimatorShakeV.class);
        effects.add(AnimatorRotateShake.class);
        effects.add(CustomAnimator.class);
    }
}
