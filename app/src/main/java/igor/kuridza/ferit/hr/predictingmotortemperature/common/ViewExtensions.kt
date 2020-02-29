package igor.kuridza.ferit.hr.predictingmotortemperature.common

import android.view.View

fun View.gone(){
    visibility = View.GONE
}

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.onClick(onClick: () -> Unit) {
    setOnClickListener { onClick() }
}
