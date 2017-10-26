package com.self.io.util;

class CreateUploadJarFolder {
    private static final String INDICATOR = "target";

    /**
     * @return true
     */
    boolean createPomFile() {
        return true;
    }

    String getProjectRootPath() {
        return CreateUploadJarFolder.class.getResource(".").getPath().split(INDICATOR)[0];
    }
}
