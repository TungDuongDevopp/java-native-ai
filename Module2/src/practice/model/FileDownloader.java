package practice.model;

import practice.interfaces.IDownloader;

public class FileDownloader implements IDownloader {
    private final String userAgent;

    public FileDownloader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(String url, String destination) {
        System.out.println("Download: " + url);
        System.out.println("User-Agent: " + userAgent);
        System.out.println("Save to: " + destination);

        // download thật...
    }
}
