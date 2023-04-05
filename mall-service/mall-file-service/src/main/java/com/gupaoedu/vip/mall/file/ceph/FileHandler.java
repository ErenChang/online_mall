package com.gupaoedu.vip.mall.file.ceph;

import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author ErenPC
 * @version 1.0
 */
@Component
public class FileHandler {
    @Autowired
    private Container container;

    public void upload(String fileName, byte[] byteBuffer) {
        StoredObject object = container.getObject(fileName);
        object.uploadObject(byteBuffer);
    }

    public byte[] download(String fileName) {
        StoredObject object = container.getObject(fileName);
        return object.downloadObject();
    }
}
