package com.alemi.cleannotes.di

import com.alemi.cleannotes.framework.presentation.BaseApplication
import com.alemi.cleannotes.framework.presentation.MainActivity
import com.alemi.cleannotes.framework.presentation.splash.NoteNetworkSyncManager
import com.alemi.cleannotes.framework.presentation.notedetail.NoteDetailFragment
import com.alemi.cleannotes.framework.presentation.notelist.NoteListFragment
import com.alemi.cleannotes.framework.presentation.splash.SplashFragment
import com.alemi.cleannotes.notes.di.NoteViewModelModule
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@FlowPreview
@Singleton
@Component(
    modules = [
        ProductionModule::class,
        AppModule::class,
        NoteViewModelModule::class,
        NoteFragmentFactoryModule::class
    ]
)
interface AppComponent {

    val noteNetworkSync: NoteNetworkSyncManager

    @Component.Factory
    interface Factory{

        fun create(@BindsInstance app: BaseApplication): AppComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(splashFragment: SplashFragment)

    fun inject(noteListFragment: NoteListFragment)

    fun inject(noteDetailFragment: NoteDetailFragment)
}












