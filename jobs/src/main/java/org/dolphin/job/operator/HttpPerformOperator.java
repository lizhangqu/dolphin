package org.dolphin.job.operator;

import org.dolphin.http.*;
import org.dolphin.job.Operator;

/**
 * Created by hanyanan on 2015/10/23.
 */
public class HttpPerformOperator implements Operator<HttpRequest, HttpResponse> {
    @Override
    public HttpResponse operate(HttpRequest input) throws Throwable {
        if (input == null) {
            return null;
        }

        try {
            HttpLoader loader = Method.isGet(input) ? HttpGetLoader.INSTANCE : HttpPostLoader.INSTANCE;
            return loader.performRequest(input);
        } finally {
            input.close();
        }
    }
}
