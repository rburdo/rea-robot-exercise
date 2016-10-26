package com.rburdo.coding.rea.robot.impl.output;


import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamReportPresenterFactory {

    public OutputStreamReportPresenter create() throws IOException {
        return new OutputStreamReportPresenter(System.out);
    }

    public OutputStreamReportPresenter create(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IOException("Report Presenter output stream cannot be null");
        }
        return new OutputStreamReportPresenter(outputStream);
    }

}
