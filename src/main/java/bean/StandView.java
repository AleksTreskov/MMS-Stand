package bean;

import dto.ItemDTO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import service.ItemService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
@Getter
@Slf4j
public class StandView implements Serializable {

    @Inject
    private ItemService itemService;

    @Inject
    private ReceiverConfigBean receiverConfigBean;

    @Inject
    @Push(channel = "stand")
    private PushContext context;

    private List<ItemDTO> items = new ArrayList<>();

    @PostConstruct
    public void init() {
        receiverConfigBean.openConnection();
        items = itemService.getItems();

    }

    public void updateStand() {
        log.info("Update...");
        items = itemService.getItems();
        log.info(items.toString());
        context.send("update");
        log.info("Update end");
    }
}
