import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView

class CustomBlink(tvTemp: TextView) {
    var blinkDuration = 200
    var tvTemp = tvTemp
    private val blinkAnimation = AlphaAnimation(0f, 1f)

    fun blink(){
        blinkAnimation.duration = blinkDuration.toLong() // Set the duration of the animation in milliseconds
        blinkAnimation.repeatCount = Animation.INFINITE
        blinkAnimation.repeatMode = Animation.REVERSE

        tvTemp.startAnimation(blinkAnimation)
    }
    fun setDuraion(duration: Int){
        blinkDuration = duration
        blinkAnimation.duration = duration.toLong()

        if(blinkAnimation.repeatCount == Animation.INFINITE)
            tvTemp.startAnimation(blinkAnimation)
    }


}