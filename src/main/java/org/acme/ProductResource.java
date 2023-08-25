package org.acme;

import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {


    @GET
    public Uni<PageResult<Product>> getAll() {
        return find();
    }

    private Uni<PageResult<Product>> find() {
        Uni<Long> count = Product
                .count("from Product p join p.secondTable join p.thirdTable where p.id > 0");


        Uni<List<Product>> content = Product.<Product>find("from Product p join fetch p.secondTable join fetch p.thirdTable where p.id > 0",
                        Sort.ascending("p.id"))
                .page(0, 10)
                .list();

        return count
                .flatMap(countResult -> content
                        .map(contentResult -> new PageResult<>(countResult, contentResult)));

//        return Uni.combine().all().unis(count, content)
//                .asTuple()
//                .map(tuple -> new PageResult<>(tuple.getItem1(), tuple.getItem2()));
    }

}
