package com.xapp.jiajunhui.effect;

import android.view.View;

import com.kk.taurus.animeffect.anims.PropertyType;
import com.kk.taurus.animeffect.base.BaseAnimator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

/**
 * Created by Taurus on 2016/12/9.
 */

public class CustomAnimator extends BaseAnimator {

    @Override
    public long getDuration() {
        return super.getDuration()*4;
    }

    @Override
    public Animator[] togetherAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, PropertyType.Alpha.getValue(),0,1).setDuration(getDuration()),
                ObjectAnimator.ofFloat(view, PropertyType.ScaleX.getValue(),0,1).setDuration(getDuration()),
                ObjectAnimator.ofFloat(view, PropertyType.ScaleY.getValue(),0,1).setDuration(getDuration()),
                ObjectAnimator.ofFloat(view, PropertyType.Rotation.getValue(),1080,720,360, 0).setDuration(getDuration())
        };
    }
}
