package igor.kuridza.ferit.hr.predictingmotortemperature.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.showFragment(containerId: Int, fragment: Fragment, shouldAddToBackStack: Boolean = false, tag: String = ""){
    supportFragmentManager.beginTransaction().apply {
        if(shouldAddToBackStack){
            addToBackStack(tag)
        }
    }.replace(containerId, fragment, tag).commitAllowingStateLoss()
}


