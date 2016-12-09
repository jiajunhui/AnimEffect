/*
 * Copyright 2016 jiajunhui
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.kk.taurus.animeffect.anims;

import android.view.View;

import com.kk.taurus.animeffect.base.BaseAnimator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by Taurus on 2016/12/9.
 */

public class AnimatorBookFlipRight extends BaseAnimator {
    @Override
    public long getDuration() {
        return ANIMATION_DURATION_DEFAULT*3/2;
    }

    @Override
    public void initTargetViewPivotX(View view) {
        ViewHelper.setPivotX(view,view.getMeasuredWidth());
    }

    @Override
    public Animator[] togetherAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, PropertyType.Alpha.getValue(),0, 1).setDuration(getDuration()),
                ObjectAnimator.ofFloat(view, PropertyType.RotationY.getValue(),180, 0).setDuration(getDuration())
        };
    }
}
