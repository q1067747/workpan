package com.watchcrack.utils;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class ZIPUtil {
    /**
     *
     * 把一个目录打包到zip文件中的某目录
     *
     * @param dirpath
     *            目录绝对地址
     *
     * @param pathName
     *            zip中目录
     */
    public static void packToolFiles(String dirpath, String zipFilePath)
            throws Exception {

        OutputStream out = null;
        BufferedOutputStream bos = null;
        ZipArchiveOutputStream zaos = null;
        File zipFile = new File(zipFilePath);
        if (!zipFile.getParentFile().exists()) {
            zipFile.getParentFile().mkdirs();
        }
        zipFile.delete();
        try {
            out = new FileOutputStream(zipFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bos = new BufferedOutputStream(out);
        zaos = new ZipArchiveOutputStream(bos);
        zaos.setEncoding("GBK");
        packToolFiles(zaos, dirpath, "");
        zaos.flush();
        zaos.close();
        bos.flush();
        bos.close();
        out.flush();
        out.close();
    }
    /**
     *
     * 把一个目录打包到一个指定的zip文件中
     *
     * @param dirpath
     *            目录绝对地址
     *
     * @param pathName
     *            zip文件抽象地址
     */
    private static void packToolFiles(ZipArchiveOutputStream zaos,
                                      String dirpath, String pathName) throws FileNotFoundException,
            IOException {
        ByteArrayOutputStream tempbaos = new ByteArrayOutputStream();
        BufferedOutputStream tempbos = new BufferedOutputStream(tempbaos);
        File dir = new File(dirpath);
        // 返回此绝对路径下的文件
        File[] files = dir.listFiles();
        if (files == null || files.length < 1) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            // 判断此文件是否是一个文件夹
            if (files[i].isDirectory()) {
                packToolFiles(zaos, files[i].getAbsolutePath(), pathName
                        + files[i].getName() + File.separator);
            } else {
                zaos.putArchiveEntry(new ZipArchiveEntry(pathName
                        + files[i].getName()));
                IOUtils.copy(new FileInputStream(files[i].getAbsolutePath()),
                        zaos);
                zaos.closeArchiveEntry();
            }
        }
        tempbaos.flush();
        tempbaos.close();
        tempbos.flush();
        tempbos.close();
    }

}

