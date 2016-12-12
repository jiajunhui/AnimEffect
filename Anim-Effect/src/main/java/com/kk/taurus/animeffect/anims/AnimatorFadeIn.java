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

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.kk.taurus.animeffect.base.BaseAnimator;

/**
 * Created by Taurus on 2016/12/8.
 */

public class AnimatorFadeIn extends BaseAnimator {
    @Override
    public Animator[] togetherAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view,PropertyType.Alpha.getValue(),0,1).setDuration(getDuration())
        };
    }
}
