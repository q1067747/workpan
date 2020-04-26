package com.watchcrack.service.impl;

import com.hebtu.service.FileFolderService;
import com.hebtu.entity.FileFolder;
import com.hebtu.entity.MyFile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @ClassName: FileFolderServiceImpl
* @Description: TODO
* @author: xw
* @date 2020/2/8 23:00
* @Version: 1.0
**/

@Service
public class FileFolderServiceImpl extends BaseService implements FileFolderService {

    @Override
    public Integer deleteFileFolderById(Integer fileFolderId) {
        return fileFolderMapper.deleteFileFolderById(fileFolderId);
    }

    @Override
    public Integer addFileFolder(FileFolder fileFolder) {
        return fileFolderMapper.addFileFolder(fileFolder);
    }

    @Override
    public List<MyFile> getFileFolderById(Integer fileFolderId) {
        return fileFolderMapper.getFileByFileFolder(fileFolderId);
    }

    @Override
    public Integer updateFileFolderById(FileFolder fileFolder) {
        return fileFolderMapper.updateFileFolderById(fileFolder);
    }

    /**
     * 获取我的作业文件夹ID
     *
     * @param storeId
     */
    @Override
    public Integer getMyTaskFolderId(Integer storeId) {
        return fileFolderMapper.getMyTaskFolderId(storeId);
    }

    @Override
    public List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId) {
        return fileFolderMapper.getFileFolderByParentFolderId(parentFolderId);
    }

    @Override
    public FileFolder getFileFolderByFileFolderId(Integer fileFolderId) {
        return fileFolderMapper.getFileFolderById(fileFolderId);
    }

    @Override
    public List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId) {
        return fileFolderMapper.getRootFoldersByFileStoreId(fileStoreId);
    }
}
