package sap.dijkrosoft.nl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@javax.servlet.annotation.WebServlet(name = "MyServlet")
public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        URL urlB = getServletContext().getResource("/test.pdf");

        try {
            Path pathB = Paths.get(urlB.toURI());
            byte[] pdfData = Files.readAllBytes(pathB);

            response.setStatus(200);
            response.setContentType("application/pdf");
            response.setHeader("Accept-Ranges", "bytes");
            response.getOutputStream().write(pdfData);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }
}
