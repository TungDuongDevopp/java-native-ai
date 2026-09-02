package practice.designpattern;

import practice.interfaces.IDownloader;
import practice.model.FileDownloader;

public class FileDownloaderProxy implements IDownloader {
    private final FileDownloader fileDownloader;

    public FileDownloaderProxy() {
        this.fileDownloader =
                new FileDownloader("Mozilla/5.0 Firefox/...");
    }

    @Override
    public void download(String url, String destination) {
        fileDownloader.download(url, destination);
    }
}
