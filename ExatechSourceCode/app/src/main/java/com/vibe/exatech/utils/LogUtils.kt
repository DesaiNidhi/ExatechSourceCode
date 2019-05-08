package com.vibe.exatech.utils

import android.util.Log
import com.vibe.exatech.BuildConfig


class LogUtils {

    private val LOG_PREFIX = "tc_"
    private val LOG_PREFIX_LENGTH = LOG_PREFIX.length
    private val MAX_LOG_TAG_LENGTH = 23

    companion object {




        /**
         * Don't use this when obfuscating class names!
         */


        fun LOGD(tag: String, message: String) {
            //noinspection PointlessBooleanExpression,ConstantConditions
            if (BuildConfig.DEBUG) {
                Log.d(tag, message)
            }
        }

        fun LOGD(tag: String, message: String, cause: Throwable) {
            //noinspection PointlessBooleanExpression,ConstantConditions
            if (BuildConfig.DEBUG) {
                Log.d(tag, message, cause)
            }
        }

        fun LOGV(tag: String, message: String) {
            //noinspection PointlessBooleanExpression,ConstantConditions
            if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, message)
            }
        }

        fun LOGV(tag: String, message: String, cause: Throwable) {
            //noinspection PointlessBooleanExpression,ConstantConditions
            if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, message, cause)
            }
        }

        fun LOGI(tag: String, message: String) {
            Log.i(tag, message)
        }

        fun LOGI(tag: String, message: String, cause: Throwable) {
            Log.i(tag, message, cause)
        }

        fun LOGW(tag: String, message: String) {
            Log.w(tag, message)
        }

        fun LOGW(tag: String, message: String, cause: Throwable) {
            Log.w(tag, message, cause)
        }

        fun LOGE(tag: String, ex: Exception) {
            Log.e(tag, Log.getStackTraceString(ex))
        }

        fun LOGE(tag: String, message: String, cause: Throwable) {
            Log.e(tag, message, cause)
        }

        fun LOGD(tag: String, message: String, shouldShow: Boolean) {
            //noinspection PointlessBooleanExpression,ConstantConditions
            if ((BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) && shouldShow) {
                Log.d(tag, message)
            }
        }

        fun LOGD(tag: String, message: String, cause: Throwable, shouldShow: Boolean) {
            //noinspection PointlessBooleanExpression,ConstantConditions
            if ((BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) && shouldShow) {
                Log.d(tag, message, cause)
            }
        }

        fun LOGV(tag: String, message: String, shouldShow: Boolean) {
            //noinspection PointlessBooleanExpression,ConstantConditions
            if ((BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) && shouldShow) {
                Log.v(tag, message)
            }
        }

        fun LOGV(tag: String, message: String, cause: Throwable, shouldShow: Boolean) {
            //noinspection PointlessBooleanExpression,ConstantConditions
            if ((BuildConfig.DEBUG || Log.isLoggable(tag, Log.VERBOSE)) && shouldShow) {
                Log.v(tag, message, cause)
            }
        }

        fun LOGI(tag: String, message: String, shouldShow: Boolean) {
            if (shouldShow) {
                Log.i(tag, message)
            }
        }

        fun LOGI(tag: String, message: String, cause: Throwable, shouldShow: Boolean) {
            if (shouldShow) {
                Log.i(tag, message, cause)
            }
        }

        fun LOGW(tag: String, message: String, shouldShow: Boolean) {
            if (shouldShow) {
                Log.w(tag, message)
            }
        }

        fun LOGW(tag: String, message: String, cause: Throwable, shouldShow: Boolean) {
            if (shouldShow) {
                Log.w(tag, message, cause)
            }
        }

        fun LOGE(tag: String, message: String, shouldShow: Boolean) {
            if (shouldShow) {
                Log.e(tag, message)
            }
        }

        fun LOGE(tag: String, message: String, cause: Throwable, shouldShow: Boolean) {
            if (shouldShow) {
                Log.e(tag, message, cause)
            }
        }

    }
}
