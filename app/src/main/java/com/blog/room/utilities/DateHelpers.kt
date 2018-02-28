package com.blog.room.utilities

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by parthasarkar on 2/26/18.
 */

class DateHelpers {

    companion object {
        fun getCurrentUTCDateTime(): String {

            val dateFormatGmt = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
            dateFormatGmt.timeZone = TimeZone.getTimeZone("GMT")
            return dateFormatGmt.format(Date())
        }
    }
}

