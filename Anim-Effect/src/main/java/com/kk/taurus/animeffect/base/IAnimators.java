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

package com.kk.taurus.animeffect.base;

import android.view.View;

import com.nineoldandroids.animation.Animator;

/**
 * Created by Taurus on 2016/12/8.
 */

public interface IAnimators {

    long ANIMATION_DURATION_DEFAULT = 500;

    /**
     * together you animators on the view effect .
     * @param view
     * @return
     */
    Animator[] togetherAnimators(View view);

    /**
     * invoke on the view
     * @param view
     */
    void invokeAnim(View view);

    /**
     * invoke on the view , and call back listener
     * @param view
     */
    void invokeAnim(View view, Animator.AnimatorListener animatorListener);

    /**
     * invoke animation use you custom animator set .
     * @param animatorTogether
     */
    void invokeAnim(AnimatorTogether animatorTogether);

    /**
     * invoke animation use you custom animator set . and call back listener
     * @param animatorTogether
     */
    void invokeAnim(AnimatorTogether animatorTogether, Animator.AnimatorListener animatorListener);

    interface AnimatorTogether{
        /**
         * return the animator set .
         * @return
         */
        Animator[] togetherAnimators();
    }

}
