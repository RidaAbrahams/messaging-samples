package za.co.rida.messaging.orders.boundary;

import za.co.rida.messaging.orders.control.OrdersService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Path("purchase-orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrdersResource {

    @Inject
    private OrdersService ordersService;

    @Path("place")
    @GET
    public Response placeOrder() {
        ordersService.placePurchaseOrder();
        return Response.ok(Collections.singletonMap("result", "Order placed successfully")).build();
    }
}
