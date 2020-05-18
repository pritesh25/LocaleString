package com.vinrak.play_service

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.ConnectionResult.*
import com.google.android.gms.common.GoogleApiAvailability

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonClick).setOnClickListener {

            /*try {
                if (isGooglePlayServicesAvailable(this, applicationContext)) {
                    Toast.makeText(applicationContext, "Yes", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "No", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Log.d("MainActivity", "catch error = ${e.message}")
            }*/


            sampleMethod {
                Log.d("MainActivity", "Clicked")
            }
        }
    }

    private fun sampleMethod(param: () -> Unit) {
        param()
    }


    private fun isGooglePlayServicesAvailable(activity: AppCompatActivity?, cxt: Context): Boolean {
        val googleApiAvailability = GoogleApiAvailability.getInstance()
        /*val status = googleApiAvailability.isGooglePlayServicesAvailable(activity)
        if (status != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(status)) {
                googleApiAvailability.getErrorDialog(activity, status*//*error code*//*, 2404*//*request code*//*).show()
        }
        return false
    }*/

        return when (googleApiAvailability.isGooglePlayServicesAvailable(activity)) {
            API_UNAVAILABLE -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service API not available.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            CANCELED -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service connection was canceled.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            DEVELOPER_ERROR -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service is misconfigured.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            INTERNAL_ERROR -> {
                showPlayServiceErrorDialog(cxt, "An internal error occurred.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            INTERRUPTED -> {
                showPlayServiceErrorDialog(cxt, "An interrupt occurred while waiting for the connection complete.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            INVALID_ACCOUNT -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service attempted to connect to the service with an invalid account name specified.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            LICENSE_CHECK_FAILED -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service is not licensed to the user.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            NETWORK_ERROR -> {
                showPlayServiceErrorDialog(cxt, "A network error occurred.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            RESOLUTION_REQUIRED -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service completing the connection requires some form of resolution.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            RESTRICTED_PROFILE -> {
                showPlayServiceErrorDialog(cxt, "The current user profile is restricted and cannot use authenticated features.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SERVICE_DISABLED -> {
                showPlayServiceErrorDialog(cxt, "The installed version of Google Play services has been disabled on this device.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SERVICE_INVALID -> {
                showPlayServiceErrorDialog(cxt, "The version of the Google Play services installed on this device is not authentic.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SERVICE_MISSING -> {
                showPlayServiceErrorDialog(cxt, "Google Play services is missing on this device.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SERVICE_MISSING_PERMISSION -> {
                showPlayServiceErrorDialog(cxt, "Google Play service doesn't have one or more required permissions.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SERVICE_UPDATING -> {
                showPlayServiceErrorDialog(cxt, "Google Play service is currently being updated on this device.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SERVICE_VERSION_UPDATE_REQUIRED -> {
                showPlayServiceErrorDialog(cxt, "The installed version of Google Play services is out of date.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SIGN_IN_FAILED -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service attempted to connect to the service but the user is not signed in.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SIGN_IN_REQUIRED -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service attempted to connect to the service but the user is not signed in.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }

            SUCCESS -> {
                true
            }

            TIMEOUT -> {
                showPlayServiceErrorDialog(cxt, "Google Play Service timeout was exceeded while waiting for the connection to complete.") {
                    Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                }
                false
            }
            else -> false
        }
    }

    private fun showPlayServiceErrorDialog(cxt: Context, message: String, function: () -> Unit) {
        AlertDialog.Builder(cxt)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton("OK") { dialog, which ->
                    function
                    dialog.dismiss()
                }
                .show()


    }
}
