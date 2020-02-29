package igor.kuridza.ferit.hr.predictingmotortemperature.common

import androidx.fragment.app.FragmentManager
import igor.kuridza.ferit.hr.predictingmotortemperature.ui.fragments.base.BaseFragment

fun replaceFragment(containerId: Int,fragmentManager: FragmentManager, fragment: BaseFragment){
    fragmentManager
        .beginTransaction()
        .replace(containerId, fragment)
        .commitAllowingStateLoss()
}