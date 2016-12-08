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

package com.kk.taurus.animeffect;

import com.kk.taurus.animeffect.anims.AnimatorFadeIn;
import com.kk.taurus.animeffect.anims.AnimatorFall;
import com.kk.taurus.animeffect.anims.AnimatorFlipH;
import com.kk.taurus.animeffect.anims.AnimatorFlipV;
import com.kk.taurus.animeffect.anims.AnimatorNewsPaper;
import com.kk.taurus.animeffect.anims.AnimatorRotateBottom;
import com.kk.taurus.animeffect.anims.AnimatorRotateLeft;
import com.kk.taurus.animeffect.anims.AnimatorShakeH;
import com.kk.taurus.animeffect.anims.AnimatorShakeHV;
import com.kk.taurus.animeffect.anims.AnimatorShakeV;
import com.kk.taurus.animeffect.anims.AnimatorSlideBottom;
import com.kk.taurus.animeffect.anims.AnimatorSlideFall;
import com.kk.taurus.animeffect.anims.AnimatorSlideLeft;
import com.kk.taurus.animeffect.anims.AnimatorSlideRight;
import com.kk.taurus.animeffect.anims.AnimatorSlideTop;
import com.kk.taurus.animeffect.anims.AnimatorSlit;
import com.kk.taurus.animeffect.anims.AnimatorZoomCenter;
import com.kk.taurus.animeffect.base.BaseAnimator;

/**
 * Created by Taurus on 2016/12/7.
 */

/**
 * animation effect factory . You can specify a specific effect and execute it.
 */
public enum EffectFactory {

    FadeIn(AnimatorFadeIn.class),
    Fall(AnimatorFall.class),
    FlipH(AnimatorFlipH.class),
    FlipV(AnimatorFlipV.class),
    NewsPaper(AnimatorNewsPaper.class),
    RotateBottom(AnimatorRotateBottom.class),
    RotateLeft(AnimatorRotateLeft.class),
    ShakeH(AnimatorShakeH.class),
    ShakeV(AnimatorShakeV.class),
    ShakeHV(AnimatorShakeHV.class),
    SlideBottom(AnimatorSlideBottom.class),
    SlideFall(AnimatorSlideFall.class),
    SlideLeft(AnimatorSlideLeft.class),
    SlideRight(AnimatorSlideRight.class),
    SlideTop(AnimatorSlideTop.class),
    Slit(AnimatorSlit.class),
    ZoomCenter(AnimatorZoomCenter.class)

    ;

    private Class<? extends BaseAnimator> clz;

    EffectFactory(Class<? extends BaseAnimator> clz){
        this.clz = clz;
    }

    public BaseAnimator getAnimator(){
        BaseAnimator animator = null;
        try {
            animator = clz.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return animator;
    }
}
