import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import com.example.sukruegekorkmaz_hw1.R
import kotlin.time.Duration

class CustomBlink(tvTemp: TextView) {
    var blinkDuration = 750
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

        tvTemp.startAnimation(blinkAnimation)
    }


}