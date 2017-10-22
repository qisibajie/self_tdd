package com.self.io.util;

import org.junit.Assert;
import org.junit.Test;


public class CreateUploadJarFolderTest {
    @Test
    public void executeTest() {
        //given
        CreateUploadJarFolder createUploadJarFolder = new CreateUploadJarFolder();
        //when
        boolean isCreateSuccessful = createUploadJarFolder.createPomFile();
        //then
        Assert.assertEquals(isCreateSuccessful, true);
    }
}
