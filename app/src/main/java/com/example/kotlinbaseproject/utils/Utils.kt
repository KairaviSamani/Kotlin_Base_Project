package com.example.kotlinbaseproject.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.TypedValue
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.kotlinbaseproject.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

/**
 * This class is used for global functions used in entire application
 */
object Utils {

    private var dialog: Dialog? = null

    /**
     * This method is used to show Progressbar
     * @param context the context is used to create dialog
     */
    fun showProgressBar(context: Context) {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
            dialog = null
        }
        dialog = Dialog(context)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.custom_progress_dialog)
        dialog!!.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog!!.setCancelable(false)
        dialog!!.show()
    }

    /**
     * This method is used to dismiss Progressbar
     */
    fun dismissProgressBar() {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
            dialog = null
        }
    }

    /**
     * This method is used to hide keyboard
     * @param context the context to hide keyboard
     * @param view the view is used to get window token
     */
    fun hideKeyboard(context: Context, view: View) {
        val inputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * This method is used to load Image URL to ImageView using Glide Library
     * @param imageUrl the string image url
     * @param imageView the view to load image url
     * @param placeholder the id of the resource to use as a placeholder and error holder
     */
    fun loadImageURL(context: Activity, imageUrl: String, imageView: ImageView, placeholder: Int) {
        showProgressBar(context)
        Glide.with(context)
            .load(imageUrl)
            .placeholder(placeholder)
            .error(placeholder)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?, model: Any?,
                    target: Target<Drawable>?, isFirstResource: Boolean
                ): Boolean {
                    dismissProgressBar()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?, model: Any?,
                    target: Target<Drawable>?, dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    dismissProgressBar()
                    return false
                }

            })
            .into(imageView)
    }

    /**
     * This method is used to check internet connection
     * @param context
     * @param informToUser Boolean - to inform user via alert dialog or not
     * @return Boolean - Whether there is an internet connection
     */
    fun isNetworkAvailable(context: Context, informToUser: Boolean): Boolean {
        var isConnected = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetwork =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        isConnected = when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }

        if (informToUser && !isConnected) {
            AlertDialogView.showAlert(
                context,
                context.getString(R.string.app_name),
                context.getString(R.string.error_internet_connection),
                context.getString(R.string.ok)
            )?.show()
        }

        return isConnected
    }

}