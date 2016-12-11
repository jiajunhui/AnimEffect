# AnimEffect
View animation effects collection , You can easily add animations to your view.
# Description
The animations included in this project are based on nineold.
# Dependency
```gradle
dependencies {
    compile 'com.kk.taurus.animeffect:Anim-Effect:1.0.1'
}
```
# Use
```java
// General use , Just specify the Animation View object .
        EffectFactory.FadeIn.getAnimator().invokeAnim(mDemoView);

        //And you can also use this style.
        new AnimatorFall().invokeAnim(mDemoView);

        // you can set animation duration .
        EffectFactory.ZoomCenter.getAnimator().setDuration(800).invokeAnim(mDemoView);

        //you can custom you animator extends BaseAnimator
        new CustomAnimator().setDuration(300).invokeAnim(mDemoView);

        // you can use EffectFactory , custom you animators .
        EffectFactory.NewsPaper.getAnimator().invokeAnim(new IAnimators.AnimatorTogether() {
            @Override
            public Animator[] togetherAnimators() {
                return new Animator[]{
                        ObjectAnimator.ofFloat(mDemoView, PropertyType.Rotation.getValue(), 1080,720,360,0).setDuration(1000),
                        ObjectAnimator.ofFloat(mDemoView, PropertyType.Alpha.getValue(),0,1).setDuration(1000)
                };
            }
        });

        //you can custom you animator extends BaseAnimator and call back listener
        new CustomAnimator().setDuration(300).invokeAnim(mDemoView, new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
```
# License
```license
Copyright 2016 jiajunhui

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
