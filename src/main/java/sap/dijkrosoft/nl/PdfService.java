package sap.dijkrosoft.nl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("pdf-service")
public class PdfService {

    @GET
    public byte[] getPdf() {

        return "nice".getBytes();
    }

    @GET
    @Path("test")
    public Response test() {
        return Response.ok("prima").build();
    }
}
