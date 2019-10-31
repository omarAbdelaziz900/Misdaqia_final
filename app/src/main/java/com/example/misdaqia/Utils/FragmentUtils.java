package com.example.misdaqia.Utils;


/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Engr. Ziaa <https://github.com/ziaagikian>
 */

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;



public class FragmentUtils {
    /**
     * <p> Attach new Fragment to Activity.</p>
     *
     * @param context
     * @param fragment, fragment to add
     * @param viewID    , layout id to replace the view.
     */
    public static void attachFragment(AppCompatActivity context, Fragment fragment, int viewID) {
        FragmentTransaction ft = context.getSupportFragmentManager()
                .beginTransaction();
        ft.add(viewID, fragment).commit();
    }

    /**
     * <p>Open new fragment to existing fragment. Provides developer to add this fragment to backstack.</p>
     *
     * @param context
     * @param fragment,         fragment to add
     * @param viewID            , layout id to replace the view.
     * @param canAddBackStrace, is added to backstrace
     */

    public static void openNewFragment(AppCompatActivity context, Fragment fragment,
                                       boolean canAddBackStrace, int viewID) {
        FragmentTransaction ft = context.getSupportFragmentManager()
                .beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left, 0);
        ft.replace(viewID, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (canAddBackStrace) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    private static FragmentManager getFragmentManager(Object context) {
        if (context instanceof FragmentActivity)
            return ((FragmentActivity) context).getSupportFragmentManager();
        else if (((Fragment) context).isAdded())
            return ((Fragment) context).getChildFragmentManager();

        return null;
    }

    public static void replaceFragment(@NonNull final Object context,
                                       @IdRes int target, @NonNull Fragment fragment,
                                       Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager(context);
        if (fragmentManager == null)
            return;

        Fragment myFragment = fragmentManager.findFragmentByTag(fragment.getClass().getSimpleName());

        if (myFragment != null && myFragment.isVisible())
            return;

        if (bundle != null)
            fragment.setArguments(bundle);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            fragment.setSharedElementEnterTransition(fragment);
//            fragment.setEnterTransition(new Fade());
//            fragment.setExitTransition(new Fade());
//            fragment.setSharedElementReturnTransition(fragment);
//        }
        fragmentManager.beginTransaction().replace(target, myFragment == null ? fragment : myFragment,
                getClassName(fragment))
                .commit();
    }

    private static String getClassName(Class classa) {
       /* String c=classa.getSimpleName();
        LogUtil.e("ClassName:-",c+"");*/
        return classa.getSimpleName();
    }

    static String getClassName(Fragment classa) {
        return getClassName(classa.getClass());
    }

    /**
     * <p>
     * Open new fragment to existing fragment. Provides developer to add this
     * fragment to backstack.
     * </p>
     *
     * @param context
     * @param fragment,         fragment to add
     * @param args,             Bundle arguments to pass into next fragment
     * @param viewID            , layout id to replace the view.
     * @param canAddBackStrace, is added to backstrace
     */
    public static void openNewFragment(AppCompatActivity context,
                                       Fragment fragment, Bundle args, boolean canAddBackStrace, int viewID) {
        fragment.setArguments(args);
        openNewFragment(context, fragment, canAddBackStrace, viewID);
    }

    /**
     * <p>Close the number of fragments.</p>
     *
     * @param context
     * @param numBackStack, number of fragments to pop up.
     */
    public static void popBackStack(AppCompatActivity context, int numBackStack) {
        FragmentManager manager = context.getSupportFragmentManager();
        int fragCount = manager.getBackStackEntryCount();
        for (int i = 0; i < fragCount - numBackStack; i++) {
            manager.popBackStack();
        }
    }
}

