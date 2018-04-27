
package com.byzoro;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileSources", propOrder = {
    "videoDataHandler"
})
public class FileSources {

    @XmlMimeType("application/octet-stream")
    protected DataHandler videoDataHandler;

    public DataHandler getVideoDataHandler() {
        return videoDataHandler;
    }

    public void setVideoDataHandler(DataHandler value) {
        this.videoDataHandler = value;
    }

}
