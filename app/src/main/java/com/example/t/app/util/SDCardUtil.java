package com.example.t.app.util;

import android.os.Environment;
import android.os.StatFs;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/25 09:10
 * 作 者：T
 * 微信：704003376
 */
public class SDCardUtil {

    //判断SDCard内部空间是否足够
    public static boolean siAvaliable(long maxSize) {
        if (Environment.getExternalStorageState().
                equals(Environment.MEDIA_MOUNTED)) {
            String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
            long size = getSDCardSpace(rootPath);
            if (maxSize >= size)
                return false;
            else
                return true;

        } else {
            return false;
        }

    }


    //获取SDCard剩余空间
    private static long getSDCardSpace(String rootPath) {
        StatFs statFs = new StatFs(rootPath);
        int blockCount = statFs.getAvailableBlocks();
        int size = statFs.getBlockSize();
        long avaliableSize = blockCount * size;
        return avaliableSize;
    }


}
