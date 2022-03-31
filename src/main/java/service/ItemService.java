package service;

import dto.ItemDTO;
import util.StandJsonParser;

import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Singleton
public class ItemService {

    @Inject
    private StandJsonParser standJsonParser;

    private final String GET_STATS_URI = "http://localhost:8088/api/message";

    public List<ItemDTO> getItems() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(GET_STATS_URI);
        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        return standJsonParser.parse(response);
    }
}
