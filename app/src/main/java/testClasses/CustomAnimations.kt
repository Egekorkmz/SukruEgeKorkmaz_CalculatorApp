import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import com.example.sukruegekorkmaz_hw1.R

class CustomAnimations() {
    companion object{
        fun blink(tvTemp : TextView){
            val blinkAnimation = AlphaAnimation(1f, 0f)
            var isBlinking = false

            blinkAnimation.duration = 500 // Set the duration of the animation in milliseconds
            blinkAnimation.repeatCount = Animation.INFINITE // Infinite blinking

            // Set an AnimationListener to toggle the visibility of the TextView
            blinkAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}

                override fun onAnimationEnd(animation: Animation) {
                    // Toggle visibility when the animation ends
                    tvTemp.visibility = if (isBlinking) View.VISIBLE else View.INVISIBLE
                    isBlinking = !isBlinking
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })

            tvTemp.startAnimation(blinkAnimation)
        }
    }

}