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

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;

/**
 * Created by Taurus on 2016/12/7.
 */

public abstract class BaseAnimator implements IAnimators{

    private long mDuration = ANIMATION_DURATION_DEFAULT;
    private AnimatorSet mAnimatorSet;

    public BaseAnimator(){
        mAnimatorSet = new AnimatorSet();
    }

    public BaseAnimator(long duration){
        this();
        this.mDuration = duration;
    }

    @Override
    public void invokeAnim(View view) {
        invokeAnim(view,null);
    }

    @Override
    public void invokeAnim(View view, Animator.AnimatorListener animatorListener) {
        initTargetView(view);
        if(animatorListener!=null){
            mAnimatorSet.addListener(animatorListener);
        }
        setupAnimation(togetherAnimators(view));
        mAnimatorSet.start();
    }

    @Override
    public void invokeAnim(AnimatorTogether animatorTogether) {
        invokeAnim(animatorTogether,null);
    }

    @Override
    public void invokeAnim(AnimatorTogether animatorTogether, Animator.AnimatorListener animatorListener) {
        if(animatorListener!=null){
            mAnimatorSet.addListener(animatorListener);
        }
        setupAnimation(animatorTogether.togetherAnimators());
        mAnimatorSet.start();
    }

    public void initTargetView(View view) {
        initTargetViewPivotX(view);
        initTargetViewPivotY(view);
    }

    public void initTargetViewPivotY(View view) {
        view.setPivotY(view.getMeasuredHeight() / 2.0f);
    }

    public void initTargetViewPivotX(View view) {
        view.setPivotX(view.getMeasuredWidth() / 2.0f);
    }

    public long getDuration() {
        return mDuration;
    }

    /**
     * set the animation effect execute duration .
     * @param mDuration default value 500ms
     * @return
     */
    public BaseAnimator setDuration(long mDuration) {
        this.mDuration = mDuration;
        return this;
    }

    public AnimatorSet getAnimatorSet() {
        return mAnimatorSet;
    }

    /**
     * set up animator set and invoke it .
     * @param animators
     */
    protected void setupAnimation(Animator[] animators){
        getAnimatorSet().playTogether(animators);
    }

    @Override
    public abstract Animator[] togetherAnimators(View view);

}
