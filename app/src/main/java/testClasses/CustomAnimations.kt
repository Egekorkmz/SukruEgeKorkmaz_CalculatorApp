import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import com.example.sukruegekorkmaz_hw1.R

class CustomAnimations() {
    companion object{
        var blincDuration = 750
        fun blink(tvTemp : TextView){
            val blinkAnimation = AlphaAnimation(0f, 1f)

            blinkAnimation.duration = blincDuration.toLong() // Set the duration of the animation in milliseconds
            blinkAnimation.repeatCount = Animation.INFINITE
            blinkAnimation.repeatMode = Animation.REVERSE

            tvTemp.startAnimation(blinkAnimation)
        }
    }

}