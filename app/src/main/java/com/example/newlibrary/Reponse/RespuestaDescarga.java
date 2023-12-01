package com.example.newlibrary.Reponse;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

public class RespuestaDescarga{
    private static final int REQUEST_CODE = 100;
    public void descargarLibro(Context context, String outputFileName) {
        String url = "http://192.168.137.1/api-rest/libros/" + outputFileName;
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle(outputFileName);
        request.setDescription("Descargando" + outputFileName);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.allowScanningByMediaScanner();
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, outputFileName);
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }
}
