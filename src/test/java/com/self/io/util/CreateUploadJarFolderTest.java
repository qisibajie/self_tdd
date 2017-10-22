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

    @Test
    public void should_not_null_when_get_path_given_class() {
        //given
        CreateUploadJarFolder createUploadJarFolder = new CreateUploadJarFolder();
        final String expectedPath = "/D:/work/sourceCode/TDD/self_tdd/";
        //when
        String path = createUploadJarFolder.getProjectRootPath();
        //then
        Assert.assertEquals(expectedPath, path);
    }


}
