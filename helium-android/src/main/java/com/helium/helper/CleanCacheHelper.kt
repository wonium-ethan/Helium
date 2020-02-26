package com.helium.helper

import android.annotation.SuppressLint
import android.content.Context
import android.os.Environment
import java.io.File
import java.math.BigDecimal

/**
 * @ClassName: CleanCacheHelper
 * @Description: https://blog.csdn.net/weixin_33938733/article/details/91902990
 * @Author: Ethan
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2020/2/24 21:23
 * @UpdateUser: Ethan
 * @UpdateDate: 2020/2/24 21:23
 * @UpdateDescription: 更新说明
 * @Version: 1.0.0
 */
class CleanCacheHelper {

    companion object {

        /**
         * 清除本应用所有的数据
         * @param context 上下文
         * @param filePath 文件路径
         */

        public fun cleanApplicationData(context: Context, filePath: Array<String>) {
            cleanInternalCache(context)
            cleanExternalCache(context)
            cleanDataBases(context)
            cleanSharedPreference(context)
            cleanFiles(context)
            if (filePath.isEmpty()) {
                return
            }
            for (i in filePath.iterator()) {
                cleanCustomCache(i)
            }
        }


        public fun getTotalCacheSize(context: Context): String {
            var cacheSize: Long = getFolderSize(context.cacheDir)
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                cacheSize += context.externalCacheDir?.let { getFolderSize(it) }!!
            }
            return getFormatSize(cacheSize.toDouble())
        }


        /**
         * 删除缓存
         * @param context
         */

        public fun clearAllCache(context: Context) {
            deleteDir(context.cacheDir)
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                context.externalCacheDir?.let { deleteDir(it) }
            }
        }


        /**
         * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache)
         * @param context
         */

        private fun cleanInternalCache(context: Context) {
            deleteDir(context.cacheDir)
        }

        /**
         * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases)
         * @param context
         */

        @SuppressLint("SdCardPath")
        private fun cleanDataBases(context: Context) {
            deleteDir(File("/data/data/".plus(context.packageName).plus("/databases")))
        }


        /**
         * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs)
         * @param context 上下文
         */

        @SuppressLint("SdCardPath")
        private fun cleanSharedPreference(context: Context) {
            deleteDir(File("/data/data/".plus(context.packageName).plus("/shared_prefs")))
        }


        /**
         * * 按名字清除本应用数据库
         * @param context 上下文
         * @param dbName 数据库名字
         */

        public fun cleanDataBaseByName(context: Context, dbName: String) {
            context.deleteDatabase(dbName)
        }

        /**
         * 清除/data/data/com.xxx.xxx/files下的内容
         * @param context
         */
        public fun cleanFiles(context: Context) {
            deleteDir(context.filesDir)
        }

        /**
         * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
         * @param context 上下文关系
         */

        public fun cleanExternalCache(context: Context) {
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                deleteDir(context.cacheDir)
            }
        }

        public fun cleanCustomCache(filePath: String) {
            deleteDir(File(filePath))
        }

        private fun deleteDir(dir: File): Boolean {
            if (dir.isDirectory) {
                val children: Array<String>? = dir.list()
                var size = 0
                if (children != null) {
                    size = children.size
                    for (i in 0 until size step 1) {
                        val success: Boolean = deleteDir(File(dir, children[i]))
                        if (!success) return false
                    }
                }
            }
            return dir.delete()
        }

        /**
         * 获取文件夹的大小
         * @param file 文件夹
         */
        public fun getFolderSize(file: File): Long {
            var size: Long = 0
            try {
                val fileList: Array<File>? = file.listFiles()
                for (i in fileList?.indices?.step(1)!!) {
                    size += if (fileList[i].isDirectory) {
                        getFolderSize(fileList[i])
                    } else {
                        fileList[i].length()
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
            return size
        }

        /**
         * 格式化单位大小
         * @param size 占用得空间大小
         */
        public fun getFormatSize(size: Double): String {

            val kiloByte: Double = size / 1024
            if (kiloByte < 1) {
                return size.toString().plus("Byte")
            }
            val megaByte: Double = kiloByte / 1024
            if (megaByte < 1) {
                val result = BigDecimal(kiloByte.toString())
                return result.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString().plus("KB")
            }
            val gigaByte: Double = megaByte / 1024
            if (gigaByte < 1) {
                val result = BigDecimal(megaByte.toString())
                return result.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString().plus("MB")
            }
            val teraBytes: Double = gigaByte / 1024
            if (teraBytes < 1) {
                val result = BigDecimal(gigaByte.toString())
                return result.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString().plus("GB")
            }
            val result = BigDecimal(teraBytes)
            return result.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString().plus("TB")
        }
    }
}