package com.example.dagger_android_2020.Components;

import android.app.Application;


import com.example.dagger_android_2020.BaseApplication;
import com.example.dagger_android_2020.Modules.ActivityBuildersModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

// TODO: 3 - Create a Component for BaseApplication
// MARK: Components are classes where we put a references to the Modules. Modules
// are the classes where we configure our dependencies. Inside @Component annotation
// you need to include all the modules that are going to be used during the entire
// application. AndroidInjectionModule is required by Dagger 2 that is why we need to
// include it.

// TODO: 4 - Extend with AndroidInjector<BaseApplication>
// The next step gitis to extend ths component with AndroidInjector<> and
// provide a class that we want to be our client. Basically all the view level classes
// are our clients and Components are the bridge that pass our dependencies from
// modules which are configuration classes. We can't randomly inject dependencies
// in the classes. We need to tell Dagger where and what we are going to inject.

// TODO: 8 - Include ActivityBuildersModule in the component
// MARK: After creating a new module we need to add it into the component class. So
// the components are the classes where we include our modules and modules are classes
// where we configure our dependencies.
@Component(modules = {AndroidInjectionModule.class, ActivityBuildersModule.class})
public interface BaseApplicationComponent extends AndroidInjector<BaseApplication> {

    // TODO: 5 - Override the Builder of the component
    // This step is required in every Android Dagger application. The idea is to return
    // and instance of BaseApplicationComponent implementation which Dagger will create
    // for us. After this steps you can now build the project and in BaseApplication
    // return and instance of already generated by DaggerBaseApplicationComponent.
    @Component.Builder
    interface Builder {

        // BindsInstance is used when you have an object at the time you are constructing
        // the component. So this means that Application object is already in the memory
        // and we need somehow add this into dependency graph that is why we use BindsInstance
        // annotation.
        @BindsInstance
        Builder bindInstance(Application application);

        // Just returning the class.
        BaseApplicationComponent build();
    }
}
