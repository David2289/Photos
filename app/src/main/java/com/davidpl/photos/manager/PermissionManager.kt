package com.example.photos.utility.manager

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.example.commons.utility.helper.SharedPrefUtils

class PermissionManager {

    companion object {

        /**
         * onPermReqDisabled: When user picked "no to ask again" to permission request.
         */
        fun validate(activity: Activity,
                     permission: String,
                     onPermNotGranted: () -> Unit,
                     onPermGranted: () -> Unit,
                     onPermReqDisabled: () -> Unit
        ) {

            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
                onPermGranted() // For Android 5 (API 21 to 22) App has permission from installing.
                return
            }

            when(ContextCompat.checkSelfPermission(activity, permission)) {
                PackageManager.PERMISSION_DENIED -> {
                    // shouldShowRequestPermissionRationale:
                    // returns true if user has denied the permission.
                    // return false in others cases (For example: First time requesting or user has choose "No to show again")
                    // Android docs says to call the method inside PERMISSION_DENIED
                    if (activity.shouldShowRequestPermissionRationale(permission)) {
                        onPermNotGranted()
                    } else {
                        if (firstTimeReqPerm(activity, permission)) {
                            saveNotFirstTimeReqPerm(activity, permission)
                            onPermNotGranted()
                        } else {
                            // If is not the first time asking permission this only can happens if user has choose "No to show again"
                            onPermReqDisabled()

                        }
                    }
                }
                PackageManager.PERMISSION_GRANTED -> onPermGranted()
            }

        }

        private fun firstTimeReqPerm(context: Context, permission: String): Boolean {
            return SharedPrefUtils.getBooleanData(context, permission, true)
        }

        private fun saveNotFirstTimeReqPerm(context: Context, permission: String) {
            SharedPrefUtils.saveData(context, permission, false)
        }



    }

}