import com.google.gson.Gson;

import java.util.Collection;

import static spark.Spark.get;
import static spark.Spark.port;

public class SitesAPI {
    public static void main(String[] args) {
        port(8086);

        final ISiteService service = new SiteServiceMapImpl();
        //get("/", (req,res) -> "Probandooooo SIisisi");


        get("/sites", (req,res) -> {
            res.type("application/json");
            Operador<Site> operador = new Operador<>();

            Collection<Site> sites = service.getSites();
            Site[] arrSites = sites.toArray(new Site[sites.size()]);

            Site[] sitesOrdenados = operador.ordenar(arrSites);
            return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS , new Gson().toJsonTree(sitesOrdenados)));
        });



        get("/sites/:id/categories" , (req,res) -> {
            res.type("application/json");
            Operador<Category> operador = new Operador<>();

            Collection<Category> categories = service.getCategories(req.params(":id"));
            Category[] arrCategories = categories.toArray(new Category[categories.size()]);

            Category[] categoriesOrdenadas = operador.ordenar(arrCategories);
            return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS , new Gson().toJsonTree(categoriesOrdenadas)));
        });
    }


}
